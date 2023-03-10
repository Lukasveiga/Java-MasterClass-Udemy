package com.masterclass.oldcontent.section07.challenges.polymorphism;

class Ford extends Car{

    public Ford(String model, int cylinders) {
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

