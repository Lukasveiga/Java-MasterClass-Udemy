package com.masterclass.oldcontent.section09.challenges.innerchallenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public boolean addSong(String name, int duration) {
        return this.songs.add(new Song(name, duration));
    }

    public boolean addSongToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        Song checkSong = this.songs.findSong(trackNumber);
        if (checkSong != null) {
            playlist.add(checkSong);
            return true;
        } else {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }
    }

    public void printSongs() {
        int count = 1;
        System.out.println("---- List of songs in album: " + this.name);
        for (Song song : songs.getSongs()) {
            System.out.println("Song #" + count + ": " + song.getName() +
                    "\nDuration: " + song.getDurationMinutes() + ":" + song.getDurationSeconds());
        }
    }

    public Song findSong(String name) {
        return songs.findSong(name);
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<Song>();
        }

        public ArrayList<Song> getSongs() {
            return songs;
        }

        public boolean add(Song song) {
            if (songs.contains(song)) {
                return false;
            } else {
                songs.add(song);
                return true;
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

        public Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 && index < songs.size()) {
                return this.songs.get(index);
            } else {
                return null;
            }
        }

    }

}
