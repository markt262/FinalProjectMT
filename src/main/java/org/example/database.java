//test merge1
package org.example;
import java.sql.*;


public class database {

    public void addUser( String a,String b, String c, String d, String e){
        Statement stmt = null;
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);

            // Insert data into the database
            stmt = (Statement) conn.createStatement();
           // String query = "INSERT INTO user (firstname, lastname, dob, username,password) VALUES ( '(a)','x','1980-01-01','x','x')";
           // stmt.executeUpdate(query);

            // the mysql insert statement
            String query1 = " insert into user (firstname, lastname, dob, username, password)"
                    + " values (?, ?, ?, ?, ?)";
            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query1);

            preparedStmt.setString(1, a);
            preparedStmt.setString(2, b);
            preparedStmt.setString(3, c);
            preparedStmt.setString(4, d);
            preparedStmt.setString(5, e);

            // execute the preparedstatement
            preparedStmt.execute();



            // Close the connection version7
            conn.close();
        } catch (Exception f) {
            System.err.println("Got an exception!");
            System.err.println(f.getMessage());
        }




    }




}
