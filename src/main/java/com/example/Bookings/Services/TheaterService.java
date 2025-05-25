package com.example.Bookings.Services;

import com.example.Bookings.Enums.SeatType;
import com.example.Bookings.Models.Theater;
import com.example.Bookings.Models.TheaterSeat;
import com.example.Bookings.Repositories.TheaterRepository;
import com.example.Bookings.Repositories.TheaterSeatRepository;
import com.example.Bookings.Requests.AddTheaterRequest;
import com.example.Bookings.Requests.AddTheaterSeatsRequest;
import com.example.Bookings.Responses.TheaterResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {
    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatRepository theaterSeatRepository;


    public String addTheater(AddTheaterRequest theaterRequest){//TRequest has Client_Data
        // convert theaterRequest to Theater class
        Theater theater = new Theater();
        theater.setNoOfScreens(theaterRequest.getNoOfScreens());
        theater.setName(theaterRequest.getName());
        theater.setAddress(theaterRequest.getAddress());

        theater = theaterRepository.save(theater);

        return ""+theater.getTheaterId();
    }
    public String associateTheater(AddTheaterSeatsRequest theaterSeatsRequest){
       int theaterId = theaterSeatsRequest.getTheaterId();
       int noOfClassicSeats = theaterSeatsRequest.getNoOfClassicSeats();
       int noOfPremiumSeats = theaterSeatsRequest.getNoOfPremiumSeats();

        List<TheaterSeat> theaterSeatList = new ArrayList<>();

        //1. Get the TheaterEntity from DB
        Theater theater = theaterRepository.findById(theaterId).get();

        //2. Generate those seatNos for classic seats

        int noOfRowsInClassicSeats = noOfClassicSeats/5; // complete rows that i can build
        int noOfSeatsInLastRowClassic = noOfClassicSeats%5;
        int row,col;
        for(row=1; row<=noOfRowsInClassicSeats; row++){
            for( col=1; col<=5; col++){
                String seatNo = "RC-"+row+" s-"+col;
                TheaterSeat theaterSeat = new TheaterSeat();
                theaterSeat.setSeatNo(seatNo);
                theaterSeat.setSeatType(SeatType.CLASSIC);
                theaterSeat.setTheater(theater);

                theaterSeatList.add(theaterSeat);

            }
        }

        //For the last row
        for(int j=1; j<=noOfSeatsInLastRowClassic; j++){
            String seatNo = "RC-"+row+" s-"+j;
            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.CLASSIC);
            theaterSeat.setTheater(theater);

            theaterSeatList.add(theaterSeat);

        }

        //Same logic for the premium seats

        int noOfRowsInPremiumSeats = noOfPremiumSeats/5;
        int noOfSeatsInLastRowPremium = noOfPremiumSeats%5;
        for(row=1; row<=noOfRowsInPremiumSeats; row++){
            for(col=1; col<=5; col++){
                String seatNo = "Rp-"+row+" s-"+col;
                TheaterSeat theaterSeat = new TheaterSeat();
                theaterSeat.setSeatNo(seatNo);
                theaterSeat.setSeatType(SeatType.PREMIUM);
                theaterSeat.setTheater(theater);

                theaterSeatList.add(theaterSeat);

            }
        }

        //For the last row premium
        for(int j=1; j<=noOfSeatsInLastRowPremium; j++){
            String seatNo = "RC-"+row+" s-"+j;
            TheaterSeat theaterSeat = new TheaterSeat();
            theaterSeat.setSeatNo(seatNo);
            theaterSeat.setSeatType(SeatType.PREMIUM);
            theaterSeat.setTheater(theater);

            theaterSeatList.add(theaterSeat);
        }
        theater.setTheaterSeatList(theaterSeatList);
        theaterRepository.save(theater);
        theaterSeatRepository.saveAll(theaterSeatList);

        return "The theater seats have been associated";
    }

    public List<TheaterResponse> getThList(){
        List<Theater> theaterList = theaterRepository.findAll();
        List<TheaterResponse> theaterResponseList = new ArrayList<>();
        for(Theater theater : theaterList) {
            TheaterResponse obj  = new TheaterResponse();
            obj.setTheaterId(theater.getTheaterId());
            obj.setAddress(theater.getAddress());
            obj.setName(theater.getName());
           theaterResponseList.add(obj);
        }
        return theaterResponseList;
    }
}
