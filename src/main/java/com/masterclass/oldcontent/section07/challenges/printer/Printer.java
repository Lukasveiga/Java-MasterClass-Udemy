package com.masterclass.oldcontent.section07.challenges.printer;

public class Printer {

    private int tonerLevel = 0;
    private int numberOfPages = 0;
    private final boolean duplexPrinter;

    public Printer(int tonerLevel, int numberOfPages, boolean duplexPrinter) {

        if(tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }
        
        if(numberOfPages > 0) {
            this.numberOfPages = numberOfPages;
        }
        
        this.duplexPrinter = duplexPrinter;
    }

    public int getTonerLevel() {

        return tonerLevel;
    }

    public void fillUpToner(int fill) {

        if (fill > 0 && (tonerLevel + fill <= 100)) {

            tonerLevel += fill;
            System.out.println("Toner was recharged. Current level: " + tonerLevel + "%");

        } else {

            System.out.println("The toner is already full.");
        }
    }
    
    public void printingPages() {

        int count = 1;
        while (numberOfPages > 0) {

            if (tonerLevel < 0) {
                System.out.println("The toner has run out, needed to fill up.");
                tonerLevel = 0;
                break;
            }

            if (!duplexPrinter) {

                System.out.println("Printing page " + numberOfPages + " on sheet " + count);
                tonerLevel--;

            } else {

                System.out.println("Printing pages " + numberOfPages + " and " + (numberOfPages -= 1) + " on sheet " + count);
                tonerLevel -= 2;
            }
            numberOfPages--;
            count++;

        }
    }
    
}
