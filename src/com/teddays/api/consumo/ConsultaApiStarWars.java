package com.teddays.api.consumo;

import com.google.gson.Gson;
import com.teddays.api.modelo.PeliculaStarWar;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApiStarWars {

    public PeliculaStarWar buscaPelicula(int numeroDePelicula) {

        URI direccion = URI.create("https://swapi.py4e.com/api/films/" + numeroDePelicula + "/");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), PeliculaStarWar.class);
        }
        //vamos a capturar y mostrar cualquier error de Exception
        catch (Exception e) {
            throw new RuntimeException("No encontre esa pelicula");
        }

    }
}

