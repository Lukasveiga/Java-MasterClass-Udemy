package com.masterclass.oldcontent.section16.threadspt4;

import java.security.SecureRandom;
import java.util.List;

public class Producer implements Runnable {

    private List<String> buffer;
    private String color;

    public Producer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    private SecureRandom generator = new SecureRandom();

    @Override
    public void run() {

        int arraySize = 5;
        String[] nums = new String[arraySize];
        for (int i = 1; i <= arraySize; i++) {
            nums[i-1] = String.valueOf(i);
        }

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                synchronized (buffer) {
                    buffer.add(num);
                }

                Thread.sleep(generator.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        synchronized (buffer) {
            buffer.add("EOF");
        }

    }

}
