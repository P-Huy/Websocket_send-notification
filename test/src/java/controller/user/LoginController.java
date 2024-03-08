/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.user;

import dal.notification.NotificationsDBContext;
import dal.user.UserDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.notification.Send_Notification;
import model.user.User;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginController", urlPatterns =
{
        "/login"
})
public class LoginController extends HttpServlet
{

        /**
         * Processes requests for both HTTP <code>GET</code> and
         * <code>POST</code> methods.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException
        {
                response.setContentType("text/html;charset=UTF-8");
                try ( PrintWriter out = response.getWriter())
                {
                        /* TODO output your page here. You may use following sample code. */
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet LoginController</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
                        out.println("</body>");
                        out.println("</html>");
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
                throws ServletException, IOException
        {
                HttpSession session = request.getSession(false);
                boolean loggedIn = (session != null) && (session.getAttribute("user") != null);

                if (loggedIn)
                {
                        response.sendRedirect("/test");
                } else
                {
                        request.getRequestDispatcher("/views/login.jsp").forward(request, response);
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
                throws ServletException, IOException
        {
                String username = request.getParameter("name");
                
                UserDBContext userDB = new UserDBContext();
                User user = userDB.get("username", username);
                
                NotificationsDBContext notificationDB = new NotificationsDBContext();
                List<Send_Notification> notifications = notificationDB.load(user.getId());
                
                String unread = user.getNotification_code();
                int count = 0;
                for(Send_Notification send_Notification : notifications)
                {
                        if(!send_Notification.getCode().equalsIgnoreCase(unread))
                        {
                                count++;
                        }
                        else
                                break;
                }
                
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("count", count);
                request.getSession().setAttribute("notifications", notifications);
                
                response.sendRedirect("/test");
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo()
        {
                return "Short description";
        }// </editor-fold>

}
