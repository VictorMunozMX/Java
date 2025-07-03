package org.example;
import java.sql.*;

public class ConnectDB {

    public void Users() {

        // connection with SQL server
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRUEBA;integratedSecurity=true;encrypt=true;trustServerCertificate=true";
        try {Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
