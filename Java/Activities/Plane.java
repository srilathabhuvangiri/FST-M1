package activities;
import java.util.*;

public class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;

    Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }
    public void onboard(String passengers[]) {
        for(int i=0; i<passengers.length;i++) {
            this.passengers.add(passengers[i]);
        }
    }
    public Date takeOff() {
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;
    }
    public void land() {
       this.lastTimeLanded = new Date();
       this.passengers.clear();
    }
    public Date getLastTimeLanded() {
        return lastTimeLanded;
    }

    public int getPassengers() {
        return passengers.size();
    }

}
