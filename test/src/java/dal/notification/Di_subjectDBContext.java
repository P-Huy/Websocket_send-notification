/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.notification;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.notification.Di_subject;

/**
 *
 * @author admin
 */
public class Di_subjectDBContext extends DBContext<Di_subject>
{

        @Override
        public ArrayList<Di_subject> getList(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Di_subject get(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public Di_subject insert(Di_subject di_subject)
        {
                String sql = "INSERT INTO `notification_demo`.`di_subject`\n"
                        + "(`productId`,\n"
                        + "`notificationsId`)\n"
                        + "VALUES(?, ?)";
                try
                {
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setInt(1, di_subject.getProductId());
                        statement.setInt(2, di_subject.getNotificationsId());
                        
                        statement.executeUpdate(); 
                }
                catch(Exception er)
                {
                        er.printStackTrace();
                }
                return null;
        }

        @Override
        public void update(Di_subject model)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void delete(int id)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

}
