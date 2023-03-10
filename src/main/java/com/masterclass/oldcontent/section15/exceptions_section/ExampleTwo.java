package com.masterclass.oldcontent.section15.exceptions_section;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExampleTwo {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int result = divide(scan);
        System.out.println(result);

    }

    private static int divide(Scanner scan) {

        try {
            int x = getInt(scan);
            int y = getInt(scan);

            System.out.println(x + " / " + y + ": ");

            return x / y;
        } catch (NoSuchElementException | ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int getInt(Scanner scan) {

        System.out.println("Enter with a integer: ");
        while (true) {
            try {
                return scan.nextInt();
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Error: Please, enter with a integer number.");
            }
        }

    }

}
