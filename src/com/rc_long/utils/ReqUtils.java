package com.rc_long.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.helpers.LogLog;

public class ReqUtils {

	 public static  void Encoding(HttpServletRequest req){
		 try {
			req.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			LogLog.error("字符编码设置异常");
		}
	 }

	public static Map<String, String> parseSearch(Map<String, String> map, HttpServletRequest req) {
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

	public static Map<String, String> parseUpdate(Map<String, String> map,
			HttpServletRequest req) {
				return map;
		
	}
}
