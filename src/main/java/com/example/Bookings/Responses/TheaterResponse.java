package com.example.Bookings.Responses;

import java.time.LocalTime;

public class TheaterResponse {
    private int theaterId;
    private String name;
    private String address;

    public TheaterResponse(){}

    // Constructor
    public TheaterResponse(int theaterId, String name, String address) {
        this.theaterId = theaterId;
        this.name = name;
        this.address = address;
    }

    // Getter and Setter for theaterId
    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
