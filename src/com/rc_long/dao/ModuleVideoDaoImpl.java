package com.rc_long.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.Comment;
import com.rc_long.Entity.SysVideo;

@Component
public class ModuleVideoDaoImpl implements ModuleVideoDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session session;

	private Transaction tran;

	private Query query;

	@SuppressWarnings("unchecked")
	@Override
	public List<SysVideo> getVideoList(String hql, Object[] obj, int begin,
			int max) {
		session = sessionFactory.openSession();
		query = session.createQuery(hql);

		for (int i = 0; i < obj.length; i++) {
			query.setParameter(i, obj[i]);
		}
		query.setFirstResult(begin);
		query.setMaxResults(max);
		List<SysVideo> list = null;
		try {
			list = query.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public SysVideo getVideoById(String video_id) {
		session = sessionFactory.openSession();
		SysVideo sysVideo = (SysVideo) session.get(SysVideo.class, video_id);
		//判断该视频是否审核 是否公开
		@SuppressWarnings("unchecked")
		List<Comment> list  = session.createFilter(sysVideo.getCommentList(), "order by comment_id").setFirstResult(0).setMaxResults(5).list();
		sysVideo.setCommentList(list);
		return sysVideo;
	}
}
