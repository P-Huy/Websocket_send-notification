/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.user.User;

/**
 *
 * @author admin
 */
public abstract class DBContext<T>
{

        protected Connection connection;

        public DBContext()
        {
                try
                {
                        String username = "root";
                        String password = "majonotab1";
                        String url = "jdbc:mysql://127.0.0.1:3006/notification_demo";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        connection = DriverManager.getConnection(url, username, password);
                } 
                catch (ClassNotFoundException ex)
                {
                        Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
                } 
                catch (SQLException ex)
                {
                        Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
                }
        }

        //public abstract ArrayList<T> list();
        public abstract ArrayList<T> getList(String field, String value);
        
        public abstract T get(String field, String value);

        public abstract T insert(T model);

        public abstract void update(T model);

        public abstract void delete(int id);
}
