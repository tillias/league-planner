package com.example.leagueplanner;

import java.io.IOException;

import com.example.leagueplanner.domain.League;
import com.example.leagueplanner.domain.Plan;
import com.example.leagueplanner.services.PlannerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class PlannerServiceTest {

    @Autowired
    private PlannerService plannerService;

    @Test
    public void Calculate_ValidLeague_PlanIsGenerated() throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final League league = mapper.readValue(new ClassPathResource("test-data.json").getFile(), League.class);

        final Plan plan = plannerService.calculate(league);
        Assert.assertNotNull(plan);
    }
}
