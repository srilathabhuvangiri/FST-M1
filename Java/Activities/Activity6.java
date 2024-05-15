package activities;

public class Activity6 {
    public static void main(String args[]) throws Exception {
        int maxPassengers =10;
        Plane plane =new Plane(maxPassengers);
        String passengers[] = {"Sri", "Rama", "David", "Sita"};
        plane.onboard(passengers);
        System.out.println("Plane took off at: " + plane.takeOff());
        System.out.println("People on the plane: " +  plane.getPassengers());
        //Flying.....
        Thread.sleep(5000);
        //Plane has landed
        plane.land();
        //Plane lands
        System.out.println("Plane landed at: " + plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + plane.getPassengers());
    }

}
