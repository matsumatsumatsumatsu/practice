package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.PrivateChat;
import exception.IntegrationException;
import util.MysqlConnector;

public class PrivateChatDao implements PrivateChatInterfaceDao {
	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public void send(PrivateChat p) throws IntegrationException{
		try {
        	cn = MysqlConnector.getInstance().getConnection();

            String sql = "insert into private_chat(deal_id,buyer_id,seller_id,text,date) " + "values(?,?,?,?,cast( now() as datetime))";

            st = cn.prepareStatement(sql);

            st.setString(1, p.getDealId());
            st.setString(2, p.getBuyerId());
            st.setString(3, p.getSellerId());
            st.setString(4, p.getText());

            st.executeUpdate();
            MysqlConnector.getInstance().commit();
        }catch (SQLException e) {
            e.printStackTrace();
                        try {
                cn.rollback();
            } catch (SQLException ex) {
                //TODO: handle exception
            }

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
	public List getAllMessage(String dealId) throws IntegrationException{
		ArrayList chat =new ArrayList();
        try {
        	cn = MysqlConnector.getInstance().getConnection();

            String sql = "select chat_id,deal_id,buyer_id,seller_id,user.user_name,text,date "
            		+ "from private_chat inner join user on seller_id = user_id"
            		+ " where deal_id = "+dealId+" order by chat_id";
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                PrivateChat p = new PrivateChat();
                p.setChatId(rs.getString(1));
                p.setDealId(rs.getString(2));
                p.setBuyerId(rs.getString(3));
                p.setSellerId(rs.getString(4));
                p.setUserName(rs.getString(5));
                p.setText(rs.getString(6));
                p.setDate(rs.getTimestamp(7));

                chat.add(p);
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
        return chat;
	}
}
