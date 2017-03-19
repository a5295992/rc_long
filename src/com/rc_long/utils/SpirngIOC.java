package com.rc_long.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.rc_long.test.HibenateDataJHelper;

public class SpirngIOC {
	//spring.xml路径
	private static final String xml_path = "/com/rc_long/resouces/spring.xml";
	
	private static ClassPathXmlApplicationContext cla;
	
	/**
	 * 获取 classPath Context 对象
	 * @return
	 */
	public static ClassPathXmlApplicationContext getClassXmlapp(){
		
		if(cla==null){
			return new ClassPathXmlApplicationContext(xml_path);
		}
		return cla;
	}
	
	public static HibenateDataJHelper getBeanById(String string) {
		
		cla = getClassXmlapp();
		
		return (HibenateDataJHelper) cla.getBean(string);
	}

}
