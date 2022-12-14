package com.cinema.model;

import com.cinema.util.SeatFactory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Getter
@Component
public class CinemaRoom {
    @Value("${cinema-room-rows}")
    private int totalRows;
    @Value("${cinema-room-columns}")
    private int totalColumns;
    private final Set<Seat> availableSeats = new TreeSet<>();
    @JsonIgnore
    private final Map<UUID, Seat> purchasedSeats = new HashMap<>();
    @JsonIgnore
    private final SeatFactory seatFactory;

    @Autowired
    public CinemaRoom(SeatFactory seatFactory) {
        this.seatFactory = seatFactory;
    }

    @PostConstruct
    private void init() {
        for (int row = 1; row < totalRows + 1; row++) {
            for (int column = 1; column < totalRows + 1; column++) {
                availableSeats.add(seatFactory.getSeat(row, column));
            }
        }
    }
}
