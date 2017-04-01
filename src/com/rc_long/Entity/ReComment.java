package com.rc_long.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 回复表
 * @author Administrator
 *
 */
@Entity
@Table(name="recomment")
public class ReComment extends EntitiBaseBean<Comment>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String reComment_id;
	//评论内容
	private String text;
	//评论时间
	private Date date;
	
	private String user_id;
	
	private String comment_id;
	
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=SysUser.class)
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	private SysUser sysUser;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=Comment.class)
	@JoinColumn(name="comment_id",insertable=false,updatable=false)
	private Comment comment;

	public String getReComment_id() {
		return reComment_id;
	}

	public void setReComment_id(String reComment_id) {
		this.reComment_id = reComment_id;
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

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	
	
}
