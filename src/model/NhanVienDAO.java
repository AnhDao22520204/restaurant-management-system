/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import controler.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class NhanVienDAO {



    
 public static int delete(NhanVien nhanvien) {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete NHANVIEN where MANV=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, nhanvien.getMANV());
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static int delete(int MANV) {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete NHANVIEN where MANV=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, MANV);
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int update( NhanVien nhanvien) {
         
        
        int count=0;
       try {
           Connection con=ConnectionJDBC.connect();
           String sql = " update NHANVIEN set NGQL=?, HOTEN=?, NGSINH=?, NGVL=?, SODT=? where MANV=? ";
           
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, nhanvien.getNGQL());
            st.setString(2, nhanvien.getHOTEN());
            st.setDate(3, nhanvien.getNGSINH());
            st.setDate(4, nhanvien.getNGVL());
            st.setString(5,nhanvien.getSODT());
            st.setInt(6, nhanvien.getMANV());
         
            count =st.executeUpdate();  
           ConnectionJDBC.closeconect(con);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return count;
       
    }

    public static int insert( NhanVien nhanvien) {
        
        
        int count=0;
       
        try {
           if(nhanvien.getNGQL()!=0)
           {
            Connection con=ConnectionJDBC.connect();
            String sql="insert into NHANVIEN(NGQL,hoten,NGSINH,NGVL,SODT) values(?,?,?,?,?) ";

            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, nhanvien.getNGQL());
            //st.setInt(2, nhanvien.getMAND());
            st.setString(2, nhanvien.getHOTEN());
            st.setDate(3, nhanvien.getNGSINH());
            st.setDate(4,nhanvien.getNGVL());
            st.setString(5, nhanvien.getSODT());
          

             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
           }else
           {
               Connection con=ConnectionJDBC.connect();
            String sql="insert into NHANVIEN(hoten,NGSINH,NGVL,SODT) values(?,?,?,?) ";
            PreparedStatement st=con.prepareStatement(sql);
            //st.setInt(1, nhanvien.getNGQL());
            //st.setInt(2, nhanvien.getMAND());
            st.setString(1, nhanvien.getHOTEN());
            st.setDate(2, nhanvien.getNGSINH());
            st.setDate(3,nhanvien.getNGVL());
            st.setString(4, nhanvien.getSODT());

             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
           }
            
            

            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
   }
   
    
  
    public static ArrayList<NhanVien> findAll() {
        ArrayList<NhanVien> list=new ArrayList<NhanVien>();
   NhanVien nhanvien=new NhanVien();

        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from NHANVIEN ";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
               nhanvien=new NhanVien(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getString(4),rs.getDate(5), rs.getDate(6), rs.getString(7));
               list.add(nhanvien);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 
    public static ArrayList<NhanVien> findCondition(String condition) {
        
        ArrayList<NhanVien> list=new ArrayList<NhanVien>();
      NhanVien nhanvien=new NhanVien();
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from NHANVIEN where ?;";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, condition);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
                nhanvien=new NhanVien(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getString(4),rs.getDate(5), rs.getDate(6), rs.getString(7));
               list.add(nhanvien);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    public static NhanVien findMa(String Ma) {
       NhanVien nhanvien=new NhanVien();
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from NHANVIEN where MANV= ? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, Ma);
            ResultSet rs =st.executeQuery();
            if(rs.next())
            {
            nhanvien=new NhanVien(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getString(4),rs.getDate(5), rs.getDate(6), rs.getString(7));
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanvien;
    }
    
    
    
public static int checkMANV(int maNV)
{
    int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MANV FROM NhanVien  where MANV=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,maNV);
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

}
    
}
