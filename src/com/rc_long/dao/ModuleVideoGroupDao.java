package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.VideoGroup;
import com.rc_long.dao.dataSource.QueryCondition;

public interface ModuleVideoGroupDao {
	
	public List<VideoGroup> getGroupList(String hql,Object []obj);

	public VideoGroup getGroupById(String group_id);

	public int getCount(QueryCondition queryCondition);

	public void save(VideoGroup videoGroup);

	public void update(VideoGroup videoGroup);

	public void delete(String hql);
}
	
