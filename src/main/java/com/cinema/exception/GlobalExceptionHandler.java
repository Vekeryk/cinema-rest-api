package com.cinema.exception;

import com.cinema.dto.ErrorResponse;
import com.cinema.exception.custom.InvalidPasswordException;
import com.cinema.exception.custom.InvalidTokenException;
import com.cinema.exception.custom.SeatAlreadyBookedException;
import com.cinema.exception.custom.SeatNumberOutOfBoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<?> handleSeatAlreadyBookedException(SeatAlreadyBookedException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> handleSeatNumberOutOfBoundException(SeatNumberOutOfBoundException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> handleInvalidTokenException(InvalidTokenException exception) {
        return ResponseEntity.badRequest().body(new ErrorResponse(exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> InvalidPasswordException(InvalidPasswordException exception) {
        return new ResponseEntity<>(new ErrorResponse(exception.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}
