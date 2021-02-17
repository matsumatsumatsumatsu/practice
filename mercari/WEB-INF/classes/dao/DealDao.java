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

	public void insertDeal(Deal deal) throws IntegrationException{
		try {
			cn = MysqlConnector.getInstance().getConnection();
        	String sql = "insert into deal(before_payment_id,after_payment_id,item_id,deal_state,time_limit,user_id,user_state) values(?,?,?,?,null,?,?)";
        	st = cn.prepareStatement(sql);

        	System.out.println("-DealDao-");
        	System.out.println("sql:"+sql);

        	//購入者のpayment_log列のid
        	st.setString(1,deal.getBeforePaymentId());
        	//出品者のpayment_log列のid
        	st.setString(2,deal.getAfterPaymentId());
        	st.setString(3,deal.getItemId());
        	st.setString(4,deal.getDealState());
        	st.setString(5,deal.getUserId());
        	st.setString(6,deal.getUserState());

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

	public List getDealInfo(String dealId) throws IntegrationException{
		ArrayList chat = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select deal_id,before_payment_id,after_payment_id,item_id,deal_state,time_limit,user_id,user_state from deal where deal_id = "+ dealId ;
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
	        	deal.setUserId(rs.getString(7));
	        	deal.setUserState(rs.getString(8));
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
