package com.example.Bookings.Requests;

public class AddTheaterSeatsRequest {
    private int theaterId;
    private int noOfClassicSeats;
    private int noOfPremiumSeats;

    // Constructor
    public AddTheaterSeatsRequest() {}

    public AddTheaterSeatsRequest(int theaterId, int noOfClassicSeats, int noOfPremiumSeats) {
        this.theaterId = theaterId;
        this.noOfClassicSeats = noOfClassicSeats;
        this.noOfPremiumSeats = noOfPremiumSeats;
    }

    // Getter and Setter methods
    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public int getNoOfClassicSeats() {
        return noOfClassicSeats;
    }

    public void setNoOfClassicSeats(int noOfClassicSeats) {
        this.noOfClassicSeats = noOfClassicSeats;
    }

    public int getNoOfPremiumSeats() {
        return noOfPremiumSeats;
    }

    public void setNoOfPremiumSeats(int noOfPremiumSeats) {
        this.noOfPremiumSeats = noOfPremiumSeats;
    }
}
