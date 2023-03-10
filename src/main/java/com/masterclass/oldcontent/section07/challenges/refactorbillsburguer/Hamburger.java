package com.masterclass.oldcontent.section07.challenges.refactorbillsburguer;

public class Hamburger {

    private String name;
    private String meal;
    private String bread;
    private double price;
    private String adds;
    protected AdditionalIngredients additionalIngredients[];

    public Hamburger(String name, String meal, String bread, double price) {
        this.name = name;
        this.meal = meal;
        this.bread = bread;
        this.price = price;
    }

    public void setAdditionalIngredients(AdditionalIngredients[] additionalIngredients) {
        if (additionalIngredients.length > 4) {
            System.out.println("Error: The basic hamburger accepts only 4 additional max.");
        }
        this.additionalIngredients = additionalIngredients;
    }

    public void itemizeHamburger() {
        adds = "[";

        for (AdditionalIngredients add : this.additionalIngredients) {
            if (add != null) {
                adds += add.getName() + " (+$" + add.getPrice() + ") ";
                price += add.getPrice();
            }
        }

        adds += "]";
    }

    public void orderSummary() {
        System.out.println(this.name + " hamburger on a " + this.bread + " roll with " + this.meal + ", price is $" + this.price);
        System.out.println("Added: " + adds);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getBread() {
        return bread;
    }

    public void setBread(String bread) {
        this.bread = bread;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    
}
