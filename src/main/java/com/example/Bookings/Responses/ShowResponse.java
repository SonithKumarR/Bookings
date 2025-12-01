package com.example.Bookings.Responses;

import java.time.LocalDate;
import java.time.LocalTime;

public class ShowResponse {

    private LocalDate showDate;
    private LocalTime showTime;
    private String movieName;
    private String theaterName;
    private int theaterId;
    private int showId;

    public ShowResponse(LocalDate showDate, LocalTime showTime, String movieName, String theaterName, int theaterId,
			int showId) {
		super();
		this.showDate = showDate;
		this.showTime = showTime;
		this.movieName = movieName;
		this.theaterName = theaterName;
		this.theaterId = theaterId;
		this.showId = showId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	// Constructor
    public ShowResponse(){}

    // Getters
    public int getTheaterId() {return theaterId;}

    public void setTheaterId(int theaterId) { this.theaterId = theaterId;}

    public LocalDate getShowDate() {
        return showDate;
    }

    public LocalTime getShowTime() {
        return showTime;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    // Setters
    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public void setShowTime(LocalTime showTime) {
        this.showTime = showTime;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}
