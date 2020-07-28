package com.example;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

import static com.example.Configuration.*;

public class Main7 {
    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user");

        ArrayList<User> users = new ArrayList<>();

        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
//            users.add(new User(id, username, password));

        }
        users.forEach(System.out::println);


        statement.close();
        connection.close();
    }
}
