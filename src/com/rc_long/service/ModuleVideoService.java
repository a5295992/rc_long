package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.SysVideo;

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
}
