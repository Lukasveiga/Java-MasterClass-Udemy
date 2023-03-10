package com.masterclass.oldcontent.section16.threadspt2;

public class CountDown {

    private int i;

    public void doCountDown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread#1":
                color = ThreadColor.ANSI_GREEN;
                break;
            case "Thread#2":
                color = ThreadColor.ANSI_RED;
            default:
                color = ThreadColor.ANSI_YELLOW;
        }

        synchronized (this) {
            for (this.i = 0; this.i < 11; this.i++) {
                System.out.println(color + Thread.currentThread().getName() + " : " + i);
            }
        }

    }

}
