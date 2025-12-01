package com.example.Bookings.Controllers;

import com.example.Bookings.Requests.AddMovieRequest;
import com.example.Bookings.Responses.MovieResponse;
import com.example.Bookings.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/Movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping
    public ResponseEntity<?> addMovie(@RequestBody AddMovieRequest movieRequest){
        String response = movieService.addMovie(movieRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/get")
    public ResponseEntity<?> getMovies(){
        List<MovieResponse> movieResponseList = movieService.getMovies();
        return ResponseEntity.status(HttpStatus.OK).body(movieResponseList);
        
    }
}
