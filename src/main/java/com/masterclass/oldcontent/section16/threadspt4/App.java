package com.masterclass.oldcontent.section16.threadspt4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static final String EOF = "EOF";

    public static void main(String[] args) throws InterruptedException {

        List<String> buffer = new ArrayList<String>();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Producer(buffer, ThreadColor.ANSI_YELLOW));
        executor.execute(new Consumer(buffer, ThreadColor.ANSI_PURPLE));
        executor.execute(new Consumer(buffer, ThreadColor.ANSI_GREEN));

        executor.shutdown();

    }
}
