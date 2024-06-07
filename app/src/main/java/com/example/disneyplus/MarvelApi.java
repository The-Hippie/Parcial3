package com.example.disneyplus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Callback;

public class MarvelApi {

    private static final String API_KEY = "YOUR_API_KEY";
    private static final String API_SECRET = "YOUR_API_SECRET";
    private static final String BASE_URL = "https://gateway.marvel.com/v1/public/";

    public static void obtenerSuperheroes(Callback<List<Superhero>> callback) {
        // Lógica para obtener los superhéroes de la API de Marvel
        // Por ahora, solo creamos una lista vacía
        List<Superhero> superhero = new ArrayList<>();

        callback.getClass();
    }


}

