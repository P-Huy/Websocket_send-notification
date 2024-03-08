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
public class Subject
{
        private int id;
        private int notificationsId;
        private int actorId;

        public Subject()
        {
        }

        public Subject(int id, int notificationsId, int actorId)
        {
                this.id = id;
                this.notificationsId = notificationsId;
                this.actorId = actorId;
        }

        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public int getNotificationsId()
        {
                return notificationsId;
        }

        public void setNotificationsId(int notificationsId)
        {
                this.notificationsId = notificationsId;
        }

        public int getActorId()
        {
                return actorId;
        }

        public void setActorId(int actorId)
        {
                this.actorId = actorId;
        }
        
}
