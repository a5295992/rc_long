package com.rc_long.utils;

import com.rc_long.anotation.TableList;

/**
 * 自定义注解解析类
 * 
 * @version 1.0
 * @author longge
 * 
 */
public class AnnotationParser {

	/**
	 * 解析 多表查询注解解析
	 * 
	 * @param clazz
	 * @return
	 */
	public static String parse(Class<?> clazz) {
		StringBuilder sql =  new StringBuilder();
		boolean b = clazz.isAnnotationPresent(TableList.class);
		if (b) {
			TableList c = clazz.getAnnotation(TableList.class);
			String[] names = c.names();
			String[] condition = c.connectCondition();
			
			if (names != null && names.length > 0) {
				for (int i = 0; i < names.length; i++) {
					if(i==0){
						sql.append(names[i]);
					}else{
						sql.append(" left join ");
						sql.append(names[i]);
						sql.append(" on "+condition[i-1]);
					}
				}
			}
		} else {
			throw new RuntimeException("该类没有使用@TableList注解");
		}
		return sql.toString();
	}

}
