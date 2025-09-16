package com.nayana.movierec.controller;

import com.nayana.movierec.model.Movie;
import com.nayana.movierec.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final RecommendationService service;

    public MovieController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<Movie> listAll() { return service.getAllMovies(); }

    @GetMapping("/recommend")
    public List<Movie> recommend(@RequestParam String movie, @RequestParam(defaultValue="5") int topN) {
        return service.recommendByMovie(movie, topN);
    }

    @GetMapping("/recommendByGenre")
    public List<Movie> recommendByGenre(@RequestParam String genre, @RequestParam(defaultValue="5") int topN) {
        return service.recommendByGenre(genre, topN);
    }
}
