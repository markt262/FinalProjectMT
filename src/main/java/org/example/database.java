//test merge1
package org.example;
import java.sql.*;


public class database {

    public void addUser( String a,String b, String c, String d, String e){

        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);


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
            //conn.close();
        } catch (Exception f) {
            System.err.println("Got an exception!");
            System.err.println(f.getMessage());
        }

    }
    public void verifyUser (String u, String p) {
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);


            //create a statement object
            Statement statement = conn.createStatement();

            //execute the query
            ResultSet resultSet = statement.executeQuery("SELECT usernumber FROM user WHERE username LIKE '%marky%' AND password LIKE 'fh'");

            // retrieve the data from the ResultSet
            String result ="";
            if (resultSet.next()){
                result = resultSet.getString("usernumber");
            }

            //  Close the Resultset, statement, and Connection objects
            resultSet.close();
            statement.close();
            conn.close();

            // use the result string
            System.out.println(result);
            if (result =="") {
                System.out.println("no match");

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
