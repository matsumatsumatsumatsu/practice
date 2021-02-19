package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.IntegrationException;
import util.MysqlConnector;

public class NoticeDao implements NoticeInterfaceDao {

	Connection cn  = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	//Notice表に通知の詳細を登録する
	public void notify(String key) throws IntegrationException {
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "insert ";

			st = cn.prepareStatement(sql);

			st.executeUpdate();
			MysqlConnector.getInstance().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				cn.rollback();
			}catch(SQLException ex) {
			}
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(cn != null) {
					MysqlConnector.getInstance().closeConnection();
				}
			}
		}
	}

	//お知らせの一覧などで通知を表示する
	public List getNotice(String key) throws IntegrationException {
		ArrayList notices = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select ";

			st = cn.prepareStatement(sql);

			st.executeUpdate();
			MysqlConnector.getInstance().commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				cn.rollback();
			}catch(SQLException ex) {
			}
		}finally {
			try {
				if(st != null) {
					st.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				if(cn != null) {
					MysqlConnector.getInstance().closeConnection();
				}
			}
		}

		return notices;
	}
}