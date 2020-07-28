package com.example;

import java.sql.*;

import static com.example.Configuration.*;
//wyszukiwanie czy w bazie danych jest osoba o podanym loginie i hasle

public class Main5Injection {
    public static void main(String[] args) throws SQLException {

        String username = "Basia";
        String password = "Basia123";
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        boolean isLogged = login(connection, username, password);
        System.out.println(isLogged);


        //przykład jak można zchakować się do konta użytkownika i uzyskać dostęp

        System.out.println(login(connection, "Adam", "wrongPassword"));
        System.out.println(login(connection, "Adam", "password10"));
        System.out.println(login(connection, "Adam", "' OR '1'='1"));

        //Select * from user where username= 'Adam' and password= 'wrongPassword'
        //Select * from user where username= 'Adam' and password= 'password10'
        //Select * from user where username= 'Adam' and password= ' OR '1'='1'
    }
//ta metoda sprawdza czy w bazie danych jest osoba o podanym loginie i hasle
    private static boolean login(Connection connection, String username, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username= ? and password=?");

        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean idLogged= resultSet.next();
        preparedStatement.close();

        return idLogged;

    }
}
