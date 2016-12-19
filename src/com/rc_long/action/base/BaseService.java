package com.rc_long.action.base;

import java.util.List;
import java.util.Map;

import com.rc_long.utils.Pager;

public interface BaseService<T> {
	
	public Pager<T> getPager(Map<String,String> map);
	
	public  T getSingle(Map<String,String> map);

	public int updateSingle(Map<String,String> map);
	
	public int updateWhole(List<T> all);
	
	public int insertSingle(T T);
	
	public int insertWhole(List<T> all);
	
	public int deleteSingle(Map<String,String> map);
	
	public int deleteWhole(List<T> all);
}
