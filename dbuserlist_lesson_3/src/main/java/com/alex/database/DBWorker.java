package com.alex.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Alex on 29.07.2015.
 */
public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/userlist";
    private final String USERNAME = "root";
    private final String PASSWORD = "1234";

    private Connection connection;

    public DBWorker(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
