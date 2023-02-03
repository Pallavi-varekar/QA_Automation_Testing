//****************
//Author Name : Pallavi Varekar
//Project     : Rest Automation JDBC
//Date        : 29/01/2023
//****************
package com.bridgelabz.db.db;

import java.sql.*;

public class DbAutomation {
    public static Connection con;
    public static Statement stmt;
    public static String dbUrl = "jdbc:mysql://localhost:3306/spotify_Api";
    public static String username = "root";
     public static String password = "root@123";
     static ResultSet result;

    public static  void main(String[] args)throws SQLException {

        con = DriverManager.getConnection(dbUrl, username, password);
        stmt = con.createStatement();
        System.out.println("stmt : " + stmt);
        System.out.println("con : " + con);
        printData();

        PreparedStatement preparedStatement = con.prepareStatement("insert into user values" + "(?,?,?)");
        preparedStatement.setInt(1,4);
        preparedStatement.setString(2,"pallavi");
        preparedStatement.setString(3,"pallavi@gmail.com");
        preparedStatement.executeUpdate();
                con.close();
    }
        public static void printData () throws SQLException {
            result = stmt.executeQuery("select * from user");
            while (result.next()) {
                String userId = result.getString(1);
                String userName = result.getString("userName");
                String userEmail = result.getString("userEmail");
                System.out.println(userId + " " + userName + " " + userEmail);


            }
        }
    }