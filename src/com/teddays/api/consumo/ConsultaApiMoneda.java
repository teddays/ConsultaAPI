package com.teddays.api.consumo;

import com.google.gson.Gson;
import com.teddays.api.modelo.Moneda;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApiMoneda {

    public Moneda consultaMoneda(String monedaOrigen,String monedaConversion){

        String apiKey = "f041af840cd056d5b23fcea2";
        //URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaOrigen);
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/pair/" + monedaOrigen + "/" + monedaConversion);

        //Construyendo el cliente para solicitudes
        HttpClient client = HttpClient.newHttpClient();
        //Construyendo la solicitud
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            //Construyendo la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        }
        //vamos a capturar y mostrar cualquier error de Exception
        catch (Exception e) {
            throw new RuntimeException("No encontre la moneda solicitada");
        }
    }
}
