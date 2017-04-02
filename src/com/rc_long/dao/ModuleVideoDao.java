package com.rc_long.dao;

import java.util.List;
import java.util.Map;

import com.rc_long.Entity.SysVideo;

public interface ModuleVideoDao {

	
	public List<SysVideo> getVideoList(String hql,Object [] obj, int i, int j);
	
	public SysVideo getVideoById(String video_id);
	/**
	 * 不给参数  默认查询所有视频数目
	 * @return
	 */
	public Integer getVideoCount();

	public void update(String sql, Object []obj);

	public void update(SysVideo sysVideo);

	public void save(SysVideo sysVideo);
	
	/**
	 * @param sql 写好的hql
	 * @param map 配合 name=:name 语法形式 
	 */
	public String update_map(String hql ,Map<String,Object>map);

	public void updateOrSave(SysVideo sysVideo);
}
