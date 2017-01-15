package com.rc_long.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import com.rc_long.Entity.SysUser;

/*public class JedisTest {
 public static void main(String[] args) {
 Jedis jedis = new Jedis("localhost", 6379);
 jedis.auth("123456");
 System.out.println(jedis);
 jedis.append("nameLong", "liong");
 System.out.println(jedis.get("nameLong"));
 }
 }*/

public class JedisTest {

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

	/**
	 * 
	 * 测试jedis池方法
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		Jedis jedis = getJedisObject();// 获得jedis实例

		// 获取jedis实例后可以对redis服务进行一系列的操作
		jedis.set("name", "zhuxun");

		System.out.println(jedis.get("name"));

		jedis.del("name");
		SysUser su= new SysUser();
		su.setUser_name("along");
		 ByteArrayOutputStream bos = new ByteArrayOutputStream();
		 ObjectOutputStream obj= new ObjectOutputStream(bos);
		 
		 obj.writeObject(su);
		byte[] arr=  bos.toByteArray();
		jedis.set("sysUser".getBytes(), arr);
		
		byte[] arr2 =  jedis.get("sysUser".getBytes());
		
		ByteArrayInputStream bis = new ByteArrayInputStream(arr2);
        ObjectInputStream inputStream = new ObjectInputStream(bis);
        
        SysUser readObject = (SysUser) inputStream.readObject();
        
        System.out.println(readObject.getUser_name());
		recycleJedisOjbect(jedis); // 将 获取的jedis实例对象还回迟中
	}

}
