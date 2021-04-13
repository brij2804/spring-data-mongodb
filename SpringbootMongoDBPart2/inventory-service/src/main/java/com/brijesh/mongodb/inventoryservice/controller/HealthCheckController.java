package com.brijesh.mongodb.inventoryservice.controller;


import com.brijesh.mongodb.inventoryservice.service.HealthCheckService;
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

    @GetMapping("/inventory-service/health-check/showDatabases")
    public List<String> showDatabases(){
        logger.info("showDatabases()");
        logger.info("path : "+"/inventory-service/health-check/showDatabases");
        return healthCheckService.getDatabases();
    }
    @GetMapping("/inventory-service/health-check/hello-world")
    public String helloworld(){
        logger.info("helloworld()");
        logger.info("path : "+"/inventory-service/health-check/hello-world");
        return "hello-world";
    }
    @GetMapping("/inventory-service/health-check/check-MongoClient")
    public Boolean checkMongoClient(){
        logger.info("checkMongoClient()");
        logger.info("path : "+"/inventory-service/health-check/check-MongoClient");
        return healthCheckService.checkMongoClient();
    }

    @GetMapping("/inventory-service/health-check/check-InventoryDb")
    public String checkDatabase(){
        logger.info("checkDatabase()");
        logger.info("path : "+"/inventory-service/health-check/check-InventoryDb");
        String dbName="Not Database";
        dbName= healthCheckService.getDatabase();
        logger.info("dbName :"+dbName);
        return dbName;
    }

    @GetMapping("/inventory-service/health-check/create-InventoryDb")
    public boolean createDatabase(){
        logger.info("createDatabase()");
        logger.info("path : "+"/inventory-service/health-check/create-InventoryDb");
        return healthCheckService.createDatabase();
    }

    @GetMapping("/inventory-service/health-check/create-InventoryCollection")
    public void createCollection(){
        logger.info("createCollection()");
        logger.info("path : "+"/inventory-service/health-check/create-InventoryCollection");
        healthCheckService.createCollection();
    }

}
