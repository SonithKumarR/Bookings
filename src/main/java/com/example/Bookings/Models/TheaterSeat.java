package com.example.Bookings.Models;

import com.example.Bookings.Enums.SeatType;
import jakarta.persistence.*;

@Entity
public class TheaterSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterId;

    private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @ManyToOne
    private Theater theater;

    // No-args constructor
    public TheaterSeat() {}

    // All-args constructor
    public TheaterSeat(int theaterId, String seatNo, SeatType seatType, Theater theater) {
        this.theaterId = theaterId;
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.theater = theater;
    }

    // Getters and Setters
    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
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

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
