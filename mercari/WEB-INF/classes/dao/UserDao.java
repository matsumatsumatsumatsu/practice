package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import tera.User;

public class UserDao implements UsersDao{
	public void addUser(User p) {
        Connection cn = null;
        PreparedStatement st = null;
         ResultSet rs = null;
         String user_id ;
        System.out.println("MySQLProducts    です");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST",
                "info", "pro");
            //  Class.forName("oracle.jdbc.driver.OracleDriver");
            //  cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
               cn.setAutoCommit(false);
        
            
            String sql = "insert into user(user_name,real_name,address,tel,mail,profile,point) " + "values(?,?,?,?,?,?,?)";
            st = cn.prepareStatement(sql);
            
            st.setString(1, p.getUser_name());
            st.setString(2, p.getReal_name());
            st.setString(3, p.getAddress());
            st.setString(4, p.getTell());
            st.setString(5, p.getMail());
            st.setString(6, p.getProfile());
            st.setString(7, p.getPoint());

            st.executeUpdate();
            cn.commit();
        } catch (Exception e) {
            e.printStackTrace();
                        try {
                cn.rollback();
            } catch (Exception ex) {
                //TODO: handle exception
            }

        } finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception e) {

            } finally {
                try {
                    if (cn != null) {
                        cn.close();
                    }
                } catch (Exception e) {

                }
            }
        }

    }
    public User getUser(String user_id) {
        return null;
    }
    public List getAllProducts() {
        System.out.print("getAllProducts");
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList users =new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST",
                "info", "pro");
            //  Class.forName("oracle.jdbc.driver.OracleDriver");
            //  cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","info","pro");
            cn.setAutoCommit(false);
            String sql = "select user_id,user_name,real_name,address,tel,mail,profile,point from user";
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                User p = new User();
                p.setUser_id(rs.getString(1));
                p.setUser_name(rs.getString(2));
                p.setReal_name(rs.getString(3));
                p.setAddress(rs.getString(4));
                p.setTell(rs.getString(5));
                p.setMail(rs.getString(6));
                p.setProfile(rs.getString(7));
                p.setPoint(rs.getString(8));
                users.add(p);
            }
            cn.commit();



        } catch (Exception e) {
             e.printStackTrace();
            try {
                if (st != null) {
                    st.close();
                }
            } catch (Exception ex) {

            } finally {
                try {
                    if (cn != null) {
                        cn.close();
                    }
                } catch (Exception ex) {

                }
            }

        }
        return users;
    }

}