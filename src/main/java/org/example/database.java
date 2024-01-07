//test merge1
package org.example;
import java.sql.*;




public class database {

    public void addUser(String a, String b, String c, String d, String e) {

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

    public void verifyUser(String u, String p) {
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);


            //create a statement object
            Statement statement = conn.createStatement();

            //execute the query
            ResultSet resultSet = statement.executeQuery("SELECT usernumber FROM user WHERE username LIKE 'marky' AND password LIKE 'passmark'");

            // retrieve the data from the ResultSet
            String transferUserNo = "";
            if (resultSet.next()) {
                transferUserNo = resultSet.getString("usernumber");
            }

            //  Close the Resultset, statement, and Connection objects
            resultSet.close();
            statement.close();
            conn.close();

            // Transfer usernumber from user table to menuscreen label and to use in creating userAccount table
            if (transferUserNo == "") {
                System.out.println("no match");
            } else {
                System.out.println("Your username and password match");
                MenuScreen welcomeUser = new MenuScreen();
                welcomeUser.welcome(transferUserNo);
              welcomeUser.transferUserNumber(transferUserNo);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void addAccount(int balance, String business) {
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);


            // the mysql insert statement
            String query1 = " insert into account (balance, accountType)"
                    + " values (?, ?)";


            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query1);


            preparedStmt.setInt(1, balance);
            preparedStmt.setString(2, business);


            // execute the preparedstatement
            preparedStmt.execute();

            // Close the connection version7
            //conn.close();
        } catch (Exception f) {
            System.err.println("Got an exception!");
            System.err.println(f.getMessage());
        }
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);


            // create a statement object
            Statement statement = conn.createStatement();

            //execute the query
            ResultSet resultSet = statement.executeQuery("SELECT accountNumber FROM account ORDER BY accountNumber DESC LIMIT 1;");

            //retrieve the  data from the resultset
            String accountnumbertransfer = "";
            if (resultSet.next()){
                accountnumbertransfer = resultSet.getString("accountNumber");
            }
            MenuScreen welcomeUser = new MenuScreen();
            welcomeUser.transferAccountNumber(accountnumbertransfer);

            //  Close the Resultset, statement, and Connection objects
            resultSet.close();
            statement.close();
            conn.close();




        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void addUserAccount(String x, String y) {
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);


            // the mysql insert statement
            String query5 = " insert into useraccount (usernumber, accountnumber)"
                    + " values (?, ?)";


            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(query5);


            preparedStmt.setString(1,x);
            preparedStmt.setString(2,y);


            // execute the preparedstatement
            preparedStmt.execute();

            // Close the connection version7
            //conn.close();
        } catch (Exception f) {
            System.err.println("Got an exception!");
            System.err.println(f.getMessage());
        }



    }

    public void accountNumber() {
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);


            // create a statement object
            Statement statement = conn.createStatement();

            //execute the query
            ResultSet resultSet = statement.executeQuery("SELECT accountNumber FROM account ORDER BY accountNumber DESC LIMIT 1;");

            //retrieve the  data from the resultset
            String accountnumbertransfer = "";
           if (resultSet.next()){
            accountnumbertransfer = resultSet.getString("accountNumber");
           }
           MenuScreen welcomeUser = new MenuScreen();
            welcomeUser.transferAccountNumber(accountnumbertransfer);

            //  Close the Resultset, statement, and Connection objects
            resultSet.close();
            statement.close();
            conn.close();




        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
