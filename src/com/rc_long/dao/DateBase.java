package com.rc_long.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.rc_long.Entity.SysUser;
import com.rc_long.utils.C3P0UTils;

public class DateBase {
	private static  QueryRunner queryRunner=new QueryRunner();
	private static Connection connecion;
	public static <T> void insert(Class<T> clazz){
		connecion=C3P0UTils.getConnection();
		String[] parameters={"user_id","user_name"};
		Object []param={"10001",1};
		StringBuilder sql=new StringBuilder();
		System.out.println(sql);
		SqlCreate.insertSql(sql, clazz, parameters);
		try {
			queryRunner.update(connecion, sql.toString(), param);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		insert(SysUser.class);
	}
}
