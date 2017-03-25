package com.rc_long.service;


import com.rc_long.Entity.Comment;
import com.rc_long.utils.Pager;

public interface CommentService {
	
	
	public Pager<Comment> getComentList(boolean reply,String video_id, int i, int j,int pageNum);
}
