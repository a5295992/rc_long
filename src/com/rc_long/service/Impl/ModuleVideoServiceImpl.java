package com.rc_long.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.ModuleVideoDao;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.utils.JedisUtils;

@Component
public class ModuleVideoServiceImpl implements ModuleVideoService {
	
	@Autowired
	private ModuleVideoDao moduleVideoDao;
	
	
	public List<SysVideo> getVideoListByIsRecomment(int isR, String video_type,String index_flag,boolean from_cache,String cacheName) {
		//是否从缓存中取对象
		List<SysVideo> list =null;
		if(from_cache){
			list = JedisUtils.getObject(cacheName);
		}
		if(list==null){
			String hql = "FROM SysVideo as s WHERE s.is_recommend=? AND s.video_type =? AND s.index_flag=?";
			Object[] obj = {isR,video_type,index_flag};
			list=moduleVideoDao.getVideoList(hql, obj,0,11);
			if(list!=null){
				JedisUtils.saveObject(cacheName, list);
			}
		}
		return list;
	}


	@Override
	public List<SysVideo> getVideoByTypeAndOrder(int i, String movie,
			String index_flag,String video_kinds,String order) {
		
		String hql = "FROM SysVideo as s WHERE s.is_recommend=? AND s.video_type =? AND s.index_flag =? AND s.video_kinds =? ORDER BY ? ASC";
		Object[] obj = {i,movie,index_flag,video_kinds,order};
		return moduleVideoDao.getVideoList(hql, obj,0,11);
	}


	@Override
	public SysVideo getVideoById(String video_id) {
		
		SysVideo sysVideo = moduleVideoDao.getVideoById(video_id);
		
		if (sysVideo != null) {
			if (sysVideo.getVideo_auth() == 0 && sysVideo.getVideo_share() == 0) {
				sysVideo = null;
			}
		}
		
		return sysVideo;
	}

}
