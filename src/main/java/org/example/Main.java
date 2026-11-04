package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
// Initialize Spring IoC Container
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Get PatientAlertProcessor bean
        PatientAlertProcessor processor =
                context.getBean(PatientAlertProcessor.class);

        // Test routine notification
        processor.processRoutineAlert(
                101,
                "Your appointment is tomorrow."
        );

        // Test emergency notification
        processor.processEmergencyAlert(
                102,
                "Critical ICU patient needs immediate attention!"
        );

        // Close container
        context.close();
        }
    }
