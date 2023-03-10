package com.masterclass.oldcontent.section16.threadspt3refactor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();

        Buffer message = new Message();

        executor.execute(new Writer(message));
        executor.execute(new Reader(message));

        executor.shutdown(); // termina o aplicativo quando as tarefas concluem
        executor.awaitTermination(1, TimeUnit.MINUTES);

    }

}
