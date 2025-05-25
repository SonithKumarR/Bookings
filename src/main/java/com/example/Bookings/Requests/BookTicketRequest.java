package com.example.Bookings.Requests;

import java.util.List;

public class BookTicketRequest {
    private List<String> requestedSeats;
    private int showId;
    private String emailId;

    // Constructor
    public BookTicketRequest() {}

    public BookTicketRequest(List<String> requestedSeats, int showId, String emailId) {
        this.requestedSeats = requestedSeats;
        this.showId = showId;
        this.emailId = emailId;
    }

    // Getter and Setter methods
    public List<String> getRequestedSeats() {
        return requestedSeats;
    }

    public void setRequestedSeats(List<String> requestedSeats) {
        this.requestedSeats = requestedSeats;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
