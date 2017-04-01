package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.Comment;
import com.rc_long.Entity.ReComment;

public interface CommentDao {
	/**
	 * 获取总数
	 * @param hql
	 * @param obj
	 * @return
	 */
	public int getCount(String hql, Object[] obj);
	/**
	 * 获取 评论的 分页对象
	 * @param hql
	 * @param obj
	 * @param begin
	 * @param max
	 * @return
	 */
	public List<Comment> getCommentList(String hql, Object[] obj, int begin,
			int max);
	/**
	 * 保存对象
	 * @param commmet
	 */
	public void save(Comment commmet);
	
	/**
	 * 保存回复 内容
	 * @param commmet
	 */
	public void save(ReComment commmet);
	/**\
	 * 
	 * @param id
	 * @return
	 */
	public Comment getComment(String id);
	
	/**
	 * 
	 * @param commmet
	 */
	public void update(Comment commmet);

}
