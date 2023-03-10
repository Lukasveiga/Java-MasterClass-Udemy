package com.masterclass.oldcontent.section20.TestTwoCRUD.model;

public class SongArtist {

    private int track;
    private String album;
    private String artist;

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "[Artist: "+ artist +", Album: " + album + ", Track: " + track + ']';
    }
}
