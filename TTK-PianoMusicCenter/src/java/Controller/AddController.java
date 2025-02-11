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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class AddController extends HttpServlet {

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

        PrintWriter out = response.getWriter();

//            Cookie arrs[] = request.getCookies();
//            for (Cookie o : arrs) {
//                if (o.getName().equals("cart")) {
//                    o.setMaxAge(0);
//                response.addCookie(o);
//                }
//            }
        /* TODO output your page here. You may use following sample code. */
        HttpSession session = request.getSession();
        CartObj cart = (CartObj) session.getAttribute("CART");
        if (cart == null) {
            cart = new CartObj();
        }

        String title = request.getParameter("addList");
        cart.addItemToCart(title);
        session.setAttribute("CART", cart);
        String txt = "";
        Map<String, Integer> items = cart.getItem();
        for (Map.Entry<String, Integer> item : items.entrySet()) {
            txt += item.getKey() + "," + item.getValue() + "|";
//                response.addCookie(Products); 
            out.println("<button type=\"button\" onclick=\"changeToCart('"+item.getKey()+"')\">Minus</button>\n"
                    + "                        <li>"+item.getKey()+"</li>\n"
                    + "\n"
                    + "                        \n"
                    + "                        <div class=\"kay\">\n" +
"                            <li>"+item.getValue()+"</li>\n" +
"                        </div>");
        }
        
        Cookie cookie = new Cookie("cart", txt);
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);


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
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
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
