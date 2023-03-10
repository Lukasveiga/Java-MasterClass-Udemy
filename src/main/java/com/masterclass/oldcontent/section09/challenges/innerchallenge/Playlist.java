package com.masterclass.oldcontent.section09.challenges.innerchallenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {

    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Album> albums = new ArrayList<Album>();
    private static LinkedList<Song> playlist = new LinkedList<Song>();

    public static void main(String[] args) {

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 240);
        album.addSong("Soldier of fortune", 260);
        album.addSong("The gypsy", 220);
        album.addSong("High ball shooter", 200);
        album.addSong("Hold on", 180);
        albums.add(album);

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 240);
        album.addSong("I put the finger on you", 260);
        album.addSong("Inject the venom", 220);
        album.addSong("Evil walks", 200);
        album.addSong("C.O.D", 180);
        albums.add(album);

        boolean quit = false;
        int action;

        System.out.println("----- Playlist -----");
        printMenu();

        do {

            System.out.println("Choose your option: (Press 5 to show the menu)");
            action = scan.nextInt();
            scan.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Ending playlist...");
                    quit = true;
                    break;
                case 1:
                    addSongToPlaylist();
                    break;
                case 2:
                    removeSongFromPlaylist();
                    break;
                case 3:
                    showSongsIntoPlaylist();
                    break;
                case 4:
                    play();
                    break;
                case 5:
                    printMenu();
                    break;
            }
        } while (!quit);

        scan.close();
    }

    private static void addSongToPlaylist() {
        System.out.println("Inform the name of the album: ");
        String albumName = scan.nextLine();
        for (Album album : albums) {
            if (album.getName().equalsIgnoreCase(albumName)) {
                System.out.println("Infom the track number of thse song.");
                int trackSong = scan.nextInt();
                if (album.addSongToPlaylist(trackSong, playlist)) {
                    System.out.println("Track " + trackSong + " was add to playlist.");
                    break;
                } else {
                    break;
                }

            } else {
                System.out.println("The album was not found.");
                break;
            }

        }

    }

    private static void removeSongFromPlaylist() {
        ListIterator<Song> iterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("No songs in playlist.");
        } else {
            System.out.println("Infom the name of thse song.");
            String songTitle = scan.nextLine();
            while (iterator.hasNext()) {
                if (iterator.next().getName().equalsIgnoreCase(songTitle)) {
                    iterator.remove();
                    System.out.println("The song " + songTitle + " has been removed.");
                } else {
                    System.out.println("The song was not found in playlist.");
                }
            }
        }
    }

    private static void showSongsIntoPlaylist() {
        ListIterator<Song> iterator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("No songs in playlist.");
        } else {
            while (iterator.hasNext()) {
                System.out.println(iterator.next().toString());
            }
        }
    }

    private static void play() {
        ListIterator<Song> iterator = playlist.listIterator();

        int action;
        boolean quitPlaylist = false;
        boolean forward = true;

        if (playlist.isEmpty()) {
            System.out.println("No songs in playlist.");
        } else {
            System.out.println("Now playing " + iterator.next().toString());
            printMenuPlaylist();
        }

        do {
            action = scan.nextInt();
            scan.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quitPlaylist = true;
                    break;
                case 1:
                    if (!forward) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        forward = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("Now playing " + iterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        forward = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("Now playing " + iterator.previous().toString());
                    } else {
                        System.out.println("We are in the start of the playlist.");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (iterator.hasPrevious()) {
                            System.out.println("Now replaying " + iterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist.");
                        }
                    } else {
                        if (iterator.hasNext()) {
                            System.out.println("Now replaying " + iterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the playlist.");
                        }
                    }
                    break;
                case 4:
                    showSongsIntoPlaylist();
                    break;
                case 5:
                    printMenuPlaylist();
                    break;
            }
        } while (!quitPlaylist);
    }

    private static void printMenu() {
        System.out.println("(0) - Quit.\n" +
                "(1) - Add song to playlist.\n" +
                "(2) - Remove song to playlist.\n" +
                "(3) - Show the songs in the playlist,\n" +
                "(4) - Play");
    }

    private static void printMenuPlaylist() {
        System.out.println("(0) - Quit.\n" +
                "(1) - to play next song.\n" +
                "(2) - to play previous song.\n" +
                "(3) - to replay the current song.\n" +
                "(4) - list songs in the playlist.\n" +
                "(5) - show menu.");
    }

}
