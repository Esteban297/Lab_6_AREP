package com.eci.arep.entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;

@Entity
public class LogData {

    @Id
    private ObjectId id;

    private String message;

    private Date date;

    public LogData(){}

    public LogData(ObjectId id, String message, Date date){
        this.id=id;
        this.message=message;
        this.date=date;
    }

    public ObjectId getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
