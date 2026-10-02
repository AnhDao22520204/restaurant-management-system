/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connection URL
            String url = "jdbc:oracle:thin:@localhost:1521:orc"; // Replace 'xe' with your SID if different
            String username = "c##jj";
            String password = "jj";

            // Establish and return the connection
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}