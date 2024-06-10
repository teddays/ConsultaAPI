package com.teddays.api.generador;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teddays.api.modelo.PeliculaStarWar;

import java.io.FileWriter;
import java.io.IOException;

public class ConstruccionDeArchivo {

    public void guardarJson(PeliculaStarWar pelicula) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(pelicula.title()+".json");
        escritura.write(gson.toJson(pelicula));
        escritura.close();

    }


}
