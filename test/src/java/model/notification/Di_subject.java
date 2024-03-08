/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.notification;

import java.sql.Timestamp;

/**
 *
 * @author admin
 */
public class Di_subject
{
        private int id;
        private int productId;
        private int notificationsId;

        public Di_subject()
        {
        }

        public Di_subject(int id, int productId, int notificationsId)
        {
                this.id = id;
                this.productId = productId;
                this.notificationsId = notificationsId;
        }

        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public int getProductId()
        {
                return productId;
        }

        public void setProductId(int productId)
        {
                this.productId = productId;
        }

        public int getNotificationsId()
        {
                return notificationsId;
        }

        public void setNotificationsId(int notificationsId)
        {
                this.notificationsId = notificationsId;
        }
        
}
