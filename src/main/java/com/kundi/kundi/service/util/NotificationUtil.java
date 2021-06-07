package com.kundi.kundi.service.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kundi.kundi.configs.ApplicationProperties;
import com.kundi.kundi.domain.enumeration.AlertType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotificationUtil {
    private final Logger log = LoggerFactory.getLogger(NotificationUtil.class);
    private final ApplicationProperties applicationProperties;

    public NotificationUtil(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public int sendSMS(String to, String content, String referenceId) {
        log.info("Send sms to '{}' with content={}", to, content);
        log.info("Send sms to '{}' with content={}", to, content);

        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("to", to);
        messageMap.put("from", applicationProperties.getAlertSourceSmsAddress());
        //messageMap.put("messageType", AlertType.SMS.name());
        messageMap.put("message", content);
        messageMap.put("refId", referenceId);


        ObjectMapper objectMapper = new ObjectMapper();
        log.info("Request to send SMS : {}", messageMap);
        String jsonRequest = null;
        try {
            jsonRequest = objectMapper.writeValueAsString(messageMap);
            log.info("Request body : {}", jsonRequest);

            Map<String, String> headers = new HashMap<>();
            log.info("Request headers : {}", headers);
            // headers.put("Content-Type:","application/json");


            //HTTPResponse httpResponse = HTTPClient.send(applicationProperties.getNotificationUrl(), jsonRequest, "POST", applicationProperties.getContentType(), headers, applicationProperties.getConnectTimeout(), applicationProperties.getReadTimeout());
            HTTPResponse httpResponse = HTTPClient.send(applicationProperties.getNotificationUrl(), jsonRequest, "POST", applicationProperties.getContentType(), headers, applicationProperties.getConnectTimeout(), applicationProperties.getReadTimeout(),applicationProperties.getAuthorizationToken());

            Map<String, String> responseBody = objectMapper.readValue(httpResponse.getBody(), new TypeReference<Map<String, String>>() {
            });

            log.info("Send SMS Response : {}", httpResponse);
            if (httpResponse.getResponseCode() == 200) {
                // successful
                log.info("Successfully sent SMS. Response = {}", responseBody);
            }
            return httpResponse.getResponseCode();

        } catch (IOException e) {
            log.error("Error Sending SMS", e);
        }
        return 0;
    }

    public Integer sendEmail(String to, String subject, String content, String referenceId, boolean isMultipart, boolean isHtml) {
        log.info("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
            isMultipart, isHtml, to, subject, content);

        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("destinationAddress", to);
        messageMap.put("messageType", "EMAIL");
        messageMap.put("subject", subject);
        messageMap.put("message", content);
        messageMap.put("referenceId", referenceId);
        messageMap.put("isHtml", String.valueOf(isHtml));
        messageMap.put("sourceAddress", applicationProperties.getAlertSourceEmailAddress());


        ObjectMapper objectMapper = new ObjectMapper();
        log.debug("Request to send email : {}", messageMap);
        String jsonRequest = null;
        try {
            jsonRequest = objectMapper.writeValueAsString(messageMap);

            Map<String, String> headers = new HashMap<>();

            log.info("JsonRequest: {}", jsonRequest);
            HTTPResponse httpResponse = HTTPClient.send(applicationProperties.getNotificationUrl(), jsonRequest, "POST", applicationProperties.getContentType(), headers, applicationProperties.getConnectTimeout(), applicationProperties.getReadTimeout(),applicationProperties.getAuthorizationToken());

            Map<String, String> responseBody = objectMapper.readValue(httpResponse.getBody(), new TypeReference<Map<String, String>>() {
            });

            if (httpResponse.getResponseCode() == 200) {
                // successful
                log.info("Successfully sent email code:{}", httpResponse.getResponseCode());
                return httpResponse.getResponseCode();
            } else {
                log.error("Error Sending email. Response = {}", responseBody);

            }

        } catch (IOException e) {
            log.error("Error Sending email", e);
        }
        return 0;
    }

}
