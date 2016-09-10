package com.mystore.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {

	public static ComboPooledDataSource comboPooleDataSource = new ComboPooledDataSource();
	
	/**
	 * 获取连接
	 * 
	 * @return 返回数据库连接对�?
	 */
	public static Connection getConnection(){
		
		try {
			return comboPooleDataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 获取数据源对�?
	 * @return
	 */
	public static DataSource getDataSource(){
		return comboPooleDataSource;
	}
	
	/**
	 * 释放连接
	 * @param conn 数据库连接对�?
	 * @param stmt Statement对象
	 * @param rs Result对象
	 */
	public static void release(Connection conn, Statement stmt, ResultSet rs) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

	}
	
}
