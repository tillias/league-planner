package com.example.leagueplanner.services;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalAmount;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.example.leagueplanner.domain.Game;
import com.example.leagueplanner.domain.League;
import com.example.leagueplanner.domain.Plan;
import com.example.leagueplanner.domain.Team;
import org.paukov.combinatorics3.Generator;
import org.springframework.stereotype.Service;

@Service
public class PlannerService {

    public static final ZonedDateTime LEAGUE_START =
            ZonedDateTime.parse("2019-10-03T17:00:00.00+02:00[Europe/Berlin]");

    public Plan calculate(League league) {
        final List<Team> shuffledTeams = league.getTeams();
        Collections.shuffle(shuffledTeams);

        final List<List<Team>> rounds =
                Generator.combination(shuffledTeams)
                        .simple(2)
                        .stream()
                        .collect(Collectors.toList());

        final Plan plan = new Plan();

        final TemporalAdjuster nextSaturday = TemporalAdjusters.next(DayOfWeek.SATURDAY);
        ZonedDateTime start = LEAGUE_START;

        // Direct rounds
        for (final List<Team> round : rounds) {
            start = start.with(nextSaturday);

            Team first = round.get(0);
            Team second = round.get(1);
            plan.addGame(new Game(first, second, start));
        }

        start = start.plus(3, ChronoUnit.WEEKS);

        // reversed rounds
        for (final List<Team> round : rounds) {
            Team first = round.get(1);
            Team second = round.get(0);
            plan.addGame(new Game(first, second, start));

            start = start.with(nextSaturday);
        }

        return plan;
    }
}
