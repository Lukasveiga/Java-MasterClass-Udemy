package com.masterclass.newcontent.section12.challenge2;

public class LPAStudent extends Student{

    private final double score;

    public LPAStudent() {
        super();
        this.score = super.rand.nextDouble(0, 100.01);
    }

    @Override
    public String toString() {
        return super.toString() + "%15.2f".formatted(this.score);
    }
}
