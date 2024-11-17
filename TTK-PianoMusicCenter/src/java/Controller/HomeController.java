/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import CartObj.CartObj;
import Category.CategoryDTO;
import OrderCourse.OrderCourseDAO;
import OrderCourse.OrderCourseDTO;
import Registration.RegistrationDAO;
import Registration.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author XinWei
 */
public class HomeController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            OrderCourseDAO dao = new OrderCourseDAO();

            List<OrderCourseDTO> dto = dao.getAllProduct(0);
            List<CategoryDTO> dtoC = dao.getAllProductCategory();
            OrderCourseDTO last = dao.getLast();

            HttpSession session = request.getSession();
            session.setAttribute("P", last);
            session.setAttribute("listC", dtoC);
            session.removeAttribute("cid");
            session.removeAttribute("cnt");

            session.setAttribute("saveSearch", null);

            RegistrationDAO daos = new RegistrationDAO();
            Cookie cookies[] = request.getCookies();
            String username = null;
            String password = null;

            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("userC")) {
                        username = cookie.getValue();

                    }
                    if (cookie.getName().equals("passC")) {
                        password = cookie.getValue();
                    }

                }
            }
            boolean result = daos.checkLogin(username, password);
            if (result) {
                RegistrationDTO list = daos.getAcc(username, password);
                session.setAttribute("acc", list);
            }

            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartObj();
            }
            String cookieValues = "";
            Cookie arrs[] = request.getCookies();
            
                for (Cookie o : arrs) {
                    if (o.getName().equals("cart")) {
                        cookieValues = o.getValue();
                        String[] pairs = cookieValues.split("\\|");

                        for (String pair : pairs) {
                            String[] keyValue = pair.split(",");
                            if (keyValue.length == 2) {
                                String key = keyValue[0];
                                String value = keyValue[1];

                                cart.change(key, Integer.valueOf(value));
                                session.setAttribute("CART", cart);
                            }
                        }

//                    for (Cookie os : arr) {
//                        os.setMaxAge(0);
//                        response.addCookie(os);
//                    }
                    }
                }
            

            session.setAttribute("listP", dto);
            RequestDispatcher rd = request.getRequestDispatcher("Search.jsp");
            rd.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
