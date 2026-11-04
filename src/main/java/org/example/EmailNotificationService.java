package org.example;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;

@Component
@Primary
public class EmailNotificationService implements NotificationService{
    @Override
    public void sendNotification(int patientId, String message) {

        System.out.println("EMAIL NOTIFICATION");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Message: " + message);
        System.out.println("Email sent successfully!");
    }

}
