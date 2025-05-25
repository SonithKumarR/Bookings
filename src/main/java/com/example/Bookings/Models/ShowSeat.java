package com.example.Bookings.Models;

import com.example.Bookings.Enums.SeatType;
import jakarta.persistence.*;

@Entity
public class ShowSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showSeatId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Boolean isBooked;

    private Boolean isFoodAttached;

    @ManyToOne
    private Shows shows;

    // No-args constructor
    public ShowSeat() {}

    // All-args constructor
    public ShowSeat(int showSeatId, String seatNo, SeatType seatType, Boolean isBooked, Boolean isFoodAttached, Shows shows) {
        this.showSeatId = showSeatId;
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.isBooked = isBooked;
        this.isFoodAttached = isFoodAttached;
        this.shows = shows;
    }

    // Getters and Setters
    public int getShowSeatId() {
        return showSeatId;
    }

    public void setShowSeatId(int showSeatId) {
        this.showSeatId = showSeatId;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Boolean getIsBooked() {
        return isBooked;
    }

    public void setIsBooked(Boolean isBooked) {
        this.isBooked = isBooked;
    }

    public Boolean getIsFoodAttached() {
        return isFoodAttached;
    }

    public void setIsFoodAttached(Boolean isFoodAttached) {
        this.isFoodAttached = isFoodAttached;
    }

    public Shows getShows() {
        return shows;
    }

    public void setShows(Shows shows) {
        this.shows = shows;
    }
}
