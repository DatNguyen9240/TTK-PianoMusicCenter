package Controller;

import CartObj.CartObj;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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

public class changeToCart extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
       
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("CART");
            if (cart == null) {
                cart = new CartObj();
            }

            String key = request.getParameter("key");
            Map<String, Integer> items = cart.getItem();
            session.setAttribute("CART", cart);
            if (items.containsKey(key)) {
                int newQuantity = items.get(key) - 1;
                if (newQuantity > 0) {
                    cart.change(key, newQuantity); // Update the quantity
                } else {
                    cart.removeItemFromCart(key); // Remove the item if quantity is zero or less
                }
            }

            // Create the cookie value after updating the cart
            String txt = "";
            for (Map.Entry<String, Integer> item : items.entrySet()) {
                txt += item.getKey() + "," + item.getValue() + "|";
                out.println("<button type=\"button\" onclick=\"changeToCart('"+item.getKey()+"')\">Minus</button>\n"
                    + "                        <li>"+item.getKey()+"</li>\n"
                    + "\n"
                    + "                        \n"
                    + "                        <div class=\"kay\">\n" +
"                            <li>"+item.getValue()+"</li>\n" +
"                        </div>");
            }
            
            // Set the updated cookie
            Cookie cookie = new Cookie("cart", txt);
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
