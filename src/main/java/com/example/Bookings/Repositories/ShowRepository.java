package com.example.Bookings.Repositories;

import com.example.Bookings.Models.Shows;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowRepository extends JpaRepository<Shows,Integer> {
    List<Shows> findByMovie_MovieName(String movieName);
    List<Shows> findByShowDate(LocalDate showDate);
}
