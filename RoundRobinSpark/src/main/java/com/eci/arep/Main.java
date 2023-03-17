package com.eci.arep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import static spark.Spark.*;
public class Main {
    public static String url = "http://ec2-54-172-15-68.compute-1.amazonaws.com:3400";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static int valueRoundRobin = 0;


    public static void main(String... args){

        port(getPort());

        staticFiles.location("/frontend");

        get("/app", (req,res) -> getData());

        post("/app", (req,res) -> getPost(req.body()));

    }

    public static String getData() throws IOException {
        URL obj = new URL(getURL());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader( con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return "GET request not worked";
        }
    }

    private static String getURL(){
        String[] ips = {"3.239.79.92", "52.91.202.172" , "3.239.53.75"};
        Random r = new Random();
        String ip = ips[r.nextInt(3)];
        String url = "http://" + ip + ":4567/logs" ;
        return url;
    }

    public static String getPost(String text) throws IOException {
        URL obj = new URL(getURL());
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "text/plain");
        con.setRequestProperty("Accept", "text/plain");
        con.setDoOutput(true);

        String jsonInput = "{" + "\"message\"" + ":" +  text  + "}";
        try(OutputStream os = con.getOutputStream()) {
            System.out.println(jsonInput);
            byte[] input = jsonInput.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = con.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader( con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return "POST request not worked";
        }

    }



    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}