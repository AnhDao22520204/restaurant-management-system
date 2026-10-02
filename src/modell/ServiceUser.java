package modell;

import controler.ConnectionJDBC;
import modell.ModelLogin;
import modell.ModelUser;
import modell.ModelFogot;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ServiceUser {
    //private final Connection con;

    // Kết nối tới cơ sở dữ liệu       
    public ServiceUser() {   
    }
    
    public static String getRole(int userid)
    {
        String s=null;
        
         try {
            Connection con=ConnectionJDBC.connect();
            String sql="select Vaitro FROM NGUOIDUNG  where USERID=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,userid);

            ResultSet rs =st.executeQuery();
            if(!rs.next())
            {
                return null;
            }
            s=rs.getString(1);
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
        
    }
    
    
    public static int getMANV(int userid)
    {
        int  s=0;
        
         try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MANV FROM NhanVien  where MAND=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,userid);

            ResultSet rs =st.executeQuery();
             if(rs.next())
            {
                  s=rs.getInt(1);
            }
            
          
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
        
    }
    
    
   

    // Sign Up
    /*
        Phần đăng ký chỉ dành cho nhân viên, sau khi đăng ký thành công:
        Thêm thông tin Người dùng gồm Họ tên, mật khẩu, email, SDT, Vai trò mặc định là 'Nhân viên' xuống bảng NguoiDung.
    */
    public void insertUser(ModelUser user) throws SQLException {
     Connection conn=ConnectionJDBC.connect();
        // Lấy ID của User tiếp theo
        PreparedStatement p1 = conn.prepareStatement("SELECT MAX(UserID) as UserID FROM NguoiDung");
        ResultSet r = p1.executeQuery();
        if (r.next()) {
            int userID = r.getInt("UserID") + 1;

            // Thêm Người Dùng
            String sql_ND = "INSERT INTO NguoiDung (UserID, HoTen, MatKhau, Email, SDT, Vaitro) VALUES (?,?,?,?,?,'Nhân viên')";
            PreparedStatement p = conn.prepareStatement(sql_ND);
            p.setInt(1, userID);
            p.setString(2, user.getHoTen());
            p.setString(3, user.getMatKhau());
            p.setString(4, user.getEmail());
            p.setString(5, user.getSDT());
            p.execute();

            r.close();
            p.close();
            p1.close();

            user.setUserID(userID);
            user.setVaiTro("Nhân viên");
        } else {
            throw new SQLException("Không thể lấy UserID tiếp theo.");
        }
        
        conn.close();
    }
    
    
    
    
    //Login
    /*
        Kiểm tra thông tin đăng nhập
        Trả về : null <- Nếu Thông tin đăng nhập sai
                 ModelNguoiDung <- Nếu thông tin đăng nhập đúng
    */
    public ModelUser login(ModelLogin login) throws SQLException{
        Connection conn=ConnectionJDBC.connect();
        ModelUser user=null;
        String sql = "SELECT * FROM NguoiDung WHERE Email=? AND Matkhau=? FETCH FIRST 1 ROWS ONLY";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setString(1, login.getEmail());
        p.setString(2, login.getPassword());
        ResultSet r = p.executeQuery();
        if(r.next()){
            int userID = r.getInt("userID");
            String HoTen = r.getString("HoTen");
            String MatKhau = r.getString("Matkhau");
            String email = r.getString("Email");
            String SDT = r.getString("SDT");
            String VaiTro = r.getString("Vaitro");
            user = new ModelUser(userID, HoTen, MatKhau, email, SDT, VaiTro);
        }
        r.close();
        p.close();
        conn.close();
        return user;
    }
    
    
    
    //Forgot password
    // Kiểm tra Email đã tồn tại trong hệ thống hay chưa
    public boolean checkEmailExists(String email) throws SQLException {
        Connection conn=ConnectionJDBC.connect();
        String sql = "SELECT COUNT(*) AS count FROM NguoiDung WHERE Email = ?";
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setString(1, email);
            try (ResultSet r = p.executeQuery()) {
                if (r.next() && r.getInt("count") > 0) {
                    conn.close();
                    return true;
                }
            }
        }
        conn.close();
        return false;
    }

    // Lưu mã xác minh vào cơ sở dữ liệu
    public void saveVerifyCode(String email, int verifyCode) throws SQLException {
        Connection conn=ConnectionJDBC.connect();
        String sql = "UPDATE NguoiDung SET VerifyCode = ? WHERE Email = ?";
        PreparedStatement p = conn.prepareStatement(sql);
        p.setInt(1, verifyCode);
        p.setString(2, email);
        p.execute();
        p.close();
        conn.close();
    }

    // Kiểm tra mã xác minh của người dùng nhập vào
    public boolean verifyCodeWithUser(int userID, String verifyCode) throws SQLException {
        boolean verify = false;
        Connection conn=ConnectionJDBC.connect();
        String sql = "SELECT COUNT(UserID) as CountID FROM NguoiDung WHERE UserID = ? AND VerifyCode = ?";
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setInt(1, userID);
            p.setString(2, verifyCode);
            try (ResultSet r = p.executeQuery()) {
                if (r.next() && r.getInt("CountID") > 0) {
                    verify = true;
                }
            }
        }
        conn.close();
        return verify;
    }
    
    // Lấy userID tù email
    public int getUserIdByEmail(String email) throws SQLException {
        Connection conn=ConnectionJDBC.connect();
        int userID = -1;
        String sql = "SELECT UserID FROM NguoiDung WHERE Email = ? FETCH FIRST 1 ROWS ONLY";
        try (PreparedStatement p = conn.prepareStatement(sql)) {
            p.setString(1, email);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    userID = r.getInt("UserID");
                }
            }
        }
        conn.close();
        return userID;
    }

    //Thay đổi mật khẩu tài khoản
    public void changePassword(int userID, String newPass) throws SQLException{
        Connection conn=ConnectionJDBC.connect();
        String sql="UPDATE NguoiDung SET MatKhau = ? WHERE UserID = ?";
        PreparedStatement p=conn.prepareStatement(sql);
        p.setString(1, newPass);
        p.setInt(2, userID);
        p.execute();
        p.close();
        conn.close();
    }
}
