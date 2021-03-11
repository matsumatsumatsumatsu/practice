package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Category;
import exception.IntegrationException;
import util.MysqlConnector;

public class CategoryDao implements CategoryInterfaceDao {
	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public List getAllCategory() throws IntegrationException{
		ArrayList categoryList = new ArrayList();

		try {
        	cn = MysqlConnector.getInstance().beginTransaction();

            String sql = "select * from category ";
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setCategoryId(rs.getString(1));
                c.setCategory(rs.getString(2));

                categoryList.add(c);
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
        return categoryList;
	}

	public List getCategory(String key, String id)throws IntegrationException{
		ArrayList category = new ArrayList();
		try {
        	cn = MysqlConnector.getInstance().beginTransaction();

            String sql = "select category from category " + key + id;
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Category c = new Category();
                c.setCategory(rs.getString(1));

                category.add(c);
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
        return category;

	}

}
