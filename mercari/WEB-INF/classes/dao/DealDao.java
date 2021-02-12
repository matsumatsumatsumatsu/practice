package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
