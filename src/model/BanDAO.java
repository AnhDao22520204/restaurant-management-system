 package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controler.ConnectionJDBC;

public class BanDAO {
 //----------implement-------------
    public static int delete(Ban ban) {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete BAN where MABAN=?;";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, ban.getMaBan());
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
 //----------implement-------------
    public static int delete(int ban) {
        int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="delete BAN where MABAN=? ";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, ban);
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int insert( Ban ban) {
         int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="INSERT INTO BAN (TENBAN, VITRI)"
            +"VALUES (?, ?)";
            PreparedStatement st=con.prepareStatement(sql);
            st.setString(1, ban.getTenBan());
            st.setString(2, ban.getViTri());
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
  
    public static int update( Ban ban) {
        int count=0;
       try {
           Connection con=ConnectionJDBC.connect();
           String sql="UPDATE BAN "
           +"SET TENBAN = ?, VITRI=?"
           +"WHERE MABAN=?";
           PreparedStatement st=con.prepareStatement(sql);
           st.setString(1, ban.getTenBan());
            st.setString(2, ban.getViTri());
           
            st.setInt(3, ban.getMaBan());
            count =st.executeUpdate();  
           ConnectionJDBC.closeconect(con);
       } catch (SQLException e) {
           e.printStackTrace();
       }
       return count;
   }
   

   public static int updateTTMo( int ban) {
    int count=0;
   try {
       Connection con=ConnectionJDBC.connect();
       String sql="UPDATE BAN "
       +"Set TRANGTHAI= 'dang phuc vu'"
       +"WHERE MABAN=?";
       PreparedStatement st=con.prepareStatement(sql);

        st.setInt(1, ban);
        count =st.executeUpdate();  
       ConnectionJDBC.closeconect(con);
   } catch (SQLException e) {
       e.printStackTrace();
   }
   return count;
}

public static int updateTTDong( int ban) {
    int count=0;
   try {
       Connection con=ConnectionJDBC.connect();
       String sql="UPDATE BAN "
       +"Set TRANGTHAI= 'khong phuc vu'"
       +"WHERE MABAN=?";
       PreparedStatement st=con.prepareStatement(sql);

        st.setInt(1, ban);
        count =st.executeUpdate();  
       ConnectionJDBC.closeconect(con);
   } catch (SQLException e) {
       e.printStackTrace();
   }
   return count;
}




    public static ArrayList<Ban> selectAll() {
        ArrayList<Ban> list=new ArrayList<Ban>();
        Ban ban=new Ban(); 


        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from BAN";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
                ban=new Ban(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
                list.add(ban);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
 
    public static ArrayList<Ban> findCondition(String condition) {
        
        ArrayList<Ban> list=new ArrayList<Ban>();
        Ban ban=new Ban(); 
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from BAN where "+condition+" ";
            PreparedStatement st=con.prepareStatement(sql);
            ResultSet rs =st.executeQuery();
            while(rs.next())
            {
                ban=new Ban(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
                list.add(ban);
            }
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
   
    public static Ban findMa(int Ma) {
        Ban ban=new Ban(); 
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select * from BAN where MABAN= ?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1, Ma);
            ResultSet rs =st.executeQuery();
            rs.next();
                ban=new Ban(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getString(4));
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ban;
    }
    
    
public static int checkMABAN(int maban)
{
    int count=0;
        try {
            Connection con=ConnectionJDBC.connect();
            String sql="select MABAN FROM BAN  where MABAN=?";
            PreparedStatement st=con.prepareStatement(sql);
            st.setInt(1,maban);
             count =st.executeUpdate();  
            ConnectionJDBC.closeconect(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;

}
    
}