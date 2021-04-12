package com.brijesh.mongodb.customerservice;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class TestingConnection {

    public static void main(String[] args) {
       MongoClient client= MongoClients.create("mongodb://127.0.0.1:27017");
        //System.out.println(client.listDatabaseNames().toString());
        for(String dbname: client.listDatabaseNames()){
            System.out.println(dbname);
        }
        System.out.println(client);
    }
}
