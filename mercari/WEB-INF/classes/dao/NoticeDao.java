package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Notice;
import exception.IntegrationException;
import util.MysqlConnector;

public class NoticeDao implements NoticeInterfaceDao {

	Connection cn  = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	//Notice表に通知の詳細を登録する
	public void registNotice(String userId,String comment) throws IntegrationException {
		try {
			cn = MysqlConnector.getInstance().getConnection();

			//commentにシングルクォーテーション注意
			String sql = "insert into notice(user_id,comment,date)  values(" + userId + ", '" + comment + "', cast( now() as datetime))";

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
	public List getNotice(String userId) throws IntegrationException {
		ArrayList notices = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select notice_id, user_id, comment, is_read, date from notice where user_id = " + userId;
			st = cn.prepareStatement(sql);
			st.executeQuery();

			while (rs.next()) {
				Notice n = new Notice();
				n.setNoticeId(rs.getString(1));
				n.setUserId(rs.getString(2));
				n.setComment(rs.getString(3));
				n.setIsRead(rs.getInt(4));
				n.setDate(rs.getTimestamp(5));
				notices.add(n);
			}
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