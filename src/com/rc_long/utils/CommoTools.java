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
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.ResourceBean;
import com.rc_long.Entity.ShiroUser;
import com.rc_long.Exception.FileNameNotCorrectException;
import com.rc_long.enumeration.ResourceType;

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
		fileName = removeDot(fileName);
		Encoder encoder = new Encoder();

		try {
			encoder.getImage(new File(path), new File(resource_path + "/"
					+ fileName + ".jpg"), 1);
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
	/**
	 * 
	 * @param obj
	 * @param query
	 */
	public static void setValues(Object[] obj, Query query) {
		for (int i = 0; i < obj.length; i++) {
			query.setParameter(i, obj[i]);
		}

	}
	/**
	 * 设置
	 * @param map
	 * @param query
	 */
	public static void setValues(Map<String, Object> map, Query query) {

		for (Entry<String, Object> iterable_element : map.entrySet()) {
			query.setParameter(iterable_element.getKey(),
					iterable_element.getValue());
		}

	}

	public static boolean isAllNotEmpty(String... strings) {
		for (int i = 0; i < strings.length; i++) {
			if (StringUtils.isNullOrEmpty(strings[i])) {
				return false;
			}
		}
		return true;
	}

	public static String getDateTimerFiled(Date date) {

		@SuppressWarnings("deprecation")
		int h = date.getHours();

		if (h < 13 && h > 5) {
			return "上午";
		} else if (h < 5 && h > 0) {
			return "凌晨";
		} else if (h > 13 && h < 18) {
			return "下午";
		} else {
			return "晚上";
		}
	}

	public static boolean ifAuth(HttpServletRequest req) {
		ShiroUser user = new CurrentSession(req).getShiroUser();
		if (user != null && user.getUser_type() == 1) {
			return true;
		}
		return false;
	}

	/**
	 * 根据 给出的名字 判断是以什么结尾 从而判断是否是某类型文件
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public static int reSourceType(String name) throws Exception {
		// 文件在上传的时候应该进行 筛选 不能有. /等 特殊符号

		String arr[] = name.split("\\.");
		System.out.println(Arrays.toString(arr));
		if (arr.length == 2) {
			String fileType = arr[1].toLowerCase();
			if (fileType.endsWith("mp4")) {
				return ResourceType.video;
			} else if (fileType.endsWith("mp3")) {
				return ResourceType.audio;
			} else if (fileType.endsWith("flv")) {
				return ResourceType.flv;
			} else if (fileType.endsWith("txt")) {
				return ResourceType.txt;
			} else if (fileType.endsWith("doc")) {
				return ResourceType.doc;
			} else if (fileType.endsWith("jpg")) {
				return ResourceType.photo;
			} else if (fileType.endsWith("png")) {
				return ResourceType.photo;
			} else {
				return ResourceType.other;
			}
		} else {
			throw new FileNameNotCorrectException("不合法的文件名");
		}
	}

	public static void main(String[] args) {
		System.out.println(rePlace_("ddsada\\sdadas\\asd\\", "\\", "/"));
	}

	private static String removeDot(String string) {

		if (string.split("\\.").length > 1) {
			return string.split("\\.")[0];
		}
		return string;

	}

	public static java.sql.Date getTime() {
		return new java.sql.Date(new Date().getTime());
	}

	/**
	 * 替换符号\ 为/
	 * 
	 * @param string1
	 * @param string
	 * @param string2
	 */
	public static String rePlace_(String string1, String string, String string2) {

		return string1.replace(string, string2);

	}

}
