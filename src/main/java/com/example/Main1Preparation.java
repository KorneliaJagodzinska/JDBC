package com.example;

import java.math.BigDecimal;
import java.sql.*;

import static com.example.Configuration.*;

public class Main1Preparation {
    public static void main(String[] args) throws SQLException {
        System.out.println(1);

        Connection connection= DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement= connection.createStatement();

        ResultSet resultSet= statement.executeQuery("SELECT * FROM animal");
        while (resultSet.next()){
            BigDecimal id= resultSet.getBigDecimal(1);
            String name= resultSet.getString(2);
            int age= resultSet.getInt(3);
            System.out.println(String.format("Id: %s Name: %s", id, name, age));
        }
        statement.close();
        connection.close();

    }
}
