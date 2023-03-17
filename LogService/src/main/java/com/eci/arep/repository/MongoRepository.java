package com.eci.arep.repository;

import com.eci.arep.entity.LogData;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MongoRepository {

    MongoClient client = new MongoClient("3.237.236.139", 27017);
    Datastore dataStore = new Morphia().createDatastore(client,"logs");

    public String  addMessage(LogData logData){
        dataStore.save(logData);
        return "data save";
    }

    public List<LogData> getAllData(){
        List<LogData> arr = dataStore.find(LogData.class).asList();
        if (Objects.isNull(arr)){
            return new ArrayList<>();
        }
        return arr;
    }
}
