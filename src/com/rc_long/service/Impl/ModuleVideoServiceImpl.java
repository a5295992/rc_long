package com.rc_long.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.ModuleVideoDao;
import com.rc_long.dao.dataSource.HQLCostants;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.utils.JedisUtils;
import com.rc_long.utils.Pager;

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
		
		
		return sysVideo;
	}


	@Override
	public Pager<SysVideo > getVideoList(int begin, int max) {
		
		int count = moduleVideoDao.getVideoCount();
		
		Pager<SysVideo> videoPager  = new Pager<SysVideo>(max,count,begin);
		
		String hql ="FROM SysVideo as s";
		Object[] obj = {};
		List<SysVideo> list  = moduleVideoDao.getVideoList(hql , obj , videoPager.getStart(), max);
		
		videoPager.setList(list);
		
		return videoPager;
	}


	@Override
	public Pager<SysVideo> getVideoList(QueryCondition queryCondition) {
		int count = moduleVideoDao.getVideoCount();
		String HQL =HQLCostants.getSQL(queryCondition);
		Pager <SysVideo> perger = new Pager<SysVideo>(queryCondition.getMax(),count,queryCondition.getPageNum());
		
		List<SysVideo> list = moduleVideoDao.getVideoList(HQL, queryCondition.getObj(), perger.getStart(), queryCondition.getMax());
		perger.setList(list);
		
		return perger;
	}


	@Override
	public String update(String video_id, String resource_name) {
		String sql = "update sys_video set video_path=? where video_id=?";
		String message="success";
		try {
			moduleVideoDao.update(sql,new Object[]{resource_name,video_id});
		} catch (Exception e) {
			message=e.getMessage().substring(0, 10);
			e.printStackTrace();
		}
		
		return message;
	}


	@Override
	public void update(SysVideo sysVideo) {
			moduleVideoDao.update(sysVideo);
	}


	@Override
	public void save(SysVideo sysVideo) {
		
		try {
			moduleVideoDao.save(sysVideo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataAccessResourceFailureException("操作失败");
		}
		
	}


	@Override
	public String updateGroupId(String group_id, String in_videos) {
		
		String hql = "UPDATE SysVideo SET group_id =:group_id WHERE video_id IN "+in_videos;
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("group_id", group_id);
		
		return moduleVideoDao.update_map(hql,map);
	}

}
