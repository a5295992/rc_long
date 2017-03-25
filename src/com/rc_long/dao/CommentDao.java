package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.Comment;

public interface CommentDao {

	public int getCount(String hql, Object[] obj);

	public List<Comment> getCommentList(String hql, Object[] obj, int begin,
			int max);

}
