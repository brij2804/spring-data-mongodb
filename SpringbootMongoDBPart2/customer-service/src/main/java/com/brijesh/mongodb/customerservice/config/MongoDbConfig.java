package com.brijesh.mongodb.customerservice.config;

import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

@Configuration
@EnableMongoRepositories(basePackages = "com.brijesh.mongodb.customerservice.repository")
public class MongoDbConfig {

    private Logger logger = LoggerFactory.getLogger(MongoDbConfig.class);

   /* @Bean
    public MongoClient getMongoClient(){
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        return mongoClient;
    }*/

    @Autowired
    private AppConfig appConfig;

    //@Bean
    public  MongoClient mongoClient() {
        logger.info("mongoClient()");
        logger.info("appconfig mongoServer url: "+appConfig.getMongoServerUrl());
        MongoClient client = null;
        if(appConfig.getMongoServerUrl()!=null){
             client=MongoClients.create(appConfig.getMongoServerUrl());
            logger.info("MongoClient client created from properties",client);
        }else{
             client=MongoClients.create("mongodb://127.0.0.1:27017");
            logger.info("MongoClient client created hardcoded",client);
        }
        return client;
    }

    //connecting to multiple hosts
    public void mongoClients(){
        //MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017,localhost:27018,localhost:27019");
    }

}
