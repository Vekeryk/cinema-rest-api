package com.cinema.controller;

import com.cinema.model.CinemaRoom;
import com.cinema.model.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CinemaRoomController {

    private final CinemaRoom cinemaRoom;

    @GetMapping("/seats")
    public CinemaRoom seats() {
        return cinemaRoom;
    }

    @PostMapping("/purchase")
    public Seat purchase(@RequestBody Seat seat) {
        cinemaRoom.purchaseSeat(seat);
        return seat;
    }
}
