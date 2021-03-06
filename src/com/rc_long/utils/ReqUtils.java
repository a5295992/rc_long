package com.rc_long.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.helpers.LogLog;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.SysVideo;

public class ReqUtils {

	public static void Encoding(HttpServletRequest req) {
		try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			LogLog.error("字符编码设置异常");
		}
	}

	public static Map<String, String> parseSearch(Map<String, String> map,
			HttpServletRequest req) {
		String pageCount = req.getParameter("pageCount");
		String pageNum = req.getParameter("pageNum");
		// 更新字段
		String orderBy = req.getParameter("orderBy");
		String order = req.getParameter("order");
		String condition = "";
		String likeName = req.getParameter("likeName");
		String like = req.getParameter("like");
		map.put("pagerCount", pageCount);
		map.put("pageNum", pageNum);
		map.put("orderBy", orderBy);
		map.put("order", order);
		map.put("condition", condition);
		map.put("likeName", likeName);
		map.put("like", like);
		return map;
	}

	public static <T> Map<String, Object> parseUpdate(Map<String, Object> map,
			HttpServletRequest req, Class<T> class1) {

		Field[] f = class1.getDeclaredFields();// 获取实体类参数
		if (f != null && f.length > 0) {
			for (Field field : f) {
				//获取实体类名
				String fieldName = field.getName();
				//从请求域获取值
				String filedValue = req.getParameter(fieldName);
				if (!StringUtils.isNullOrEmpty(filedValue)) {
					map.put(fieldName, filedValue);
				}
			}
		}
		return map;
	}
	/**
	 * 将字符串转为数组
	 * @param data_id
	 * @return
	 */
	public static String  dealData(String data_id) {
		if(!StringUtils.isNullOrEmpty(data_id)){
			data_id = data_id.substring(0, data_id.length()-1);
			return data_id;
		}else{
			return "";
		}
	}
}
