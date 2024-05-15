package activities;

public class MountainBike extends Bicycle {
       int seatHeight ;
    MountainBike(int gears, int speed, int startHeight){
        super(gears, speed);
        seatHeight = startHeight;

    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public String bicycleDesc(){
        return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
    }
}
