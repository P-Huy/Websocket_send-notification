/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import Websocket.WebSocketServer;
import dal.notification.Di_subjectDBContext;
import dal.notification.In_subjectDBContext;
import dal.notification.NotificationsDBContext;
import dal.notification.SubjectDBContext;
import java.sql.Timestamp;
import java.util.UUID;
import model.notification.Di_subject;
import model.notification.In_subject;
import model.notification.Notifications;
import model.notification.Send_Notification;
import model.notification.Subject;

/**
 *
 * @author admin
 */
public class Notification
{

        public void Save(String code, String url, Timestamp created_at, int entity, int actor, int receiver, int id)
        {
                NotificationsDBContext notificationDB = new NotificationsDBContext();

                Notifications notification = new Notifications();
                notification.setCode(code);
                notification.setUrl(url);
                notification.setStatus(false);
                notification.setCreated_at(created_at);
                notification.setUpdated_at(created_at);
                notification.setEntityTypeId(entity);
                Notifications new_notification = notificationDB.insert(notification);

                SubjectDBContext subjectDB = new SubjectDBContext();

                Subject subject = new Subject();
                subject.setActorId(actor);
                subject.setNotificationsId(new_notification.getId());
                subjectDB.insert(subject);

                In_subjectDBContext in_subjectDB = new In_subjectDBContext();

                In_subject in_subject = new In_subject();
                in_subject.setReceiverId(receiver);
                in_subject.setNotificationsId(new_notification.getId());
                in_subjectDB.insert(in_subject);

                Di_subjectDBContext di_subjectDB = new Di_subjectDBContext();

                Di_subject di_subject = new Di_subject();
                di_subject.setProductId(id);
                di_subject.setNotificationsId(new_notification.getId());
                di_subjectDB.insert(di_subject);

        }

        public void Create(String sendFrom, int sendFrom_id, String subject, int id, int sendTo, Timestamp created_at, int entity)
        {
                UUID uuid = UUID.randomUUID();

                String code = uuid.toString();
                String message = null;
                String url = null;
                switch (entity)
                {
                        case 1:
                                message = sendFrom + " đã thực hiện giao dịch cho sản phẩm " + subject + " của bạn.";
                                url = "https://majotabi.fandom.com/vi/wiki/H%C3%A0nh_tr%C3%ACnh_c%E1%BB%A7a_Elaina" + id;
                                break;
                        // code block
                        case 2:
                                message = sendFrom + " đã thanh toán giao dịch cho sản phẩm " + subject + " của bạn.";
                                url = "/ElaTrading/productdetail?id=" + id;
                                break;
                        // code block
                        case 3:
                                message = sendFrom + " đã khiếu nại về sản phẩm " + subject + " của bạn." ;
                                url = "" + id;
                                break;
                        // code block
                        case 4:
                                message = "Yêu cầu khiếu nại về sản phẩm " + subject + "đã được chấp nhận.";
                                url = "" + id;
                                break;
                        // code block
                        case 5:
                                message = "Yêu cầu khiếu nại về sản phẩm " + subject + "đã bị từ chối.";
                                url = "" + id;
                                break;
                        // code block
                        case 6:
                                message = "Yêu cầu nạp tiền của bạn đã được chấp nhận.";
                                url = "" + id;
                                break;
                        // code block          
                }
                Send_Notification notification = new Send_Notification();
                notification.setCode(code);
                notification.setMessage(message);
                notification.setUrl(url);
                notification.setCreated_at(created_at);

                WebSocketServer.broadcast(notification, sendTo);
                Save(code, url, created_at, entity, sendFrom_id, sendTo, id);
        }

        public String fetch(int entity, String actor, String description, String pro)
        {
                String[] arr = description.split("_", 2);
                
                String message = null;
                if (1 <= entity && entity <= 3)
                {
                        message = actor + " " + arr[0] + " " + pro + " " + arr[1];
                } else if (4 <= entity && entity <= 5)
                {
                        message = arr[0] + " " + pro + " " + arr[1];
                } else
                {
                        message = description;
                }
                return message;
        }
}
