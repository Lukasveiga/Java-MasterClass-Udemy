package com.masterclass.oldcontent.section08.challenges.playlist;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist= artist;
        this.songs = new ArrayList<Song>();
    }

    public String getName() {
        return name;
    }

    public String getArtist(){
        return artist;
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean addSong(String name, int duration) {
        if (findSong(name) == null) {
            songs.add(new Song(name, duration));
            return true;
        } else {
            System.out.println("The song already exists in the album.");
            return false;
        }
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index >= 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addSongToPlaylist(String titleSong, LinkedList<Song> playlist) {
        Song checkedSong = findSong(titleSong);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + titleSong + " is not in this album.");
        return false;
    }

    public void printSongs() {
        int count = 1;
        System.out.println("---- List of songs in album: " + this.name);
        for (Song song : songs) {
            System.out.println("Song #" + count + ": " + song.getName() +
                    "\nDuration: " + song.getDurationMinutes() + ":" + song.getDurationSeconds());
        }
    }

    public Song findSong(String name) {
        for (Song song : songs) {
            if (song.getName().equalsIgnoreCase(name)) {
                return song;
            }
        }
        return null;
    }

}
