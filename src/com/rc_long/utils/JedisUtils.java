package com.rc_long.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import org.apache.log4j.helpers.LogLog;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.rc_long.test.JedisTest;

public class JedisUtils {
	private static JedisPool pool;

	// 静态代码初始化池配置

	static {

		try {

			Properties props = new Properties();

			props.load(JedisTest.class.getClassLoader().getResourceAsStream(
					"redis.properties"));

			// 创建jedis池配置实例

			JedisPoolConfig config = new JedisPoolConfig();
			// 设置池配置项值

			config.setMaxActive(Integer.valueOf(props
					.getProperty("jedis.pool.maxActive")));

			config.setMaxIdle(Integer.valueOf(props
					.getProperty("jedis.pool.maxIdle")));

			config.setMaxWait(Long.valueOf(props
					.getProperty("jedis.pool.maxWait")));

			config.setTestOnBorrow(Boolean.valueOf(props
					.getProperty("jedis.pool.testOnBorrow")));

			config.setTestOnReturn(Boolean.valueOf(props
					.getProperty("jedis.pool.testOnReturn")));

			// 根据配置实例化jedis池

			pool = new JedisPool(config, props.getProperty("redis.ip"),
					Integer.valueOf(props.getProperty("redis.port")));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	/** 获得jedis对象 */

	public static Jedis getJedisObject() {

		return pool.getResource();

	}

	/** 归还jedis对象 */

	public static void recycleJedisOjbect(Jedis jedis) {

		pool.returnResource(jedis);

	}

	public static <T> void saveObject(String string, T session) {

		Jedis jedis = JedisUtils.getJedisObject();

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream obj = null;
		try {
			obj = new ObjectOutputStream(bos);

			obj.writeObject(session);

			byte[] arr = bos.toByteArray();
			jedis.set(string.getBytes(), arr);

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			JedisUtils.recycleJedisOjbect(jedis);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getObject(String name) {

		Jedis jedis = JedisUtils.getJedisObject();
		byte[] arr2 = null;
		try {
			arr2 = jedis.get(name.getBytes());
			ByteArrayInputStream bis = new ByteArrayInputStream(arr2);
			ObjectInputStream inputStream = null;
			try {
				inputStream = new ObjectInputStream(bis);
			} catch (IOException e) {
				LogLog.warn("IOError");
				e.printStackTrace();
			}

			try {
				return (T) inputStream.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				JedisUtils.recycleJedisOjbect(jedis);
			}
		} catch (Exception e1) {
			LogLog.warn("cant resolve this resource because it not exit");
		}
		return null;
	}

	public static void save(String string, String string2) {
		Jedis jedis = JedisUtils.getJedisObject();
		try {
			jedis.set(string, string2);
		} finally {
			JedisUtils.recycleJedisOjbect(jedis);
		}
	}
	public static String load(String string){
		Jedis jedis = JedisUtils.getJedisObject();
		try {
			return jedis.get(string);
		} finally {
			JedisUtils.recycleJedisOjbect(jedis);
		}
	}
   //清空 资源
	public static void clear() {
		
		Jedis jedis = JedisUtils.getJedisObject();
		
		try {
			jedis.flushDB();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			
			JedisUtils.recycleJedisOjbect(jedis);
		}
	}
}
