/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.notification;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.notification.Notifications;
import model.notification.Send_Notification;
import utils.Notification;

/**
 *
 * @author admin
 */
public class NotificationsDBContext extends DBContext<Notifications>
{

        @Override
        public ArrayList<Notifications> getList(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Notifications get(String field, String value)
        {
                String sql = "Select * from notifications\n";
                if (!field.equals(""))
                {
                        sql += "where `" + field + "` = '" + value + "'";
                } // SQL Injection
                PreparedStatement statement = null;
                try
                {
                        statement = connection.prepareStatement(sql);
                        ResultSet result = statement.executeQuery();
                        while (result.next())
                        {
                                Notifications notifications = new Notifications();
                                notifications.setId(result.getInt("id"));
                                notifications.setCode(result.getString("code"));
                                notifications.setUrl(result.getString("url"));
                                notifications.setStatus(result.getBoolean("status"));
                                notifications.setCreated_at(result.getTimestamp("created_at"));
                                notifications.setUpdated_at(result.getTimestamp("updated_at"));
                                notifications.setEntityTypeId(result.getInt("entityTypeId"));

                                return notifications;
                        }
                } catch (SQLException er)
                {
                        er.printStackTrace();
                }
                return null;
        }

        @Override
        public Notifications insert(Notifications notification)
        {
                String sql = "INSERT INTO `notification_demo`.`notifications`\n"
                        + "(`code`,\n"
                        + "`url`,\n"
                        + "`status`,\n"
                        + "`created_at`,\n"
                        + "`updated_at`,\n"
                        + "`entityTypeId`)\n"
                        + "VALUES(?, ?, ?, ?, ?, ?);";
                try
                {
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, notification.getCode());
                        statement.setString(2, notification.getUrl());
                        statement.setBoolean(3, notification.isStatus());
                        statement.setTimestamp(4, notification.getUpdated_at());
                        statement.setTimestamp(5, notification.getUpdated_at());
                        statement.setInt(6, notification.getEntityTypeId());
                        statement.executeUpdate();

                        Notifications new_notifications = get("code", notification.getCode());
                        return new_notifications;
                } catch (SQLException er)
                {
                        er.printStackTrace();
                }
                return null;
        }

        @Override
        public void update(Notifications model)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void delete(int id)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public List<Send_Notification> load(int receiverId)
        {
                String sql = "SELECT  notifications.code, notifications.url, notifications.status, notifications.created_at, notifications.updated_at,\n"
                        + "		entitytype.id as entityId, entitytype.description as description,\n"
                        + "		pro.productName as product, actor.username as actor, `in_subject`.receiverId as receiver\n"
                        + "FROM notifications \n"
                        + "JOIN (\n"
                        + "		SELECT productName, notificationsId\n"
                        + "		FROM `di_subject` JOIN product ON `di_subject`.productId = `product`.id\n"
                        + "	 ) AS pro ON notifications.id = pro.notificationsId\n"
                        + "JOIN (\n"
                        + "		SELECT username, notificationsId\n"
                        + "		FROM `subject` JOIN `user` ON `subject`.actorId = `user`.id\n"
                        + "	 ) AS actor ON notifications.id = actor.notificationsId\n"
                        + "JOIN `in_subject` ON notifications.id = `in_subject`.notificationsId\n"
                        + "JOIN `entitytype` ON notifications.entityTypeId = entitytype.id \n"
                        + "where receiverId = ?\n"
                        + "ORDER By created_at desc;";
                try
                {
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setInt(1, receiverId);
                        
                        ResultSet result = statement.executeQuery();
                        
                        List<Send_Notification> list = new ArrayList<>();
                        while (result.next())
                        {
                                Send_Notification send_Notification = new Send_Notification();

                                int entity = result.getInt("entityId");
                                String actor = result.getString("actor");
                                String description = result.getString("description");
                                String pro = result.getString("product");
                                
                                Notification fetch = new Notification();
                                String message = fetch.fetch(entity, actor, description, pro);
                                
                                send_Notification.setCode(result.getString("code"));
                                send_Notification.setMessage(message);
                                send_Notification.setUrl(result.getString("url"));
                                send_Notification.setCreated_at(result.getTimestamp("created_at"));
                                
                                list.add(send_Notification);
                        }
                        return list;
                } catch (SQLException er)
                {
                        er.printStackTrace();
                }
                return null;
        }
}
