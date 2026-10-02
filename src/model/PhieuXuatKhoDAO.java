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





public class PhieuXuatKhoDAO {
    
 public static int insert(PhieuXuatKho pxk)
    {

          int count=0;

        try {
            Connection con=ConnectionJDBC.connect();
            String sql="INSERT INTO PHIEUXUATKHO ( MANL , MANV , NGAYXUAT, SOLUONGXUAT, GIAXUAT )  VALUES (?,?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            //st.setInt(1, pxk.getMAXK());
            st.setInt(1, pxk.getMANL());
            st.setInt(2, pxk.getMANV());
            st.setDate(3,pxk.getNGAYXUAT());
            st.setInt(4,pxk.getSOLUONGXUAT());
            st.setInt(5,pxk.getGIAXUAT());
            count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }








    public static int delete(PhieuXuatKho pxk)
    {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete PHIEUXUATKHO where MAXK=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, pxk.getMAXK());
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public static int delete(int pxk)
    {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete PHIEUXUATKHO where MAXK=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, pxk);
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }


    

   public static ArrayList<PhieuXuatKho> selectALL()
    {
        ArrayList<PhieuXuatKho> list=new ArrayList<PhieuXuatKho>();
        PhieuXuatKho nl=new PhieuXuatKho(); 

        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from PHIEUXUATKHO ";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
                nl= new PhieuXuatKho(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4), rs.getInt(5),rs.getInt(6));
                list.add(nl);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
}

   
   
   
   
      public static ArrayList<PhieuXuatKho> selectMANL(int maNL)
    {
        ArrayList<PhieuXuatKho> list=new ArrayList<PhieuXuatKho>();
        PhieuXuatKho nl=new PhieuXuatKho(); 

        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from PHIEUXUATKHO where MANL=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, maNL);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
                nl= new PhieuXuatKho(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDate(4), rs.getInt(5),rs.getInt(6));
                list.add(nl);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
}

   
   
   
   
public static int checkMAXK(PhieuXuatKho pxk)
{
    int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MAXK FROM PHIEUXUATKHO  where MAXK=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,pxk.getMAXK());
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

}


public static int checkMAXK(int nl)
{
    int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MAXK FROM PHIEUXUATKHO  where MAXK=?";
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
