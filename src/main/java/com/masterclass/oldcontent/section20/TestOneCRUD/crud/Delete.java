package com.masterclass.oldcontent.section20.TestOneCRUD.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    private static final String DB_NAME = "testjava.db";
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/java/com/masterclass/section20/TestOneCRUD/database/" + DB_NAME;

    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement()
        ) {

            //Delete value
            //statement.execute("DELETE FROM contacts WHERE name = 'Lukas'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
