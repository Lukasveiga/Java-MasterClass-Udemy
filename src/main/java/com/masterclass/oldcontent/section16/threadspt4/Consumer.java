package com.masterclass.oldcontent.section16.threadspt4;

import java.util.List;

public class Consumer implements Runnable {

    private List<String> buffer;
    private String color;

    public Consumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(App.EOF)) {
                    System.out.println(color + " Exiting...");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));

                }
            }

        }

    }

}
