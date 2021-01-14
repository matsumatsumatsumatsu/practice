package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Item;

public class ItemDao implements ItemInterfaceDao {
	public void listing(Item item) {
        Connection cn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST","kirisuto", "zabieru");
        	cn.setAutoCommit(false);

        	String sql = "insert into item(item_id, item_name, price, item_image, item_explanation, hardware_id, category_id, seller_id, listing_date, term) " + "values(?,?,?,?,?,?,?,?,cast ( now() as date),?)";
        	st = cn.prepareStatement(sql);

        	st.setInt(1, item.getItemId());
        	st.setString(2, item.getItemName());
        	st.setInt(3, item.getPrice());
        	st.setString(4, item.getItemImage());
        	st.setString(5, item.getItemExplanation());
        	st.setInt(6, item.getHardwareId());
        	st.setInt(7, item.getCategoryId());
        	st.setInt(8, item.getSellerId());
        	st.setInt(10, item.getTerm());

            st.executeUpdate();
            cn.commit();

        }catch(ClassNotFoundException e){
        	throw new RuntimeException();
		}catch (SQLException e) {
            e.printStackTrace();
            try {
            	cn.rollback();
            } catch (SQLException ex) {
            	//TODO: handle exception
            }

        } finally {
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
}
