package org.example;

import org.springframework.stereotype.Component;

@Component("emergencyService")
public class EmergencyNotificationService implements NotificationService{
    @Override
    public void sendNotification(int patientId, String message) {

        System.out.println("!!! CRITICAL ICU ALERT !!!");
        System.out.println("Patient ID: " + patientId);
        System.out.println("URGENT MESSAGE: " + message);
        System.out.println("Emergency notification sent!");
    }
}
