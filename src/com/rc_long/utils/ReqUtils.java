package com.rc_long.utils;

import java.io.UnsupportedEncodingException;

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
}
