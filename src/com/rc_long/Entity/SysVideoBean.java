package com.rc_long.Entity;

import java.sql.Date;

import com.rc_long.anotation.TableList;
@TableList(names={"sys_video a1","sys_user a2"},connectCondition={"a1.user_id=a2.user_id"})
public class SysVideoBean {
	
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
	
	private String video_img;
	
	private String video_desc;

	

	private String user_name;//用户姓名
	private String user_ssid;//id
	private String user_img;//头像
	private String user_key;//用户密码
	private int user_group;//组织֯
	private int user_type;//用户类型 1
	private int user_staut;//状态 1代表在线 0 代表不在线?
	private int user_flag; //标识 1代表可用 0 不可用?
	private String user_attr1;
	private String user_attr2;
	private String session_id; //
	private Date user_last_time; //最后登录时间
	private Date user_regist_time;//ע注册时间
	
	private String video_type_id;
	
	private String video_type_name;
	
	
	public String getVideo_type_id() {
		return video_type_id;
	}

	public void setVideo_type_id(String video_type_id) {
		this.video_type_id = video_type_id;
	}

	public String getVideo_type_name() {
		return video_type_name;
	}

	public void setVideo_type_name(String video_type_name) {
		this.video_type_name = video_type_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_ssid() {
		return user_ssid;
	}

	public void setUser_ssid(String user_ssid) {
		this.user_ssid = user_ssid;
	}

	public String getUser_img() {
		return user_img;
	}

	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

	public String getUser_key() {
		return user_key;
	}

	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	public int getUser_group() {
		return user_group;
	}

	public void setUser_group(int user_group) {
		this.user_group = user_group;
	}

	public int getUser_type() {
		return user_type;
	}

	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}

	public int getUser_staut() {
		return user_staut;
	}

	public void setUser_staut(int user_staut) {
		this.user_staut = user_staut;
	}

	public int getUser_flag() {
		return user_flag;
	}

	public void setUser_flag(int user_flag) {
		this.user_flag = user_flag;
	}

	public String getUser_attr1() {
		return user_attr1;
	}

	public void setUser_attr1(String user_attr1) {
		this.user_attr1 = user_attr1;
	}

	public String getUser_attr2() {
		return user_attr2;
	}

	public void setUser_attr2(String user_attr2) {
		this.user_attr2 = user_attr2;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public Date getUser_last_time() {
		return user_last_time;
	}

	public void setUser_last_time(Date user_last_time) {
		this.user_last_time = user_last_time;
	}

	public Date getUser_regist_time() {
		return user_regist_time;
	}

	public void setUser_regist_time(Date user_regist_time) {
		this.user_regist_time = user_regist_time;
	}
	
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
	
}
