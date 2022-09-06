package com.cinema.exception.custom;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException() {
        super("Wrong token!");
    }
}