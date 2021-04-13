package com.brijesh.mongodb.inventoryservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "inventory-service")
public class AppConfig {
    private String mongoServerUrl;
    private String dbName;
    private String collectionName;
}
