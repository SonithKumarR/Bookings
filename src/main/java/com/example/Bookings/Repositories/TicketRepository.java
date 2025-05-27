package com.example.Bookings.Repositories;

import com.example.Bookings.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,String> {
    List<Ticket> findByEmailId(String Email);

}
