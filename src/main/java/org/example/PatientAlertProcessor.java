
package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Component
public class PatientAlertProcessor {

    private final NotificationService notificationService;
    private final NotificationService emergencyService;

    @Value("${hospital.name:General City Hospital}")
    private String hospitalName;

    @Value("${HOSPITAL_API_SECRET}")
    private String hospitalApiSecret;

    @Autowired
    public PatientAlertProcessor(
            NotificationService notificationService,
            @Qualifier("emergencyService")
            NotificationService emergencyService) {

        this.notificationService = notificationService;
        this.emergencyService = emergencyService;
    }

    public void processRoutineAlert(int patientId, String message) {

        System.out.println("\nHospital: " + hospitalName);

        notificationService.sendNotification(patientId, message);
    }

    public void processEmergencyAlert(int patientId, String message) {

        System.out.println("\nHospital: " + hospitalName);

        emergencyService.sendNotification(patientId, message);
    }

    public void displayConfiguration() {

        System.out.println("Hospital: " + hospitalName);

        System.out.println("Hospital API Secret: " +
                (hospitalApiSecret != null && !hospitalApiSecret.isBlank()
                        ? "Successfully loaded"
                        : "Missing"));
    }

    public static void main(String[] args) {

        // Load environment variables from .env
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        String secret = System.getenv("HOSPITAL_API_SECRET");

        if (secret == null || secret.isBlank()) {
            secret = dotenv.get("HOSPITAL_API_SECRET");
        }

        String name = System.getenv("HOSPITAL_NAME");

        if (name == null || name.isBlank()) {
            name = dotenv.get(
                    "HOSPITAL_NAME",
                    "General City Hospital"
            );
        }

        if (secret == null || secret.isBlank()) {
            throw new IllegalStateException(
                    "HOSPITAL_API_SECRET is missing!"
            );
        }

        // Make configuration available to Spring
        System.setProperty("HOSPITAL_API_SECRET", secret);
        System.setProperty("hospital.name", name);

        // Initialize Spring IoC container
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve PatientAlertProcessor bean
        PatientAlertProcessor processor =
                context.getBean(PatientAlertProcessor.class);

        // Display configuration
        processor.displayConfiguration();

        // Test routine notification (Email - @Primary)
        processor.processRoutineAlert(
                101,
                "Your appointment is tomorrow."
        );

        // Test emergency notification (@Qualifier)
        processor.processEmergencyAlert(
                102,
                "Critical ICU patient needs immediate attention!"
        );

        // Close Spring container
        context.close();
    }
}
