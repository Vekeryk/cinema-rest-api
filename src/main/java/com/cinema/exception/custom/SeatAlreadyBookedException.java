package com.cinema.exception.custom;

public class SeatAlreadyBookedException extends RuntimeException {
    public SeatAlreadyBookedException() {
        super("The ticket has been already purchased!");
    }
}