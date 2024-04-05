package com.exercise.reposcanms.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.exercise.reposcanms.constants.apiConstants.API;
import static com.exercise.reposcanms.constants.apiConstants.HEALTH_CHECK;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = {HealthCheckController.class})
public class HealthCheckControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private HealthCheckController healthCheckController;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(healthCheckController).build();
    }



    @Test
    public void testHealthCheckResponse() throws Exception {
        mockMvc.perform(get(API + HEALTH_CHECK))
                .andExpect(status().isOk());
    }
}
