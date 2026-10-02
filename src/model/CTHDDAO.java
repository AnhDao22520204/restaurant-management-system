package model;

import model.CTHD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import controler.DbOperations;


public class CTHDDAO {
    public static void createNewCTHD(int maMonAn, int soHD, int soLuong, int thanhTien) {
        String query = "INSERT INTO cthd(mamonan, sohd, soluong, thanhtien) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = DbOperations.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, maMonAn);
            statement.setInt(2, soHD);
            statement.setInt(3, soLuong);
            statement.setInt(4, thanhTien);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm chi tiết hóa đơn thành công");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static List<CTHD> getAllCTHDs() {
        List<CTHD> cthds = new ArrayList<>();
        String query = "SELECT * FROM cthd";
        try {
            Connection connection = DbOperations.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                CTHD cthd = new CTHD();
                cthd.setMaMonAn(rs.getInt("mamonan"));
                cthd.setSoHD(rs.getInt("sohd"));
                cthd.setSoLuong(rs.getInt("soluong"));
                cthd.setThanhTien(rs.getInt("thanhtien"));
                cthds.add(cthd);
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cthds;
    }

    public static void update(CTHD cthd) {
        String query = "UPDATE cthd SET soluong = ?, thanhtien = ? WHERE mamonan = ? AND sohd = ?";
        try {
            Connection connection = DbOperations.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, cthd.getSoLuong());
            statement.setInt(2, cthd.getThanhTien());
            statement.setInt(3, cthd.getMaMonAn());
            statement.setInt(4, cthd.getSoHD());
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cập nhật chi tiết hóa đơn thành công");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void delete(int maMonAn, int soHD) {
        String query = "DELETE FROM cthd WHERE mamonan = ? AND sohd = ?";
        try {
            Connection connection = DbOperations.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, maMonAn);
            statement.setInt(2, soHD);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Xóa chi tiết hóa đơn thành công");
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public static List<CTHD> getCTHDsBySoHD(int soHD) {
    List<CTHD> cthds = new ArrayList<>();
    String query = "SELECT * FROM cthd WHERE sohd = ?";
    try {
        Connection connection = DbOperations.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, soHD);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            CTHD cthd = new CTHD();
            cthd.setMaMonAn(rs.getInt("mamonan"));
            cthd.setSoHD(rs.getInt("sohd"));
            cthd.setSoLuong(rs.getInt("soluong"));
            cthd.setThanhTien(rs.getInt("thanhtien"));
            cthds.add(cthd);
        }
        connection.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
    return cthds;
}
    
     public static int getGiaMonAn(int maMonAn) {
    int giaMonAn = 0;
    String query = "SELECT GIA FROM MONAN WHERE MAMONAN = ?";
    try (Connection con = DbOperations.getConnection();
         PreparedStatement stmt = con.prepareStatement(query)) {
        stmt.setInt(1, maMonAn);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                giaMonAn = rs.getInt("GIA");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return giaMonAn;
}
     public static List<String> getAllMaMonAn() {
        List<String> maMonAnList = new ArrayList<>();
        
        String sql = "SELECT MaMonAn FROM MonAn";
        
        try (
            Connection con = DbOperations.getConnection();
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
        ) {
            while (rs.next()) {
                String maMonAn = rs.getString("MaMonAn");
                maMonAnList.add(maMonAn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return maMonAnList;
    }
     
}