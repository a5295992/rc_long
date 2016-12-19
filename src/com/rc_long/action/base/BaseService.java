package com.rc_long.action.base;

import java.util.Map;

import com.rc_long.utils.Pager;

public interface BaseService<T> {
	
	
	public Pager<T> getPager(Map<String,String> map);
	
	
	public  T getSingle(Map<String,String> map);
	

	public int updateSingle(Map<String,String> map);
	
	public int updateWhole(Map<String,String> map);
	
	public int insertSingle(Map<String,String> map);
	
	public int insertWhole(Map<String,String> map);
	
	public int deleteSingle(Map<String,String> map);
	
	public int deleteWhole(Map<String,String> map);
	
}
