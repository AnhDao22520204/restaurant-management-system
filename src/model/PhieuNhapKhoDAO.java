/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84889
 */
import controler.ConnectionJDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class PhieuNhapKhoDAO {
   
 public static int insert(PhieuNhapKho pnk)
    {

          int count=0;

        try {
            Connection con=ConnectionJDBC.connect();
             
            String sql="INSERT INTO PHIEUNHAPKHO ( MANL , MANV , NGAYNHAP, SOLUONGNHAP, GIANHAP )  VALUES (?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
             
          //  st.setInt(1, pnk.getMANK());
            st.setInt(1, pnk.getMANL());
            st.setInt(2, pnk.getMANV());
              java.util.Date utilDate = pnk.getNGAYNHAP(); // Giả sử getNGAYNHAP trả về java.util.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            st.setDate(3,sqlDate);
            st.setInt(4,pnk.getSOLUONGNHAP());
            st.setInt(5,pnk.getGIANHAP());
             
            count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return count;
    }

    public static int delete(PhieuNhapKho pnk)
    {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete PHIEUNHAPKHO where MANk=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, pnk.getMANK());
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static int delete(int pnk)
    {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete PHIEUNHAPKHO where MANK=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, pnk);
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    

   public static ArrayList<PhieuNhapKho> selectALL()
    {
        ArrayList<PhieuNhapKho> list=new ArrayList<PhieuNhapKho>();
        PhieuNhapKho nl=new PhieuNhapKho(); 

        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from PHIEUNHAPKHO ";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
                nl= new PhieuNhapKho(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4), rs.getInt(5),rs.getInt(6));
                list.add(nl);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
}

   
   
   public static ArrayList<PhieuNhapKho> selectMANL(int maNL)
    {
        ArrayList<PhieuNhapKho> list=new ArrayList<PhieuNhapKho>();
        PhieuNhapKho nl=new PhieuNhapKho(); 

        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from PHIEUNHAPKHO where MANL=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, maNL);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
                nl= new PhieuNhapKho(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4), rs.getInt(5),rs.getInt(6));
                list.add(nl);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
}

   
   
   
   
   
   
   
   
public static int checkMANK(PhieuNhapKho pnk)
{
    int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MANK FROM PHIEUNHAPKHO  where MANK=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,pnk.getMANK());
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

}


public static int checkMANK(int nl)
{
    int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MANK FROM PHIEUNHAPKHO  where MANK=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,nl);
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
}
}
