package com.rc_long.ThreadPool.task.service.impl;

import java.util.Map;

import com.mysql.jdbc.StringUtils;

public class ServiceUtils {

	public static void getMap(Map<String, String> map) {
		
		String order = map.get("order");
		
		String orderBy = map.get("orderBy");
		
		if(bothHaveValue(order,orderBy)){
			String order_orderBy = " "+orderBy+" "+order;
			map.remove(order);
			map.remove(orderBy);
			map.put("order", order_orderBy);
		}else{
			map.remove(order);
			map.remove(orderBy);
		}
		
		String like = map.get("like");

		String likeName = map.get("likeName");
		
		if(bothHaveValue(like,likeName)){
			String like_likeName = " "+likeName+" like '%"+like+"%'";
			map.remove(like);
			map.remove(likeName);
			map.put("like", like_likeName);
		}else{
			map.remove(like);
			map.remove(likeName);
		}
	}
	private static boolean bothHaveValue(String one, String two) {
		if(!StringUtils.isNullOrEmpty(one)){
			if(!StringUtils.isNullOrEmpty(two)){
				return true;
			}
		}
		return false;
	}

	public static int getPageCount(Map<String, String> map,Object defaul) {
		
		return 0;
	}
	
	public static int getPageCount(Map<String, String> map) {
		int pageCount = 0;
		try {
			return Integer.parseInt(map.get("pageCount"));
		} catch (Exception e) {
			pageCount=10;
		}
		return pageCount;
	}

	public static int getPageNum(Map<String, String> map,Object defaul) {
		return 0;
	}
	
	
	public static int getPageNum(Map<String, String> map) {
		int pageNum = 0;
		try {
			return Integer.parseInt(map.get("pageNum"));
		} catch (Exception e) {
			pageNum=0;
		}
		return pageNum;
	}

}
