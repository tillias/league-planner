package com.example.leagueplanner.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Plan {

    private UUID       id;
    private List<Game> games = new ArrayList<>();

    public Plan() {
        this.id = UUID.randomUUID();
    }

    public void addGame(@NonNull Game game) {
        games.add(game);
    }
}
