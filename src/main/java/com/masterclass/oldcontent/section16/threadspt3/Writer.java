package com.masterclass.oldcontent.section16.threadspt3;

import java.security.SecureRandom;

public class Writer implements Runnable {

    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {

        String messages[] = { "Todas as cartas de amor são ridículas",
                "Não seriam cartas de amor se não fossem ridículas",
                "As cartas de amor, se há amor, têm de ser ridículas..." };

        SecureRandom generator = new SecureRandom();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(generator.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        message.write("Finished");

    }

}
