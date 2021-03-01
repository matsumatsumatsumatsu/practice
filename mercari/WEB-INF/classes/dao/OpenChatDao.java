package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.OpenChat;
import exception.IntegrationException;
import util.MysqlConnector;

public class OpenChatDao implements OpenChatInterfaceDao {
	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public void send(OpenChat op) throws IntegrationException {
		try {
        	cn = MysqlConnector.getInstance().getConnection();

            String sql = "insert into open_chat(user_id,text,date,item_id)  values(?,?,cast( now() as datetime),?)";

            st = cn.prepareStatement(sql);

            st.setString(1, op.getUserId());
            st.setString(2, op.getText());
            st.setString(3, op.getItemId());

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

	public List getAllMessage(String item_id) throws IntegrationException{
		ArrayList chat =new ArrayList();
        try {
        	cn = MysqlConnector.getInstance().getConnection();

            String sql = "select open_chat_id,open_chat.user_id,user.user_name,text,date,item_id "
            		+ "from open_chat inner join user on open_chat.user_id = user.user_id "
            		+ "where item_id = "+item_id+" order by open_chat_id";
            st = cn.prepareStatement(sql);
            rs = st.executeQuery();

            while (rs.next()) {
                OpenChat op = new OpenChat();
                op.setOpenChatId(rs.getString(1));
                op.setUserId(rs.getString(2));
                op.setUserName(rs.getString(3));
                op.setText(rs.getString(4));
                op.setDate(rs.getTimestamp(5));
                op.setItemId(rs.getString(6));

                chat.add(op);
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
