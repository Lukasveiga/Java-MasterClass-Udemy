package com.masterclass.oldcontent.section00;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PrintHelloWorld print = System.out::println;

        print.printHelloWord("Hello World!");

        List<String> words = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 2; i++) {
            System.out.println("Enter with word: ");
            words.add(scan.nextLine());
        }

        words.forEach(word -> System.out.print(word + " "));

        Product product = new Product("Shampoo");
        System.out.println(product.getName());

    }
}