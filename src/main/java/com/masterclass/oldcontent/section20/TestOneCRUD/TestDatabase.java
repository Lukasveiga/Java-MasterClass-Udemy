package com.masterclass.oldcontent.section20.TestOneCRUD;

import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class TestDatabase {

    public static void main(String[] args) {

        final String DATABASE_URL = "jdbc:sqlite:src/main/java/com/masterclass/section20/database/testjava.db";
        final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS contacts (contact_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone TEXT, email TEXT)";

        try (
                Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement()
        ) {

            //Create table
            statement.execute(CREATE_TABLE);

            //Add values
            //addContactToDatabase("contacts", "Julia", "(22)-955685816", "julia@email.com", statement);
            //addContactToDatabase("contacts", "Ana", "(22)-955685816", "ana@email.com", statement);
            //addContactToDatabase("contacts", "Steve", "(22)-955685816", "steve@email.com", statement);
            //addContactToDatabase("contacts", "Natalia", "(22)-955685816", "natalia@email.com", statement);
            //addContactToDatabase("contacts", "Lukas", "(22)-955685816", "lukas@email.com", statement);


            //Update a value
            statement.execute("UPDATE contacts SET phone = '(83)-977685822' WHERE name = 'Natalia'");

            //Delete value
            statement.execute("DELETE FROM contacts WHERE name = 'Ana'");

            //Consume and show valeus of the table
            showTable("contacts", statement);



        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void addContactToDatabase(String table, String name, String phone, String email, @NotNull Statement statement) throws SQLException {
        final String VALUES = String.format("('%s', '%s', '%s')", name, phone, email);
        final String ADD_CONTACT = "INSERT INTO " + table + " (name, phone, email) VALUES " + VALUES;

        statement.execute(ADD_CONTACT);
    }

    private static void showTable(String tableName, @NotNull Statement statement) throws SQLException {
        final String SELECT_QUERY = "SELECT * FROM " + tableName;
        ResultSet resultSet = statement.executeQuery(SELECT_QUERY);

        ResultSetMetaData metaData = resultSet.getMetaData();
        int numberOfColumns = metaData.getColumnCount();

        System.out.println(tableName + " table from Database: ");

        for (int i = 1; i <= numberOfColumns; i++) {
            System.out.printf("%-10s\t", metaData.getColumnName(i));
        }
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= numberOfColumns; i++) {
                System.out.printf("%-10s\t", resultSet.getObject(i));
            }
            System.out.println();
        }

        resultSet.close();
    }
}
