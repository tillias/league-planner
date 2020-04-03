package com.example.leagueplanner.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
public class Team {

    private String name;
    private String founding_date;

    public Team(String name, String founding_date) {
        this.name = name;
        this.founding_date = founding_date;
    }
}
