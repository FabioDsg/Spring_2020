package com.spring.demo.springdemoannotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        
        return null;
    }
    
}