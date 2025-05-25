package com.example.Bookings.Responses;

public class MovieResponse {
    private String movieName;
    private String image;
    private Double duration;
    private Double rating;

    //  Constructor
    public MovieResponse(){}

    public MovieResponse(String movieName, String image, Double duration, Double rating) {
        this.movieName = movieName;
        this.image = image;
        this.duration = duration;
        this.rating = rating;
    }

    //  Getters
    public String getMovieName() {
        return movieName;
    }

    public String getImage() {
        return image;
    }

    public Double getDuration() {
        return duration;
    }

    public Double getRating() {
        return rating;
    }

    // Setters
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
