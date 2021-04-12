package com.brijesh.mongodb.customerservice.controller;

import com.brijesh.mongodb.customerservice.config.MongoDbSetup;
import com.brijesh.mongodb.customerservice.service.HealthCheckService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthCheckController {

    private Logger logger = LoggerFactory.getLogger(HealthCheckController.class);

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping("/customer-service/health-check/showDatabases")
    public List<String> showDatabases(){
        logger.info("showDatabases()");
        logger.info("path : "+"/customer-service/health-check/showDatabases");
        return healthCheckService.getDatabases();
    }
    @GetMapping("/customer-service/health-check/hello-world")
    public String helloworld(){
        logger.info("helloworld()");
        logger.info("path : "+"/customer-service/health-check/hello-world");
        return "hello-world";
    }
    @GetMapping("/customer-service/health-check/check-MongoClient")
    public Boolean checkMongoClient(){
        logger.info("checkMongoClient()");
        logger.info("path : "+"/customer-service/health-check/check-MongoClient");
        return healthCheckService.checkMongoClient();
    }

    @GetMapping("/customer-service/health-check/check-CustomerDb")
    public String checkCustomerDb(){
        logger.info("checkCustomerDb()");
        logger.info("path : "+"/customer-service/health-check/check-CustomerDb");
        String dbName="Not Database";
        dbName= healthCheckService.getCustomerDB();
        logger.info("dbName :"+dbName);
        return dbName;
    }

    @GetMapping("/customer-service/health-check/create-CustomerDb")
    public boolean createCustomerDb(){
        logger.info("createCustomerDb()");
        logger.info("path : "+"/customer-service/health-check/create-CustomerDb");
        return healthCheckService.createCustomerDb();
    }

    @GetMapping("/customer-service/health-check/create-CustomerCollection")
    public void createCustomerCollection(){
        logger.info("createCustomerCollection()");
        logger.info("path : "+"/customer-service/health-check/create-CustomerCollection");
        healthCheckService.createCustomerCollection();
    }

}
