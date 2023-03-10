package com.masterclass.oldcontent.section07.challenges.refactorbillsburguer;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Hamburger burger = new Hamburger("Basic", "Sausage", "White", 10.0);
        HealthyBurger hBurger = new HealthyBurger("Sausage", 12.0);
        DeluxBurger DxBuger = new DeluxBurger();

        AdditionalIngredients[] adds = new AdditionalIngredients[3];

        try (Scanner input = new Scanner(System.in)) {
            for (int i = 0; i < 2; i++) {

                AdditionalIngredients add = new AdditionalIngredients();

                System.out.println("Additional: ");
                add.setName(input.nextLine());
                System.out.println("Price: ");
                add.setPrice(input.nextDouble());
                adds[i] = add;
                input.nextLine();
            }
        }

        burger.setAdditionalIngredients(adds);
        burger.itemizeHamburger();

        burger.orderSummary();

        hBurger.setAdditionalIngredients(adds);
        hBurger.itemizeHamburger();

        hBurger.orderSummary();

        DxBuger.setAdditionalIngredients(adds);
        DxBuger.itemizeHamburger();

        DxBuger.orderSummary();
        
    }
    
}
