package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import exception.IntegrationException;

public class MysqlConnector{

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String user = "kirisuto";
	private static String pass = "zabieru";
	private static String url = "jdbc:mysql://localhost:3306/humie?characterEncoding=UTF-8&serverTimezone=JST";
	//AWSに移行する際に接続記述子を変える。githubに公開するときは危険なので書かないこと

	private static Connection cn = null;

	private MysqlConnector() {}

	public static Connection getConnection() throws IntegrationException{
		try {
			Class.forName(driver);

			cn = DriverManager.getConnection(url,user,pass);

			cn.setAutoCommit(false);

			System.out.println("cd:"+cn);

		}catch(ClassNotFoundException e) {
			throw new IntegrationException(e.getMessage(),e);
		}catch(SQLException e) {
			throw new IntegrationException(e.getMessage(),e);
		}
		return cn;
	}
}