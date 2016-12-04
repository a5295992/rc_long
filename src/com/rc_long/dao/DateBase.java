package com.rc_long.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.rc_long.utils.C3P0UTils;
import com.rc_long.utils.Pager;

public class DateBase {
	private static QueryRunner queryRunner = new QueryRunner();
	private static Connection connecion;

	public static <T> void insert(Class<T> clazz, Map<String, Object> map) {
		connecion = C3P0UTils.getConnection();
		try {
			connecion.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		Object[] parameters;
		Object[] param;
		List<String> list = new ArrayList<String>();
		List<Object> list2 = new ArrayList<Object>();
		for (Entry<String, Object> m : map.entrySet()) {
			list.add(m.getKey());
			list2.add(m.getValue());
		}
		// 将list集合转为数组
		parameters = list.toArray();
		param = list2.toArray();

		StringBuilder sql = new StringBuilder();

		SqlCreate.insertSql(sql, clazz, parameters);
		try {
			queryRunner.update(connecion, sql.toString(), param);
			connecion.commit();
		} catch (SQLException e) {
			try {
				connecion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				printSql(sql.toString());
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 更新操作
	 * 
	 * @param <T>
	 */
	public static <T> void update(Class<T> clazz, Map<String, Object> map,
			Map<String, Object> condition) {
		connecion = C3P0UTils.getConnection();
		// 开启事务
		try {
			connecion.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		StringBuilder sql = new StringBuilder();

		Object[] parameters;
		Object[] param;
		List<String> list = new ArrayList<String>();
		List<Object> list2 = new ArrayList<Object>();
		for (Entry<String, Object> m : map.entrySet()) {
			list.add(m.getKey());
			list2.add(m.getValue());
		}

		// 将list集合转为数组
		parameters = list.toArray();
		param = list2.toArray();
		SqlCreate.generateUpdateSql(clazz, sql, parameters);
		if (condition != null) {
			SqlCreate.setConditions(condition, sql);
			for (Entry<String, Object> m : map.entrySet()) {
				list2.add(m.getValue());
			}
		}
		// 执行更新操作
		try {
			queryRunner.update(connecion, sql.toString(), param);
			connecion.commit();
		} catch (SQLException e) {
			try {
				connecion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				printSql(sql.toString());
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除
	 * 
	 * @param clazz
	 * @param map
	 */
	public static <T> void delete(Class<T> clazz, Map<String, Object> condition) {
		connecion = C3P0UTils.getConnection();
		// 开启事务
		try {
			connecion.setAutoCommit(false);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		StringBuilder sql = new StringBuilder();

		SqlCreate.generateDelete(sql, clazz, condition);
		try {
			queryRunner.update(connecion, sql.toString());
			connecion.commit();
		} catch (SQLException e) {
			try {
				connecion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				printSql(sql.toString());
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 查询所有
	 * 
	 * @param <T>
	 * @param sql
	 */
	public static <T> Pager<T> queryList(Class<T> clazz, String query,
			String conditionJson, String orderJson, Pager<T> limit,
			String[] like) {
		connecion = C3P0UTils.getConnection();
		StringBuilder sql = new StringBuilder();
		// 创建查询基础语句
		String[] queryThing = null;
		if(query!=null){
			queryThing=query.split(",");
		}
		SqlCreate.generateQuerySql(clazz, queryThing, sql);
		JSONObject json = null;
		if (!conditionJson.isEmpty()) {
			json = JSONObject.fromObject(conditionJson);

		}
		Map<String, Object> map = null;
		// 将json格式的数据转换成map
		if (json != null) {
			map = (Map<String, Object>) json;
		}
		if (map != null) {
			SqlCreate.setConditions(map, sql);
		}
		// 模糊查询
		if (like != null) {
			SqlCreate.like(sql, like[0], like[1]);
		}
		if (orderJson != null) {
			String[] arr = orderJson.split(",");
			SqlCreate.OrderBy(arr[0], arr[1], sql);
		}

		if (limit != null) {
			SqlCreate.limitIn(sql, limit.getStart(), limit.getPageCount());
		}
		List<T> list = null;
		try {
			list = queryRunner.query(connecion, sql.toString(),
					new BeanListHandler<T>(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				printSql(sql.toString());
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		limit.setList(list);
		return limit;
	}

	/**
	 * 查询单个实例
	 * 
	 * @param clazz 目标对象的字节码文件
	 * @param queryThing 需要查询的内容
	 * @param conditionjson jason 格式的数据 类似键值对的map 条件
	 *            json格式的条件
	 * @return 返回目标对象
	 */
	public static <T> T querySingle(Class<T> clazz, String queryThing,
			String conditionjson) {
		connecion = C3P0UTils.getConnection();
		StringBuilder sql = new StringBuilder();
		String []obj=queryThing.split(",");
		SqlCreate.generateQuerySql(clazz, obj, sql);
		//如果判断条件不为空
		JSONObject json=null;
		if(conditionjson!=null){
			json=JSONObject.fromObject(conditionjson);
			Map<String,Object> map=(Map)json;
			SqlCreate.setConditions(map, sql);
		}
		try {
			return queryRunner.query(connecion, sql.toString(), new BeanHandler<T>(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				printSql(sql.toString());
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**\
	 * 查询所给表的数据的记录条数
	 * @param clazz 目标字节码文件
	 * @param condition json格式的 字符串
	 * @return 返回所有记录的和
	 */
	public static int queryCount(Class clazz){
		connecion=C3P0UTils.getConnection();
		StringBuilder sql=new StringBuilder();
		SqlCreate.generateQueryCountSql(clazz, sql);
		ResultSet rs=null;
		try {
			rs=connecion.prepareStatement(sql.toString()).executeQuery();
			if(rs!=null){
				//在查询结果集之前需要对光标进行移动位置
				rs.next();
				try {
					return rs.getInt("count(*)");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				printSql(sql.toString());
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	/**
	 * 关联查询单个指定对象
	 * @param sql 指定的查询语句
	 * @return 返回指定对象的单个实例
	 */
	public static <T> T getBeanRunsql(Class<T> clazz,String sql){
		connecion=C3P0UTils.getConnection();
		
		try {
			return queryRunner.query(connecion, sql, new BeanHandler<T>(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			printSql(sql);
			try {
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 查询关联查询多个结果集
	 * @param clazz 目标字节码文件
	 * @param sql 自拟查询语句
	 * @return 返回结果集对象
	 */
	public static <T>List<T> getBeanListRunsql(Class<T> clazz,String sql){
		connecion=C3P0UTils.getConnection();
		try {
			return queryRunner.query(connecion, sql, new BeanListHandler<T>(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			printSql(sql);
			try {
				connecion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * 打印操作的sql语句 方便 改错开发
	 * @param sql
	 */
	public static void printSql(String sql) {
		System.out.println("Rc_long:" + sql);
	}
}
