package com.masterclass.oldcontent.section20.TestTwoCRUD.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {

    private static final String DB_NAME = "music.db";
    private static final String CONNECTION = "jdbc:sqlite:src/main/java/com/masterclass/section20/TestTwoCRUD/database/" + DB_NAME;
    // Albums table
    private static final String TABLE_ALBUMS = "albums";
    private static final String COLUMN_ALBUMS_ID = "_id";
    private static final String COLUMN_ALBUMS_ARTIST = "artist";
    private static final String COLUMN_ALBUMS_NAME = "name";
    private static final int INDEX_ALBUM_ID = 1;
    private static final int INDEX_ALBUM_ARTIST = 2;
    private static final int INDEX_ALBUM_NAME = 3;
    // Artists table
    private static final String TABLE_ARTISTS = "artists";
    private static final int INDEX_ARTISTS_ID = 1;
    private static final int INDEX_ARTISTS_NAME = 2;
    private static final String COLUMN_ARTISTS_ID = "_id";
    private static final String COLUMN_ARTISTS_NAME = "name";
    // Songs table
    private static final String TABLE_SONGS = "songs";
    private static final int INDEX_SONGS_ID = 1;
    private static final int INDEX_SONGS_ALBUM = 2;
    private static final int INDEX_SONGS_TITLE = 3;
    private static final int INDEX_SONGS_TRACK = 4;
    private static final String COLUMN_SONGS_ID = "_id";
    private static final String COLUMN_SONGS_ALBUM = "album";
    private static final String COLUMN_SONGS_TITLE = "title";
    private static final String COLUMN_SONGS_TRACK = "track";

    //View table
    private static final String TABLE_ARTISTS_SONGS_VIEW = "artist_list";

    // Inserting Records into Music Database
    private static final String INSERT_ARTISTS = String.format("INSERT INTO %s(%s) VALUES(?)",
            TABLE_ARTISTS, COLUMN_ARTISTS_NAME);
    private static final String INSERT_ALBUMS = String.format("INSERT INTO %s(%s, %s) VALUES(?, ?)",
            TABLE_ALBUMS, COLUMN_ALBUMS_NAME, COLUMN_ALBUMS_ARTIST);
    private static final String INSERT_SONGS = String.format("INSERT INTO %s(%s, %s, %s) VALUES(?, ?, ?)",
            TABLE_SONGS, COLUMN_SONGS_TRACK, COLUMN_SONGS_TITLE, COLUMN_SONGS_ALBUM);

    // Check if the input already exists into database
    private static final String QUERY_ARTIST = String.format("SELECT %s FROM %s WHERE %s = ?",
            COLUMN_ARTISTS_ID, TABLE_ARTISTS, COLUMN_ARTISTS_NAME);
    private static final String QUERY_ALBUM = String.format("SELECT %s FROM %s WHERE %s = ?",
            COLUMN_ALBUMS_ID, TABLE_ALBUMS, COLUMN_ALBUMS_NAME);
    private static final String QUERY_SONG = String.format("SELECT %s FROM %s WHERE %s = ?",
            COLUMN_SONGS_ID, TABLE_SONGS, COLUMN_SONGS_TITLE);

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    private PreparedStatement queryArtist;
    private PreparedStatement queryAlbum;
    private PreparedStatement querySong;

    public enum SortOrder {
        ORDER_BY_ASC("ASC"), ORDER_BY_DESC("DESC"), ORDER_BY_NONE("");
        private final String order;

        SortOrder(String order) {
            this.order = order;
        }

        public String getOrder() {
            return this.order;
        }
    }

    private Connection connection;

    public boolean open() {
        try {

            connection = DriverManager.getConnection(CONNECTION);

            insertIntoArtists = connection.prepareStatement(INSERT_ARTISTS, Statement.RETURN_GENERATED_KEYS);
            insertIntoAlbums = connection.prepareStatement(INSERT_ALBUMS, Statement.RETURN_GENERATED_KEYS);
            insertIntoSongs = connection.prepareStatement(INSERT_SONGS, Statement.RETURN_GENERATED_KEYS);

            queryArtist = connection.prepareStatement(QUERY_ARTIST);
            queryAlbum = connection.prepareStatement(QUERY_ALBUM);
            querySong = connection.prepareStatement(QUERY_SONG);

            return true;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to database " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if (insertIntoArtists != null) {
                insertIntoArtists.close();
            }

            if (insertIntoAlbums != null) {
                insertIntoAlbums.close();
            }

            if (insertIntoSongs != null) {
                insertIntoSongs.close();
            }

            if (queryArtist != null) {
                queryArtist.close();
            }

            if (queryAlbum != null) {
                queryAlbum.close();
            }

            if (querySong != null) {
                querySong.close();
            }

            if (connection != null) {
                connection.close();
            }

        } catch (SQLException e) {
            System.out.println("Couldn't close connection " + e.getMessage());
        }
    }

    public List<Artist> queryArtist(SortOrder order) {

        StringBuilder sb = new StringBuilder("SELECT * FROM ");
        sb.append(TABLE_ARTISTS);
        if (order != SortOrder.ORDER_BY_NONE) {
            final String orderQuery = String.format(" ORDER BY %s COLLATE NOCASE %s", COLUMN_ARTISTS_NAME, order.getOrder());
            sb.append(orderQuery);
        }

        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sb.toString())) {


            List<Artist> artists = new ArrayList<>();

            while (result.next()) {
                Artist artist = new Artist();
                artist.setId((int) result.getObject(INDEX_ARTISTS_ID));
                artist.setName((String) result.getObject(INDEX_ARTISTS_NAME));
                artists.add(artist);
            }

            System.out.println("Query successful: " + sb);
            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            System.out.println("Query: " + sb);
            return null;
        }
    }

    public List<String> queryAlbumsForArtist(String artistName, SortOrder order) {

        final String query = String.format("SELECT %s.%s FROM %s INNER JOIN %s ON %s.%s = %s.%s WHERE %s.%s = '%s'",
                TABLE_ALBUMS, COLUMN_ALBUMS_NAME, TABLE_ALBUMS, TABLE_ARTISTS, TABLE_ALBUMS, COLUMN_ALBUMS_ARTIST, TABLE_ARTISTS, COLUMN_ARTISTS_ID,
                TABLE_ARTISTS, COLUMN_ARTISTS_NAME, artistName);


        StringBuilder sb = new StringBuilder(query);
        if (order != SortOrder.ORDER_BY_NONE) {
            final String orderQuery = String.format(" ORDER BY %s.%s COLLATE NOCASE %s", TABLE_ALBUMS, COLUMN_ALBUMS_NAME, order.getOrder());
            sb.append(orderQuery);
        }


        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sb.toString())) {

            List<String> albumsForArtist = new ArrayList<>();

            while (result.next()) {
                albumsForArtist.add(result.getString(1));
            }

            System.out.println("Query successful: " + sb);
            return albumsForArtist;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed: " + sb);
            return null;
        }
    }

    public List<SongArtist> queryArtistForSong(String song) {

        final String QUERY = String.format("SELECT %s.%s, %s.%s, %s.%s FROM %s " +
                        "INNER JOIN %s ON %s.%s = %s.%s " +
                        "INNER JOIN %s ON %s.%s = %s.%s WHERE %s.%s = ? ORDER BY %s.%s COLLATE NOCASE ASC", TABLE_SONGS, COLUMN_SONGS_TRACK,
                TABLE_ARTISTS, COLUMN_ARTISTS_NAME, TABLE_ALBUMS, COLUMN_ALBUMS_NAME,
                TABLE_SONGS, TABLE_ALBUMS, TABLE_SONGS, COLUMN_SONGS_ALBUM, TABLE_ALBUMS, COLUMN_ALBUMS_ID,
                TABLE_ARTISTS, TABLE_ARTISTS, COLUMN_ARTISTS_ID, TABLE_ALBUMS, COLUMN_ALBUMS_ARTIST,
                TABLE_SONGS, COLUMN_SONGS_TITLE, TABLE_ARTISTS, COLUMN_ARTISTS_NAME);

        try (PreparedStatement statement = connection.prepareStatement(QUERY)) {

            statement.setString(1, song);

            ResultSet result = statement.executeQuery();

            List<SongArtist> songArtists = new ArrayList<>();

            while (result.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setTrack(result.getInt(1));
                songArtist.setArtist(result.getString(2));
                songArtist.setAlbum(result.getString(3));
                songArtists.add(songArtist);
            }

            System.out.println("Query successful: " + QUERY);
            return songArtists;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed: " + QUERY);
            return null;
        }

    }

    public int getCount(String table) {
        String queryFunc = "SELECT COUNT(*) FROM " + table;

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(queryFunc)) {

            return resultSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void createViewForArtistsSongs() {
        final String CREATE_VIEW = String.format("CREATE VIEW IF NOT EXISTS %s AS " +
                        "SELECT %s.%s, %s.%s AS album, %s.%s, %s.%s " +
                        "FROM %s INNER JOIN %s ON %s.%s = %s.%s " +
                        "INNER JOIN %s ON %s.%s = %s.%s " +
                        "ORDER BY %s.%s, %s.%s, %s.%s", TABLE_ARTISTS_SONGS_VIEW, TABLE_ARTISTS, COLUMN_ARTISTS_NAME,
                TABLE_ALBUMS, COLUMN_ALBUMS_NAME, TABLE_SONGS, COLUMN_SONGS_TRACK,
                TABLE_SONGS, COLUMN_SONGS_TITLE, TABLE_SONGS, TABLE_ALBUMS, TABLE_SONGS, COLUMN_SONGS_ALBUM,
                TABLE_ALBUMS, COLUMN_ALBUMS_ID, TABLE_ARTISTS, TABLE_ALBUMS, COLUMN_ALBUMS_ARTIST, TABLE_ARTISTS, COLUMN_ARTISTS_ID,
                TABLE_ARTISTS, COLUMN_ARTISTS_NAME, TABLE_ALBUMS, COLUMN_ALBUMS_NAME, TABLE_SONGS, COLUMN_SONGS_TRACK);

        try (Statement statement = connection.createStatement()) {

            statement.execute(CREATE_VIEW);
            System.out.println("Create View successfully: " + CREATE_VIEW);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to create view: " + CREATE_VIEW);
        }
    }

    public List<SongArtist> querySongInfoView(String songName) {
        final String QUERY_VIEW = String.format("SELECT %s, %s, %s FROM %s WHERE %s = ?",
                COLUMN_ARTISTS_NAME, COLUMN_SONGS_ALBUM, COLUMN_SONGS_TRACK,
                TABLE_ARTISTS_SONGS_VIEW, COLUMN_SONGS_TITLE);

        try (PreparedStatement statement = connection.prepareStatement(QUERY_VIEW)) {

            statement.setString(1, songName);
            ResultSet result = statement.executeQuery();

            List<SongArtist> songsArtistsView = new ArrayList<>();

            while (result.next()) {
                SongArtist songArtist = new SongArtist();
                songArtist.setArtist(result.getString(1));
                songArtist.setAlbum(result.getString(2));
                songArtist.setTrack(result.getInt(3));

                songsArtistsView.add(songArtist);
            }

            System.out.println("Query successfully: " + QUERY_VIEW);
            statement.close();

            return songsArtistsView;

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Query failed: " + QUERY_VIEW);
            return null;
        }
    }

    private boolean isAlreadyExistArtist = false;
    private boolean isAlreadyExistAlbum = false;

    private int insertArtist(String name) throws SQLException {

        queryArtist.setString(1, name);
        ResultSet result = queryArtist.executeQuery();

        if (result.next()) {
            isAlreadyExistArtist = true;
            return result.getInt(1);
        } else {
            // insert artist
            insertIntoArtists.setString(1, name);
            int affectedRows = insertIntoArtists.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert artist.");
            }

            ResultSet generatedKeys = insertIntoArtists.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for artist");
            }
        }
    }

    private int insertAlbum(String name, int artistId) throws SQLException {

        queryAlbum.setString(1, name);
        ResultSet result = queryAlbum.executeQuery();

        if (result.next()) {
            isAlreadyExistAlbum = true;
            return result.getInt(1);
        } else {
            // insert album
            insertIntoAlbums.setString(1, name);
            insertIntoAlbums.setInt(2, artistId);
            int affectedRows = insertIntoAlbums.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert album.");
            }

            ResultSet generatedKeys = insertIntoAlbums.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            } else {
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    public void insertSong(String songTitle, String albumName, String artistName, int track) {

        try {
            connection.setAutoCommit(false);

            int artistsId = insertArtist(artistName);
            int albumId = insertAlbum(albumName, artistsId);

            querySong.setString(1, songTitle);
            ResultSet result = querySong.executeQuery();

            if (isAlreadyExistArtist && isAlreadyExistAlbum && result.next()) {
                System.out.println("Song already exists into database.");
            } else {
                // insert album
                insertIntoSongs.setInt(1, track);
                insertIntoSongs.setString(2, songTitle);
                insertIntoSongs.setInt(3, albumId);
                int affectedRows = insertIntoSongs.executeUpdate();

                if (affectedRows == 1) {
                    System.out.println("Song inserted successfully.");
                    connection.commit();
                } else {
                    throw new SQLException("The song insert failed.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Inset song exception: " + e.getMessage());
            try {
                connection.rollback();
            } catch (SQLException e2) {
                System.out.println("Things are really bad! " + e2.getMessage());
            }
        } finally {
            try {
                System.out.println("Resetting default commit behavior.");
                connection.setAutoCommit(true);
            } catch (SQLException e3) {
                System.out.println("Couldn't reset to default commit behavior: " + e3.getMessage());
            }
        }
    }
}

















