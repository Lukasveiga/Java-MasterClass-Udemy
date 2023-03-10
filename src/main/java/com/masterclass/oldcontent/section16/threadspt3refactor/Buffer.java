package com.masterclass.oldcontent.section16.threadspt3refactor;

public interface Buffer {

    public void blockingPut(String value) throws InterruptedException;
    public String blockingGet() throws InterruptedException;                                                                                                                          
    
}
