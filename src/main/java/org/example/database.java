package org.example;
import java.sql.*;
import com.mysql.jdbc.Driver;


public class database {

    public void addUser(){
        Statement stmt = null;
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);

            // Insert data into the database
            stmt = (Statement) conn.createStatement();
            String query = "INSERT INTO user (1stname, 2ndname, password, dob) VALUES ('Mark','Thompson','apple','1972-01-01')";
            stmt.executeUpdate(query);


            // Close the connection version4
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }




    }




}
