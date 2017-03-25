package com.rc_long.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.VideoGroup;
import com.rc_long.dao.ModuleVideoGroupDao;

@Component
public class ModuleVideoGroupDaoImpl implements ModuleVideoGroupDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private  Session session;
	
	private Query query;
	
	@Override
	public List<VideoGroup> getGroupList(String hql, Object[] obj) {
		session = sessionFactory.openSession();
		query = session.createQuery(hql);
		
		for (int i = 0; i < obj.length; i++) {
			query.setParameter(i, obj[i]);
		}
		query.setFirstResult(0);
		query.setMaxResults(11);
		
		List<VideoGroup> list = query.list();
		
		for (VideoGroup videoGroup : list) {
			List<SysVideo> list2 = session.createFilter(videoGroup.getVideoList(),"order by video_id").setFirstResult(0).setMaxResults(11).list();
			videoGroup.setVideoList(list2);
		}
		return list;
	}

	@Override
	public VideoGroup getGroupById(String  group_id) {
		session = sessionFactory.openSession();
		VideoGroup videoGroup = (VideoGroup) session.get(VideoGroup.class, group_id);
		
		List <SysVideo> list = session.createFilter(videoGroup.getVideoList(),"order by video_id").setFirstResult(0).setMaxResults(8).list();
		videoGroup.setVideoList(list);
		return videoGroup;
	}

}
