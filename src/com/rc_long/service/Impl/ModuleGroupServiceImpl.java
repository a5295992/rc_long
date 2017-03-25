package com.rc_long.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.VideoGroup;
import com.rc_long.dao.ModuleVideoGroupDao;
import com.rc_long.service.ModuleGroupService;
import com.rc_long.utils.JedisUtils;

@Component
public class ModuleGroupServiceImpl implements ModuleGroupService {
	@Autowired
	private ModuleVideoGroupDao moduleVideoGroupDao;
	@Override
	public List<VideoGroup> getVideoGroupList(boolean fromCach,String cachName) {
		
		List<VideoGroup> list = null;
		
		if(fromCach){
			list  = JedisUtils.getObject(cachName);
		}
		if(list==null){
			String hql = "FROM VideoGroup v ORDER BY v.group_watchers ASC LIMIT '0','5'";
			list  = moduleVideoGroupDao.getGroupList(hql, new Object[]{});
			if(list != null){
				JedisUtils.saveObject(cachName, list);
			}
		}
		return list;
	}
	@Override
	public VideoGroup getVideoGroupByTyId(boolean fromCach,String cachName,String  group_id) {
		
		VideoGroup videoGroup = null;
		
		if(fromCach){
			videoGroup  = JedisUtils.getObject(cachName);
		}
		if(videoGroup==null){
			videoGroup  = moduleVideoGroupDao.getGroupById(group_id);
			if(videoGroup != null){
				JedisUtils.saveObject(cachName, videoGroup);
			}
		}
		return videoGroup;
	}

}
