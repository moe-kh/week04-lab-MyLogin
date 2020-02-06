/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 794456
 */
public class LoginServlet extends HttpServlet {
HttpSession session;
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
            throws ServletException, IOException {

    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       System.out.println("get request");
        String logout = request.getParameter("logout");
        String logoutMsg;
        if (logout == null) {
            System.out.println("");
        } else {
            logoutMsg = "you have successfully logged out";
            request.setAttribute("logoutMsg", logoutMsg);
            session.invalidate();
            System.out.println("loghere");

        }

        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
      
           System.out.println("post request");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
String msg;
        session = request.getSession();
if(username.equals("") || username==null || password.equals("") || password==null){
    msg="Enter value to the fields";
}else
{
    session.setAttribute("username", username);
    session.setAttribute("password",password);
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
