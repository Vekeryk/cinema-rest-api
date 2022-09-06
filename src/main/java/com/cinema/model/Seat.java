package com.cinema.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode(of = {"row", "column"})
public class Seat implements Comparable<Seat> {

    private final int row;
    private final int column;
    private final double price;

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        price = row < 5 ? 10 : 8;
    }

    @Override
    public int compareTo(Seat another) {
        return this.row - another.getRow() == 0 ? this.column - another.getColumn() : this.row - another.getRow();
    }
}
