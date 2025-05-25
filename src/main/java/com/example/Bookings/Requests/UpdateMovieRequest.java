package com.example.Bookings.Requests;

import com.example.Bookings.Enums.Language;

public class UpdateMovieRequest {
    private String movieName;
    private Language newLanguage;
    private Double rating;

    // Constructor
    public UpdateMovieRequest() {}

    public UpdateMovieRequest(String movieName, Language newLanguage, Double rating) {
        this.movieName = movieName;
        this.newLanguage = newLanguage;
        this.rating = rating;
    }

    // Getter and Setter methods
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Language getNewLanguage() {
        return newLanguage;
    }

    public void setNewLanguage(Language newLanguage) {
        this.newLanguage = newLanguage;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
