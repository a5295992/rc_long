package com.rc_long.annotationPaser;

import com.rc_long.anotation.RcLongTable;

/**
 * 注解TableName的解析类
 * @author longge
 *
 */

public class RcLongTablePaser {
	
	public  static String getTableName(Class<?> clazz){
		boolean b = clazz.isAnnotationPresent(RcLongTable.class);
		if(b){
			RcLongTable rcLongTable = clazz.getAnnotation(RcLongTable.class);
			return rcLongTable.name();
		}
		return null;
	}
}
