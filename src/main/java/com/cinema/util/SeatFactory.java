package com.cinema.util;

import com.cinema.model.Seat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SeatFactory {
    @Value("${low-price}")
    private double lowPrice;
    @Value("${high-price}")
    private double highPrice;
    @Value("${price-switch-row}")
    private int priceSwitchRow;

    public Seat getSeat(int row, int column) {
        double price = row < priceSwitchRow ? highPrice : lowPrice;
        return new Seat(row, column, price);
    }
}
