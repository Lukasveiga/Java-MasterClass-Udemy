package com.masterclass.newcontent.section12.challenge2;

public class LPAStudent extends Student{

    private final double score;

    public LPAStudent() {
        super();
        this.score = super.rand.nextDouble(0, 100.01);
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        if (fieldName.equalsIgnoreCase("score")){
            return this.score <= Integer.parseInt(value);
        }
        return super.matchFieldValue(fieldName, value);
    }

    @Override
    public String toString() {
        return super.toString() + "%15.2f".formatted(this.score);
    }
}
