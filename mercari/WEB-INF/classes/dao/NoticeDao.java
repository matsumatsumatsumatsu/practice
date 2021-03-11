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
			cn = MysqlConnector.getInstance().beginTransaction();

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
	public List getAllNotices(String userId) throws IntegrationException {
		ArrayList notices = new ArrayList();
		try {
			cn = MysqlConnector.getInstance().beginTransaction();

			String sql = "select notice_id, user_id, comment, is_read, date from notice where user_id = " + userId;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();

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

	//既読の有無だけ確認
	public int getIsRead(String userId) throws IntegrationException {
		int isRead = 0;
		try {
			cn = MysqlConnector.getInstance().beginTransaction();

			String sql = "select  is_read, from notice where user_id = " + userId;
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				isRead = rs.getInt(1);
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
		return isRead;
	}

	//未読を既読にする処理
	public String readCheck(String userId) throws IntegrationException{
		String notices = "";

		try {
			cn = MysqlConnector.getInstance().beginTransaction();

			String sql = "update notice set is_read = 0 where user_id = " + userId;
			st = cn.prepareStatement(sql);

			st.executeUpdate();

			MysqlConnector.getInstance().commit();

		}catch (SQLException e) {
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