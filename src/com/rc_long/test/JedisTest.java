package com.rc_long.test;

import redis.clients.jedis.Jedis;

public class JedisTest {
		public static void main(String[] args) {
			Jedis jedis = new Jedis("192.168.17.128", 6379);
			jedis.auth("123");
			System.out.println(jedis);
			jedis.append("nameLong", "liong");
			System.out.println(jedis.get("nameLong"));
		}
}
