package com.masterclass.oldcontent.section16.threadspt2;

public class Main {

    public static void main(String[] args) {

        CountDown countDown = new CountDown();

        Thread t1 = new Thread(new CountDownThread(countDown));
        t1.setName("Thread#1");
        t1.start();

        Thread t2 = new Thread(new CountDownThread(countDown));
        t2.setName("Thread#2");
        t2.start();
        
    }
    
}
