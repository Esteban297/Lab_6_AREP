package com.eci.arep.entity.api_request;

import java.util.Date;

public class LogDataRequest {
    private String message;

    public LogDataRequest(){};

    public LogDataRequest(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
