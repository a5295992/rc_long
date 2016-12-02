package com.rc_long.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.rc_long.Entity.SysUser;

public class SqlCreate {
	/**
	 * 查询所有
	 * @param clazz
	 * @return 1
	 */
	public static String tableName=null;
	public static void generateQuerySql(Class<?> clazz,StringBuilder sb){
		sb.append("select *from ");
		 tableName=clazz.getSimpleName();
		//将class名字变为 table 名
		deleWithTableName(tableName, sb);
	}
	/**
	 * 查询一个或者多个
	 * @param clazz
	 * @param obj
	 * @return 2
	 */
	public static void generateQuerySql(Class<?> clazz,String []obj,StringBuilder sb){
		sb.append("select ");
		tableName=clazz.getSimpleName();
		//先将其首字母变为小写 添加
		for (int i = 0; i < obj.length; i++) {
			sb.append(obj[i]);
			if(obj.length-i>1){
				sb.append(",");
			}
		}
		sb.append(" from ");
		deleWithTableName(tableName, sb);
	}
	/**
	 * 查询数量
	 * @return
	 */
	public static void generateQueryCountSql(Class<?> clazz,StringBuilder sb,Map<String, Object> obj){
		tableName=clazz.getSimpleName();
		sb.append("select ");
		parseArray(obj, sb);
		sb.append(" count(*) from ");
		//先将其首字母变为小写 添加
		deleWithTableName(tableName, sb);
	}
	/**
	 * 生成 关联查询语句
	 * @param sb
	 * @param classArr
	 * @param condition
	 */
	public static void genenrateLeftJoinQuerySql(List<Class> list,List<String[]> searchList,List<String> condition,StringBuilder sb){
		sb.append("select ");
		StringBuilder sbx=new StringBuilder();
		sbx.append(" from ");
		for (int i = 0; i < list.size(); i++) {
			tableName=list.get(i).getSimpleName();
			sbx.append(tableName.charAt(0));
			for (int j = 1; j < tableName.length(); j++) {
				//其后 如果是大写字母 就将其变小写
				if(tableName.charAt(j)<97&&tableName.charAt(j)>65){
					sbx.append("_"+(tableName.charAt(j)+"".toLowerCase()));
				}else{
					sbx.append(tableName.charAt(j));
				}
			}
			sbx.append(" t"+i+" ");
			if(list.size()-i>1){
				sbx.append(",");
			}
			//要查找的字段
			if(searchList!=null){
				for(int z=0;z<searchList.get(i).length;z++){
					sb.append(" t"+i);
					sb.append(".");
					sb.append(searchList.get(i)[z]);
					if(list.size()-i>1){
						sb.append(",");
					}
				}
			}
			//关联条件
		}
		sb.append(sbx);
	for (int i = 0; i < condition.size(); i++) {
		sb.append(" where ");
		sb.append(condition.get(i));
	}
	}
	/**
	 * 添加条件 生成预编译语句
	 * @param obj
	 * @param sb
	 */
	public static void setConditions(Map<String,Object>map,StringBuilder sb){
		if(sb.toString().contains("where")){
			sb.append(" and ");
		}else{
			sb.append(" where ");
		}
		parseArray(map,sb);
	}
	//用来解析数组 组装成为语句
	public static void parseArray(Map<String, Object> map,StringBuilder sb){
		int index=0;
		for(Entry<String, Object> m:map.entrySet()){
			sb.append(m.getKey());
			sb.append(" = ");
			sb.append("'"+m.getValue()+"'");
			if(map.size()-index>1){
				sb.append(" and ");
			}
			index++;
		}
	}
	/**
	 * 排序
	 * @param culum
	 * @param desc
	 * @param sb
	 * @return
	 */
	public static void OrderBy(String culum,String desc,StringBuilder sb){
		sb.append(" ORDER BY ");
		sb.append(culum);
		sb.append(" ");
		sb.append(desc);
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
	/**
	 * 分组
	 * @param sb
	 * @param sbx
	 * @return
	 */
	public static void groupBy(StringBuilder sb,String sbx){
		sb.append(" group by ");
		sb.append(sbx);
	}
	/**
	 * 分组后条件
	 * @param obj
	 * @param sb
	 * @return
	 */
	public static  void having(Map<String, Object> obj,StringBuilder sb){
		sb.append(" having ");
		parseArray(obj, sb);
	}
	/**
	 * 分页查询
	 * @param sb 放在最后
	 * @return
	 */
	public static void limitIn(StringBuilder sb,int start,int end){
		sb.append(" limit ");
		sb.append(start);
		sb.append(',');
		sb.append(end);
		sb.append(" ");
	}
	public static void like(StringBuilder sb,String clum,Object like){
		if(sb.toString().contains("where")){
			sb.append(" and ");
		}else{
			sb.append(" where ");
		}
		sb.append(clum);
		sb.append(" like ");
		sb.append("'"+'%'+""+like+""+'%'+"'");
	}
	/**
	 * 插入
	 * @param sb
	 */
	private static String dealWithName(String tableName){
		StringBuilder sbx=new StringBuilder();
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
		
		return tableName=sbx.toString();
	}
	/**
	 * 
	 * @param sb
	 * @param clazz
	 * @param parameters
	 */
	public static void insertSql(StringBuilder sb,Class<?> clazz,String[] parameters){
		String tableName=clazz.getSimpleName();
		tableName=dealWithName(tableName);
		sb.append("insert into ");
		sb.append(tableName);
		StringBuilder sbs=new StringBuilder();
		if(parameters!=null){
			sb.append("(");
			for (int i = 0; i < parameters.length; i++) {
				sb.append(parameters[i]);
				sbs.append(" ? ");
				if(parameters.length-i>1){
					sb.append(",");
					sbs.append(",");
				}
			}
			sb.append(")");
			sb.append(" values(");
			sb.append(sbs);
			sb.append(")");
		}else{
			int lenth=clazz.getDeclaredFields().length-1;
			sb.append(" values(");
			for (int i = 0; i < lenth; i++) {
				sb.append(" ? ");
				if(isLastIndex(lenth,i)){
					sb.append(",");
				}
			}
			sb.append(")");
		}
	}
	/**
	 * 查詢操作
	 * @param clazz
	 * @param sb
	 * @param parameters
	 */
	public static void generateUpdateSql(Class<?> clazz,StringBuilder sb,String []parameters){
		String tableName=clazz.getSimpleName();
		tableName=dealWithName(tableName);
		sb.append("update ");
		sb.append(tableName);
		sb.append(" set ");
		sb.append(parameters[0]);
		sb.append(" = ?");
		for (int i = 1; i < parameters.length; i++) {
			sb.append(" and ");
			sb.append(parameters[i]);
			sb.append("= ?");
		}
	}
	/**
	 * 判斷是不是最後一位
	 * @param index
	 * @param last
	 * @return
	 */
	private static boolean isLastIndex(int index,int last){
		return (index-last>1);
	}
	/**
	 * 刪除操作
	 * @param sb
	 * @param clazz
	 * @param parameters
	 */
	public static void generateDelete(StringBuilder sb,Class<?> clazz,String []parameters){
		String tableName=clazz.getSimpleName();
		tableName=dealWithName(tableName);
		sb.append("delete ");
		sb.append("from ");
		sb.append(tableName);
		if(parameters!=null){
			for (int i = 0; i < parameters.length; i++) {
				sb.append(parameters[i]+" = ?");
			}
		}
	}
	
}
