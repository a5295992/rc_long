package com.rc_long.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author 周湘龙
 *
 */
@Entity
@Table(name="sys_user")
public class SysUser extends EntitiBaseBean<SysUser>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//id
	
	private String user_id;//uuid
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
	
	
	@Id
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
	
	
}
