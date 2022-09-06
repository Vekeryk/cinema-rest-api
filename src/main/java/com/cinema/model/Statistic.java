package com.cinema.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Statistic {
    private final CinemaRoom cinemaRoom;

    public double getCurrentIncome() {
        return cinemaRoom.getPurchasedSeats().values().stream().mapToDouble(Seat::getPrice).sum();
    }

    public int getNumberOfAvailableSeats() {
        return cinemaRoom.getAvailableSeats().size();
    }

    public int getNumberOfPurchasedTickets() {
        return cinemaRoom.getPurchasedSeats().size();
    }
}
