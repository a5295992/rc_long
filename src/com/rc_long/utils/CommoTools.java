package com.rc_long.utils;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.ResourceBean;
import com.rc_long.Entity.ShiroUser;

public class CommoTools {

	public static void saveFile(BufferedInputStream buf, BufferedOutputStream os)
			throws IOException {
		int len = 0;
		byte[] by = new byte[1024];
		while ((len = buf.read(by, 0, 1024)) != -1) {
			os.write(by, 0, len);
		}
		buf.close();
		os.close();
	}

	public static Map<String, Object> beanToMap(ResourceBean resource) {
		Map<String, Object> objectAsMap = new HashMap<String, Object>();
		BeanInfo info;
		try {
			info = Introspector.getBeanInfo(resource.getClass());
			for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
				Method reader = pd.getReadMethod();
				if (reader != null)
					objectAsMap.put(pd.getName(), reader.invoke(resource));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectAsMap;
	}

	/**
	 * 用ffemp 截图缩略图
	 * 
	 * @param path
	 */
	public static void screenPNG(String path, String resource_path,
			String fileName) {
		Encoder encoder = new Encoder();

		try {
			encoder.getImage(new File(path), new File(resource_path + "/"
					+ fileName + ".PNG"), 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EncoderException e) {
			e.printStackTrace();
		}
	}

	// 2545624810894a86bc129aa6d9ecd6d1,395cf22219094b7d95a8b6fd8c4b154a,af473add31f04bdc87e4e7527bd1a216,b31ae9202b014bd3879b6d797a5d792d)
	public static String addHot(String inCondition) {
		String[] inArr = inCondition.split(",");
		StringBuilder sb = new StringBuilder();
		for (String string : inArr) {
			String newString = "'" + string + "'";
			sb.append(newString);
			sb.append(",");
		}
		return ReqUtils.dealData(sb.toString());
	}

	public static String getUUID() {
		
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static void setValues(Object[] obj, Query query) {
		for (int i = 0; i < obj.length; i++) {
			query.setParameter(i, obj[i]);
		}
		// TODO Auto-generated method stub
		
	}

	public static boolean isAllNotEmpty(String ...strings) {
		for (int i = 0; i < strings.length; i++) {
			if(StringUtils.isNullOrEmpty(strings[i])){
				return false;
			}
		}
		return true;
	}
	
	public static String  getDateTimerFiled(Date date) {
		
		@SuppressWarnings("deprecation")
		int h = date.getHours();
		
		if(h<13&&h>5){
			return "上午";
		}else if(h<5&&h>0){
			return "凌晨";
		}else if(h>13&&h<18){
			return "下午";
		}else{
			return "晚上";
		}
	}

	public static boolean ifAuth(HttpServletRequest req) {
		ShiroUser user = new CurrentSession(req).getShiroUser();
		if(user!=null&&user.getUser_type()==1){
			return true;
		}
		return false;
	}
}
