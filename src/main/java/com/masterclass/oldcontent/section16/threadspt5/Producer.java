package com.masterclass.oldcontent.section16.threadspt5;

import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Producer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public Producer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    private SecureRandom generator = new SecureRandom();

    @Override
    public void run() {

        int arraySize = 5;
        String[] nums = new String[arraySize];
        for (int i = 1; i <= arraySize; i++) {
            nums[i - 1] = String.valueOf(i);
        }

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(generator.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }

    }

}
