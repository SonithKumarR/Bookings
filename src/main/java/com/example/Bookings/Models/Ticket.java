package com.example.Bookings.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theaterName;
    private int totalAmount;
    private String emailId;

    @ManyToOne
    private Shows shows;

    @ManyToOne
    private User user;

    // No-args constructor
    public Ticket() {}

    // All-args constructor
    public Ticket(int ticketId,String emailId, String bookedSeats, LocalDate showDate, LocalTime showTime,
                  String movieName, String theaterName, int totalAmount, Shows shows, User user) {
        this.ticketId = ticketId;
        this.emailId=emailId;
        this.bookedSeats = bookedSeats;
        this.showDate = showDate;
        this.showTime = showTime;
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.totalAmount = totalAmount;
        this.shows = shows;
        this.user = user;
    }

    // Getters and Setters
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

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

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
