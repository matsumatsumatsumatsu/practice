package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;

public class ItemDao implements ItemInterfaceDao {

	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public void listing(Item item) {
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST","kirisuto", "zabieru");
        	cn.setAutoCommit(false);

        	String sql = "insert into item(item_name, price, item_image, item_explanation, hardware_id, category_id, seller_id, listing_date, term) values(?,?,?,?,?,?,?,cast( now() as datetime),?)";
        	st = cn.prepareStatement(sql);

        	st.setString(1, item.getItemName());
        	st.setInt(2, item.getPrice());
        	st.setString(3, item.getItemImage());
        	st.setString(4, item.getItemExplanation());
        	st.setString(5, item.getHardwareId());
        	st.setString(6, item.getCategoryId());
        	st.setString(7, item.getSellerId());
        	st.setInt(8, item.getTerm());

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

	public Item getItem(String itemId) {
        Item i = new Item();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST","kirisuto", "zabieru");
            cn.setAutoCommit(false);
            String sql = "select * from item where item_name = ?";
            st = cn.prepareStatement(sql);
            st.setString(1, itemId);
            rs = st.executeQuery();

            while (rs.next()) {
                i.setItemId(rs.getString(1));
                i.setItemName(rs.getString(2));
                i.setPrice(rs.getInt(3));
                i.setItemImage(rs.getString(4));
                i.setItemExplanation(rs.getString(5));
                i.setHardwareId(rs.getString(6));
                i.setCategoryId(rs.getString(7));
                i.setSellerId(rs.getString(8));
                i.setTerm(rs.getInt(9));
                i.setStock(rs.getInt(10));
                i.setListingDate(rs.getInt(11));
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
            	e.printStackTrace();
            } finally {
                try {
                    if (cn != null) {
                        cn.close();
                    }
                } catch (SQLException ex) {
                	e.printStackTrace();
                }
            }

        }
        return i;
    }

	 public List getAllItems() {
	        ArrayList items =new ArrayList();
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	             cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST","kirisuto", "zabieru");
	            cn.setAutoCommit(false);
	            String sql = "select item_id,item_name,price,item_image,item_explanation from item";
	            st = cn.prepareStatement(sql);
	            rs = st.executeQuery();

	            while (rs.next()) {
	                Item i = new Item();
	                i.setItemId(rs.getString(1));
	                i.setItemName(rs.getString(2));
	                i.setPrice(rs.getInt(3));
	                i.setItemImage(rs.getString(4));
	                i.setItemExplanation(rs.getString(5));

	                items.add(i);
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
	            	e.printStackTrace();
	            } finally {
	                try {
	                    if (cn != null) {
	                        cn.close();
	                    }
	                } catch (SQLException ex) {
	                	e.printStackTrace();
	                }
	            }
	        }
	        return items;
	    }
}
