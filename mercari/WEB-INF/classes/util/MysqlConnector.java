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

	private static MysqlConnector mysqlconn = null;
	private static Connection cn = null;

	private MysqlConnector() {}


	public static MysqlConnector getInstance(){
	  if(mysqlconn == null){
	    mysqlconn = new MysqlConnector();
	  }

	  return mysqlconn;
	}

	public Connection getConnection() throws IntegrationException{
		try {
			Class.forName(driver);

			cn = DriverManager.getConnection(url,user,pass);

			cn.setAutoCommit(false);

		}catch(ClassNotFoundException e) {
			throw new IntegrationException(e.getMessage(),e);
		}catch(SQLException e) {
			throw new IntegrationException(e.getMessage(),e);
		}
		return cn;
	}

	public void closeConnection(){
		    try{
		      if(cn != null){
		        //Connectionのインスタンスの破棄ができてないっぽい
		        cn.close();
		        cn=null;
		      }
		    }catch(SQLException e){
		      e.printStackTrace();
		      System.out.println("closeできませんでした。SQL関連の例外です");
		    }
		  }

	public void beginTransaction(){
	    if(cn ==null){
	    	try {
	    		getConnection();
	    	}catch(IntegrationException e) {

	    	}
	    }
	    try{
	      cn.setAutoCommit(false);
	    }catch(SQLException e){
	      e.printStackTrace();
	      System.out.println("setAutoCommitできませんでした。SQL関連の例外です");
	    }
	  }

	  public void commit(){
	    try{
	      cn.commit();
	    }catch(SQLException e){
	      e.printStackTrace();
	      System.out.println("commitできませんでした。SQL関連の例外です");
	    }
	  }

	  public void rollback(){
	    try{
	      cn.rollback();
	    }catch(SQLException e){
	      e.printStackTrace();
	      System.out.println("rollbackできませんでした。SQL関連の例外です");
	    }
	  }
}