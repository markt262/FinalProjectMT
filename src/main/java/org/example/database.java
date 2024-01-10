//test merge1
package org.example;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

        String Q = ("SELECT usernumber FROM user WHERE username LIKE '" + u + "' AND password LIKE '" + p + "'");
        System.out.println(Q);
        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);


            //create a statement object
            Statement statement = conn.createStatement();

            //execute the query
            ResultSet resultSet = statement.executeQuery(Q);//"SELECT usernumber FROM user WHERE username LIKE 'davey' AND password LIKE 'passdave'");

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


    public void addAccount(int balance, String accountType) {
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
            preparedStmt.setString(2, accountType);


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
            if (resultSet.next()) {
                accountnumbertransfer = resultSet.getString("accountNumber");
            }
            MenuScreen welcomeUser = new MenuScreen();
            welcomeUser.transferAccountNumber(accountnumbertransfer);

            //  Close the Resultset, statement, and Connection objects
            resultSet.close();
            statement.close();
            conn.close();


        } catch (SQLException e) {
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


            preparedStmt.setString(1, x);
            preparedStmt.setString(2, y);


            // execute the preparedstatement
            preparedStmt.execute();

            // Close the connection version7
            //conn.close();
        } catch (Exception f) {
            System.err.println("Got an exception!");
            System.err.println(f.getMessage());
        }


    }


    public void viewAllAccounts(int intUserNumber) {


        //System.out.println(userIDretainer);

        try {
            // Connect to the database
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);

            String query6 = "SELECT account.`accountnumber`, account.accountType,account.balance\n" +
                    "FROM `user`\n" +
                    "INNER JOIN (account\n" +
                    "INNER JOIN useraccount ON account.`accountnumber` = useraccount.`accountnumber`)\n" +
                    "ON `user`.`usernumber` = useraccount.`usernumber`\n" +
                    "WHERE (((`user`.`usernumber`)=" + intUserNumber + "));\n";


            // create a statement object
            Statement statement = conn.createStatement();

            //execute the query
            ResultSet resultSet = statement.executeQuery(query6);
                    /*("SELECT account.`accountnumber`, account.accountType,account.balance\n" +
                    "FROM `user`\n" +
                    "INNER JOIN (account\n" +
                    "INNER JOIN useraccount ON account.`accountnumber` = useraccount.`accountnumber`)\n" +
                    "ON `user`.`usernumber` = useraccount.`usernumber`\n" +
                    "WHERE (((`user`.`usernumber`)=1));\n"));*/

            //create a table model
            DefaultTableModel model = new DefaultTableModel();
            JTable table = new JTable(model);

            //add column names to the table model
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            //add rows to the table model
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);

                }
                model.addRow(row);
            }
            // add table to a JScroolPane and display it

            ViewMyAccounts allAccount = new ViewMyAccounts();
            allAccount.returnTable(table);


            //  Close the Resultset, statement, and Connection objects
            //  resultSet.close();
            // statement.close();
            // conn.close();

           JComboBox<String> comboBox1 = new JComboBox<>();
            try {
                // String url = "jdbc:mysql://localhost:3306/projectdatabase";
                // String user = "root";
                // String password = "LT0k41JCeam5";
                //  Connection conn = DriverManager.getConnection(url, user, password);
                DefaultComboBoxModel myModel = new DefaultComboBoxModel();
                PreparedStatement statement1 = conn.prepareStatement("SELECT account.`accountnumber`,account.accountType,account.balance\n" +
                        "FROM `user`\n" +
                        "INNER JOIN (account\n" +
                        "INNER JOIN useraccount ON account.`accountnumber` = useraccount.`accountnumber`)\n" +
                        "ON `user`.`usernumber` = useraccount.`usernumber`\n" +
                        "WHERE (((`user`.`usernumber`)=" + intUserNumber + "));\n");
                ResultSet resultSet1 = statement1.executeQuery();
                while (resultSet1.next()) {
                   // comboBox1.addItem(resultSet1.getString("accountnumber"));
                    String column= resultSet1.getString("accountNumber");
                    myModel.addElement(column);


                }

                //ViewMyAccounts allAccount = new ViewMyAccounts();
                allAccount.returnAccountNumber(myModel);
                

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}




        /*JComboBox<String> comboBox1 = new JComboBox<>();
        try {
            String url = "jdbc:mysql://localhost:3306/projectdatabase";
            String user = "root";
            String password = "LT0k41JCeam5";
            Connection conn = DriverManager.getConnection(url, user, password);

            PreparedStatement statement = conn.prepareStatement("SELECT account.`accountnumber`,account.accountType,account.balance\n" +
                    "FROM `user`\n" +
                    "INNER JOIN (account\n" +
                    "INNER JOIN useraccount ON account.`accountnumber` = useraccount.`accountnumber`)\n" +
                    "ON `user`.`usernumber` = useraccount.`usernumber`\n" +
                    "WHERE (((`user`.`usernumber`)="+intUserNumber+"));\n");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                comboBox1.addItem(resultSet.getString("accountnumber"));


            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ViewMyAccounts allAccount = new ViewMyAccounts();
        allAccount.returnAccountNumber(comboBox1);



    }
    }*/
