package com.example.Bookings.Services;

import com.example.Bookings.Enums.SeatType;
import com.example.Bookings.Models.ShowSeat;
import com.example.Bookings.Models.Shows;
import com.example.Bookings.Models.Ticket;
import com.example.Bookings.Models.User;
import com.example.Bookings.Repositories.ShowRepository;
import com.example.Bookings.Repositories.ShowSeatRepository;
import com.example.Bookings.Repositories.TicketRepository;
import com.example.Bookings.Repositories.UserRepository;
import com.example.Bookings.Requests.BookTicketRequest;
import com.example.Bookings.Responses.TicketResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    public Integer bookTicket(BookTicketRequest ticketRequest) {
        //1. Find the show Entity
        Shows shows = showRepository.findById(ticketRequest.getShowId()).orElse(null);

        //2.Find the user Entity
        User user = userRepository.findByEmailId(ticketRequest.getEmailId());

        //3 Mark those seats as booked and now calculate total amount
        int totalAmount = 0;
        String bookedSeats="";
       List<ShowSeat> showSeatList;

        if( shows != null) {
            showSeatList = shows.getShowSeatList();
            for (ShowSeat showSeat : showSeatList) {
                String seatNo = showSeat.getSeatNo();
                if (ticketRequest.getRequestedSeats().contains(seatNo)) {
                    showSeat.setIsBooked(Boolean.TRUE);
                    bookedSeats+=seatNo+", ";

                    if (showSeat.getSeatType().equals(SeatType.CLASSIC))
                        totalAmount += 100;

                    else totalAmount += 150;
                }
            }
        }
        else throw new RuntimeException("showsSeat is Empty by id ");

        //Create the ticket entity and set the attributes
        Ticket ticket = new Ticket();
        ticket.setShowDate(shows.getShowDate());
        ticket.setShowTime(shows.getShowTime());
        ticket.setMovieName(shows.getMovie().getMovieName());
        ticket.setTheaterName(shows.getTheater().getName());
        ticket.setTotalAmount(totalAmount);
        ticket.setShows(shows);
        System.out.println(ticket.getEmailId());
        ticket.setBookedSeats(bookedSeats);
        ticket.setEmailId(ticketRequest.getEmailId());
        ticket.setUser(user);

        showSeatRepository.saveAll(showSeatList);
        ticket = ticketRepository.save(ticket);
        //5. Save the ticket into DB and return Ticket Entity (Ticket Response)
        return  ticket.getTicketId();
    }
    public TicketResponse generateTicket(String ticketId){
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found by id " + ticketId));

// Creating a TicketResponse object manually
        TicketResponse ticketResponse = new TicketResponse();
        ticketResponse.setMovieName(ticket.getMovieName());
        ticketResponse.setTheaterName(ticket.getTheaterName());
        ticketResponse.setShowTime(ticket.getShowTime());
        ticketResponse.setBookedSeats(ticket.getBookedSeats());
        ticketResponse.setTotalAmount(ticket.getTotalAmount());
        ticketResponse.setShowDate(ticket.getShowDate());

// Return the ticket response
        return ticketResponse;

    }
}
