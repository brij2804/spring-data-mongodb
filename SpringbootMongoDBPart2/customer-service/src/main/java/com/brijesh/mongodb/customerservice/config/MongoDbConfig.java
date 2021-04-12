package com.brijesh.mongodb.customerservice.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.brijesh.mongodb.customerservice.repository")
public class MongoDbConfig {

   /* @Bean
    public MongoClient getMongoClient(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        return mongoClient;
    }*/

    @Autowired
    private AppConfig appConfig;

    @Bean
    public  MongoClient mongoClient() {
        System.out.println("appconfig"+appConfig.getMongoServerUrl());
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoAdmin mongoAdmin(){
        MongoAdmin mongoAdmin=new MongoAdmin(mongoClient());
        return mongoAdmin;
    }

}
