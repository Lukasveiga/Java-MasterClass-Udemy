package com.masterclass.newcontent.section12.extra;

import java.util.List;

public class RentalService<T extends Vehicle> {
    private final List<T> availableVehicles;

    public RentalService(List<T> availableVehicles) {
        this.availableVehicles = availableVehicles;
    }

    public T searchAvailableVehicle() {
        System.out.println("Looking for vehicle...");
        T t = availableVehicles.remove(0);
        System.out.println("Rental vehicle: " + t.getName());
        System.out.println("Vehicles available to rental: " + availableVehicles);
        return t;
    }

    public void returnVehicle(T t) {
        System.out.println("Returning vehicle: " + t.getName());
        availableVehicles.add(t);
        System.out.println("Vehicles available to rental: " + availableVehicles);
    }
}
