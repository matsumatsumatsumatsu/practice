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

//        	System.out.println("-DealDao-");
//        	System.out.println("sql:"+sql);

        	//購入者のpayment_log列のid
        	st.setString(1,deal.getBeforePaymentId());
//        	System.out.println("---DealDao---");
//        	System.out.println("payId:"+deal.getBeforePaymentId());

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

	public List getAllDeals(String userId) throws IntegrationException{
		ArrayList deals = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			//deal表とitem表を表結合（内部結合）、item表のitem_nameをdealのbeanに挿入する。user_idで識別。
			String sql = "select deal.deal_id,deal.before_payment_id,deal.after_payment_id,deal.item_id,item.item_name,item.item_image,item.seller_id,item.term,deal.deal_state,deal.time_limit,deal.user_id,deal.user_state "
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
	        	//itemIdからitemName、itemImage、出品者ID、発送期間を取得
	        	d.setItemName(rs.getString(5));
	        	d.setItemImage(rs.getString(6));
	        	d.setSellerId(rs.getString(7));
	        	d.setTerm(rs.getInt(8));
	        	d.setDealState(rs.getString(9));
	        	d.setTimeLimit(rs.getTimestamp(10));
	        	d.setUserId(rs.getString(11));
	        	d.setUserState(rs.getString(12));

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

	public List getSellAllDeals(String userId) throws IntegrationException{
		ArrayList deals = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			//deal表とitem表を表結合（内部結合）、item表のitem_nameをdealのbeanに挿入する。user_idで識別。
			String sql = "select deal.deal_id,deal.before_payment_id,deal.after_payment_id,deal.item_id,item.item_name,item.item_image,item.seller_id,item.term,deal.deal_state,deal.time_limit,deal.user_id,deal.user_state "
					+ "from deal inner join item on deal.item_id = item.item_id"
					+ " where item.seller_id = "+ userId;
			st = cn.prepareStatement(sql);
	        rs = st.executeQuery();

	        while(rs.next()) {
	        	Deal d = new Deal();
	        	d.setDealId(rs.getString(1));
	        	d.setBeforePaymentId(rs.getString(2));
	        	d.setAfterPaymentId(rs.getString(3));
	        	d.setItemId(rs.getString(4));
	        	//itemIdからitemName、itemImage、出品者ID、発送期間を取得
	        	d.setItemName(rs.getString(5));
	        	d.setItemImage(rs.getString(6));
	        	d.setSellerId(rs.getString(7));
	        	d.setTerm(rs.getInt(8));
	        	d.setDealState(rs.getString(9));
	        	d.setTimeLimit(rs.getTimestamp(10));
	        	d.setUserId(rs.getString(11));
	        	d.setUserState(rs.getString(12));

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

	public List getDeal(String dealId) throws IntegrationException {
		List deal = new ArrayList();
		Deal d = new Deal();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select * from deal where deal_id = "+dealId;
			System.out.println("sql="+sql);
			st = cn.prepareStatement(sql);
			System.out.println("sql="+sql);
			rs = st.executeQuery();

			while (rs.next()) {
	        	d.setDealId(rs.getString(1));
	        	d.setBeforePaymentId(rs.getString(2));
	        	d.setAfterPaymentId(rs.getString(3));
	        	d.setItemId(rs.getString(4));
	        	d.setDealState(rs.getString(5));
	        	d.setTimeLimit(rs.getTimestamp(6));
	        	d.setUserId(rs.getString(7));
	        	d.setUserState(rs.getString(8));

				deal.add(d);
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
		return deal;
	}
	public void changeState(String dealId,String state) throws IntegrationException {
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "update deal set user_state = "+state+" where deal_id = "+dealId;
			System.out.println("update deal set user_state = "+state+" where = deal_id = "+dealId);
			st = cn.prepareStatement(sql);
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
