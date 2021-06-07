package com.kundi.kundi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.kundi.kundi.configs.ApplicationProperties;
import com.kundi.kundi.domain.Member;
import com.kundi.kundi.service.util.AuthTemplateUtil;
import com.kundi.kundi.service.util.HTTPClient;
import com.kundi.kundi.service.util.HTTPResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class MailService {
    private static final String BASE_URL = "baseUrl";
    private final ApplicationProperties applicationProperties;
    private final Logger log = LoggerFactory.getLogger(MailService.class);

    public MailService(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Async
    public void sendPasswordResetEmail(Member user) {
        // Create reset link: e.g http://localhost:19645/#/reset/finish?key=27480715901825269197
        String name = user.getfName() + " " + user.getlName();
        String resetLink = getBaseUrl() + "/reset/finish?key=" + user.getResetKey();

        String content = AuthTemplateUtil.getPasswordResetEmail(name, resetLink);
        String subject = "Kundi Password Reset";
        sendEmail(user.getEmail(), subject, content, false, true);
    }

    @Async
    public void sendCreationEmail(Member user) {
        String name = user.getfName() +" " +user.getlName();
        String activationLink = getBaseUrl() + "/reset/finish?key=" + user.getResetKey();

        String content = AuthTemplateUtil.getAccountCreationEmail(name, activationLink);
        String subject = "Kundi Account Activation";
        sendEmail(user.getEmail(), subject, content, false, true);
    }

    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        log.info("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
                isMultipart, isHtml, to, subject, content);

        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("destinationAddress", to);
        messageMap.put("messageType", "EMAIL");
        messageMap.put("subject", subject);
        messageMap.put("message", content);
        messageMap.put("referenceId", UUID.randomUUID().toString());
        messageMap.put("isHtml", String.valueOf(isHtml));


        ObjectMapper objectMapper = new ObjectMapper();
        log.debug("Request to send email : {}", messageMap);
        String jsonRequest = null;
        try {
            jsonRequest = objectMapper.writeValueAsString(messageMap);

            Map<String, String> headers = new HashMap<>();

            HTTPResponse httpResponse = HTTPClient.send(applicationProperties.getNotificationUrl(), jsonRequest, "POST", "application/json", headers, 2000, 5000,applicationProperties.getAuthorizationToken());

            Map<String, String> responseBody = objectMapper.readValue(httpResponse.getBody(), new TypeReference<Map<String, String>>() {
            });

            if (httpResponse.getResponseCode() == 200) {
                // successful
                log.info("Successfully sent email");
            } else {
                log.error("Error Sending email. Response = {}", responseBody);

            }
        } catch (IOException e) {
            log.error("Error Sending email", e);
        }
    }

    private String getBaseUrl() {
        String baseUrl = System.getenv("BASE_URL");

        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            // get from configs
            baseUrl = applicationProperties.getBaseUrl();
        }
        return baseUrl;
    }
}
