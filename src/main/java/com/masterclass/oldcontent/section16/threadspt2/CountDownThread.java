package com.masterclass.oldcontent.section16.threadspt2;

public class CountDownThread implements Runnable {

    private CountDown countDown;

    public CountDownThread(CountDown countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        this.countDown.doCountDown();
    }

}
