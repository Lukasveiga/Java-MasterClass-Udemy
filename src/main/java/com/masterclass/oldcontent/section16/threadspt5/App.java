package com.masterclass.oldcontent.section16.threadspt5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class App {

    public static final String EOF = "EOF";

    public static void main(String[] args) throws InterruptedException {

        List<String> buffer = new ArrayList<String>();

        ReentrantLock bufferLock = new ReentrantLock();

        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Producer(buffer, ThreadColor.ANSI_YELLOW, bufferLock));
        executor.execute(new Consumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock));
        executor.execute(new Consumer(buffer, ThreadColor.ANSI_GREEN, bufferLock));

        executor.shutdown();

    }
}
