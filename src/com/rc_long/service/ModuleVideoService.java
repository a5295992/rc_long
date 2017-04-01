package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.Pager;

/**
 * 视频信息操作类
 * @author Administrator
 *
 */
public interface ModuleVideoService {
		
	/**
	 * 根据条件查询视频信息
	 * 0 false 1 true
	 * @param string 
	 * @param b 
	 * @param cacheName 
	 */
	public List<SysVideo> getVideoListByIsRecomment(int isR,String video_type, String string, boolean b, String cacheName);

	public List<SysVideo> getVideoByTypeAndOrder(int i, String movie,
			 String movietype, String action_movie,String order);

	public SysVideo getVideoById(String video_id);
	/**
	 * 从 xx开始显示 最多xx位
	 * @param begin 
	 * @param max
	 * @return
	 */
	public Pager<SysVideo> getVideoList(int begin, int max);
	
	public Pager<SysVideo> getVideoList(QueryCondition QueryCondition);

	public String update(String video_id, String resource_name);

	public void update(SysVideo sysVideo);

	public void save(SysVideo sysVideo);	
	/**
	 * 暂时没想到 好的方法去解决 in(ds,dsd,sd)
	 * @param changes 更改的字段 sql
	 * @param in_videos
	 * @return
	 */
	public String updateGroupId(String changes, String in_videos);
	
}
