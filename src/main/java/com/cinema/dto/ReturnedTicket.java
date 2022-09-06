package com.cinema.dto;

import com.cinema.model.Seat;
import lombok.Value;

@Value
public class ReturnedTicket {
    Seat returnedTicket;
}
