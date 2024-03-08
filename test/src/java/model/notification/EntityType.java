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
public class EntityType
{
        private int id;
        private String entity;
        private String description;

        public EntityType()
        {
        }

        public EntityType(int id, String entity, String description)
        {
                this.id = id;
                this.entity = entity;
                this.description = description;
        }

        public int getId()
        {
                return id;
        }

        public void setId(int id)
        {
                this.id = id;
        }

        public String getEntity()
        {
                return entity;
        }

        public void setEntity(String entity)
        {
                this.entity = entity;
        }

        public String getDescription()
        {
                return description;
        }

        public void setDescription(String description)
        {
                this.description = description;
        }
        
}
