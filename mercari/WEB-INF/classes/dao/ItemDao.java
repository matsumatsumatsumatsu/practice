package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import exception.IntegrationException;
import util.MysqlConnector;

public class ItemDao implements ItemInterfaceDao {

	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public void listing(Item item) throws IntegrationException {
        try {
        	cn = MysqlConnector.getInstance().beginTransaction();

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
            MysqlConnector.getInstance().commit();

        }catch (SQLException e) {
            e.printStackTrace();
            MysqlConnector.getInstance().rollback();

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

	public List getItem(String key) throws IntegrationException {
		ArrayList items = new ArrayList();

        try {
        	cn = MysqlConnector.getInstance().beginTransaction();

			String sql = "select item_id, item_name, price, item_image, item_explanation, item.hardware_id, item.category_id, hardware.hardware, category.category, item.seller_id, stock, listing_date, term "
					+ " from item left join hardware on item.hardware_id = hardware.hardware_id "
					+ " left join category on item.category_id = category.category_id "
					+  key;
//            System.out.println("確認用SQL文:"+sql);

            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
            	Item i = new Item();
                i.setItemId(rs.getString(1));
                i.setItemName(rs.getString(2));
                i.setPrice(rs.getInt(3));
                i.setItemImage(rs.getString(4));
                i.setItemExplanation(rs.getString(5));
                i.setHardwareId(rs.getString(6));
                i.setCategoryId(rs.getString(7));
                i.setHardware(rs.getString(8));
                i.setCategory(rs.getString(9));
                i.setSellerId(rs.getString(10));
                i.setStock(rs.getInt(11));
                i.setListingDate(rs.getTimestamp(12));
                i.setTerm(rs.getInt(13));

//                Timestamp timestamp = rs.getTimestamp(10);
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//                String str = sdf.format(timestamp);
//                i.setListingDate(str);

                items.add(i);
            }
            System.out.println("DAOサイド：search結果："+items);

            MysqlConnector.getInstance().commit();
        }catch (SQLException e) {
             e.printStackTrace();
            try {
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
            	e.printStackTrace();
            } finally {
	            if (cn != null) {
	            	MysqlConnector.getInstance().closeConnection();
	            }
            }

        }
        return items;
    }

	 public List getAllItems() throws IntegrationException {
	        ArrayList items =new ArrayList();
	        try {
	        	cn = MysqlConnector.getInstance().beginTransaction();

	            String sql = "select item_id,item_name,price,item_image,item_explanation,stock from item";
	            st = cn.prepareStatement(sql);
	            rs = st.executeQuery();

	            while (rs.next()) {
	                Item i = new Item();
	                i.setItemId(rs.getString(1));
	                i.setItemName(rs.getString(2));
	                i.setPrice(rs.getInt(3));
	                i.setItemImage(rs.getString(4));
	                i.setItemExplanation(rs.getString(5));
	                i.setStock(rs.getInt(6));
	                items.add(i);
	            }
	            MysqlConnector.getInstance().commit();
	        }catch (SQLException e) {
	             e.printStackTrace();
	            try {
	                if (st != null) {
	                    st.close();
	                }
	            } catch (SQLException ex) {
	            	e.printStackTrace();
	            } finally {
                    if (cn != null) {
                    	MysqlConnector.getInstance().closeConnection();
                    }
	            }
	        }
	        return items;
	    }

	 public String getItemName(String itemId) throws IntegrationException {
		 String itemName= "";
		 try {
			 cn = MysqlConnector.getInstance().beginTransaction();
			 String sql = "select item_name from item where item_id = " + itemId;
			 System.out.println("確認用SQL文:"+sql);

			 st = cn.prepareStatement(sql);
			 rs = st.executeQuery();

			 //カーソルを使うので取るデータが一つでもwhile文を回したい
			 while (rs.next()) {
				 itemName = rs.getString(1);
			 }

			 MysqlConnector.getInstance().commit();
		 }catch (SQLException e) {
			 e.printStackTrace();
			 try {
				 if (st != null) {
					 st.close();
				 }
			 } catch (SQLException ex) {
				 e.printStackTrace();
			 } finally {
				 if (cn != null) {
					 MysqlConnector.getInstance().closeConnection();
				 }
			 }
		 }

		 return itemName;
	 }

	public String  getSellerId(String itemId) throws IntegrationException {
		 String sellerId = "";
		 try {
			 cn = MysqlConnector.getInstance().beginTransaction();
			 String sql = "select seller_id from item where item_id = " + itemId;
			 System.out.println("確認用SQL文:"+sql);

			 st = cn.prepareStatement(sql);
			 rs = st.executeQuery();

			 while (rs.next()) {
				 sellerId = rs.getString(1);
			 }

			 MysqlConnector.getInstance().commit();
		 }catch (SQLException e) {
			 e.printStackTrace();
			 try {
				 if (st != null) {
					 st.close();
				 }
			 } catch (SQLException ex) {
				 e.printStackTrace();
			 } finally {
				 if (cn != null) {
					 MysqlConnector.getInstance().closeConnection();
				 }
			 }
		 }
		 return sellerId;
	 }

	 public Item manageStock(String itemId) throws IntegrationException {
	        Item i = new Item();
	        try {
	        	cn = MysqlConnector.getInstance().beginTransaction();

	            String sql = "update item set stock = 0 where item_id = ?";
	            st = cn.prepareStatement(sql);
	            st.setString(1, itemId);
	            st.executeUpdate();
	            MysqlConnector.getInstance().commit();

	        }catch (SQLException e) {
	             e.printStackTrace();
	            try {
	                if (st != null) {
	                    st.close();
	                }
	            } catch (SQLException ex) {
	            	e.printStackTrace();
	            } finally {
                 if (cn != null) {
                 	MysqlConnector.getInstance().closeConnection();
                 }
	            }

	        }
	        return i;
	    }


	 public List search(String keyword) throws IntegrationException {
	        List items= new ArrayList();
		 	Item i = new Item();
	        try {
	        	cn = MysqlConnector.getInstance().beginTransaction();

	            String sql = "select * from item where item_name like '%?%'" + "";
	            st = cn.prepareStatement(sql);
	            st.setString(1, keyword);
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
	                i.setStock(rs.getInt(9));
	                i.setListingDate(rs.getTimestamp(10));
	                i.setTerm(rs.getInt(11));

//	                Timestamp timestamp = rs.getTimestamp(10);
//	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//	                String str = sdf.format(timestamp);
//	                i.setListingDate(str);

	                items.add(i);
	            }
	            MysqlConnector.getInstance().commit();
	        }catch (SQLException e) {
	             e.printStackTrace();
	            try {
	                if (st != null) {
	                    st.close();
	                }
	            } catch (SQLException ex) {
	            	e.printStackTrace();
	            } finally {
                    if (cn != null) {
                    	MysqlConnector.getInstance().closeConnection();
                    }
	            }

	        }
	        return items;
	    }

