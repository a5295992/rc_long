package com.rc_long.service.video;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.rc_long.Entity.SysVideo;
import com.rc_long.utils.Pager;

@Service
public interface VideoService {
	
	public Pager<SysVideo> getVideoPager(Map<String,Object> map);
	
	public SysVideo getVideo(Map<String,Object>map);
	
	public int updateVideo(Map<String,Object>map,Map<String,Object>conditon);
	
	public int deleteVideo(Map<String,Object>map);
	/**
	 * 创建视频信息
	 * @param map 添加视频必须的字段
	 * @return 返回int -1 代表不成功 大于0代表成功
	 */
	public int createVideo(Map<String,Object>map);
}
