package com.masterclass.oldcontent.section16.threadspt1;

import static com.masterclass.oldcontent.section16.threadspt1.ThreadColor.ANSI_BLUE;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(ANSI_BLUE + "Hello from " + currentThread().getName());

        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }

        System.out.println(ANSI_BLUE + "Three seconds have passed and I'm awake.");
    }

    
    
}
