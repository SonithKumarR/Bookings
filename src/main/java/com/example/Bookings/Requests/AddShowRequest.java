package com.example.Bookings.Requests;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddShowRequest {
    private LocalDate showDate;
    private LocalTime showTime;
    private int movieId;
    private int theaterId;
    // Constructor
    public AddShowRequest() {}

    public AddShowRequest(LocalDate showDate, LocalTime showTime, int movieId, int theaterId) {
        this.showDate = showDate;
        this.showTime = showTime;
        this.movieId = movieId;
        this.theaterId = theaterId;
    }

    // Getter and Setter methods
    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }
}
