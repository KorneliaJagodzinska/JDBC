package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.example.Configuration.*;

public class Main6Transaction {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        connection.setAutoCommit(false);

        Statement statement1= connection.createStatement();
        statement1.executeUpdate("update user set username='haha' where id=7");
        connection.rollback();
        statement1.close();

        Statement statement2= connection.createStatement();
        statement2.executeUpdate("update user set username='Alicja' where id=11");
        statement2.close();


        connection.commit();
        connection.close();
    }
}
