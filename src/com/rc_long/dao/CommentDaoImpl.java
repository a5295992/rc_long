package com.rc_long.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.Comment;
import com.rc_long.Entity.ReComment;
import com.rc_long.dao.impl.Daoutils;
import com.rc_long.utils.CommoTools;

@Component
public class CommentDaoImpl implements CommentDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private Query query;
	@Override
	public int getCount(String hql,Object [] obj) {
		session  = sessionFactory.openSession();
		query  = session.createQuery(hql);
		CommoTools.setValues(obj, query);
		return query.list().size();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getCommentList(String hql, Object[] obj, int begin,
			int max) {
		session  = sessionFactory.openSession();
		query  = session.createQuery(hql);
		
		CommoTools.setValues(obj, query);
		query.setFirstResult(begin);
		query.setMaxResults(max);
		
		List<Comment> list = query.list();
		
		for (Comment comment : list) {
			Query query2= session.createQuery("FROM ReComment as c WHERE c.comment_id =:comment_id");
			query2.setParameter("comment_id", comment.getComment_id());
			
			comment.setReComment(query2.list());
		}
		return list;
	}
	
	
	@Override
	public void save(Comment commmet) {

		Daoutils.saveBean(sessionFactory, commmet);
	}
	@Override
	public void save(ReComment commmet) {
		
		
		Daoutils.saveBean(sessionFactory, commmet);
	}
	@Override
	public Comment getComment(String id) {
		
		
		return Daoutils.getBeanById(sessionFactory, id, Comment.class);
	}
	@Override
	public void update(Comment commmet) {
		
		
		Daoutils.updateMerge(sessionFactory, commmet);
	}
}
