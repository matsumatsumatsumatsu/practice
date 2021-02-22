package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Admin;
import exception.IntegrationException;
import util.MysqlConnector;

public class AdminDao implements AdminInterfaceDao {

	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public List getAdminPass(String adminName) throws IntegrationException {
		List admins = new ArrayList();
		Admin admin = new Admin();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select * from admin where admin_name = ?" ;
			st = cn.prepareStatement(sql);
			st.setString(1, adminName);
			rs = st.executeQuery();

			while (rs.next()) {
				admin.setAdminId(rs.getString(1));
				admin.setAdminName(rs.getString(2));
				admin.setAdminPassword(rs.getString(3));
				admin.setMail(rs.getString(4));
				admins.add(admin);
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
		return admins;
	}

}
