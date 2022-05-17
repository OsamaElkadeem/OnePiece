/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.onepiece;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ali
 */
public class ConnectDatabase {

    public static Connection connect() {
        //setting the connection to the databse[
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            //path to the local db
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/OnePiece",
                            "postgres", "postgres");

            System.out.println("Opened database successfully");
            
            //catching the error if db doesn;t connect
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return c;
}
}
