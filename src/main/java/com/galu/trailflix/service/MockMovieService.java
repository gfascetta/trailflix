package com.galu.trailflix.service;
import org.json.JSONArray;
import org.json.JSONObject;
public class MockMovieService {
    // Instancia única de la clase (Singleton)
    private static MockMovieService instance;

    // Constructor privado para evitar instanciación externa
    private MockMovieService() {}

    // Método para obtener la única instancia de la clase
    public static synchronized MockMovieService getInstance() {
        if (instance == null) {
            instance = new MockMovieService();
        }
        return instance;
    }

    // Método para devolver un JSON con películas mock
    public String getMockMoviesJson() {
        JSONArray movies = new JSONArray();

        JSONObject movie1 = new JSONObject();
        movie1.put("title", "Inception");
        movie1.put("year", 2010);
        movie1.put("director", "Christopher Nolan");

        JSONObject movie2 = new JSONObject();
        movie2.put("title", "The Matrix");
        movie2.put("year", 1999);
        movie2.put("director", "Lana Wachowski, Lilly Wachowski");

        movies.put(movie1);
        movies.put(movie2);

        return movies.toString();  // Devuelve el JSON como String
    }
}