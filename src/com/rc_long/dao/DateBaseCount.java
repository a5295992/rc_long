package com.rc_long.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rc_long.Entity.ChatLog;
import com.rc_long.utils.C3P0UTils;

public class DateBaseCount {
	private static Connection connecion;

	public static int queryCount(Class<ChatLog> class1, String sql,
			Object[] params) {
		connecion = C3P0UTils.getConnection();
		java.sql.PreparedStatement prep = null;
		try {
			prep = connecion.prepareStatement(sql);
			setParams(prep,params);
			ResultSet re = prep.executeQuery();
			if (re.next()) {
				return re.getInt(1) ;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3P0UTils.closeCon(connecion);
		}
		return 0;
	}
	
	private static void setParams(PreparedStatement prep, Object[] params) throws SQLException{
		for (int i = 0; i < params.length; i++) {
			prep.setObject(i+1, params[i]);
		}
	}
}
