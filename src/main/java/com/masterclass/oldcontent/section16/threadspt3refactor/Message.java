package com.masterclass.oldcontent.section16.threadspt3refactor;

import java.util.concurrent.ArrayBlockingQueue;

public class Message implements Buffer {

    private final ArrayBlockingQueue<String> buffer;

    public Message() {
        this.buffer = new ArrayBlockingQueue<String>(1);
    }

    @Override
    public void blockingPut(String value) throws InterruptedException {
        buffer.put(value);
        
    }

    @Override
    public String blockingGet() throws InterruptedException {
        String readValue = buffer.take();
        return readValue;
    }
    
}
