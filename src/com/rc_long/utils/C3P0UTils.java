package com.rc_long.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0UTils {
	private static DataSource combPoolDataSource;
	static {
		combPoolDataSource=new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		
		return combPoolDataSource;
	}
	/**
	 * 獲取連接
	 */
	public static Connection getConnection(){
		try {
			return combPoolDataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
