package com.masterclass.oldcontent.section07.challenges.polymorphism;

class Car {

    private String model;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String model, int cylinders) {
        this.model = model;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
    }


    public String getModel() {
        return model;
    }

    public int getCylinders() {
        return cylinders;
    }

    

    public boolean isEngine() {
        return engine;
    }


    public int getWheels() {
        return wheels;
    }


    public String startEngine() {
        return "Car -> startEngine()";
    }

    public String accelerate() {
        return "Car -> accelerate()";
    }

    public String brake() {
        return "Car -> brake()";
    }
}

class Mitsubishi extends Car{

    public Mitsubishi(String model, int cylinders) {
        super(model, cylinders);
    }

    @Override
    public String startEngine() {
        return getClass().getSimpleName() + " -> startEngine()";
    }

    @Override
    public String accelerate() {
        return getClass().getSimpleName() + " -> accelerate()";
    }

    @Override
    public String brake() {
        return getClass().getSimpleName() + " -> brake()";
    }
}

public class Main {

    public static void main(String[] args) {

        Car car = new Car("basic", 8);
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi("Mitsubishi", 16);
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford("Ford", 12);
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());
    }
}
