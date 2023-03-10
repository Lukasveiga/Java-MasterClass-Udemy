package com.masterclass.oldcontent.section17.streams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> someBingoNumbers = lerNumerosBingo("src/com/masterclass/section16/streams/bingonumbers.txt");
        System.out.println(someBingoNumbers);
        

        someBingoNumbers.stream()
                        .sorted(String::compareTo)
                        .forEach(number -> System.out.print(number + " "));

        System.out.println();

        someBingoNumbers.stream()
                        .filter(number -> number.startsWith("G"))
                        .forEach(System.out::println);
        
    }

    private static List<String> lerNumerosBingo(String path) {
        String input;
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

            while ((input = reader.readLine()) != null) {
                data = Arrays.asList(input.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
    
}
