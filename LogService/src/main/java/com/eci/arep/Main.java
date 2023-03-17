package com.eci.arep;

import com.eci.arep.entity.LogData;
import com.eci.arep.entity.api_request.LogDataRequest;
import com.eci.arep.repository.MongoRepository;
import com.google.gson.Gson;

import java.util.Date;

import static spark.Spark.*;

public class Main {

    public static MongoRepository mongoRepository = new MongoRepository();
    public static void main(String[] args) {
        port(getPort());
        Gson gson = new Gson();
        post("/logs",(request, response) -> {
            response.type("application/json");
            LogDataRequest logDataRequest = gson.fromJson(request.body(),LogDataRequest.class);
            LogData logData = new LogData();
            logData.setMessage(logDataRequest.getMessage());
            logData.setDate(new Date());
            return mongoRepository.addMessage(logData);
        },gson::toJson);
        get("/logs", (request,response) -> {
            response.type("application/json");
            return mongoRepository.getAllData();
        },gson::toJson );
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}