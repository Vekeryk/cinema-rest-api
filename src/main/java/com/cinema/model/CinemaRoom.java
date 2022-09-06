package com.cinema.model;

import com.cinema.exception.custom.SeatAlreadyBookedException;
import com.cinema.exception.custom.SeatNumberOutOfBoundException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Getter
@Component
public class CinemaRoom {
    private final int totalRows = 9;
    private final int totalColumns = 9;
    private final Set<Seat> availableSeats = new HashSet<>();
    @JsonIgnore
    private final Set<Seat> purchasedSeats = new HashSet<>();

    public CinemaRoom() {
        for (int row = 1; row < totalRows + 1; row++) {
            for (int column = 1; column < totalRows + 1; column++) {
                availableSeats.add(new Seat(row, column));
            }
        }
    }

    public void purchaseSeat(Seat seat) {
        validateSeat(seat);
        if (!purchasedSeats.add(seat)) {
            throw new SeatAlreadyBookedException();
        }
        availableSeats.remove(seat);
    }

    private void validateSeat(Seat seat) {
        if (seat.getRow() > totalRows || seat.getColumn() > totalColumns ||
                seat.getRow() < 1 || seat.getColumn() < 1) {
            throw new SeatNumberOutOfBoundException();
        }
    }
}
