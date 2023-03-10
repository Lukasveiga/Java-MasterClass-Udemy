package com.masterclass.oldcontent.section07.challenges.billsburguer;

public class DeluxeBurger extends Hamburger{

    public DeluxeBurger() {
        super("Deluxe", "Sausage & Bacon", "White", 14.54);
        super.addHamburgerAdd1("Chips", 2.75);
        super.addHamburgerAdd2("Drink", 1.81);
    }

    @Override
    public void addHamburgerAdd1(String name, double price) {
        System.out.println("Cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAdd2(String name, double price) {
        System.out.println("Cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAdd3(String name, double price) {
        System.out.println("Cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAdd4(String name, double price) {
        System.out.println("Cannot add additional items to deluxe burger");
    }
}
