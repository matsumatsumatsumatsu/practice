package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import exception.IntegrationException;
import util.MysqlConnector;

public class UserDao implements UserInterfaceDao{

	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public void addUser(User u) throws IntegrationException {
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) " + "values(?,?,?,?,?,?,?,?)";

			st = cn.prepareStatement(sql);

			st.setString(1, u.getUserName());
			st.setString(2, u.getUserPassword());
			st.setString(3, u.getRealName());
			st.setString(4, u.getAddress());
			st.setString(5, u.getTel());
			st.setString(6, u.getMail());
			st.setString(7, u.getProfile());
			st.setInt(8, u.getPoint());

			st.executeUpdate();
			MysqlConnector.getInstance().commit();
		}catch (SQLException e) {
			e.printStackTrace();
			MysqlConnector.getInstance().rollback();
		}finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if (cn != null) {
					MysqlConnector.getInstance().closeConnection();
				}

			}
		}

	}

	public List getUser(String userId) throws IntegrationException {
		List users = new ArrayList();
		User u = new User();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select * from user where user_id = ?";
			st = cn.prepareStatement(sql);
			st.setString(1, userId);
			rs = st.executeQuery();

			while (rs.next()) {
				u.setUserId(rs.getString(1));
				u.setUserName(rs.getString(2));
				u.setUserPassword(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setAddress(rs.getString(5));
				u.setTel(rs.getString(6));
				u.setMail(rs.getString(7));
				u.setProfile(rs.getString(8));
				u.setPoint(rs.getInt(9));

				users.add(u);
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
		return users;
	}

	public List getUserPass(String userName) throws IntegrationException {
		List users = new ArrayList();
		User u = new User();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select * from user where user_name = ?" ;
			st = cn.prepareStatement(sql);
			st.setString(1, userName);
			rs = st.executeQuery();

			while (rs.next()) {
				u.setUserId(rs.getString(1));
				u.setUserName(rs.getString(2));
				u.setUserPassword(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setAddress(rs.getString(5));
				u.setTel(rs.getString(6));
				u.setMail(rs.getString(7));
				u.setProfile(rs.getString(8));
				u.setPoint(rs.getInt(9));

				users.add(u);
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
		return users;
	}

	public List getCurrentUserPass(String sessionUserId) throws IntegrationException {
		List users = new ArrayList();
		User u = new User();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select * from user where user_id = ?" ;
			st = cn.prepareStatement(sql);
			st.setString(1, sessionUserId);
			rs = st.executeQuery();

			while (rs.next()) {
				u.setUserId(rs.getString(1));
				u.setUserName(rs.getString(2));
				u.setUserPassword(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setAddress(rs.getString(5));
				u.setTel(rs.getString(6));
				u.setMail(rs.getString(7));
				u.setProfile(rs.getString(8));
				u.setPoint(rs.getInt(9));

				users.add(u);
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
		return users;
	}

	public List getAllUsers() throws IntegrationException {
		ArrayList users =new ArrayList();
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "select user_id,user_name,user_password,real_name,address,tel,mail,profile,point from user";
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUserId(rs.getString(1));
				u.setUserName(rs.getString(2));
				u.setUserPassword(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setAddress(rs.getString(5));
				u.setTel(rs.getString(6));
				u.setMail(rs.getString(7));
				u.setProfile(rs.getString(8));
				u.setPoint(rs.getInt(9));
				users.add(u);
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
		return users;
	}

	public void updateUser(User u) throws IntegrationException {
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql = "update user set user_name = ?, user_password = ?, real_name = ?, address = ?, tel = ?, mail = ?, profile = ?";
			st = cn.prepareStatement(sql);

			st.setString(1, u.getUserName());
			st.setString(2, u.getUserPassword());
			st.setString(3, u.getRealName());
			st.setString(4, u.getAddress());
			st.setString(5, u.getTel());
			st.setString(6, u.getMail());
			st.setString(7, u.getProfile());

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

	public void deleteUser(String userId) throws IntegrationException {
		try {
			cn = MysqlConnector.getInstance().getConnection();

			String sql1 = "SET FOREIGN_KEY_CHECKS = 0";
			String sql2 = "delete from user where user_id = ?";
			String sql3 = "SET FOREIGN_KEY_CHECKS = 1";

			st = cn.prepareStatement(sql1);
			st.executeUpdate();
			MysqlConnector.getInstance();
			st = cn.prepareStatement(sql2);
			st.setString(1, userId);
			MysqlConnector.getInstance();
			st.executeUpdate();
			st = cn.prepareStatement(sql3);
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

	public void pay(String userId,int point) throws IntegrationException{
		try {
			cn = MysqlConnector.getInstance().getConnection();
			String sql = "update user set point = ? where user_id = ?";
			st = cn.prepareStatement(sql);
			st.setInt(1,point);
			st.setString(2, userId);
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
	public void grantPoint(String userId,int point) throws IntegrationException{
		try {
			cn = MysqlConnector.getInstance().getConnection();
			String sql = "update user set point = ? where user_id = ?";
			st = cn.prepareStatement(sql);
			st.setInt(1,point);
			st.setString(2, userId);
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
