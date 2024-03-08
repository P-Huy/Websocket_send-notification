/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(urlPatterns =
{
        "/notify"
}, asyncSupported = true)
public class NotificationChannel extends HttpServlet implements DefaultListener
{

        private static final long serialVersionUID = -2827663265593547983L;
        private ConcurrentMap<String, AsyncContext> contexts = new ConcurrentHashMap<>();
        
        NotificationListener listener = NotificationListener.getInstance();
        
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
                //initialize for server-sent events
                
                response.setContentType("text/event-stream");
                response.setCharacterEncoding("UTF-8");

                final String userId = request.getParameter("userId"); //retrieve the user Id
                if (userId == null)
                {
                        response.sendError(HttpServletResponse.SC_BAD_REQUEST);
                        return;
                }

                //to clear threads and allow for asynchronous execution
                final AsyncContext asyncContext = request.startAsync(request, response);
                asyncContext.setTimeout(0);

                //add context to list for later use
                if (contexts == null || contexts.isEmpty() || !contexts.containsKey(userId))
                {
                        if (contexts == null)
                        {
                                contexts = new ConcurrentHashMap<String, AsyncContext>();
                        }
                        contexts.put(userId, asyncContext);
                }
                listener.addListener(this);
                sendNotification(userId, "connected");
        }

        protected void sendNotification(String userId, String notification)
        {
                try
                {
                        if (contexts.containsKey(userId))
                        {
                                AsyncContext asyncContext = contexts.get(userId);
                                PrintWriter writer = asyncContext.getResponse().getWriter();
                                writer.write("data: " + notification + "\n\n");
                                writer.flush();
                        }
                } catch (Exception e)
                {
                        e.printStackTrace();
                        //try again before disconnecting the user
                        try
                        {
                                if (contexts.containsKey(userId))
                                {
                                        AsyncContext asyncContext = contexts.get(userId);
                                        PrintWriter writer = asyncContext.getResponse().getWriter();
                                        writer.write("data: " + notification + "\n\n");
                                        writer.flush();
                                }
                        } catch (Exception e2)
                        {
                                e2.printStackTrace();
                                AsyncContext asyncContext = contexts.remove(userId);
                                asyncContext.complete();
                        }
                }
        }

        @Override
        public void onNotification(NotificationEvent event)
        {
               // this.sendNotification(event.getUserId(), event.getJSONEvent());
                //System.out.println(event.getUserId());
        }

}
