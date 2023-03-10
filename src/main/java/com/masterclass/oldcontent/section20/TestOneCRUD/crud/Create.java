package com.masterclass.oldcontent.section20.TestOneCRUD.crud;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create {

    // URL Connection
    private static final String DB_NAME = "testjava.db";
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/java/com/masterclass/section20/TestOneCRUD/database/" + DB_NAME;
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS contacts (contact_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, email TEXT)";

    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement()
        ) {

            statement.execute(CREATE_TABLE);

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
