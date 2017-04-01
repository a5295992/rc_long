package com.rc_long.service;


import com.rc_long.Entity.Comment;
import com.rc_long.Entity.ReComment;
import com.rc_long.utils.Pager;

public interface CommentService {
	
	
	public Pager<Comment> getComentList(String video_id, int i, int j,int pageNum);

	public void save(Comment commmet);

	public void save(ReComment commmet);

	public Comment getCommentById(String id);

	public void update(Comment commmet);
}
