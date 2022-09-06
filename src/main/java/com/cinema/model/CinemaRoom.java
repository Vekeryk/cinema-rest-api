package com.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.*;

@Getter
@Component
public class CinemaRoom {
    private final int totalRows = 9;
    private final int totalColumns = 9;
    private final Set<Seat> availableSeats = new TreeSet<>();
    @JsonIgnore
    private final Map<UUID, Seat> purchasedSeats = new HashMap<>();

    public CinemaRoom() {
        for (int row = 1; row < totalRows + 1; row++) {
            for (int column = 1; column < totalRows + 1; column++) {
                availableSeats.add(new Seat(row, column));
            }
        }
    }
}
