package com.aulacanina.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    private static final String DATABASE_NAME = "aula_canina";


    private static final String URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME
            + "?useSSL=false"
            + "&serverTimezone=Europe/Madrid"
            + "&allowPublicKeyRetrieval=true";


    private static final String USER = "root";


    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}