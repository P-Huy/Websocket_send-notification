/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Websocket;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import model.notification.Send_Notification;

@ServerEndpoint("/notification")
public class WebSocketServer
{

        //private static final CopyOnWriteArrayList<Session> sessions = new CopyOnWriteArrayList<>();
        private static final ConcurrentHashMap<String, Session> sessions = new ConcurrentHashMap<>();

        @OnOpen
        public void onOpen(Session session)
        {
                String userId = session.getRequestParameterMap().get("id").get(0);
                sessions.put(userId, session);
        }

        @OnMessage
        public void onMessage(String content, Session session)
        {

        }

        @OnClose
        public void onClose(Session session)
        {
                sessions.remove(session);
        }

        @OnError
        public void onError(Throwable error)
        {
                System.err.println("Error: " + error.getMessage());
        }

        public static void broadcast(Send_Notification send, int sendTo)
        {
                Thread thread = new Thread(new Runnable()
                {
                        @Override
                        public void run()
                        {
                                try
                                {
                                        String _sendTo = String.valueOf(sendTo);
                                        if (sessions.containsKey(_sendTo))
                                        {
                                                Session session = sessions.get(_sendTo);
                                                if (session.isOpen())
                                                {
                                                        try
                                                        {
                                                                String customDateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
                                                               Gson gson = new GsonBuilder().setDateFormat(customDateFormat).create();
                                                                String notification = gson.toJson(send);
                                                                session.getBasicRemote().sendText(notification);
                                                        } catch (IOException e)
                                                        {
                                                                System.err.println("Error broadcasting message: " + e.getMessage());
                                                        }
                                                } else
                                                {
                                                        System.out.println("User " + sendTo + " not connected or session closed.");
                                                }
                                        } else
                                        {
                                                System.out.println("User " + sendTo + " not connected or session closed.");
                                        }
                                }
                                catch(Exception er)
                                {
                                        er.printStackTrace();
                                }
                        }
                });
                thread.start();
                
        }
}
