package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class JsonToJava {
    public static void main(String [] args) throws ClassNotFoundException, SQLException, IOException {
        ArrayList <CustomerDetails> arrayListCustomerDetails =  new ArrayList<CustomerDetails>() ;

        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Dynamically get the project directory path
        String projectPath = Paths.get("").toAbsolutePath().toString();

        // Correct JDBC URL: "jdbc:mysql://" instead of "jdbc.mysql://"
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "toor");

        // Object of Statement class will help to execute queries
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM CustomerInfo WHERE Location = 'Asia' AND PurchasedDate = '2024-09-13';");

        // Processing the ResultSet
        while (rs.next()) {
            CustomerDetails customerDetails = new CustomerDetails() ; //object from class Customer and set the data return from the DB

            //3 diff json file , need  3 diff java object
            // Assuming the first column is a String
            customerDetails.setCustomerName(rs.getString(1));
           // Assuming the second column is a String
            customerDetails.setPurchasedData(rs.getString(2));
            // Assuming the third column is an int
            customerDetails.setAmount(rs.getInt(3));
            // Assuming the fourth column is a String
            customerDetails.setLocation(rs.getString(4));
            arrayListCustomerDetails.add(customerDetails);
        }
        //create json file for each row in DB coming from Query
        for(int i = 0 ;i<arrayListCustomerDetails.size();i++){
            ObjectMapper objectMapper = new ObjectMapper() ;
            // Define the file path dynamically using the project path
            File file = new File(projectPath + "/customerInfo" + i + ".json");
            // Write the object to the file
            objectMapper.writeValue(file, arrayListCustomerDetails.get(i));
        }

        // Close the connection
        conn.close();

    }
}
