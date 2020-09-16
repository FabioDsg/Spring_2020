package com.spring.demo.springdemoannotations;

import org.springframework.stereotype.Component;

@Component
public class Lesson implements Coach {

    @Override
    public String getDailyWorkout() {
        
        return "Let's have some rest!";
    }
    
}
