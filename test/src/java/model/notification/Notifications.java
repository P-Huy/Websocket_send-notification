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
public class Notifications
{
        private int id;
        private String code;
        private String url;
        private boolean status;
        private int entityTypeId;
        private Timestamp created_at;
        private Timestamp updated_at;

        public Notifications()
        {
        }

        public Notifications(int id, String code, String url, boolean status, int entityTypeId, Timestamp created_at, Timestamp updated_at)
        {
                this.id = id;
                this.code = code;
                this.url = url;
                this.status = status;
                this.entityTypeId = entityTypeId;
                this.created_at = created_at;
                this.updated_at = updated_at;
        }

        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public String getCode()
        {
                return code;
        }

        public void setCode(String code)
        {
                this.code = code;
        }

        public String getUrl()
        {
                return url;
        }

        public void setUrl(String url)
        {
                this.url = url;
        }

        public boolean isStatus()
        {
                return status;
        }

        public void setStatus(boolean status)
        {
                this.status = status;
        }

        public int getEntityTypeId()
        {
                return entityTypeId;
        }

        public void setEntityTypeId(int entityTypeId)
        {
                this.entityTypeId = entityTypeId;
        }

        public Timestamp getCreated_at()
        {
                return created_at;
        }

        public void setCreated_at(Timestamp created_at)
        {
                this.created_at = created_at;
        }

        public Timestamp getUpdated_at()
        {
                return updated_at;
        }

        public void setUpdated_at(Timestamp updated_at)
        {
                this.updated_at = updated_at;
        }
        
}
