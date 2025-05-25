package com.example.Bookings.Requests;

public class AddTheaterRequest {
    private int noOfScreens;
    private String name;
    private String address;

    // Constructor
    public AddTheaterRequest() {}

    public AddTheaterRequest(int noOfScreens, String name, String address) {
        this.noOfScreens = noOfScreens;
        this.name = name;
        this.address = address;
    }

    // Getter and Setter methods
    public int getNoOfScreens() {
        return noOfScreens;
    }

    public void setNoOfScreens(int noOfScreens) {
        this.noOfScreens = noOfScreens;
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
}
