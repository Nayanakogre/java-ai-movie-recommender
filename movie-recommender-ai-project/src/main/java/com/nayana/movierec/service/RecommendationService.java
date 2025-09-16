package com.nayana.movierec.service;

import com.nayana.movierec.ai.MovieRecommender;
import com.nayana.movierec.model.Movie;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

@Service
public class RecommendationService {
    private final List<Movie> movies = new ArrayList<>();
    private final MovieRecommender recommender = new MovieRecommender();

    public RecommendationService() {
        try {
            InputStream is = getClass().getResourceAsStream("/movies.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = br.readLine(); // header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 4);
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String genre = parts[2];
                String[] vec = parts[3].replace(""","").split(";");
                double[] features = Arrays.stream(vec).mapToDouble(Double::parseDouble).toArray();
                movies.add(new Movie(id,title,genre,features));
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public List<Movie> getAllMovies() { return movies; }

    public List<Movie> recommendByMovie(String title, int topN) {
        Movie target = movies.stream().filter(m -> m.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
        if(target==null) return List.of();
        return recommender.recommendByMovie(target, movies, topN);
    }

    public List<Movie> recommendByGenre(String genre, int topN) {
        return recommender.recommendByGenre(genre, movies, topN);
    }
}
