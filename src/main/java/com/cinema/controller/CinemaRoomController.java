package com.cinema.controller;

import com.cinema.dto.PurchasedTicket;
import com.cinema.dto.ReturnedTicket;
import com.cinema.dto.SeatDTO;
import com.cinema.dto.Token;
import com.cinema.exception.custom.InvalidPasswordException;
import com.cinema.model.CinemaRoom;
import com.cinema.model.Seat;
import com.cinema.model.Statistic;
import com.cinema.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CinemaRoomController {
    @Value("${secret}")
    private String secret;
    private final BookingService bookingService;
    private final Statistic statistic;

    @GetMapping("/seats")
    public CinemaRoom seats() {
        return bookingService.getSeats();
    }

    @PostMapping("/purchase")
    public PurchasedTicket purchase(@RequestBody SeatDTO seatDTO) {
        Seat seat = new Seat(seatDTO.getRow(), seatDTO.getColumn());
        UUID uuid = bookingService.purchaseSeat(seat);
        return new PurchasedTicket(uuid, seat);
    }

    @PostMapping("/return")
    public ReturnedTicket returned(@RequestBody Token token) {
        Seat seat = bookingService.refundTicket(token.getToken());
        return new ReturnedTicket(seat);
    }

    @PostMapping("/stats")
    public Statistic stats(@RequestParam(required = false) String password) {
        if (password != null && password.equals(secret)) {
            return statistic;
        }
        throw new InvalidPasswordException();
    }
}
