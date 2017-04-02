package com.rc_long.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;
/**
 * 
 * @author 周湘龙
 *
 */
@Entity
@RcLongTable(name=TableName.SysUser)
@Table(name="sys_user")
public class SysUser extends EntitiBaseBean<SysUser>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//id
	
	@Id
	private String user_id;//uuid
	private String user_name;//用户姓名
	private String user_ssid;//id
	private String user_img;//头像
	private String user_key;//用户密码
	private Integer user_group;//组织֯
	private Integer user_type;//用户类型 1
	private Integer user_staut;//状态 1代表在线 0 代表不在线?
	private Integer user_flag; //标识 1代表可用 0 不可用?

	@OneToMany(targetEntity=Comment.class,cascade=CascadeType.ALL)
	private List<Comment> comentList;
	//发布的所有视频
	@OneToMany(targetEntity=SysVideo.class,cascade=CascadeType.ALL)
	private List<SysVideo> videoList;
	@OneToMany(cascade=CascadeType.ALL,targetEntity=News.class)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<News> newsList;
	
	@OneToOne(mappedBy = "sysUser",cascade=CascadeType.ALL)
	private SysUserInfor userInfor;
	
	

	private String user_attr1;
	private String user_attr2;
	private String session_id; //
	private Date user_last_time; //最后登录时间
	private Date user_regist_time;//ע注册时间
	
	
	
	public SysUserInfor getUserInfor() {
		return userInfor;
	}

	public void setUserInfor(SysUserInfor userInfor) {
		this.userInfor = userInfor;
	}

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

	public List<Comment> getComentList() {
		return comentList;
	}

	public void setComentList(List<Comment> comentList) {
		this.comentList = comentList;
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

	public List<SysVideo> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<SysVideo> videoList) {
		this.videoList = videoList;
	}

	public Integer getUser_group() {
		return user_group;
	}

	public void setUser_group(Integer user_group) {
		this.user_group = user_group;
	}

	public Integer getUser_type() {
		return user_type;
	}

	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}

	public Integer getUser_staut() {
		return user_staut;
	}

	public void setUser_staut(Integer user_staut) {
		this.user_staut = user_staut;
	}

	public Integer getUser_flag() {
		return user_flag;
	}

	public void setUser_flag(Integer user_flag) {
		this.user_flag = user_flag;
	}
	
}
