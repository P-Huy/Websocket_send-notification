/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.user;

/**
 *
 * @author admin
 */
public class User
{
        private int id;
        private String username;
        private String notification_code;
        public User()
        {
        }

        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public String getUsername()
        {
                return username;
        }

        public void setUsername(String username)
        {
                this.username = username;
        }

        public String getNotification_code()
        {
                return notification_code;
        }

        public void setNotification_code(String notification_code)
        {
                this.notification_code = notification_code;
        }
}