	 public void deleteItem(String itemid) throws IntegrationException{
		 try {
				cn = MysqlConnector.getInstance().beginTransaction();

				String sql1 = "SET FOREIGN_KEY_CHECKS = 0";
				String sql2 = "delete from item where item_id = ?";
				String sql3 = "SET FOREIGN_KEY_CHECKS = 1";

				st = cn.prepareStatement(sql1);
				st.executeUpdate();
				MysqlConnector.getInstance();
				st = cn.prepareStatement(sql2);
				st.setString(1, itemid);
				MysqlConnector.getInstance();
				st.executeUpdate();
				st = cn.prepareStatement(sql3);
				st.executeUpdate();
				MysqlConnector.getInstance().commit();
			}catch (SQLException e) {
				e.printStackTrace();
				try {
					if (st != null) {
						st.close();
					}
				} catch (SQLException ex) {
					e.printStackTrace();
				} finally {
					if (cn != null) {
						MysqlConnector.getInstance().closeConnection();
					}
				}
			}
	 }

	 public void updateItem(Item i,String id) throws IntegrationException {
			try {
				cn = MysqlConnector.getInstance().beginTransaction();

				String sql = "update item set item_name = ?, price = ?, item_explanation = ?, hardware_id = ?, category_id = ?, term = ? where item_id = "+id;
				st = cn.prepareStatement(sql);

				st.setString(1, i.getItemName());
	        	st.setInt(2, i.getPrice());
	        	st.setString(3, i.getItemExplanation());
	        	st.setString(4, i.getHardwareId());
	        	st.setString(5, i.getCategoryId());
	        	st.setInt(6, i.getTerm());

				st.executeUpdate();
				MysqlConnector.getInstance().commit();
			}catch (SQLException e) {
				e.printStackTrace();
				try {
					if (st != null) {
						st.close();
					}
				} catch (SQLException ex) {
					e.printStackTrace();
				} finally {
					if (cn != null) {
						MysqlConnector.getInstance().closeConnection();
					}
				}
			}
		}
}
