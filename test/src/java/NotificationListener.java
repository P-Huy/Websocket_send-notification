/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
import java.util.ArrayList;
import java.util.List;

public class NotificationListener
{

        private static final NotificationListener instance = new NotificationListener();

        private List<DefaultListener> listeners = new ArrayList<>();

        private NotificationListener()
        {
                // Private constructor to enforce singleton pattern
        }

        public static NotificationListener getInstance()
        {
                return instance;
        }

        public void addListener(DefaultListener l)
        {
                listeners.add(l);
        }

        public void removeListener(DefaultListener l)
        {
                listeners.remove(l);
        }

        public void notifyListeners(NotificationEvent event)
        {
                for (DefaultListener l : listeners)
                {
                        l.onNotification(event);
                }
        }

        public void checkForUpdates(String userId)
        {
                // Manually check the database for updates
        }
}
