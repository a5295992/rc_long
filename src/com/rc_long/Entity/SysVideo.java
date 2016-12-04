package com.rc_long.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 视频实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="sys_video")
public class SysVideo extends EntitiBaseBean<SysVideo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String video_id;
	
	private String  video_name;
	
	private String video_cname;
	
	private String video_path;//视频播放路径
	
	private int group_id;
	
	private int is_recommend;//是否推荐 0 推荐 ，1 不推荐
	
	private String video_type;
	
	private String user_id;
	
	private String video_long;
	
	private Date create_time;
	
	private long video_wathers;//视频观看人数 播放次数
	
	private int video_status;//视频状态， 0为成功 1为失败
	
	private int video_auth;// 0 代表审核  1.未审核
	
	private int video_share; //0 代表 公开观看，1 代表登录观看，2，代表Vip观看

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_cname() {
		return video_cname;
	}

	public void setVideo_cname(String video_cname) {
		this.video_cname = video_cname;
	}

	public String getVideo_path() {
		return video_path;
	}

	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}

	public int getGroup_id() {
		return group_id;
	}

	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getIs_recommend() {
		return is_recommend;
	}

	public void setIs_recommend(int is_recommend) {
		this.is_recommend = is_recommend;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getVideo_long() {
		return video_long;
	}

	public void setVideo_long(String video_long) {
		this.video_long = video_long;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public long getVideo_wathers() {
		return video_wathers;
	}

	public void setVideo_wathers(long video_wathers) {
		this.video_wathers = video_wathers;
	}

	public int getVideo_status() {
		return video_status;
	}

	public void setVideo_status(int video_status) {
		this.video_status = video_status;
	}

	public int getVideo_auth() {
		return video_auth;
	}

	public void setVideo_auth(int video_auth) {
		this.video_auth = video_auth;
	}

	public int getVideo_share() {
		return video_share;
	}

	public void setVideo_share(int video_share) {
		this.video_share = video_share;
	}
	
	

	
}
