package com.example.Bookings.Responses;

import java.time.LocalDate;
import java.time.LocalTime;

public class TicketResponse {
    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theaterName;
    private int totalAmount;

    // Default constructor
    public TicketResponse() {}

    // Parameterized constructor
    public TicketResponse(String bookedSeats, LocalDate showDate, LocalTime showTime, String movieName, String theaterName, int totalAmount) {
        this.bookedSeats = bookedSeats;
        this.showDate = showDate;
        this.showTime = showTime;
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.totalAmount = totalAmount;
    }

    // Getter and Setter methods
    public String getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(String bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

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

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
