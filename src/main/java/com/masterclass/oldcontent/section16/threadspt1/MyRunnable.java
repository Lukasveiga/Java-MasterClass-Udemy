package com.masterclass.oldcontent.section16.threadspt1;

import static com.masterclass.oldcontent.section16.threadspt1.ThreadColor.*;

public class MyRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println(ANSI_RED + "Hello from runnable thread.");
        
    }
    
}
