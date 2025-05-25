package com.example.Bookings.Repositories;

import com.example.Bookings.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
    List<ShowSeat> findByShows_ShowId(int showId);

}
