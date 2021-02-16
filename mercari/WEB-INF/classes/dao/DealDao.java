package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Deal;
import exception.IntegrationException;
import util.MysqlConnector;

public class DealDao implements DealInterfaceDao {
	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public void insertDeal() throws IntegrationException{
		try {
			cn = MysqlConnector.getInstance().getConnection();
        	String sql = "insert into item(item_name, price, item_image, item_explanation, hardware_id, category_id, seller_id, listing_date, term) values(?,?,?,?,?,?,?,cast( now() as datetime),?)";
        	st = cn.prepareStatement(sql);
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

	public List getDealInfo(String dealId) throws IntegrationException{
		ArrayList chat = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select deal_id,before_payment_id,after_payment_id,item_id,deal_state,time_limit from deal where deal_id = "+ dealId ;
	        st = cn.prepareStatement(sql);
	        rs = st.executeQuery();

	        while(rs.next()) {
	        	Deal deal = new Deal();
	        	deal.setDealId(rs.getString(1));
	        	deal.setBeforePaymentId(rs.getString(2));
	        	deal.setAfterPaymentId(rs.getString(3));
	        	deal.setItemId(rs.getString(4));
	        	deal.setDealState(rs.getString(5));
	        	deal.setTimeLimit(rs.getTimestamp(6));
	        }
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
		return chat;
	}

}
