package com.spring.demo.springdemoannotations;

import java.lang.reflect.Method;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

public TennisCoach() {
    
    System.out.println(">> TenisCoach: Inside default constructor");

}

// Define a setter method
    // @Autowired
    // public void doSomeCrazyStuff(FortuneService fortuneService) {
    //     System.out.println(">> TenisCoach: Inside doSomeCrazyStuff() method");
    //     this.fortuneService = fortuneService;
    // }

    
    // @Autowired
    // public TennisCoach(FortuneService fortuneService) {
    //     this.fortuneService = fortuneService;
    // }
    
    
    @Override
    public String getDailyWorkout() {
        
        return "Practice your backhand volley";

    }

    @Override
    public String getDailyFortune() {
        
        return fortuneService.getFortune();
    }

   

   

    
    
}
