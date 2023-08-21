package com.consumoAPI.demo.service;

import com.consumoAPI.demo.model.Pokemon;
import com.consumoAPI.demo.model.Response;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class APIPokemon {

    private static final String API_URL = "https://pokeapi.co/api/v2/pokemon";
    private static HttpURLConnection connection;
    static final Logger logger = Logger.getLogger(APIPokemon.class.getName());
    public static List<Pokemon> getPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        String nextUrl = API_URL;

        try {
            // Set up the connection
            URL endpoint = new URL(API_URL);
            connection = (HttpURLConnection) endpoint.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = connection.getResponseCode();

            if (responseCode != 200) {
                logger.severe("Error: " + responseCode);
            }
            if (responseCode == HttpURLConnection.HTTP_OK) {
                logger.info("Conexion establecida!");


                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();


                Gson gson = new Gson();
                Response responseObject = gson.fromJson(response.toString(), Response.class);
                if (responseObject != null) {
                    pokemons.addAll(responseObject.getResults());
                    nextUrl = responseObject.getNext();
                    logger.info("Obtener la URL : " + nextUrl);
                } else {
                    logger.info("No hay más URL!");
                    nextUrl = null;
                }
            } else {
                nextUrl = null;
            }
        } catch (IOException e) {
            logger.severe("Error: " + e.getMessage());
        } finally {
            connection.disconnect();
        }
        return pokemons;
    }
}
