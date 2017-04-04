package com.rc_long.service;

import java.util.List;
import java.util.Map;

import com.rc_long.Entity.RePlayImg;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.Pager;

/**
 * 轮播图
 * @author Administrator
 *
 */
public interface RePlayImgService {
	
	
	public void save(RePlayImg rePlayImg);
	
	
	public void update(RePlayImg rePlayImg);
	
	
	public void dele(String re_id);
	
	public void dele(Map<String,Object> map);
	
	public RePlayImg get(String id);
	
	public Pager<RePlayImg> getPager(QueryCondition condition);
	
	
	public List<RePlayImg> getList(QueryCondition condition);


	public void saveOrUpdate(RePlayImg rePlayImg);


	public void deles(String re_ids);
}
