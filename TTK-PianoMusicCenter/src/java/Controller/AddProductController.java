/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import OrderCourse.OrderCourseDAO;
import Registration.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author XinWei
 */
public class AddProductController extends HttpServlet {

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
            HttpSession session = request.getSession();
            RegistrationDTO a = (RegistrationDTO) session.getAttribute("acc");
            int sid = a.getSellid();
            String image = request.getParameter("image");
            String Name = request.getParameter("name");
            String Des = request.getParameter("description");
            String priceParam = request.getParameter("price");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int status = Integer.parseInt(request.getParameter("status"));
            Double priceDouble = 0.0;
            
            if (priceParam != null) {
                try {
                    priceDouble = Double.parseDouble(priceParam);
                } catch (NumberFormatException e) {
                    priceDouble = 0.0; // Nếu không phải kiểu double thì trả về null
                }
            }

            double Price = priceDouble;
            String Category = request.getParameter("category");
            String StartDate = request.getParameter("dateStart");
            boolean isValidFormat = StartDate.matches("\\d{4}-\\d{2}-\\d{2}");
            if (!isValidFormat) {
                StartDate = null;
            }
            String EndDate = request.getParameter("dateEnd");
            isValidFormat = EndDate.matches("\\d{4}-\\d{2}-\\d{2}");
            if (!isValidFormat) {
                EndDate = null;
            }
            
            boolean result=false;
            OrderCourseDAO dao = new OrderCourseDAO();
            
            if(Price!=0.0&&StartDate!=null&&EndDate!=null&&image!=null&&Des!=null&&quantity>=0&&status>=0){
                 result = dao.insertProduct(image, Des, Price, StartDate, EndDate, Category, Name, sid,quantity,status);
            }
            if(result){
                response.sendRedirect("ManagerController");
            }else{
                request.setAttribute("AddErr", "AddErr");
                request.getRequestDispatcher("ManagerController").forward(request, response);
            }
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
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
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
