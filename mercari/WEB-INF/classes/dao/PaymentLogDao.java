package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.PaymentLog;
import exception.IntegrationException;
import util.MysqlConnector;

public class PaymentLogDao implements PaymentLogInterfaceDao {
	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public String insertPaymentLog(PaymentLog payment) throws IntegrationException{
        String payId = "";

        System.out.println("---PaymentLogDao---");

		try {
			cn = MysqlConnector.getInstance().beginTransaction();
			String sql = "insert into payment_log(seller_id,buyer_id,item_id,price,date) values(?,?,?,?,cast( now() as datetime))";
			st = cn.prepareStatement(sql);

        	//出品者のpayment_log列のid
        	st.setString(1,payment.getSellerId());
        	st.setString(2,payment.getBuyerId());
        	st.setString(3,payment.getItemId());
        	st.setInt(4,payment.getPrice());

            st.executeUpdate();
            MysqlConnector.getInstance().commit();

            String selectId = "select LAST_INSERT_ID()";
			st = cn.prepareStatement(selectId);
	        rs = st.executeQuery();

	        while(rs.next()) {
	        	 payId = rs.getString(1);
	        }

	        System.out.println("payId"+payId);

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

		return payId;
	}

	public List getAllPaymentLogs(String paymentLogId) throws IntegrationException{
		List paymentLogs = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().beginTransaction();

			//deal表とitem表を表結合（内部結合）、item表のitem_nameをdealのbeanに挿入する。user_idで識別。
			String sql = "select payment_id,seller_id,buyer_id,item_id,price,date from payment_log";
			st = cn.prepareStatement(sql);
	        rs = st.executeQuery();

	        while(rs.next()) {
	        	PaymentLog pl = new PaymentLog();
	        	pl.setPaymentId(rs.getString(1));
	        	pl.setSellerId(rs.getString(2));
	        	pl.setBuyerId(rs.getString(3));
	        	pl.setItemId(rs.getString(4));
	        	pl.setPrice(rs.getInt(5));
	        	pl.setDate(rs.getTimestamp(6));
	        	paymentLogs.add(pl);
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

		return paymentLogs;
	}

	public String getBuyerId(String itemId) throws IntegrationException{
		String buyerId = "";
		 try {
			 cn = MysqlConnector.getInstance().beginTransaction();
			 String sql = "select buyer_id from payment_log where item_id = " + itemId;
			 System.out.println("確認用SQL文:"+sql);

			 st = cn.prepareStatement(sql);
			 rs = st.executeQuery();

			 //カーソルを使うので取るデータが一つでもwhile文を回したい
			 while (rs.next()) {
				 buyerId = rs.getString(1);
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
		return buyerId;
	}

	public String getSellerId(String itemId) throws IntegrationException {
		String sellerId = "";
		 try {
			 cn = MysqlConnector.getInstance().beginTransaction();
			 String sql = "select seller_id from payment_log where item_id = " + itemId;
			 System.out.println("確認用SQL文:"+sql);

			 st = cn.prepareStatement(sql);
			 rs = st.executeQuery();

			 //カーソルを使うので取るデータが一つでもwhile文を回したい
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
}
