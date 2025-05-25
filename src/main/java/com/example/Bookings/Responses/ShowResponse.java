package com.example.Bookings.Responses;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowResponse {

    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theaterName;
    private int theaterId;

    // Constructor
    public ShowResponse(){}

    public ShowResponse(int theaterId,LocalDate showDate, LocalTime showTime, String movieName, String theaterName) {
        this.showDate = showDate;
        this.theaterId = theaterId;
        this.showTime = showTime;
        this.movieName = movieName;
        this.theaterName = theaterName;
    }

    // Getters
    public int getTheaterId() {return theaterId;}

    public void setTheaterId(int theaterId) { this.theaterId = theaterId;}

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    // Setters
    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}
