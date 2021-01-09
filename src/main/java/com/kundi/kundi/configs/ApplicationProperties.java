package com.kundi.kundi.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private String jwtSecret;

    private int tokenValidityInSeconds;

    private int tokenValidityInSecondsForRememberMe;

    private String baseUrl;
    private String notificationUrl;
    private String alertSourceSmsAddress;

    private String alertSourceEmailAddress;

    private String contentType;

    private int connectTimeout;

    private int readTimeout;


    public int getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAlertSourceEmailAddress() {
        return alertSourceEmailAddress;
    }

    public void setAlertSourceEmailAddress(String alertSourceEmailAddress) {
        this.alertSourceEmailAddress = alertSourceEmailAddress;
    }

    public String getAlertSourceSmsAddress() {
        return alertSourceSmsAddress;
    }

    public void setAlertSourceSmsAddress(String alertSourceSmsAddress) {
        this.alertSourceSmsAddress = alertSourceSmsAddress;
    }

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public int getTokenValidityInSeconds() {
        return tokenValidityInSeconds;
    }

    public void setTokenValidityInSeconds(int tokenValidityInSeconds) {
        this.tokenValidityInSeconds = tokenValidityInSeconds;
    }

    public int getTokenValidityInSecondsForRememberMe() {
        return tokenValidityInSecondsForRememberMe;
    }

    public void setTokenValidityInSecondsForRememberMe(int tokenValidityInSecondsForRememberMe) {
        this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }


}