package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;

public class UserDao implements UserInterfaceDao{
	public void addUser(User u) {
        Connection cn = null;
        PreparedStatement st = null;
         ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST","kirisuto", "zabieru");
               cn.setAutoCommit(false);

            String sql = "insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) " + "values(?,?,?,?,?,?,?,?)";

            st = cn.prepareStatement(sql);

            st.setString(1, u.getUserName());
            st.setString(2, u.getUserPassword());
            st.setString(3, u.getRealName());
            st.setString(4, u.getAddress());
            st.setString(5, u.getTel());
            st.setString(6, u.getMail());
            st.setString(7, u.getProfile());
            st.setString(8, u.getPoint());

            st.executeUpdate();
            cn.commit();
        }catch(ClassNotFoundException e) {
        	throw new RuntimeException();
        }

        catch (SQLException e) {
            e.printStackTrace();
                        try {
                cn.rollback();
            } catch (SQLException ex) {
                //TODO: handle exception
            }

        }finally {
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException e) {

            } finally {
                try {
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException e) {

                }
            }
        }

    }
    public List getAllUsers() {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList users =new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST","kirisuto", "zabieru");
            cn.setAutoCommit(false);
            String sql = "select user_id,user_name,user_password,real_name,address,tel,mail,profile,point from user";
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                User u = new User();
                u.setUserId(rs.getString(1));
                u.setUserName(rs.getString(2));
                u.setUserPassword(rs.getString(3));
                u.setRealName(rs.getString(4));
                u.setAddress(rs.getString(5));
                u.setTel(rs.getString(6));
                u.setMail(rs.getString(7));
                u.setProfile(rs.getString(8));
                u.setPoint(rs.getString(9));
                users.add(u);
            }
            cn.commit();



        }catch(ClassNotFoundException e) {
        	throw new RuntimeException();
        }catch (SQLException e) {
             e.printStackTrace();
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {

            } finally {
                try {
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException ex) {

                }
            }

        }
        return users;
    }

}