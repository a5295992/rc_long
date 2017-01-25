package com.rc_long.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

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
			return queryRunner.update(connecion,sql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			printSql(sql.toString());
			C3P0UTils.closeCon(connecion);
		}
		return -1;
	}

	public static <T> int update(Class<T> class1, String sql, Object[] params) {
		connecion = C3P0UTils.getConnection();
		try {
			return queryRunner.update(connecion,sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			C3P0UTils.closeCon(connecion);
		}
		return -1;
		
	}
	
	/**
	 * 打印操作的sql语句 方便 改错开发
	 * 
	 * @param sql
	 */
	public static void printSql(String sql) {
		System.out.println("Rc_long:" + sql);
	}


}
