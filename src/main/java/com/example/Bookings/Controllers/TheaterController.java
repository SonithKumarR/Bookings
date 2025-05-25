package com.example.Bookings.Controllers;

import com.example.Bookings.Models.Theater;
import com.example.Bookings.Requests.AddTheaterRequest;
import com.example.Bookings.Requests.AddTheaterSeatsRequest;
import com.example.Bookings.Responses.TheaterResponse;
import com.example.Bookings.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTh")
    public ResponseEntity<?> addTheater(@RequestBody AddTheaterRequest theaterRequest){
        String response = theaterService.addTheater(theaterRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/addSeat")
    public ResponseEntity<?> associateSeats(@RequestBody AddTheaterSeatsRequest theaterSeatsRequest){
        String response = theaterService.associateTheater(theaterSeatsRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/theaterList")
    public ResponseEntity<?> getThList(){
        List<TheaterResponse> response = theaterService.getThList();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
