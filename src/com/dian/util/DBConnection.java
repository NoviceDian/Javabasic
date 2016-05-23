package com.dian.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


//连接数据库的工具类
public class DBConnection {
	private static String url;
	private static String userName;
	private static String pwd;
	private static int max = 5;
	private static int init = 3;

	private static  BasicDataSource ds;

	private DBConnection() {

	}

	static {
		ds = new BasicDataSource();
		Properties pro = new Properties();
		try {
			InputStream is = 
					DBConnection.class.getClassLoader()
						.getResourceAsStream(
							"db.properties");
				pro.load(is);
				is.close();
			url = pro.getProperty("url");
			userName = pro.getProperty("username");
			pwd = pro.getProperty("password");
			if (pro.getProperty("maxActive") != null && !"".equals(pro.getProperty("maxActive"))) {
				max = Integer.parseInt(pro.getProperty("maxActive"));
			}
			if (pro.getProperty("initialSize") != null && !"".equals(pro.getProperty("initialSize"))) {
				init = Integer.parseInt(pro.getProperty("initialSize"));
			}
			ds.setDriverClassName(pro.getProperty("driverClassName"));
			ds.setUrl(url);
			ds.setUsername(userName);
			ds.setPassword(pwd);
			ds.setMaxActive(max);
			ds.setInitialSize(init);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void closedCon(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void closedPst(PreparedStatement ps){
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void ckosedResult(ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		ds.setUrl("jdbc:mysql://localhost:3306/spring");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setMaxActive(5);
		ds.setInitialSize(3);
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
