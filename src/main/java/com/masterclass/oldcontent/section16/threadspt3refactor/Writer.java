package com.masterclass.oldcontent.section16.threadspt3refactor;

import java.security.SecureRandom;

public class Writer implements Runnable {

    private Buffer message;

    public Writer(Buffer message) {
        this.message = message;
    }

    @Override
    public void run() {

        String messages[] = { "Todas as cartas de amor são ridículas",
                "Não seriam cartas de amor se não fossem ridículas",
                "As cartas de amor, se há amor, têm de ser ridículas..." };

        SecureRandom generator = new SecureRandom();

        for (int i = 0; i < messages.length; i++) {
            try {
                Thread.sleep(generator.nextInt(2000));
                message.blockingPut(messages[i]);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }

}
