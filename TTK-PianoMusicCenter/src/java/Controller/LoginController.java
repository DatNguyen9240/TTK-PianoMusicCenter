package Controller;

import Registration.RegistrationDAO;
import Registration.RegistrationDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

    private static final String HomeController = "HomeController";
    private static final String INVALIDPAGE = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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
        Cookie arr[] = request.getCookies();
        for (Cookie o : arr) {
            if (o.getName().equals("userC")) {
                request.setAttribute("username", o.getValue());
            }
            if (o.getName().equals("passC")) {
                request.setAttribute("password", o.getValue());
            }
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
        String url = INVALIDPAGE;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        RegistrationDAO dao = new RegistrationDAO();
        try {
            boolean result = dao.checkLogin(username, password);
            if (result) {
                url = HomeController;

                RegistrationDTO list = dao.getAcc(username, password);

                HttpSession session = request.getSession();
                session.setMaxInactiveInterval(60);
                session.setAttribute("acc", list);

                Cookie u = new Cookie("userC", username);
                Cookie p = new Cookie("passC", password);
                u.setMaxAge(60);
                p.setMaxAge(60);
                response.addCookie(u);
                response.addCookie(p);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (url.endsWith(INVALIDPAGE)) {
                request.setAttribute("txtUsername", username);
                request.setAttribute("msg", "Error username or password");
                request.getRequestDispatcher("index.jsp").forward(request, response);

            }
            response.sendRedirect(url);
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
