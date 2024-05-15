package activities;

import java.util.Arrays;

public class Bicycle implements  BicycleParts, BicycleOperations {
    int  gears ;
    int speed;
    Bicycle(int gears, int speed){
      this.gears = gears;
      this.speed = speed;
    }

    @Override
    public void applyBrake(int decrement) {
        speed -= decrement;
        System.out.println("Current speed: " + speed);
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
        System.out.println("Current speed: " + speed);
    }

    public String bicycleDesc(){
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + speed);
    }
}
