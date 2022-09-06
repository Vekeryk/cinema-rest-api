package com.cinema.service;

import com.cinema.exception.custom.InvalidTokenException;
import com.cinema.exception.custom.SeatAlreadyBookedException;
import com.cinema.exception.custom.SeatNumberOutOfBoundException;
import com.cinema.model.CinemaRoom;
import com.cinema.model.Seat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final CinemaRoom cinemaRoom;

    public CinemaRoom getSeats() {
        return cinemaRoom;
    }

    public UUID purchaseSeat(Seat seat) {
        if (isSeatInvalid(seat) || !cinemaRoom.getAvailableSeats().contains(seat)) {
            throw new SeatAlreadyBookedException();
        }
        UUID uuid = UUID.randomUUID();
        cinemaRoom.getPurchasedSeats().put(uuid, seat);
        cinemaRoom.getAvailableSeats().remove(seat);
        return uuid;
    }

    public Seat getSeatByToken(UUID uuid) {
        Seat seat = cinemaRoom.getPurchasedSeats().get(uuid);
        return Optional.ofNullable(seat).orElseThrow(InvalidTokenException::new);
    }

    private boolean isSeatInvalid(Seat seat) {
        if (seat.getRow() > cinemaRoom.getTotalRows() || seat.getColumn() > cinemaRoom.getTotalColumns() ||
                seat.getRow() < 1 || seat.getColumn() < 1) {
            throw new SeatNumberOutOfBoundException();
        }
        return false;
    }
}
