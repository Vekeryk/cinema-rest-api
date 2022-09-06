package com.cinema.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CinemaRoom {
    private final int totalRows;
    private final int totalColumns;
    private final List<Seat> availableSeats = new ArrayList<>();

    public CinemaRoom(int totalRows, int totalColumns) {
        this.totalRows = totalRows;
        this.totalColumns = totalColumns;
        for (int row = 1; row < totalRows + 1; row++) {
            for (int column = 1; column < totalRows + 1; column++) {
                availableSeats.add(new Seat(row, column));
            }
        }
    }
}
