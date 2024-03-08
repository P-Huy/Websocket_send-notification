/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.notification;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.notification.In_subject;

/**
 *
 * @author admin
 */
public class In_subjectDBContext extends DBContext<In_subject>
{

        @Override
        public ArrayList<In_subject> getList(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public In_subject get(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public In_subject insert(In_subject in_subject)
        {
                String sql = "INSERT INTO `notification_demo`.`in_subject`\n"
                        + "(`receiverId`,\n"
                        + "`notificationsId`)\n"
                        + "VALUES(?, ?)";
                try
                {
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setInt(1, in_subject.getReceiverId());
                        statement.setInt(2, in_subject.getNotificationsId());
                        
                        statement.executeUpdate(); 
                }
                catch(Exception er)
                {
                        er.printStackTrace();
                }
                return null;
        }

        @Override
        public void update(In_subject model)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void delete(int id)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
}
