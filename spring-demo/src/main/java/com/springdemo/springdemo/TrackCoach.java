package com.springdemo.springdemo;

public class TrackCoach implements Coach{
    
     // Define a private field for the dependency
     private FortuneService fortuneService;

     // Temp issue fix in MyApp
     public TrackCoach(){

     }

     // Define a contructor for dependency injector
     public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune(){
        return "Just Do It: " + fortuneService.getFortune();
    }


    // Add a init method
    public void doMyStartupStuff() {
        System.out.println("TrackCoach: Inside method doMyStartupStuff");
    }

    // Add a destroy method
    public void doMyCleanupStuff() {
        System.out.println("TrackCoach: Inside method doMyCleanupStuff");
    }
}
