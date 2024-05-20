package activities;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onboard("Passenger1");
        plane.onboard("Passenger2");
        plane.onboard("Passenger3");
        System.out.println("Plane took off at: " + plane.takeOff());
        List<String> passengers=plane.getPassengers();
        System.out.println("Passenger list is as below ");
        for(String passenger :passengers){
            System.out.println(passenger);
        }
        Thread.sleep(5000);
        plane.land();
        Date landedtime=plane.getLastTimeLanded();
        System.out.println("Landed time is " +landedtime);


    }
}
