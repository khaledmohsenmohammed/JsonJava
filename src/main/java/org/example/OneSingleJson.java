package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;

public class OneSingleJson {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        ArrayList<CustomerDetails> arrayListCustomerDetails = new ArrayList<CustomerDetails>();

        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Dynamically get the project directory path
        String projectPath = Paths.get("").toAbsolutePath().toString();

        // Correct JDBC URL
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business?useSSL=false", "root", "toor");

        // Object of Statement class will help to execute queries
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM CustomerInfo WHERE Location = 'Asia' AND PurchasedDate = '2024-09-13';");

        JSONArray jsonArray = new JSONArray();

        // Processing the ResultSet
        while (rs.next()) {
            CustomerDetails customerDetails = new CustomerDetails(); // Object from class Customer and set the data returned from the DB

            // Assuming the first column is a String
            customerDetails.setCustomerName(rs.getString(1));
            // Assuming the second column is a String
            customerDetails.setPurchasedData(rs.getString(2));
            // Assuming the third column is an int
            customerDetails.setAmount(rs.getInt(3));
            // Assuming the fourth column is a String
            customerDetails.setLocation(rs.getString(4));
            arrayListCustomerDetails.add(customerDetails);

            // Create JSON string from Java object using Gson and add it to the JSONArray
            Gson gson = new Gson();
            String jsonString = gson.toJson(customerDetails);
            jsonArray.add(jsonString);
        }
        // Create the final JSON object to hold the array
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data", jsonArray);
        System.out.println(jsonObject.toJSONString());
        String unEscapeJSONObjData =  StringEscapeUtils.unescapeJava(jsonObject.toJSONString()); //to remove the \\ in the json and save it in the file
        System.out.println(unEscapeJSONObjData);
        //to replace the "{ to the { only
        String editString = unEscapeJSONObjData.replace("\"{","{");//to replace the "{ to the { only
        String FinalJsonString =editString.replace("}\"" , "}");
        System.out.println(FinalJsonString);

        // Write the final JSON object to a file
        File file = new File(projectPath + "/oneSingleJson.json");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(FinalJsonString);
        }
        System.out.println("JSON file created successfully: " + file.getAbsolutePath());

        // Close the connection
        conn.close();
    }
}
