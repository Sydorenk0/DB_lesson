package com.alex.database;

//Created by Alex on 29.07.2015.

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/userlist";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    private static final String INSERT_NEW = "INSERT INTO dish VALUES(?,?,?,?,?,?,?)";
    private static final String GET_ALL = "Select * from dish";
    private static final String DELETE = "Delete from dish where id=?";

       public static void main(String[]args) {
           Connection connection = null;
           PreparedStatement preparedStatement = null;

           try {
               Driver driver = new FabricMySQLDriver();
               DriverManager.registerDriver(driver);
               connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
               preparedStatement = connection.prepareStatement(INSERT_NEW);




               preparedStatement.setInt(1, 5);
               preparedStatement.setString(2, "Insert title");
               preparedStatement.setString(3, "Inserted desc");
               preparedStatement.setFloat(4, 0.2f);
               preparedStatement.setBoolean(5, true);
               preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
               preparedStatement.setBlob(7, new FileInputStream("mouse.jpg"));


               preparedStatement.execute();
               //  выполнить запрос


               preparedStatement = connection.prepareStatement(DELETE);

               preparedStatement.setInt(1,1);
               preparedStatement.executeUpdate();


               preparedStatement = connection.prepareStatement(GET_ALL);

              ResultSet res = preparedStatement.executeQuery();

              while (res.next()) {
                  int id = res.getInt("id");
                  String title = res.getString("title");
                  String desc = res.getString("description");
                  float rating = res.getFloat("rating");
                  boolean publish = res.getBoolean("published");
                  Date date = res.getDate("created");
                   byte[] icon = res.getBytes("icon");

                   System.out.println("id: " + id + " , title: " + title + " , descriotion" + desc + " , rating: "
                   + rating + " , publiched: " + publish + " , created: " +  date + " , icon.lemgth: " + icon.length);
               }



           } catch (SQLException e) {
               e.printStackTrace();
          }
           catch (FileNotFoundException e) {
               e.printStackTrace();
           }


       }
}


