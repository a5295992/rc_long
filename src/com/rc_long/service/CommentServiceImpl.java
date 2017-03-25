package com.rc_long.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.Comment;
import com.rc_long.dao.CommentDao;
import com.rc_long.utils.Pager;

@Component
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentDao  commentDao;
	@Override
	
	public Pager<Comment> getComentList(boolean reply, String video_id,int begin,int max,int pageNum) {
		String hql = "FROM Comment as c WHERE c.is_recoment=? AND c.video_id =?";
		Object []obj ={reply,video_id};
		int count = commentDao.getCount(hql,obj);
		Pager<Comment> pager = new Pager<Comment>(max,count,pageNum);
		
		List<Comment> list = commentDao.getCommentList(hql,obj,begin,max);
		pager.setList(list);
		return pager;
	}
	
	

}
