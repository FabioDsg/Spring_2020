package com.spring.demo.springdemoannotations;

import java.lang.reflect.Method;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

// Define a default constructor    
public TennisCoach() {
    
    System.out.println(">> TenisCoach: Inside default constructor");

}

// Define my init method
@PostConstruct
public void doMyStartupStuff() {
    System.out.println(">> TennisCoach: Inside of doMyStartupStuff()");
}

// Define my destroy method
@PreDestroy
public void doMyCleanupStuff() {
    System.out.println(">> TennisCoach: Inside of doMyCleanupStuff()");
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
