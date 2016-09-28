package org.cc.ems.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 数据库工具类
 * @author CC11001100
 *
 */
public class DbUtil {

	private Properties dbProps; //配置文件在内存的表现形式
	private String configFile="dbconfig.properties"; //默认配置文件位置
	
	private DbUtil() {
		try {
			//初始化资源
			dbProps=new Properties();
			dbProps.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(configFile));
			Class.forName(dbProps.getProperty("driver"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static class DbUtilHolder{
		private static DbUtil INSTANCE=new DbUtil();
	}
	
	/**
	 * 单例
	 * @return
	 */
	public static DbUtil getInstance(){
		return DbUtilHolder.INSTANCE; 
	}
	
	/**
	 * 获得一个数据库连接
	 * @return
	 */
	public Connection getConnection(){
		try {
			return DriverManager.getConnection(dbProps.getProperty("url"),dbProps);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void close(Connection conn,PreparedStatement pstmt,ResultSet rs){
		try {
			if(rs!=null && !rs.isClosed()) rs.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		try {
			if(pstmt!=null && !pstmt.isClosed()) pstmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			if(conn!=null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public void close(Connection conn,PreparedStatement pstmt){
		close(conn,pstmt,null);
	}
}
