/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.func;

import dal.product.ProductDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import model.product.Product;
import model.user.User;
import utils.Notification;

/**
 *
 * @author admin
 */
@WebServlet(name = "Process", urlPatterns =
{
        "/process"
})
public class Process extends HttpServlet
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
                        out.println("<title>Servlet Process</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Servlet Process at " + request.getContextPath() + "</h1>");
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
                try
                {
                        System.out.println("elaina-chan");
                } catch (Exception er)
                {
                        er.printStackTrace();
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

                ProductDBContext productDB = new ProductDBContext();

                String productId = request.getParameter("product");
                Product product = productDB.get("id", productId);

                User user = (User) request.getSession().getAttribute("user");

                String sendFrom = user.getUsername();
                int sendFrom_id = user.getId();
                String subject = product.getProductName();
                int id = product.getId();
                int sendTo = product.getUserId();
                Timestamp created_at = new Timestamp(System.currentTimeMillis());
                
                Notification notification = new Notification();
                notification.Create(sendFrom, sendFrom_id, subject, id, sendTo, created_at, 1);
                
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
