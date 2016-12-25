package com.rc_long.action.base;

import java.util.List;
import java.util.Map;

import com.rc_long.utils.Pager;

public interface BaseService<T> {
	
	public Pager<T> getPager(Map<String,String> map);
	
	public  T getSingle(Map<String,String> map);

	public int updateSingle(Map<String,Object> map);
	
	public int updateWhole(List<Map<String,Object>> all);
	
	public int insertSingle(Map<String, Object> map);
	
	public int insertWhole(List<Map<String, Object>> all);
	
	public int deleteSingle(Map<String, Object> map);
	
	public int deleteWhole(List<Map<String, Object>> all);
}
