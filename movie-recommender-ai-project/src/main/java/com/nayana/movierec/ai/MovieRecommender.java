package com.nayana.movierec.ai;

import smile.math.distance.CosineDistance;
import com.nayana.movierec.model.Movie;

import java.util.*;
import java.util.stream.Collectors;

public class MovieRecommender {
    private final CosineDistance cosine = new CosineDistance();

    public List<Movie> recommendByMovie(Movie target, List<Movie> movies, int topN) {
        return movies.stream()
                .filter(m -> m.getId() != target.getId())
                .sorted((a,b) -> Double.compare(
                        1 - cosine.d(target.getFeatures(), b.getFeatures()),
                        1 - cosine.d(target.getFeatures(), a.getFeatures())
                ))
                .limit(topN)
                .collect(Collectors.toList());
    }

    public List<Movie> recommendByGenre(String genre, List<Movie> movies, int topN) {
        return movies.stream()
                .filter(m -> m.getGenre().equalsIgnoreCase(genre))
                .limit(topN)
                .collect(Collectors.toList());
    }
}
