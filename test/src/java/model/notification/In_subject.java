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
public class In_subject
{
        private int id;
        private int receiverId;
        private int notificationsId;

        public In_subject()
        {
        }

        public In_subject(int id, int receiverId, int notificationsId)
        {
                this.id = id;
                this.receiverId = receiverId;
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

        public int getReceiverId()
        {
                return receiverId;
        }

        public void setReceiverId(int receiverId)
        {
                this.receiverId = receiverId;
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
