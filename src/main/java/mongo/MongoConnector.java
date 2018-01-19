/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/**
 *
 * @author Diego
 */
public  class MongoConnector {
    
    public static MongoDatabase Connect(String dbName){
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://booksadmin:diegomary@ds061371.mongolab.com:61371/diegomary88"));
        return  mongoClient.getDatabase(dbName);     
    
    }
    
    
}
