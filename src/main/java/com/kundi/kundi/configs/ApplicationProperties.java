package com.kundi.kundi.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    private String jwtSecret;

    private int tokenValidityInSeconds;

    private int tokenValidityInSecondsForRememberMe;

    private String baseUrl;
    private String notificationUrl;

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