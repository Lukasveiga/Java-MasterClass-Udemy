package com.masterclass.oldcontent.section07.challenges.billsburguer;

public class Main {

    public static void main(String[] args) {

        Hamburger hamburger = new Hamburger("Basic", "Sausage", "White", 3.56);
        hamburger.addHamburgerAdd1("Tomato", 0.27);
        hamburger.addHamburgerAdd2("Lettuce", 0.75);
        System.out.println("Total burger price : " + hamburger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.47);
        healthyBurger.addHamburgerAdd5("Egg", 0.58);
        healthyBurger.addHamburgerAdd6("Egg", 0.58);
        System.out.println("Total burger price : " + healthyBurger.itemizeHamburger());

        DeluxeBurger db = new DeluxeBurger();
        db.itemizeHamburger();
        db.addHamburgerAdd3("Tomato", 2.45);
        System.out.println("Total burger price : " + db.itemizeHamburger());

    }
}
