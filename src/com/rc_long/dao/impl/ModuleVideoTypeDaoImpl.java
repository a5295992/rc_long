package com.rc_long.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.VideoType;
import com.rc_long.dao.ModuleVideoTypeDao;
import com.rc_long.utils.CommoTools;

@Component
public class ModuleVideoTypeDaoImpl implements ModuleVideoTypeDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	private Query query;
	private Transaction tran;
	@SuppressWarnings("unchecked")
	@Override
	public List<VideoType> getVideoType(String hql, Object[] obj,int begin,int max) {
		session = sessionFactory.openSession();
		
		query = session.createQuery(hql);
		CommoTools.setValues(obj,query);
		List<VideoType> list= null;
		
		try {
			list=query.list();
			for (VideoType videoType : list) {
				List<SysVideo> list2 = session.createFilter(videoType.getVideoList(), "order by video_id")
				.setFirstResult(begin)
				.setMaxResults(max).list();
				videoType.setVideoList(list2);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return list;
	}

}
