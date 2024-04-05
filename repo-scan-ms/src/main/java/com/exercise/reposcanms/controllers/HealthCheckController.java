package com.exercise.reposcanms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.exercise.reposcanms.constants.apiConstants.API;
import static com.exercise.reposcanms.constants.apiConstants.HEALTH_CHECK;

@RestController
@RequestMapping(API)
public class HealthCheckController {

    @GetMapping(HEALTH_CHECK)
    public boolean check() {
        return true;
    }


}
