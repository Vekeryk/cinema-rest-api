package com.cinema.dto;

import com.cinema.model.Seat;
import lombok.Value;

import java.util.UUID;

@Value
public class PurchasedTicket {
    UUID token;
    Seat ticket;
}
