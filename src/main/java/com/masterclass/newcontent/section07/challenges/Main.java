package com.masterclass.newcontent.section07.challenges;

public class Main {

    public static void main(String[] args) {

        SalariedEmployee e1 = new SalariedEmployee("Lukas", "29/08/1996", "13/03/2023", 30000);
        System.out.println(e1);

        HourlyEmployee e2 = new HourlyEmployee("Lukas2", "29/08/1996", "13/03/2023", 120);
        System.out.println(e2);

        System.out.println(e1.getAge());
        System.out.println(e2.getAge());

    }
}
