package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.VideoGroup;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.Pager;

public interface ModuleGroupService {

	public List<VideoGroup> getVideoGroupList(boolean b, String string);

	public VideoGroup getVideoGroupByTyId(boolean fromCach,String cachName,String  group_id);
	/**
	 * 获取 视频分组的分页对象
	 * @param queryCondition
	 * @return
	 */
	public Pager<VideoGroup> getPager(QueryCondition queryCondition);

	public void save(VideoGroup videoGroup);

	public void update(VideoGroup videoGroup);
	
	/**
	 * 批量删除
	 * @param group_ids
	 * @return
	 */
	public String delete(String group_ids);
}
