package com.example.Bookings.Controllers;

import com.example.Bookings.Requests.BookTicketRequest;
import com.example.Bookings.Responses.TicketResponse;
import com.example.Bookings.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping  //Storing the data to DB
    public int bookTicket(@RequestBody BookTicketRequest ticketRequest){
        return ticketService.bookTicket(ticketRequest);
    }

    @GetMapping  //Taking the stored data from DB
    public TicketResponse generateTicket(@RequestParam("ticketId") String ticketId){
        return ticketService.generateTicket(ticketId);
    }
}
