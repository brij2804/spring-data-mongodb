package com.brijesh.mongodb.inventoryservice.service;

import com.brijesh.mongodb.inventoryservice.config.MongoDbSetup;
import com.mongodb.client.MongoDatabase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthCheckService {
    private Logger logger = LoggerFactory.getLogger(HealthCheckService.class);

    @Autowired
    private MongoDbSetup mongoDbSetup;

    public List<String> getDatabases(){
        logger.info("getDatabases()");
        return mongoDbSetup.showDatabases();
    }

    public boolean checkMongoClient(){
        logger.info("checkMongoClient()");
        return mongoDbSetup.checkMongoClientForUI();
    }

    public String getDatabase(){
        logger.info("getDatabase()");
        MongoDatabase mongoDatabase=mongoDbSetup.getDatabase(null);
        if(mongoDatabase!=null){
            logger.info("mongoDatabase.getName() : "+mongoDatabase.getName());
              return mongoDatabase.getName();
        }
        return null;
    }

    public boolean createDatabase(){
        logger.info("createDatabase()");
       return mongoDbSetup.createDatabase();
    }

    public void createCollection(){
        logger.info("createCollection()");
        mongoDbSetup.createCollection();
    }
}
