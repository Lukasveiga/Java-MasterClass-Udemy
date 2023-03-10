package com.masterclass.oldcontent.section13.theatreseats;

import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);
        //theatre.getSeats();

        /*if (theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if (theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        theatre.cancelSeatreversed("H11");

        if (theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }*/

        if (theatre.reserveSeat("H11")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if (theatre.reserveSeat("A06")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if (theatre.reserveSeat("F04")){
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        printList(theatre.getSeats());

        System.out.println("==============================");

        Collections.sort(theatre.getSeats(), Theatre.PRICE_ORDER);
        printList(theatre.getSeats());


    }

    public static void printList(List<Theatre.Seat> list){
        for (Theatre.Seat seat: list) {
            System.out.println("Seat Number: " + seat.getSeatNumber() + " Price: R$" + seat.getPrice() + " Reversed: " + seat.isReserved());
        }
    }
}
