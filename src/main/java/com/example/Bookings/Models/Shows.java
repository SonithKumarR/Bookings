package com.example.Bookings.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Shows {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;

    private LocalDate showDate;

    private LocalTime showTime;

    private String movieName;

    private  String theaterName;

    @JoinColumn
    @ManyToOne
    private Movie movie;

    @JoinColumn
    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "shows", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList;

    @OneToMany(mappedBy = "shows", cascade = CascadeType.ALL)
    private List<Ticket> ticketList;

    // Constructors
    public Shows() {}

    public Shows(int showId, LocalDate showDate,String movieName,String theaterName, LocalTime showTime, Movie movie, Theater theater
                 ,List<ShowSeat> showSeatList, List<Ticket> ticketList) {
        this.showId = showId;
        this.showDate = showDate;
        this.showTime = showTime;
        this.movie = movie;
        this.theater = theater;
        this.showSeatList = showSeatList;
        this.ticketList = ticketList;
        this.movieName = movieName;
        this.theaterName = theaterName;
    }

    // Getters and Setters

    public void  setMovieName(String movieName){
        this.movieName = movieName;
    }

    public String getMovieName(){return movieName;}

    public void setTheaterName(String theaterName){this.theaterName = theaterName;}

    public String getTheaterName(){return theaterName;}

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<ShowSeat> getShowSeatList() {
        return showSeatList;
    }

    public void setShowSeatList(List<ShowSeat> showSeatList) {
        this.showSeatList = showSeatList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

}
