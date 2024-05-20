package activities;

public  class Car {
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;

    public Car(String color, String transmission, int make){
        this.color=color;
        this.transmission=transmission;
        this.make=make;
        this.tyres=4;
        this.doors=4;
    }

    public void displayCharacteristics(){
        System.out.println("colour is "+this.color);
        System.out.println("transmission is "+this.transmission);
        System.out.println("make is "+this.make);
        System.out.println("door is "+this.doors);
        System.out.println("tyre is "+this.tyres);

    }

    public void accelarate(){
        System.out.println("Car is moving forward");
    }

    public void brake(){
        System.out.println("Car stopped");

    }
}
