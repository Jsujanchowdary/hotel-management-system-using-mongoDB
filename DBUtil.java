package com.vit.hms.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DBUtil {
    public MongoDatabase getDBConnection(){

        Logger monLogger = Logger.getLogger("org.mongodb.driver");
        monLogger.setLevel(Level.SEVERE);
            MongoClient mongo = new MongoClient("localhost",27017);
                MongoDatabase db=mongo.getDatabase("properties");
                return db;
            
    }
}


