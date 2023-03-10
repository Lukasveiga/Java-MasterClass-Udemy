package com.masterclass.oldcontent.section07.challenges.printer;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(10, 2, true);

        printer.fillUpToner(1);
        printer.printingPages();
        System.out.println(printer.getTonerLevel() + "%");

    }
    
}
