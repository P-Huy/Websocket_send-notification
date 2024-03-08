/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.notification;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.notification.Subject;

/**
 *
 * @author admin
 */
public class SubjectDBContext extends DBContext<Subject>
{

        @Override
        public ArrayList<Subject> getList(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Subject get(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Subject insert(Subject subject)
        {
                String sql = "INSERT INTO `notification_demo`.`subject`\n"
                        + "(`actorId`,\n"
                        + "`notificationsId`)\n"
                        + "VALUES(?, ?)";
                try
                {
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setInt(1, subject.getActorId());
                        statement.setInt(2, subject.getNotificationsId());
                        
                        statement.executeUpdate(); 
                }
                catch(Exception er)
                {
                        er.printStackTrace();
                }
                return null;
        }

        @Override
        public void update(Subject model)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void delete(int id)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
}
