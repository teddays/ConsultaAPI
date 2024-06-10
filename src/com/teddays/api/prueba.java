package com.teddays.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.teddays.api.modelo.Moneda;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class prueba {

    public static void main(String[] args) throws IOException {

        String url_str = "https://v6.exchangerate-api.com/v6/f041af840cd056d5b23fcea2/latest/USD";
        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = null;
        try {
            request = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        request.connect();

// Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        System.out.println(jsonobj);





// Accessing object
        String req_result = jsonobj.get("result").getAsString();



    }
}
