package com.rc_long.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.rc_long.Entity.ChatLog;
import com.rc_long.utils.C3P0UTils;

/**
 * 更具实际需要重写DateBase
 * @author longge
 *
 */
public class DateBaseNew {
	private static QueryRunner queryRunner = new QueryRunner();
	private static Connection connecion;
	
	public static <T> int delete(Class<T> clazz,String condition,String inCondition){
		connecion = C3P0UTils.getConnection();
		StringBuilder sql = new StringBuilder();
		SqlCreate.generateDeleteSQL(clazz,sql,condition,inCondition);
		try {
			return queryRunner.update(sql.toString(),connecion);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0UTils.closeCon(connecion);
		}
		return -1;
	}

	public static int update(Class<ChatLog> class1, String sql, Object[] params) {
		connecion = C3P0UTils.getConnection();
		try {
			return queryRunner.update(sql,connecion,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0UTils.closeCon(connecion);
		}
		return -1;
		
	}
}
