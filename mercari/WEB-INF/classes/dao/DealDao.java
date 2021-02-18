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

	public List getDealInfo(String userId) throws IntegrationException{
		ArrayList deals = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			//deal表とitem表を表結合（内部結合）、item表のitem_nameをdealのbeanに挿入する。user_idで識別。
			String sql = "select deal.deal_id,deal.before_payment_id,deal.after_payment_id,deal.item_id,item.item_name,deal.deal_state,deal.time_limit,deal.user_id,deal.user_state "
					+ "from deal inner join item on deal.item_id = item.item_id"
					+ " where user_id = "+ userId;
			st = cn.prepareStatement(sql);
	        rs = st.executeQuery();

	        while(rs.next()) {
	        	Deal d = new Deal();
	        	d.setDealId(rs.getString(1));
	        	d.setBeforePaymentId(rs.getString(2));
	        	d.setAfterPaymentId(rs.getString(3));
	        	d.setItemId(rs.getString(4));
	        	d.setItemName(rs.getString(5));
	        	d.setDealState(rs.getString(6));
	        	d.setTimeLimit(rs.getTimestamp(7));
	        	d.setUserId(rs.getString(8));
	        	d.setUserState(rs.getString(9));

	        	deals.add(d);
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
		return deals;
	}

}
