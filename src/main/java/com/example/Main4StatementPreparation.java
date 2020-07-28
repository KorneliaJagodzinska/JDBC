package com.example;

import java.sql.*;
import java.util.List;

import static com.example.Configuration.*;

//Uzupełnianie bazy danych danymi z listy

public class Main4StatementPreparation {
    public static void main(String[] args) throws SQLException {
        List<String> userNames = List.of("Julek", "Franek", "Jacek", "Jarek");
        List<String> passwords = List.of("Julek123", "Franek123", "Jacek123", "Jarek123");

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        PreparedStatement preparedStatement = connection.prepareStatement("insert into user(username, password) values (?,?)");
        for (int i = 0; i < userNames.size(); i++) {
            preparedStatement.setString(1, userNames.get(i));
            preparedStatement.setString(2, passwords.get(i));
            int resultSet = preparedStatement.executeUpdate();
            System.out.println(resultSet);
        }
        preparedStatement.close();

        //wyszukiwanie osób ktorych imię zaczyna sie na A

        PreparedStatement preparedStatement1 = connection.prepareStatement("select * from user where username like ?");
        preparedStatement1.setString(1, "'A%'");
        ResultSet result = preparedStatement1.executeQuery();
        System.out.println(result);
        preparedStatement1.close();


        connection.close();


    }
}
