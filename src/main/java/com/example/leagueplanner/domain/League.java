package com.example.leagueplanner.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class League {

    private String     league;
    private String     country;
    private List<Team> teams = new ArrayList<>();

    public League(String league, String country, List<Team> teams) {
        this.league = league;
        this.country = country;
        this.teams = teams;
    }
}
