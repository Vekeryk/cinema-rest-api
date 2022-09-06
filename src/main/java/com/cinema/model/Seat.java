package com.cinema.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"row", "column"})
public class Seat {

    private final int row;
    private final int column;
    private final int price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        price = row < 5 ? 10 : 8;
    }
}
