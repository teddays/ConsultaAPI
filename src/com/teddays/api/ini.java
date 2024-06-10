package com.teddays.api;

import com.teddays.api.consumo.ConsultaApiMoneda;
import com.teddays.api.consumo.ConsultaApiStarWars;
import com.teddays.api.modelo.Moneda;
import com.teddays.api.modelo.PeliculaStarWar;

import java.util.Scanner;

public class ini {
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaApiStarWars consulta1 = new ConsultaApiStarWars();
        ConsultaApiMoneda consulta2 = new ConsultaApiMoneda();

        int salir =1;
        //condicion de desigual
        while (salir != 0) {

            try {
//            System.out.println("Escribe el numero de la pelicula de Star Wars que desea consultar: ");
//            var numeroDePelicula = Integer.valueOf(lectura.nextLine());
//            PeliculaStarWar pelicula = consulta1.buscaPelicula(numeroDePelicula);
//            System.out.println(pelicula);

                System.out.println("\nIngresa el codigo ISO de la moneda de origen: ");
                var monedaOrigen = String.valueOf(lectura.nextLine()).toUpperCase();
                System.out.println("\nIngresa el codigo ISO de la moneda a convertir: ");
                var monedaConversion = String.valueOf(lectura.nextLine()).toUpperCase();
                Moneda moneda = consulta2.consultaMoneda(monedaOrigen, monedaConversion);
                System.out.println(moneda);

                //ConstruccionDeArchivo generador = new ConstruccionDeArchivo();
                //generador.guardarJson(pelicula);
            } catch (NumberFormatException e) {
                System.out.println("El numero ingresado no fue encontrado " + e.getMessage());
            } catch (RuntimeException e) { //| IOException
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicacion.");
            }


        }

    }
}
