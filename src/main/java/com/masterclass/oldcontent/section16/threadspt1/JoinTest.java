package com.masterclass.oldcontent.section16.threadspt1;

public class JoinTest {

    public static void main(String[] args) {

        System.out.println("I'm a main thread.");

        Thread t2 = new Thread( new Runnable() {

            @Override
            public void run() {
                System.out.println("I'm thread 2 and with the join method the main thread have to wait.");
            }

        });

        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("I'm a main thread and I wait for the thread 2 finished.");
        
    }
    
}
