package com.masterclass.oldcontent.section16.threadspt3;

import java.security.SecureRandom;

public class Reader implements Runnable {

    private Message message;

    public Reader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

        SecureRandom generator = new SecureRandom();

        for (String latestMessage = message.read(); !latestMessage.equalsIgnoreCase("Finished"); latestMessage = message
                .read()) {
            System.out.println(latestMessage);
            try {
                Thread.sleep(generator.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
