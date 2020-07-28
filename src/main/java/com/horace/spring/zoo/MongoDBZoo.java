package com.horace.spring.zoo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class MongoDBZoo {
    public static void main(String[] args) {

        MongoClientURI uri = new MongoClientURI(
                "mongodb+srv://horace:Super123@cluster0.zrgqp.azure.mongodb.net/spring?retryWrites=true&w=majority");

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("spring");
        database.createCollection("testCollection");
        mongoClient.close();
    }
}
