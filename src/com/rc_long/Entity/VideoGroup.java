package com.rc_long.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;

/**
 * 视频分组表
 * @author Administrator
 *
 */
@RcLongTable(name=TableName.VideoGroup)
@Entity
@Table(name="video_group")
public class VideoGroup  extends EntitiBaseBean<VideoGroup>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String group_id;
	
	private String group_name;
	
	private String group_pid = "0";
	
	private Integer group_watchers;
	
	private String group_img;

	private String group_desc;//分组描述

	private String group_type;
	
	private Date group_create_time;
	
	@OneToMany(mappedBy="videoGroup",cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<SysVideo> videoList;

	

	public String getGroup_desc() {
		return group_desc;
	}

	public void setGroup_desc(String group_desc) {
		this.group_desc = group_desc;
	}

	public String getGroup_type() {
		return group_type;
	}

	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}

	public Date getGroup_create_time() {
		return group_create_time;
	}

	public void setGroup_create_time(Date group_create_time) {
		this.group_create_time = group_create_time;
	}

	public List<SysVideo> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<SysVideo> videoList) {
		this.videoList = videoList;
	}

	public Integer getGroup_watchers() {
		return group_watchers;
	}

	public void setGroup_watchers(Integer group_watchers) {
		this.group_watchers = group_watchers;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public String getGroup_img() {
		return group_img;
	}

	public void setGroup_img(String group_img) {
		this.group_img = group_img;
	}

	public String getGroup_pid() {
		return group_pid;
	}

	public void setGroup_pid(String group_pid) {
		this.group_pid = group_pid;
	}
	
}
