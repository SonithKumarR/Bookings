package com.example.Bookings.Controllers;

import com.example.Bookings.Requests.AddShowRequest;
import com.example.Bookings.Responses.ShowResponse;
import com.example.Bookings.Responses.ShowSeatResponse;
import com.example.Bookings.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/show")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/add")
    public ResponseEntity<?> addShow(@RequestBody AddShowRequest showRequest){
        String response = showService.addShow(showRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/getshowes")
    public List<ShowResponse> getShowsDate(@RequestParam("movieName") String movieName){
        return showService.getShowsDate(movieName);
    }

    @GetMapping("/getshowSeats")
    public ResponseEntity<?> getSeatsById(@RequestParam("showId") String showId){
        List<ShowSeatResponse> showSeatResponseList=showService.getSeatsById(showId);
        return ResponseEntity.status(HttpStatus.OK).body(showSeatResponseList);
    }

    @GetMapping("/getshowsbydate")
    public ResponseEntity<?> getShowsByDate(@RequestParam("showDate") LocalDate showDate){
        List<ShowResponse> showResponseList =showService.getShowsByDate(showDate);
        return ResponseEntity.status(HttpStatus.OK).body(showResponseList);
    }
}
