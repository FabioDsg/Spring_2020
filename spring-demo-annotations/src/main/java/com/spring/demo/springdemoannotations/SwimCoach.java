package com.spring.demo.springdemoannotations;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${foo.email}") // Injecting value from propertie file
    private String email;

    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        
        return "Swim a 1000 meters as warm up.";
    }

    @Override
    public String getDailyFortune() {
        
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

 
    public String getTeam() {
        return team;
    }

      
    
}
