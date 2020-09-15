package com.springdemo.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {
    
    public static void main(String[] args) {
        
        // Load the spring configuration file
        ClassPathXmlApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext.xml");
            
        // Retrieve bean from spring container
        CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);

        // Call methods on the bean


        // Close the context
        context.close();

    }
}
