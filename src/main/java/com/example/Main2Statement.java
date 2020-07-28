package com.example;


import java.sql.*;

import static com.example.Configuration.*;

public class Main2Statement  {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement= connection.createStatement();

        int result= statement.executeUpdate("delete from animal where name= 'Benio';");
        System.out.println(result);


        statement.close();
        connection.close();



    }
}
