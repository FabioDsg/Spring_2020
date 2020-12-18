package com.springdemo.springdemo;

public class BaseballCoach implements Coach {
    
    // Define a private field for the dependency
    private FortuneService fortuneService;

    // Define a contructor for dependency injector
    public BaseballCoach (FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout(){

        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune(){

        // Use my fortuneService to get a fortune

        return fortuneService.getFortune();
    }
}
