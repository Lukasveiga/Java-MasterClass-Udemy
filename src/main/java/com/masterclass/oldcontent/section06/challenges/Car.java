package com.masterclass.oldcontent.section06.challenges;

public class Car extends Vehicle {

    private int numberOfDoors;
    private int numberOfWheels;
    private String colour;

    public Car(double width, double lenght, double height, double weight, double maxSpeed, int numberOfDoors,
            int numberOfWheels, String colour) {
        super(width, lenght, height, weight, maxSpeed);
        this.numberOfDoors = numberOfDoors;
        this.numberOfWheels = numberOfWheels;
        this.colour = colour;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {

        if (numberOfDoors < 0) {

            System.out.println("Error: Number of doors must be positive.");

        } else {

            this.numberOfDoors = numberOfDoors;
        }
        
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        
        if (numberOfWheels < 0) {

            System.out.println("Error: Number of wheels must be positive.");

        } else {

            this.numberOfWheels = numberOfWheels;
        }
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void move(double speed, int angle) {

        this.speedUp(speed);

        if (this.getCurrentSpeed() > 0) {

            this.setDirection(angle);
        }
        

        System.out.println("Moving at " + this.getCurrentSpeed() + " miles/hour to " + this.getDirection() + " degrees direction.");
    }

    public void reduce(double speed) {

        this.speedDown(speed);

        System.out.println("Reducing speed at " + speed + " miles/hour to " + this.getDirection() + " degrees direction.");
    }
    
}
