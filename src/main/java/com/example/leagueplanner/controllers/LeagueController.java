package com.example.leagueplanner.controllers;

import com.example.leagueplanner.domain.League;
import com.example.leagueplanner.domain.Plan;
import com.example.leagueplanner.services.PlannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeagueController {


    private final PlannerService plannerService;

    public LeagueController(PlannerService plannerService) {
        this.plannerService = plannerService;
    }

    @PostMapping("/import")
    public Plan importLeague(@RequestBody League league) {
        return plannerService.calculate(league);
    }
}
