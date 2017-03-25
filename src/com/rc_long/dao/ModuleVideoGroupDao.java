package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.VideoGroup;

public interface ModuleVideoGroupDao {
	
	public List<VideoGroup> getGroupList(String hql,Object []obj);

	public VideoGroup getGroupById(String group_id);
}
