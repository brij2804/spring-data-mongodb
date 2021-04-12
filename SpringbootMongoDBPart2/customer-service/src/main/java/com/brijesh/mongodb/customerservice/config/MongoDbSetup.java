package com.brijesh.mongodb.customerservice.config;

import com.brijesh.mongodb.customerservice.entity.Customer;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.stereotype.Component;

@Component
public class MongoDbSetup {

    @Autowired
    private MongoDbConfig mongoDbConfig;

    @Autowired
    private AppConfig appConfig;

    //check if customer database created and return the database
    public MongoDatabase getDatabase(){
        MongoClient client=mongoDbConfig.mongoClient();
        MongoDatabase database = null;
        database =client.getDatabase(appConfig.getDbName());
        if(database==null){
            createCustomerDb();
            database =client.getDatabase(appConfig.getDbName());
        }
        return database;
    }

    //create customer database
    public void createCustomerDb(){
        MongoAdmin admin= mongoDbConfig.mongoAdmin();
        admin.createDatabase(appConfig.getDbName());
    }

    //check if the customer collection created
    public MongoCollection getCollection(){
        MongoDatabase database=getDatabase();
        MongoCollection collection = null;
        collection =database.getCollection(appConfig.getCollectionName());
        if(collection==null){
            createCollection();
            collection =database.getCollection(appConfig.getCollectionName());
        }
        return collection;
    }

    //create customer collection
    public void createCollection(){
        MongoDatabase database=getDatabase();
        database.createCollection(appConfig.getCollectionName());
    }



}
