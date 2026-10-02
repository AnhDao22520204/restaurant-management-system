/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

/**
 *
 * @author 84889
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionJDBC {
    // Thông tin kết nối Oraclejava.sql/java.sql.DriverManager.getConnection(DriverManager.java:702
    public static Connection connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Không thể tìm thấy driver JDBC của Oracle!");
            e.printStackTrace();
            return null;
        }
        // Thông tin kết nối
        //create user c##HQT identified by hqt;
        //grant connect, dba to c##HQT;
        String url = "jdbc:oracle:thin:@localhost:1521:orc";
        String username = "C##JJ";
        String password = "jj";
        // Thử kết nối và trả về đối tượng Connection
        //
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Kiem tra kết noi!");
            // Kiểm tra kết nối
    if (connection != null) {
        System.out.println("Kết nối thành công!");
    } else {
        System.out.println("Kết nối không thành công!");
    }
    return     connection;

     } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
            return null;
        }
    }
    
public static void closeconect(Connection connection)
{
        try {
            // Đóng kết nối sau khi sử dụng xong
            if (connection != null) {
                connection.close();
                System.out.println("Đã đóng kết nối đến cơ sở dữ liệu Oracle!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
}


    }
