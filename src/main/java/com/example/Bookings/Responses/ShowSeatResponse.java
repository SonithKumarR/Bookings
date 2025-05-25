package com.example.Bookings.Responses;

import com.example.Bookings.Enums.SeatType;

public class ShowSeatResponse {
    private String seatNo;
    private SeatType seatType;
    private boolean isBooked;

    // Constructor
    public ShowSeatResponse(){}
    public ShowSeatResponse(String seatNo,boolean isBooked, SeatType seatType) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.isBooked = isBooked;
    }

    // Getter for seatNo
    public String getSeatNo() {
        return seatNo;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
    // Setter for seatNo

    // Getter for seatType
    public boolean getIsBooked() {
        return isBooked;
    }
    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }
    // Setter for seatNo

    // Getter for seatType
    public SeatType getSeatType() {
        return seatType;
    }

    // Setter for seatType
    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
