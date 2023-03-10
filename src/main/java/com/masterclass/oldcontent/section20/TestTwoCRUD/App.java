package com.masterclass.oldcontent.section20.TestTwoCRUD;

import com.masterclass.oldcontent.section20.TestTwoCRUD.model.Artist;
import com.masterclass.oldcontent.section20.TestTwoCRUD.model.SongArtist;
import com.masterclass.oldcontent.section20.TestTwoCRUD.model.DataSource;
import com.masterclass.oldcontent.section20.TestTwoCRUD.model.DataSource.SortOrder;

import java.util.List;

public class App {

    public static void main(String[] args) {

        DataSource dataSource = new DataSource();
        if (!dataSource.open()) {
            System.out.println("Can't open datasource");
        }

        List<Artist> artists = dataSource.queryArtist(SortOrder.ORDER_BY_ASC);
        if (artists.isEmpty()) {
            System.out.println("No artist!");
            return;
        }
        System.out.printf("%s | %s%n", "_Id", "Name");
        for (Artist artist : artists) {
            System.out.printf("%03d | %s%n", artist.getId(), artist.getName());
        }

        System.out.println("#############################################");

        String artist = "Pink Floyd";
        List<String> albumsForArtist = dataSource.queryAlbumsForArtist(artist, SortOrder.ORDER_BY_NONE);
        if (albumsForArtist.isEmpty()) {
            System.out.println("No artist!");
            return;
        }
        System.out.println("Artist: " + artist);
        System.out.println("Albums: ");
        for (String album : albumsForArtist) {
            System.out.println(album);
        }

        System.out.println("#############################################");
        String song = "Go Your Own Way";
        List<SongArtist> songArtists = dataSource.queryArtistForSong(song);
        System.out.println("Song: " + song);
        if (songArtists.isEmpty()) {
            System.out.println("No artist!");
            return;
        }
        for (SongArtist songArtist : songArtists) {
            System.out.println(songArtist);
        }

        System.out.println("#############################################");
        System.out.println("Songs count: " + dataSource.getCount("songs"));

        System.out.println("#############################################");
        dataSource.createViewForArtistsSongs();

        System.out.println("#############################################");
        String songName = "She's On Fire";
        List<SongArtist> songArtistsView = dataSource.querySongInfoView(songName);
        if (songArtistsView.isEmpty()) {
            System.out.println("No artist!");
            return;
        }
        System.out.println("Song name: " + songName);
        for (SongArtist songArtist : songArtistsView) {
            System.out.println(songArtist);
        }

        System.out.println("#############################################");
        dataSource.insertSong("If You Intend", "Our Time in Eden", "1000 Maniacs", 7);
        dataSource.insertSong("Touch of Grey", "Grateful Dead", "In The Dark", 1);

        dataSource.close();

    }
}
