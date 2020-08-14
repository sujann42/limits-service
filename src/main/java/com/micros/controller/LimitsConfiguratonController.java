package com.micros.controller;

import com.micros.beans.LimitConfiguration;
import com.micros.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfiguratonController {

    @Autowired
    private Configuration configuration;

    //This will return hard-coded mim and max values
    @GetMapping("/limits-hardcoded")
    public LimitConfiguration retrieveLimitsFromConfigurationsHardCoded() {
        return new LimitConfiguration(1000, 1);
    }

    //This will read the data from bootstrap.properties
    @GetMapping("/limits/app-prop")
    public LimitConfiguration retrieveLimitsFromConfigurationsAppProperties() {
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }

}
