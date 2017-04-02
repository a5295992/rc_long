package com.rc_long.dao;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.Comment;
import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.dataSource.HQLCostants;
import com.rc_long.dao.impl.Daoutils;
import com.rc_long.utils.SessionUtils;

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

	@SuppressWarnings("unchecked")
	@Override
	public SysVideo getVideoById(String video_id) {
		
		session = sessionFactory.openSession();
		
		SysVideo  sysVideo = (SysVideo) session.get(SysVideo.class, video_id);
		List<Comment> list  =null ;	
		if(sysVideo.getCommentList()!=null){
			list  = session.createFilter(sysVideo.getCommentList(), "order by comment_id").setFirstResult(0).setMaxResults(5).list();
		}
		if(list != null){
			sysVideo.setCommentList(list);
		}
		return sysVideo;
	}

	@Override
	public Integer getVideoCount() {
		String hql = HQLCostants.getALL("sys_video");
		
		session = SessionUtils.getSession(sessionFactory);
		
		
		BigInteger count = (BigInteger) session.createSQLQuery(hql).uniqueResult();
		Integer in = count.intValue();
		return in;
	}

	@Override
	public void update(String sql, Object[] objects) {
		DateBaseNew.update(SysVideo.class, sql, objects);
		
	}
	
	public static void main(String[] args) {
		new ModuleVideoDaoImpl().update("update sys_video set video_path=? where video_id=?", new Object[]{"222","10001"});
	}

	@Override
	public void update(SysVideo sysVideo) {
		try {
			Daoutils.updateBean(sessionFactory, sysVideo);
		} catch (Exception e) {
			Daoutils.updateMerge(sessionFactory,sysVideo);
		}
	}

	@Override
	public void save(SysVideo sysVideo) {
		
		session = SessionUtils.getSession(sessionFactory);
		Daoutils.saveBean(sessionFactory, sysVideo);
	}

	@Override
	public String update_map(String hql, Map<String, Object> map) {
		
		try {
			Daoutils.updateMap(sessionFactory,hql,map);
			return "1";
		} catch (Exception e) {
			
			e.printStackTrace();
			return "0";
		}
		
	}

	@Override
	public void updateOrSave(SysVideo sysVideo) {
		
		Daoutils.saveOrupdate(sessionFactory, sysVideo);
		
	}
	
}
