package com.example;

import java.sql.*;

import static com.example.Configuration.*;

public class Main3Exercise {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        Statement statementCreateTable= connection.createStatement();
        int resultCreateTable= statementCreateTable.executeUpdate(
                "create table if not exists user " +
                        "(id bigint not null auto_increment primary key,username varchar(50), password varchar(50));");
        System.out.println(resultCreateTable);
        statementCreateTable.close();

        Statement statementAddRecords= connection.createStatement();
        int resultAddRecord= statementAddRecords.executeUpdate("insert into user(username, password) values ('Kasia', 'Kasia123'), ('Basia', 'Basia123'), ('Asia','Asia123'), ('Antek', 'Antek123');");
        System.out.println(resultAddRecord);
        statementAddRecords.close();

//        Statement statementDeleteAllUsers= connection.createStatement();
//        int resultDeleteAllUsers= statementDeleteAllUsers.executeUpdate("delete from user");
//        System.out.println(resultDeleteAllUsers);
//        statementDeleteAllUsers.close();


        connection.close();
    }
}
