package com.rc_long.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.VideoGroup;
import com.rc_long.dao.ModuleVideoGroupDao;
import com.rc_long.dao.dataSource.HQLCostants;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.service.ModuleGroupService;
import com.rc_long.utils.JedisUtils;
import com.rc_long.utils.Pager;

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
			if(videoGroup != null&&!StringUtils.isNullOrEmpty(cachName)){
				JedisUtils.saveObject(cachName, videoGroup);
			}
		}
		return videoGroup;
	}
	@Override
	public Pager<VideoGroup> getPager(QueryCondition queryCondition) {
		
		int count  = moduleVideoGroupDao.getCount(queryCondition);
		
		Pager<VideoGroup> pager = new Pager<VideoGroup>(queryCondition.getMax(),count,queryCondition.getPageNum());
		
		String hql = HQLCostants.getSQL(queryCondition);
		List<VideoGroup> list = moduleVideoGroupDao.getGroupList(hql, queryCondition.getObj());
		
		pager.setList(list);
		return pager;
	}
	
	
	@Override
	public void save(VideoGroup videoGroup) {
		
		
		moduleVideoGroupDao.save(videoGroup);
	}
	@Override
	public void update(VideoGroup videoGroup) {
		
		moduleVideoGroupDao.update(videoGroup);
	}
	
	
	@Override
	public String delete(String group_ids) {
		String hql = "DELETE VideoGroup WHERE group_id IN "+group_ids;
		try {
			moduleVideoGroupDao.delete(hql);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
}
