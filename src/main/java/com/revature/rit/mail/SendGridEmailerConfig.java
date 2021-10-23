package com.revature.rit.mail;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SendGridEmailerConfig {

    @Value("${twilio.send-grid.api-key}")
    @Getter
    private String apiKey;

    @Value("${email}")
    @Getter
    private String fromEmail;

}
