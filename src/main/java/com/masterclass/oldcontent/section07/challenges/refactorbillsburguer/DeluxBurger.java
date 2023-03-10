package com.masterclass.oldcontent.section07.challenges.refactorbillsburguer;

public class DeluxBurger extends Hamburger{

    public DeluxBurger() {
        super("Deluxe", "Sausage & Bacon", "White", 15.0);

        AdditionalIngredients[] addsDelux = new AdditionalIngredients[2];
        addsDelux[0] = new AdditionalIngredients("Chips", 2.75);
        addsDelux[1] = new AdditionalIngredients("Drink", 1.75);

        super.setAdditionalIngredients(addsDelux);
    }

    @Override
    public void setAdditionalIngredients(AdditionalIngredients[] additionalIngredients) {
        System.out.println("Cannot add additional items to deluxe burger");
    }

    @Override
    public void itemizeHamburger() {
    }

    @Override
    public void orderSummary() {
        System.out.println(super.getName() + " hamburger on a " + super.getBread() + " roll with " + super.getMeal() + ", price is $" + super.getPrice());
    }

}
