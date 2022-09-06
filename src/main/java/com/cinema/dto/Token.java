package com.cinema.dto;

import lombok.Getter;

import java.util.UUID;

public class Token {
    @Getter
    UUID token;

    public void setToken(String token) {
        this.token = UUID.fromString(token);
    }
}
