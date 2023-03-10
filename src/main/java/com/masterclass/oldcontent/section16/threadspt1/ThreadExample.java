package com.masterclass.oldcontent.section16.threadspt1;

import static com.masterclass.oldcontent.section16.threadspt1.ThreadColor.*;

public class ThreadExample {

    public static void main(String[] args) {

        System.out.println(ANSI_PURPLE + "Hello from main thread.");

        Thread myThread = new MyThread();
        myThread.setName("== Another Thread ==");
        myThread.start();

        new Thread() {
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous thread.");
            }
        }.start();

        Thread myRunnable = new Thread(new MyRunnable() {

            @Override
            public void run() {
                System.out.println(ANSI_RED + "Hello from anonymous runnable thread.");

                try {
                    myThread.join(3000);
                    System.out.println(ANSI_GREEN + "Hello from anonymous thread.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        myRunnable.start();
        // myThread.interrupt();

        System.out.println(ANSI_PURPLE + "Hello again from main thread.");

    }

}
