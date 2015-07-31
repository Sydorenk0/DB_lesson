package com.alex.database;

//Created by Alex on 29.07.2015.


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/userlist";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[]args) {
        try {
           Driver driver = new FabricMySQLDriver();
           DriverManager.registerDriver(driver);
           } catch (SQLException e) {
               e.printStackTrace();
           }

           try(Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
               Statement statement = connection.createStatement() ) {
               System.out.println(connection.isClosed());
               //statement.execute("insert into animal (animal_name, animal_desc) value ('name', 'desc');");
           //int res = statement.executeUpdate("UPDATE animal SET  animal_name = 'new_name', animal_desc= 'dark' where id = 10");
            //System.out.println(res);
          //ResultSet res = statement.executeQuery("select * from animal");
          statement.addBatch("insert into animal (animal_name, animal_desc) value ('kuzy', 'desc1');");
          statement.addBatch("insert into animal (animal_name, animal_desc) value ('luzy', 'desc21');");
          statement.addBatch("insert into animal (animal_name, animal_desc) value ('fuzy', 'desc31');");

           statement.executeBatch();
           statement.clearBatch();
               //  очистить беч

           statement.getConnection();
               // соединение c базой данных

           statement.close();
               // закрыть стайтмен (поскольку он в трай то закрывать не обизательно)

           boolean status = statement.isClosed();
          System.out.println(status);

           } catch (SQLException e) {
              e.printStackTrace();
        }
    }
}