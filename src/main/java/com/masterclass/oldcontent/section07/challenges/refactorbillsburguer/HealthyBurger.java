package com.masterclass.oldcontent.section07.challenges.refactorbillsburguer;

public class HealthyBurger extends Hamburger {

    public HealthyBurger(String meal, double price) {
        super("Healthy", meal, "Brown rye", price);
    }

    @Override
    public void setAdditionalIngredients(AdditionalIngredients[] additionalIngredients) {
        if (additionalIngredients.length > 6) {
            System.out.println("Error: The basic hamburger accepts only 6 additional max.");
        }
        this.additionalIngredients = additionalIngredients;
    }
}
