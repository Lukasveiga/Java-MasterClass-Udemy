package com.masterclass.oldcontent.section07.challenges.billsburguer;

public class HealthyBurger extends Hamburger{

    private String add5Name;
    private double add5Price;
    private String add6Name;
    private double add6Price;

    public HealthyBurger(String meal, double price) {
        super("Healthy", meal, "Brown rye", price);
    }

    public void addHamburgerAdd5(String name, double price) {
        this.add5Name = name;
        this.add5Price = price;
    }

    public void addHamburgerAdd6(String name, double price) {
        this.add6Name = name;
        this.add6Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double hamburgerPrice =  super.itemizeHamburger();

        if (this.add5Name != null) {
            hamburgerPrice += this.add5Price;
            System.out.println("Added " + this.add5Name + " for an extra " + this.add5Price);
        }
        if (this.add6Name != null) {
            hamburgerPrice += this.add6Price;
            System.out.println("Added " + this.add6Name + " for an extra " + this.add6Price);
        }

        return hamburgerPrice;
    }
}
