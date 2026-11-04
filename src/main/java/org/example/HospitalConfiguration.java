package org.example;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HospitalConfiguration {
    @Value("${hospital.name:General City Hospital}")
    private String hospitalName;

    @Value("${HOSPITAL_API_SECRET}")
    private String apiSecret;

    public String getHospitalName() {
        return hospitalName;
    }

    public String getApiSecret() {
        return apiSecret;
    }
}








