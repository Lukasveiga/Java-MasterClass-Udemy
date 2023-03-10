package com.masterclass.oldcontent.section16.threadspt5;

import com.masterclass.oldcontent.section16.threadspt4.App;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {

    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public Consumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        while (true) {
            bufferLock.lock();
            try {
                if (buffer.isEmpty()) {
                    continue;
                }
                if (buffer.get(0).equals(App.EOF)) {
                    System.out.println(color + " Exiting...");
                    break;
                } else {
                    System.out.println(color + "Removed " + buffer.remove(0));

                }
            } finally {
                bufferLock.unlock();
            }

        }

    }

}
