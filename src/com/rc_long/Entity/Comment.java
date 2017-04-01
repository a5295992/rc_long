package com.rc_long.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment extends EntitiBaseBean<Comment>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	private String comment_id;
	
	
	//评论内容
	private String text;
	//评论时间
	private Date date;
	
	public List<ReComment> getReComment() {
		return reComment;
	}

	public void setReComment(List<ReComment> reComment) {
		this.reComment = reComment;
	}

	private String video_id;
	
	private String user_id;
	//回复
	@OneToMany(cascade=CascadeType.ALL,targetEntity=ReComment.class,mappedBy="comment")
	private List<ReComment> reComment;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	private SysUser sysUser;
	
	

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="video_id",insertable=false,updatable=false)
	private SysVideo sysVideo;
	
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	
	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}




	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysVideo getSysVideo() {
		return sysVideo;
	}

	public void setSysVideo(SysVideo sysVideo) {
		this.sysVideo = sysVideo;
	}

}
