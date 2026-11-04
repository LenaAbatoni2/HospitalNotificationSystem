package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages = "org.example")
public class AppConfig {
    @Value("${hospital.name:General City Hospital}")
    private String hospitalName;

    @Value("${HOSPITAL_API_SECRET}")
    private String apiSecret;

    public void displayHospitalName() {
        System.out.println("Hospital Name: " + hospitalName);
    }

    public boolean isSecretConfigured() {
        return apiSecret != null && !apiSecret.isEmpty();
    }
}
