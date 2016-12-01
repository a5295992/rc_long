package com.rc_long.dao;

public class SqlCreate {
	/**
	 * 查询所有
	 * @param clazz
	 * @return 1
	 */
	public static StringBuilder generateQuerySql(Class<?> clazz,StringBuilder sb){
		String tableName=clazz.getSimpleName();
		tableName=deleWithTableName(tableName, sb);
		
		sb.append("select *from ");
		sb.append(tableName);
		return sb;
	}
	/**
	 * 查询一个或者多个
	 * @param clazz
	 * @param obj
	 * @return 2
	 */
	public static StringBuilder generateQuerySql(Class<?> clazz,String []obj,StringBuilder sb){
		String tableName=clazz.getSimpleName();
		//先将其首字母变为小写 添加
		tableName=deleWithTableName(tableName, sb);
		
		sb.append("select ");
		for (int i = 0; i < obj.length; i++) {
			sb.append(obj[i]);
			sb.append(",");
		}
		sb.append(" from ");
		sb.append(tableName);
		return sb;
	}
	/**
	 * 查询数量
	 * @return
	 */
	public static StringBuilder generateQueryCountSql(Class<?> clazz,StringBuilder sb){
		String tableName=clazz.getSimpleName();
		//先将其首字母变为小写 添加
		tableName=deleWithTableName(tableName, sb);
		sb.append("select count(*) from ");
		sb.append(tableName);
		
		return sb;
	}
	/**
	 * 添加条件 生成预编译语句
	 * @param obj
	 * @param sb
	 */
	public static StringBuilder setConditions(String []obj,StringBuilder sb){
		sb.append(" where ");
		parseArray(obj,sb);
		return sb;
	}
	//用来解析数组 组装成为语句
	public static StringBuilder parseArray(String []obj,StringBuilder sb){
		for (int i = 0; i < obj.length; i++) {
			sb.append(obj[i]);
			sb.append(" = ");
			sb.append(" ? ");
			if(obj.length-i>1){
				sb.append(" and ");
			}
		}
		return sb;
	}
	public static StringBuilder OrderBy(String culum,String desc,StringBuilder sb){
		sb.append(" ORDER BY ");
		sb.append(culum);
		sb.append(" ");
		sb.append(desc);
		return sb;
	}
	//将实体名替换成相应的表名
	public static String deleWithTableName(String tableName,StringBuilder sbx){
		sbx.append((tableName.charAt(0)+"").toLowerCase());
		//先将其首字母变为小写 添加
		for (int i = 1; i < tableName.length(); i++) {
			//其后 如果是大写字母 就将其变小写
			if(tableName.charAt(i)<97&&tableName.charAt(i)>65){
				sbx.append("_"+(tableName.charAt(i)+"".toLowerCase()));
			}else{
				sbx.append(tableName.charAt(i));
			}
		}
		return sbx.toString();
	}
	public static StringBuilder groupBy(StringBuilder sb,String sbx){
		sb.append(" group by ");
		sb.append(sbx);
		return sb;
	}
	public static StringBuilder having(String [] obj,StringBuilder sb){
		parseArray(obj, sb);
		sb.append(" having ");
		parseArray(obj, sb);
		return sb;
	}
}
