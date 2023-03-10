package com.masterclass.oldcontent.section15.fileio.Adventure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.masterclass.oldcontent.section15.fileio.Adventure.enums.Directions;

public class App {

    private static Locations locations = new Locations();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put(Directions.QUIT.getDescription() , Directions.QUIT.getDirection());
        vocabulary.put(Directions.NORTH.getDescription(), Directions.NORTH.getDirection());
        vocabulary.put(Directions.SOUTH.getDescription(), Directions.SOUTH.getDirection());
        vocabulary.put(Directions.WEST.getDescription() , Directions.WEST.getDirection());
        vocabulary.put(Directions.EAST.getDescription() , Directions.EAST.getDirection());

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());

            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = input.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);

            } else {
                System.out.println("You cannot go in that direction");
            }
        }

    }

}
