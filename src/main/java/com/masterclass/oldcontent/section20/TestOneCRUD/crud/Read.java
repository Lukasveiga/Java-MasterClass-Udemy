package com.masterclass.oldcontent.section20.TestOneCRUD.crud;

import org.jetbrains.annotations.NotNull;

import java.sql.*;

public class Read {

    // URL Connection
    private static final String DB_NAME = "testjava.db";
    private static final String DATABASE_URL = "jdbc:sqlite:src/main/java/com/masterclass/section20/TestOneCRUD/database/" + DB_NAME;

    public static void main(String[] args) {

        try (
                Connection connection = DriverManager.getConnection(DATABASE_URL);
                Statement statement = connection.createStatement()
        ) {

            showTable("contacts", statement);

        } catch (SQLException e) {
            e.printStackTrace();
        }

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
                System.out.printf("%-8s\t", resultSet.getObject(i));
            }
            System.out.println();
        }

        resultSet.close();
    }
}
