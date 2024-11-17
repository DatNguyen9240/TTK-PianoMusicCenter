
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainController extends HttpServlet {

    private static final String LOGINCONTROLLER  = "LoginController";
    private static final String ADDTOCARTCONTROLLER  = "AddController";
    private static final String SEARCHCONTROLLER  = "SearchController";
    private static final String REGISTER = "Register";
    private static final String LOGOUTCONTROLLER = "LogoutController";
    private static final String NULLCONTROLLER = "NullController";
    private static final String MANAGERCONTROLLER = "ManagerController";
    private static final String UPDATECONTROLLER = "UpdateController";
    private static final String DELETECONTROLLER = "DeleteController";
    private static final String ADDPRODUCTCONTROLLER = "AddProductController";
    private static final String REMOVECONTROLLER = "RemoveController";
    private static final String RESET = "Register.html";
    private static final String PAGINATION = "PaginationController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String url = "";
            String action = request.getParameter("btAction");
            if(action==null){
                url = NULLCONTROLLER;
            }else if (action.equals("Login")){
                url = LOGINCONTROLLER;
            }else if(action.equals("Search")){
                url = SEARCHCONTROLLER;
            }else if(action.equals("addToCart")){
                url = ADDTOCARTCONTROLLER;
            }else if(action.equals("Register")){
                url = REGISTER;
            }else if(action.equals("logout")){
                url = LOGOUTCONTROLLER;
            }else if(action.equals("Manager")){
                url = MANAGERCONTROLLER;
            }else if(action.equals("Update")){
                url = UPDATECONTROLLER;
            }else if(action.equals("Delete")){
                url = DELETECONTROLLER;
            }else if(action.equals("AddMore")){
                url = ADDPRODUCTCONTROLLER;
            }else if(action.equals("Remove")){
                url = REMOVECONTROLLER;
            }else if(action.equals("Reset")){
                url = RESET;
            }else if(action.equals("Change")){
                url = PAGINATION;
            }
            
            
            RequestDispatcher rd = request.getRequestDispatcher(url);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
