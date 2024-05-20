package activities;

public class Bicycle implements BicycleParts,BicycleOperations{
    public int gears;
    public int currentSpeed;

    //the Bicycle class has one constructor
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

    public void applyBrake(int num){
        this.currentSpeed = (currentSpeed-num);

    }

    public void speedUp(int num){
        this.currentSpeed = (currentSpeed+num);

    }

    public String bicycleDesc(){
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }



}
