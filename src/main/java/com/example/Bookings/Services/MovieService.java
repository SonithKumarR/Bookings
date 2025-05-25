package com.example.Bookings.Services;

import com.example.Bookings.Models.Movie;
import com.example.Bookings.Repositories.MovieRepository;
import com.example.Bookings.Requests.AddMovieRequest;
import com.example.Bookings.Responses.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public String addMovie(AddMovieRequest movieRequest){
        Movie movie = new Movie();
        movie.setMovieName(movieRequest.getMovieName());
        movie.setDuration(movieRequest.getDuration());
        movie.setRating(movieRequest.getRating());
        movie.setLanguage(movieRequest.getLanguage());
        movie.setReleaseDate(movieRequest.getReleaseDate());
        movie.setImage(movieRequest.getImage());

        movie = movieRepository.save(movie);
        return ""+movie.getMovieId();
    }

    public List<MovieResponse> getMovies(){
        List<Movie> movieList = movieRepository.findAll();
        List<MovieResponse> movieResponseList = new ArrayList<>();
        for(Movie movie:movieList){
            MovieResponse movieResponse = new MovieResponse();
            movieResponse.setDuration(movie.getDuration());
            movieResponse.setMovieName(movie.getMovieName());
            movieResponse.setRating(movie.getRating());
            movieResponse.setImage(movie.getImage());
            movieResponseList.add(movieResponse);
        }
        return movieResponseList;
    }
}
