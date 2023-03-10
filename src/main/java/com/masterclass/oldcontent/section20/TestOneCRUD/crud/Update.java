package com.masterclass.oldcontent.section20.TestOneCRUD.crud;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

    // URL Connection
    private static final String DB_NAME = "testjava.db";
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/java/com/masterclass/section20/TestOneCRUD/database/" + DB_NAME;

    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement()
        ) {

            //Add values
            //addContactToDatabase("contacts", "Lukas", "(13)-988685816", "lukas@email.com", statement);

            //Update a value
            //statement.execute("UPDATE contacts SET phone = '(83)-977685822' WHERE name = 'Natalia'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void addContactToDatabase(String table, String name, String phone, String email, @NotNull Statement statement) throws SQLException {
        final String VALUES = String.format("('%s', '%s', '%s')", name, phone, email);
        final String ADD_CONTACT = "INSERT INTO " + table + " (name, phone, email) VALUES " + VALUES;

        statement.execute(ADD_CONTACT);
    }
}
