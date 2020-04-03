package com.example.leagueplanner.domain;

import java.time.ZonedDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Getter @Setter @ToString
public class Game {

    private Team          first;
    private Team          second;
    private ZonedDateTime timestamp;

    public Game(Team first, Team second, @NonNull ZonedDateTime timestamp) {
        this.first = first;
        this.second = second;
        this.timestamp = timestamp;
    }
}
