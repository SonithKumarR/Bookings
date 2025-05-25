package com.example.Bookings.Models;

import com.example.Bookings.Enums.Language;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
//@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    @Column(unique = true)
    private String movieName;

    private String image;

    private Double duration;

    private LocalDate releaseDate;

    @Enumerated(value = EnumType.STRING)
    private Language language;

    private Double rating;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Shows> shows;


    // Constructors
    public Movie() {
    }

    public Movie(int movieId, String image,String movieName, Double duration, LocalDate releaseDate, Language language, Double rating, List<Shows> shows) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.language = language;
        this.rating = rating;
        this.shows = shows;
        this.image = image;
    }

    // Getters and Setters
    public void setImage(String image){
        this.image = image;
    }

    public String getImage(){
        return image;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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

    public List<Shows> getShows() {
        return shows;
    }

    public void setShows(List<Shows> shows) {
        this.shows = shows;
    }
}
