package com.masterclass.newcontent.section12.extra;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Car> carsAvailable = new ArrayList<>(List.of(
                new Car("BMW"), new Car("Fusca"),
                new Car("Dodge Ram")
        ));

        List<Boat> boatsAvailable = new ArrayList<>(List.of(
                new Boat("Bay"), new Boat("Bow-rider"),
                new Boat("Cabin Cruisers")
        ));

        RentalService<Car> rentalServiceCar = new RentalService<>(carsAvailable);
        RentalService<Boat> rentalServiceBoat = new RentalService<>(boatsAvailable);

        Car rentalCar = rentalServiceCar.searchAvailableVehicle();
        rentalServiceCar.returnVehicle(rentalCar);

        Boat rentalBoat = rentalServiceBoat.searchAvailableVehicle();
        rentalServiceBoat.returnVehicle(rentalBoat);

    }
}
