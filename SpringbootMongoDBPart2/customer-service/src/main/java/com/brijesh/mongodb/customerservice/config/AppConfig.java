package com.brijesh.mongodb.customerservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Configuration
@ConfigurationProperties(prefix = "customer-service")
public class AppConfig {
    private String mongoServerUrl;
    private String dbName;
    private String collectionName;
}
