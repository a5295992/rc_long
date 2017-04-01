package com.rc_long.dao.impl;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.VideoGroup;
import com.rc_long.dao.ModuleVideoGroupDao;
import com.rc_long.dao.dataSource.HQLCostants;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.SessionUtils;

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

	@Override
	public int getCount(QueryCondition queryCondition) {
		session = SessionUtils.getSession(sessionFactory);
		String hql = HQLCostants.getALL(queryCondition);
		
		SQLQuery sql = session.createSQLQuery(hql);
		CommoTools.setValues(queryCondition.getObj(), sql);
		BigInteger b = (BigInteger) sql.uniqueResult();
		
		return b.intValue();
	}

	@Override
	public void save(VideoGroup videoGroup) {
		Daoutils.saveBean(sessionFactory, videoGroup);
	}

	@Override
	public void update(VideoGroup videoGroup) {
		Daoutils.updateMerge(sessionFactory, videoGroup);
	}

	@Override
	public void delete(String hql) {
		
		
		Daoutils.delete(sessionFactory,hql);
		
	}

}
