package com.masterclass.oldcontent.section17.streams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class BingoNumbersGenerator {

    public static void main(String[] args) {

        List<String> someBingoNumbers= new ArrayList<>();

        SecureRandom generator = new SecureRandom();

        for (int i = 0; i < 10; i++) {
            char randomChar = (char)(generator.nextInt(26) + 'A');
            int randomInt = generator.nextInt(100);
            someBingoNumbers.add(randomChar + Integer.toString(randomInt));
        }

        salvarNumerosBingo(someBingoNumbers);

    }

    private static void salvarNumerosBingo(List<String> bingoNumbers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/masterclass/section16/streams/bingonumbers.txt"))){

            for (int i = 0; i < bingoNumbers.size() - 1; i++) {
                writer.write(bingoNumbers.get(i) + ",");
            }
            writer.write(bingoNumbers.get(bingoNumbers.size() -1 ));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
