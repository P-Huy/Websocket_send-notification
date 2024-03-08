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
public class Send_Notification
{
        private String code;
        private String message; 
        private String url;
        private Timestamp created_at;

        public Send_Notification()
        {
        }

        public Send_Notification(String code, String message, String url, Timestamp created_at)
        {
                this.code = code;
                this.message = message;
                this.url = url;
                this.created_at = created_at;
        }

        public String getCode()
        {
                return code;
        }

        public void setCode(String code)
        {
                this.code = code;
        }

        public String getMessage()
        {
                return message;
        }

        public void setMessage(String message)
        {
                this.message = message;
        }

        public String getUrl()
        {
                return url;
        }

        public void setUrl(String url)
        {
                this.url = url;
        }

        public Timestamp getCreated_at()
        {
                return created_at;
        }

        public void setCreated_at(Timestamp created_at)
        {
                this.created_at = created_at;
        }
        
}
