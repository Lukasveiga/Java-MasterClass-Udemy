package com.masterclass.oldcontent.section16.threadspt3refactor;

import java.security.SecureRandom;

public class Reader implements Runnable {

    private Buffer message;

    public Reader(Buffer message) {
        this.message = message;
    }

    @Override
    public void run() {

        SecureRandom generator = new SecureRandom();

        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(generator.nextInt(2000));
                String readValue = message.blockingGet();
                System.out.println(readValue);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
