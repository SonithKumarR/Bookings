package com.example.Bookings.Repositories;

import com.example.Bookings.Models.Ticket;
import com.example.Bookings.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmailId(String emailId);
}

