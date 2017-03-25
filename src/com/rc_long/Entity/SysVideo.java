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

import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;

/**
 * 视频实体类
 * @author Administrator
 *
 */
@RcLongTable(name=TableName.SysVideo)
@Entity
@Table(name="sys_video")
public class SysVideo extends EntitiBaseBean<SysVideo> {
	/**
	 * 
	 */
	@OneToMany(targetEntity=Comment.class,cascade=CascadeType.ALL)
	private List<Comment> commentList;
	private static final long serialVersionUID = 1L;
	//视频分类
	private String video_kinds;
	//在首页摆放的位置
	private String index_flag;
	
	@Id
	private String video_id;
	
	private Integer video_rating;
	
	
	private String  video_name;
	
	private String video_cname;
	
	private String video_path;//视频播放路径
	
	private String  group_id;
	
	private Integer is_recommend;//是否推荐 1 推荐 ，0 不推荐
	
	private String video_type;//movie tv enter
	
	private String user_id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="video_type_id",insertable=false,updatable=false)
	private VideoType videoType;
	
	public VideoType getVideoType() {
		return videoType;
	}

	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="group_id",insertable=false,updatable=false)
	private VideoGroup videoGroup;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	private SysUser sysUser;
	
	private String video_long;
	
	private Date create_time;
	
	private Long video_wathers;//视频观看人数 播放次数

	private Integer video_status;//视频状态， 0为成功 1为失败
	
	private Integer video_auth;// 0 代表审核  1.未审核
	
	private Integer video_share; //0 代表 公开观看，1 代表登录观看，2，代表Vip观看
	
	private String video_img;
	
	private String video_desc;
	
	private String resource_id;
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

	
	public String getVideo_img() {
		return video_img;
	}

	public void setVideo_img(String video_img) {
		this.video_img = video_img;
	}

	public String getVideo_desc() {
		return video_desc;
	}

	public void setVideo_desc(String video_desc) {
		this.video_desc = video_desc;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	
	public Long getVideo_wathers() {
		return video_wathers;
	}

	public void setVideo_wathers(Long video_wathers) {
		this.video_wathers = video_wathers;
	}

	public Integer getVideo_status() {
		return video_status;
	}

	public void setVideo_status(Integer video_status) {
		this.video_status = video_status;
	}

	public Integer getVideo_auth() {
		return video_auth;
	}

	public void setVideo_auth(Integer video_auth) {
		this.video_auth = video_auth;
	}

	public Integer getVideo_share() {
		return video_share;
	}

	public void setVideo_share(Integer video_share) {
		this.video_share = video_share;
	}

	

	public void setIs_recommend(Integer is_recommend) {
		this.is_recommend = is_recommend;
	}

	public Integer getVideo_rating() {
		return video_rating;
	}

	public void setVideo_rating(Integer video_rating) {
		this.video_rating = video_rating;
	}

	public VideoGroup getVideoGroup() {
		return videoGroup;
	}

	public void setVideoGroup(VideoGroup videoGroup) {
		this.videoGroup = videoGroup;
	}

	public String getIndex_flag() {
		return index_flag;
	}

	public void setIndex_flag(String index_flag) {
		this.index_flag = index_flag;
	}

	public String getVideo_kinds() {
		return video_kinds;
	}

	public void setVideo_kinds(String video_kinds) {
		this.video_kinds = video_kinds;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}


	
}
