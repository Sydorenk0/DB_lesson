package com.alex.database;

//Created by Alex on 29.07.2015.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

       public static void main(String[]args) {
           DBWorker worker = new DBWorker();
           // получаем конекшион.

           //String query = "select * from user where id =10";
           String query = "select * from user";
           // можно добавить фильтр where
           try {
               Statement statement = worker.getConnection().createStatement();
               //запрос выборки из таблицы
              //statement.execute("insert into user (username, password) value ('fedy', 'rrt');");
               ResultSet resultSet = statement.executeQuery(query);

              while (resultSet.next()){
                  User user = new User();
                  user.setId(resultSet.getInt("id"));
                  user.setUsername(resultSet.getString("username"));
                  user.setPassword(resultSet.getString("password"));

                  //user.setId(resultSet.getInt(1));
                 // user.setUsername(resultSet.getString(2));
                  //user.setPassword(resultSet.getString(3));

                  System.out.println(user);

              }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
}

