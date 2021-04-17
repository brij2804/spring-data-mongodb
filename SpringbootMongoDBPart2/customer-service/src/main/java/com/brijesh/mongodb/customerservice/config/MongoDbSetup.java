package com.brijesh.mongodb.customerservice.config;

import com.mongodb.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoAdmin;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MongoDbSetup {

    private Logger logger = LoggerFactory.getLogger(MongoDbSetup.class);

    @Autowired
    private MongoDbConfig mongoDbConfig;

    @Autowired
    private AppConfig appConfig;

    //check if customer database created and return the database
    public MongoDatabase getDatabase(MongoClient client){
        logger.info("getDatabase()");
        MongoDatabase database = null;
        if(client==null){
            client=mongoDbConfig.mongoClient();
        }
        String dbName=appConfig.getDbName();
        logger.info("dbName: "+dbName);
        if(checkMongoClient(client)){
            database =client.getDatabase(dbName);
            if(database==null){
                if(createDatabase()){
                    logger.info("database created");
                    database =client.getDatabase(dbName);
                    logger.info("database : "+database.getName());
                }
            }
        }
        return database;
    }

    //create customer database
    public boolean createDatabase(){
        logger.info("createDatabase()");

        MongoClient client=mongoDbConfig.mongoClient();
        //starting session
        ClientSession session =client.startSession();
        logger.info("session started");
        session.startTransaction();
        logger.info("transaction started");

        boolean created= false;
        String dbname=appConfig.getDbName();
        logger.info("dbname from properties :"+dbname);

        if(checkMongoClient(client)){
            MongoAdmin admin= mongoAdmin(client);
            if(admin!=null){
                logger.info("creating database");
                admin.createDatabase(dbname);
                logger.info("database created");
                created=true;
            }
        }
        session.commitTransaction();
        logger.info("transaction committed");
        session.close();
        logger.info("session closed");
        client.close();
        logger.info("client closed");
        logger.info("createDatabase() flag"+created);
        return created;
    }

    //check if the customer collection created
    public MongoCollection getCollection(){
        MongoClient client=mongoDbConfig.mongoClient();
        MongoDatabase database=getDatabase(client);
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
        logger.info("createCollection");
        MongoClient client=mongoDbConfig.mongoClient();
        MongoDatabase database=getDatabase(client);
        String collectionName=appConfig.getCollectionName();
        logger.info("collectionName"+collectionName);
        // starting session and transaction

        ClientSession session =client.startSession();
        logger.info("session started");


        database.createCollection(session,collectionName);
        logger.info("collection created");


        session.close();
        logger.info("session closed");
        client.close();
        logger.info("client closed");
    }

    //show all the databases in server
    public List<String> showDatabases(){
        logger.info("showDatabases");
        MongoClient client=mongoDbConfig.mongoClient();
        List<String> dbNames=new ArrayList<>();
        if(checkMongoClient(client)){
            logger.info("fetching listDatabaseNames");
            MongoIterable<String> listDatabaseNames=client.listDatabaseNames();
            for (String dbname: listDatabaseNames) {
                dbNames.add(dbname);
                logger.info(" dbname : "+dbname);
            }
            client.close();
        }

       return dbNames;
    }

    // show all collections in the given database
    public void showCollections(){
        MongoClient client=mongoDbConfig.mongoClient();
        MongoDatabase database=getDatabase(client);
        MongoIterable<String> listCollectionNames=database.listCollectionNames();
        for (String collection: listCollectionNames) {
            System.out.println(" collection : "+collection);
        }
    }

    //check if mongo client is created
    public boolean checkMongoClient(MongoClient client){
        logger.info(" checkMongoClient() ");
        if(client!=null){
            logger.info(" checkMongoClient(): "+true);
         return true;
        }else {
            logger.info(" checkMongoClient(): "+false);
            return false;
        }
    }

    //check if mongo client is created : UI
    public boolean checkMongoClientForUI(){
        logger.info(" checkMongoClientForUI() ");
        MongoClient client=mongoDbConfig.mongoClient();
        if(client!=null){
            logger.info(" checkMongoClientForUI(): "+true);
            return true;
        }else {
            logger.info(" checkMongoClientForUI(): "+false);
            return false;
        }
    }

    // creating MongoAdmin
    public MongoAdmin mongoAdmin(MongoClient client){
        logger.info("mongoAdmin()");
        MongoAdmin mongoAdmin = null;
        if(client!=null){
            mongoAdmin=new MongoAdmin(client);
            logger.info("MongoAdmin created",mongoAdmin);
        }
        return mongoAdmin;
    }

}
