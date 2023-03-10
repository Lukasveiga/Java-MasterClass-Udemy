package com.masterclass.oldcontent.section09.challenges.innerchallenge;

public class Song {

    private String name;
    private int durationSeconds;

    public Song(String name, int durationSeconds) {
        this.name = name;
        this.durationSeconds = durationSeconds;
    }

    public String getName() {
        return name;
    }

    public int getDurationSeconds() {
        return durationSeconds % 60;
    }

    public int getDurationMinutes() {
        return durationSeconds / 60;
    }

    @Override
    public String toString(){
        return "Song: " + name + " - Duration: " +
                            String.format("%02d:%02d", getDurationMinutes(), getDurationSeconds());
    }

    

}
