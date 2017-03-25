package com.rc_long.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.VideoType;
import com.rc_long.dao.ModuleVideoTypeDao;
import com.rc_long.service.ModuleVideoTypeService;
import com.rc_long.utils.JedisUtils;
@Component
public class ModuleVideoTypeServiceImpl implements ModuleVideoTypeService {
	
	@Autowired
	private ModuleVideoTypeDao moduleVideoTypeDao;
	@Override
	public List<VideoType> getVideoType(int begin, int max,boolean fromCach,String cachName) {
		List<VideoType> list =null;
		
		if(fromCach){
			list = JedisUtils.getObject(cachName);
		}
		if(list == null){
			String hql  = "FROM VideoType as v ORDER BY v.video_type_id ASC ";
			Object [] obj = {};
			list = moduleVideoTypeDao.getVideoType(hql, obj, begin, max);
			if(list!=null){
				JedisUtils.saveObject(cachName, list);
			}
		}
		return list;
	}

}
