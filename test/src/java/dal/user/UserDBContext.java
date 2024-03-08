/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal.user;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.user.User;

/**
 *
 * @author admin
 */
public class UserDBContext extends DBContext<User>
{

        @Override
        public User get(String field, String value)
        {
                String sql = "Select * from user\n"
                        + "where " + field + " = ?";
                PreparedStatement statement = null;
                try
                {
                        statement = connection.prepareStatement(sql);
                        statement.setString(1, value);
                        ResultSet result = statement.executeQuery();
                        while (result.next())
                        {
                                User user = new User();
                                user.setId(result.getInt("id"));
                                user.setUsername(result.getString("username"));
                                user.setNotification_code(result.getString("notification_code"));

                                return user;
                        }
                } catch (SQLException er)
                {
                        er.printStackTrace();
                }
                return null;
        }

        @Override
        public ArrayList<User> getList(String field, String value)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public User insert(User model)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void update(User model)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void delete(int id)
        {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public User resetNotification_code(String id, String code)
        {
                String sql = "UPDATE `notification_demo`.`user`\n"
                        + "SET `notification_code` = ?\n"
                        + "WHERE `id` = ?;";
                try
                {
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, code);
                        statement.setString(2, id);
                        
                        statement.executeUpdate(); 
                        
                        User user = get("id", id);
                        return user;
                }
                catch(Exception er)
                {
                        er.printStackTrace();
                }
                return null;
        }
}
