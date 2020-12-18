package com.spring.demo.springdemoannotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        
        // Read spring config file
        ClassPathXmlApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        // Get the bean from spring container
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        // Check if they are the same
        boolean result = (theCoach == alphaCoach);

        // Print out results
        System.out.println("\nPointing to the same object: " + result);

        System.out.println("\nMemory location for theCoach: " + theCoach);

        System.out.println("\nMemory location for theCoach: " + alphaCoach);

        // // Call a method on the bean
        // System.out.println(theCoach.getDailyWorkout());

        // // Call method to get the daily fortune
        // System.out.println(theCoach.getDailyFortune());

        // Close the context
        context.close();
    }
}
