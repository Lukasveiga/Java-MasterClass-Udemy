package com.masterclass.oldcontent.section06.challenges;

public class Vehicle {

    // physical parameters
    private double width;
    private double lenght;
    private double height;
    private double weight;

    // movement parameters
    private int direction;
    private double maxSpeed;
    private double currentSpeed;

    public Vehicle(double width, double lenght, double height, double weight,
            double maxSpeed) {
        this.width = width;
        this.lenght = lenght;
        this.height = height;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.direction = 0;
        this.currentSpeed = 0;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {

        if (width < 0) {

            System.out.println("Error: Width must be positive.");

        } else {

            this.width = width;
        }

        
    }

    public double getLenght() {
        return lenght;
    }

    public void setLenght(double lenght) {

        if (lenght < 0) {

            System.out.println("Error: Lenght must be positive.");

        } else {

            this.lenght = lenght;
        }
        
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {

        if (height < 0) {

            System.out.println("Error: Height must be positive.");

        } else {

            this.height = height;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        
        if (weight < 0) {

            System.out.println("Error: Weight must be positive.");

        } else {

            this.weight = weight;
        }
    }

    public int getDirection() {
        return direction;
    }


    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {

        if (maxSpeed < 0) {

            System.out.println("Error: MaxSpeed must be positive.");

        } else {

            this.maxSpeed = maxSpeed;
        }
        
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }


    public void setDirection(int angle) {

        if (angle < 0 || angle > 360) {

            System.out.println("Error: The direction must be between 0 and 360.");
             
        } else {

            System.out.println("Changed vehicle direction in " + angle + " degrees.");
            this.direction = angle;
        }
    }

    public void speedUp(double speed) {

        if (speed < 0) {

            System.out.println("Error: Speed must be positive.");

        } else if (speed > maxSpeed) {

            System.out.println("Error: Value exceeds maximum speed.");

        } else {

            this.currentSpeed = speed;
        }
    }

    public void speedDown(double speed) {

        if (speed < 0) {

            System.out.println("Error: Speed must be positive.");

        } else if (speed > currentSpeed) {

            this.currentSpeed = 0;

        } else {

            this.currentSpeed -= speed;
        }

    }

}
