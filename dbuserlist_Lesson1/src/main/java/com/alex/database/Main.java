package com.alex.database;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//Created by Alex on 29.07.2015.

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/userlist";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[]args) {
        Connection connection;


        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if(!connection.isClosed()){
                System.out.println("conection with DB ok");
            }
            connection.close();

            if(connection.isClosed()) {
                System.out.println("conection with DB close");
            }

        } catch (SQLException e) {
            System.err.println("Не удалось загрузить класс драйвера");
        }
    }
}
