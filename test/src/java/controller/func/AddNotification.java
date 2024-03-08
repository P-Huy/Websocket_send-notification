/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.func;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.notification.Send_Notification;

/**
 *
 * @author admin
 */
@WebServlet(name = "AddNotification", urlPatterns =
{
        "/add"
})
public class AddNotification extends HttpServlet
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
                        out.println("<title>Servlet AddNotification</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet AddNotification at " + request.getContextPath() + "</h1>");
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
                throws ServletException, IOException
        {

                String code = request.getParameter("code");
                String message = request.getParameter("message");
                String url = request.getParameter("url");
                String X = request.getParameter("created_at");
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                try
                {
                        Date date = dateFormat.parse(X);
                        Timestamp created_at = new java.sql.Timestamp(date.getTime());

                        Send_Notification notification = new Send_Notification(code, message, url, created_at);

                        List<Send_Notification> notifications = (List<Send_Notification>) request.getSession().getAttribute("notifications");
                        notifications.add(0, notification);
                        request.getSession().setAttribute("notifications", notifications);
                        
                        int count = (int) request.getSession().getAttribute("count");
                        count++;
                        request.getSession().setAttribute("count", count);
                        
                } catch (Exception er)
                {
                        er.printStackTrace();
                }
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
