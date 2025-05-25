package com.example.Bookings.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theaterId;

    private String name;

    private String address;

    private int noOfScreens;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<Shows> showsList;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeatList = new ArrayList<>();

    // No-args constructor
    public Theater() {}

    // All-args constructor
    public Theater(int theaterId, String name, String address, int noOfScreens,
                   List<Shows> showsList, List<TheaterSeat> theaterSeatList) {
        this.theaterId = theaterId;
        this.name = name;
        this.address = address;
        this.noOfScreens = noOfScreens;
        this.showsList = showsList;
        this.theaterSeatList = theaterSeatList;
    }

    // Getters and Setters
    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNoOfScreens() {
        return noOfScreens;
    }

    public void setNoOfScreens(int noOfScreens) {
        this.noOfScreens = noOfScreens;
    }

    public List<Shows> getShowsList() {
        return showsList;
    }

    public void setShowsList(List<Shows> showsList) {
        this.showsList = showsList;
    }

    public List<TheaterSeat> getTheaterSeatList() {
        return theaterSeatList;
    }

    public void setTheaterSeatList(List<TheaterSeat> theaterSeatList) {
        this.theaterSeatList = theaterSeatList;
    }
}
