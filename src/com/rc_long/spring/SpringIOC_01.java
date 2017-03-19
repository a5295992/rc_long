package com.rc_long.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOC_01 {
	private final static String xmlpath= "/com/rc_long/resouces/spring.xml";

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  cml =  new ClassPathXmlApplicationContext(xmlpath);
		
		cml.getBean("user");
		/*User u = new User();
		
		u.setUser_age(10);
		
		u.setUser_id(UUID.randomUUID().toString().replace("-", ""));
		
		u.setUser_name("����");
		userDao.save(u);*/
	}
}
