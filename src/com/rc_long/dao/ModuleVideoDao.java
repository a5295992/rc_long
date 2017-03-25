package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.SysVideo;

public interface ModuleVideoDao {

	
	public List<SysVideo> getVideoList(String hql,Object [] obj, int i, int j);

	public SysVideo getVideoById(String video_id);
}
