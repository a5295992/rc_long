package com.rc_long.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.Comment;
import com.rc_long.Entity.ReComment;
import com.rc_long.dao.CommentDao;
import com.rc_long.utils.Pager;

@Component
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao  commentDao;
	@Override
	
	public Pager<Comment> getComentList(String video_id,int begin,int max,int pageNum) {
		String hql = "FROM Comment as c WHERE c.video_id =?";
		Object []obj ={video_id};
		int count = commentDao.getCount(hql,obj);
		Pager<Comment> pager = new Pager<Comment>(max,count,pageNum);
		
		List<Comment> list = commentDao.getCommentList(hql,obj,begin,max);
		pager.setList(list);
		return pager;
	}
	@Override
	public void save(Comment commmet) {
		
		commentDao.save(commmet);
	}
	@Override
	public void save(ReComment commmet) {
		
		
		commentDao.save(commmet);
	}
	@Override
	public Comment getCommentById(String id) {
		
		
		return commentDao.getComment(id);
	}
	@Override
	public void update(Comment commmet) {
		
		commentDao.update(commmet);
		
	}

}
