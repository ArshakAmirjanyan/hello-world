package com.fipsoft.jdbc.db;

import com.fipsoft.jdbc.api.ConnectionProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aamirjanyan on 6/27/16.
 */
public class ConnectionManager implements ConnectionProvider {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/arshak";
    static final String USER = "Arshak";
    static final String PASS = "voidassault";
    @Override
    public Connection getConnection() {
        try{
            return DriverManager.getConnection(DB_URL,USER,PASS);}
        catch (SQLException a){
            System.out.println("Connection error");
        }
        return null;
    }
}
