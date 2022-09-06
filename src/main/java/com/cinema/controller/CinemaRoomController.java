package com.cinema.controller;

import com.cinema.dto.PurchasedTicket;
import com.cinema.dto.ReturnedTicket;
import com.cinema.dto.Token;
import com.cinema.model.CinemaRoom;
import com.cinema.model.Seat;
import com.cinema.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CinemaRoomController {

    private final BookingService bookingService;

    @GetMapping("/seats")
    public CinemaRoom seats() {
        return bookingService.getSeats();
    }

    @PostMapping("/purchase")
    public PurchasedTicket purchase(@RequestBody Seat seat) {
        UUID uuid = bookingService.purchaseSeat(seat);
        return new PurchasedTicket(uuid, seat);
    }

    @PostMapping("/return")
    public ReturnedTicket returned(@RequestBody Token token) {
        Seat seat = bookingService.getSeatByToken(token.getToken());
        return new ReturnedTicket(seat);
    }
}
