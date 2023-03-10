package com.masterclass.oldcontent.section15.exceptions_section;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExampleOne {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        int x = getIntEAFP(scan);
        int y = 0;

        System.out.println(divideLBLY(x, y));
        System.out.println(divideEAFP(x, y));
            
    }

    private static int divideLBLY(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("Error: dvision by 0.");
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    // private static int getInt(Scanner scan){
    //     System.out.println("Insert a integer: ");
    //         return scan.nextInt();
    // }

    // private static int getIntLBYL(Scanner scan){

    //     System.out.println("Insert a integer: ");
    //     String input = scan.nextLine();
       
    //     if (isValid(input)) {
    //         return Integer.parseInt(input);
    //     } else {
    //         System.out.println("The input must be a valid integer.");
    //         return 0;
    //     }
    // }

    // private static boolean isValid(String input) {
    //     boolean isValid = true;

    //     for (int i = 0; i < input.length(); i++) {
    //         if (!Character.isDigit(input.charAt(i))) {
    //             isValid = false;
    //             break;
    //         }
    //     }
    //     return isValid;
    // }

    private static int getIntEAFP(Scanner scan) {
        System.out.println("Insert a integer: ");
        try {
            return scan.nextInt();
        } catch (InputMismatchException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
}
