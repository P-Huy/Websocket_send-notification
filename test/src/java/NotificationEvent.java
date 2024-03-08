/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class NotificationEvent
{

        private String type;
        private String message;
        private String toUserId;

        public NotificationEvent(String type, String message, String toUserId)
        {
                this.type = type;
                this.message = message;
                this.toUserId = toUserId;
        }

        public NotificationEvent(String type, String toUserId)
        {
                this.type = type;
                this.message = "";
                this.toUserId = toUserId;
        }

        public String getType()
        {
                return this.type;
        }

        public String getMessage()
        {
                return this.message;
        }

        public String getUserId()
        {
                return this.toUserId;
        }

//	public String getJSONEvent(){
//		JSONObject obj = new JSONObject();
//		try {
//			obj.put("type", type);
//			obj.put("message", message);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		return obj.toString();
//	}
}
