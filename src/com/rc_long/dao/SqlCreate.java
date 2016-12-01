package com.rc_long.dao;

public class SqlCreate {
	/**
	 * 查询所有
	 * @param clazz
	 * @return
	 */
	public static String generateQuerySql(Class<?> clazz){
		String tableName=clazz.getSimpleName();
		StringBuilder sb=new StringBuilder();
		sb.append("select *from ");
		sb.append(tableName);
		return sb.toString();
	}
	/**
	 * 查询一个或者多个
	 * @param clazz
	 * @param obj
	 * @return
	 */
	public static String generateQuerySql(Class<?> clazz,String []obj){
		String tableName=clazz.getSimpleName();
		StringBuilder sb=new StringBuilder();
		sb.append("select ");
		for (int i = 0; i < obj.length; i++) {
			sb.append(obj[i]);
			sb.append(",");
		}
		sb.append(" from ");
		sb.append(tableName);
		return sb.toString();
	}
	public static String generateQueryCountSql(){
		
		
		return null;
		
	}
	public static String generateQueryJoinSql(Class[] clazz){
		return null;
		
	}
	/**
	 * 添加条件 生成预编译语句
	 * @param obj
	 * @param sb
	 */
	public static String setConditions(String []obj){
		StringBuilder sb=new StringBuilder();
		sb.append(" where ");
		for (int i = 0; i < obj.length; i++,sb.append("and ")) {
			sb.append(obj[i]);
			sb.append(" = ");
			sb.append(" ? ");
		}
		return sb.toString();
	}
	public static String gennerate(){
		return null;
	}
	
}
