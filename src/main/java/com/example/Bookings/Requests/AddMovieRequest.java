package com.example.Bookings.Requests;

import com.example.Bookings.Enums.Language;
import java.time.LocalDate;

public class AddMovieRequest {
    private String movieName;
    private Double duration;
    private LocalDate releaseDate;
    private Language language;
    private Double rating;
    private String image;

    // Constructor
    public AddMovieRequest() {}

    public AddMovieRequest(String movieName,String image, Double duration, LocalDate releaseDate, Language language, Double rating) {
        this.movieName = movieName;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.language = language;
        this.rating = rating;
        this.image = image;
    }

    // Getter and Setter methods
    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
