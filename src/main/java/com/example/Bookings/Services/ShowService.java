package com.example.Bookings.Services;

import com.example.Bookings.Models.*;
import com.example.Bookings.Repositories.MovieRepository;
import com.example.Bookings.Repositories.ShowRepository;
import com.example.Bookings.Repositories.ShowSeatRepository;
import com.example.Bookings.Repositories.TheaterRepository;
import com.example.Bookings.Requests.AddShowRequest;
import com.example.Bookings.Responses.ShowResponse;
import com.example.Bookings.Responses.ShowSeatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private MovieRepository movieRepository;

    public String addShow(AddShowRequest showRequest){

        Theater theater = theaterRepository.findById(showRequest.getTheaterId()).get();//orElseThrow(()->new RuntimeException("Not Found"));
        Movie movie = movieRepository.findById(showRequest.getMovieId()).get();
        //.orElseThrow(()-> new RuntimeException("Not found",+ id));
        //Optional<Theater> obj=same // also methods obj.isPresent(),obj.get()

        //Add validations if movie and theater are valid scenarios
        Shows shows = new Shows();
        shows.setShowDate(showRequest.getShowDate());
        shows.setShowTime(showRequest.getShowTime());
        shows.setTheater(theater);
        shows.setMovie(movie);
        shows.setMovieName(movie.getMovieName());
        shows.setTheaterName(theater.getName());

        shows = showRepository.save(shows);


        //Associate the corresponding show seats along with it
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

        List<ShowSeat> showSeatList = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setSeatType(theaterSeat.getSeatType());
            showSeat.setIsBooked(Boolean.FALSE);
            showSeat.setIsFoodAttached(Boolean.FALSE);
            showSeat.setShows(shows);

            showSeatList.add(showSeat);

        }
        shows.setShowSeatList(showSeatList);
        showRepository.save(shows);
        showSeatRepository.saveAll(showSeatList);
        return "The show has been saved to the Db with showId"+shows.getShowId();
    }

    public List<ShowResponse> getShowsDate(String movieName){
        List<Shows> showsList = showRepository.findByMovie_MovieName(movieName);
        List<ShowResponse> showResponseList = new ArrayList<>();
        for(Shows shows : showsList){
            ShowResponse showResponse = new ShowResponse();
            showResponse.setShowDate(shows.getShowDate());
            showResponse.setShowTime(shows.getShowTime());
            showResponse.setTheaterName(shows.getTheaterName());
            showResponse.setMovieName(shows.getMovieName());
            showResponse.setTheaterId(shows.getTheater().getTheaterId());
            showResponse.setShowId(shows.getShowId());
            showResponseList.add(showResponse);
        }
        return showResponseList;
    }
    public List<ShowSeatResponse> getSeatsById(String showId){
    	int showId1= Integer.parseInt(showId);
        List<ShowSeat> showSeatList = showSeatRepository.findByShows_ShowId(showId1);
        List<ShowSeatResponse> showSeatResponseList = new ArrayList<>();
        for(ShowSeat showSeat:showSeatList){
            ShowSeatResponse showSeatResponse = new ShowSeatResponse();
            showSeatResponse.setSeatNo(showSeat.getSeatNo());
            showSeatResponse.setSeatType(showSeat.getSeatType());
            showSeatResponse.setIsBooked(showSeat.getIsBooked());
            showSeatResponseList.add(showSeatResponse);
        }
        return showSeatResponseList;
    }

    public List<ShowResponse> getShowsByDate(LocalDate showDate){
        List<Shows> showsList = showRepository.findByShowDate(showDate);
        List<ShowResponse> showResponseList = new ArrayList<>();
        for(Shows shows : showsList){
            ShowResponse showResponse = new ShowResponse();
            showResponse.setShowDate(shows.getShowDate());
            showResponse.setShowTime(shows.getShowTime());
            showResponse.setTheaterName(shows.getTheaterName());
            showResponse.setMovieName(shows.getMovieName());
            showResponse.setTheaterId(shows.getTheater().getTheaterId());
            showResponse.setShowId(shows.getShowId());
            showResponseList.add(showResponse);
        }
        return showResponseList;
    }

}
