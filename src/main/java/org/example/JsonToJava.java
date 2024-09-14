package org.example;

import java.sql.*;

public class JsonToJava {
    public static void main(String [] args) throws ClassNotFoundException, SQLException {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Correct JDBC URL: "jdbc:mysql://" instead of "jdbc.mysql://"
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "toor");

        // Object of Statement class will help to execute queries
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM CustomerInfo WHERE Location = 'Asia' AND PurchasedDate = '2024-09-13';");

        // Processing the ResultSet
        while (rs.next()) {
            System.out.println(rs.getString(1)); // Assuming the first column is a String
            System.out.println(rs.getString(2)); // Assuming the second column is a String
            System.out.println(rs.getInt(3));    // Assuming the third column is an int
            System.out.println(rs.getString(4)); // Assuming the fourth column is a String
        }
        // Close the connection
        conn.close();

    }
}