package com.nayana.movierec.model;

public class Movie {
    private int id;
    private String title;
    private String genre;
    private double[] features;

    public Movie() {}

    public Movie(int id, String title, String genre, double[] features) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.features = features;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public double[] getFeatures() { return features; }

    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setFeatures(double[] features) { this.features = features; }
}
