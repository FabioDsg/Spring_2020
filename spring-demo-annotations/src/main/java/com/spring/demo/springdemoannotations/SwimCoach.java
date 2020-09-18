package com.spring.demo.springdemoannotations;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

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

   
    
}
