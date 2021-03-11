package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Hardware;
import exception.IntegrationException;
import util.MysqlConnector;

public class HardwareDao implements HardwareInterfaceDao {
	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public List getAllHardware() throws IntegrationException{
		ArrayList hardwareList = new ArrayList();

		try {
        	cn = MysqlConnector.getInstance().beginTransaction();

            String sql = "select * from hardware";
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Hardware c = new Hardware();
                c.setHardwareId(rs.getString(1));
                c.setHardware(rs.getString(2));

                hardwareList.add(c);
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
        return hardwareList;
	}

	public List getHardware(String key, String id)throws IntegrationException{
		ArrayList hardware = new ArrayList();
		try {
        	cn = MysqlConnector.getInstance().beginTransaction();

            String sql = "select hardware from hardware " + key + id;
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                Hardware c = new Hardware();
                c.setHardware(rs.getString(1));

                hardware.add(c);
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
        return hardware;

	}
}
