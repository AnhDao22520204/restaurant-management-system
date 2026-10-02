/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 84889
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import controler.ConnectionJDBC;
public class NguyenLieuDAO {
    public static int insert(NguyenLieu nl)
    {

          int count=0;

        try {
            Connection con=ConnectionJDBC.connect();
           
            String sql="INSERT INTO NGUYENLIEU ( TENNL, SOLUONG, TONGGT, NHACUNGCAP)  VALUES (?,?,?,?)";
            PreparedStatement st=con.prepareStatement(sql);
            
            st.setString(1, nl.getTENNL());
            st.setInt(2, nl.getSOLUONG());
            st.setInt(3, nl.getTONGGT());
            st.setString(4,nl.getNHACUNGCAP());
           
            count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int delete(int manl)
    {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete NGUYENLIEU where MANL=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, manl);
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int update(NguyenLieu nl)
    { int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="UPDATE NGUYENLIEU "
            +" set TENNL=?, SOLUONG=?,TONGGT=?, NHACUNGCAP=? where MANL=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, nl.getTENNL());
            st.setInt(2, nl.getSOLUONG());
            st.setInt(3, nl.getTONGGT());
            st.setString(4, nl.getNHACUNGCAP());
            st.setInt(5,nl.getMANL());

             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

   public static ArrayList<NguyenLieu> selectALL()
    {
        ArrayList<NguyenLieu> list=new ArrayList<NguyenLieu>();
        NguyenLieu nl=new NguyenLieu(); 

        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from  NGUYENLIEU";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
                nl= new NguyenLieu(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4), rs.getString(5));
                list.add(nl);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
}

public static int checkMANL(NguyenLieu nl)
{
    int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MANL FROM NGUYENLIEU  where MANL=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,nl.getMANL());
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
}

public static int checkMANL(int nl)
{
    int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MANL FROM NGUYENLIEU  where MANL=?";
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
