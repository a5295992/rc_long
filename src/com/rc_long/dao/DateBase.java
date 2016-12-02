package com.rc_long.dao;
import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.rc_long.utils.C3P0UTils;
public class DateBase {
	private static  QueryRunner queryRunner=new QueryRunner();
	private static Connection connecion;
	public static <T> void insert(Class<T> clazz){
		connecion=C3P0UTils.getConnection();
		try {
			connecion.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String[] parameters={"user_id","user_name"};
		Object []param={"10001",1};
		
		StringBuilder sql=new StringBuilder();
		
		SqlCreate.insertSql(sql, clazz, parameters);
		try {
			queryRunner.update(connecion, sql.toString(), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connecion.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void printSql(String sql){
		System.out.println("Rc_long:"+sql);
	}
}
