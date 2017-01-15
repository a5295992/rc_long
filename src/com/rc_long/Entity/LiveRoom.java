package com.rc_long.Entity;

import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;


/**
 * @author Long
 *
 */
@RcLongTable(name=TableName.LiveRoom)
public class LiveRoom extends EntitiBaseBean<LiveRoom> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//直播首页图片
	private String live_img;
	
	private String live_id;
	
	private String live_name;
	
	private String live_title;
	
	private String video_id;
	
	private String user_id;
	
	private String start_time;
	
	private String end_time;
	
	private int live_status;//0 未直播　１直播中　２直播结束
	
	private String live_path;//直播路径
	
	private int is_recoment;//是否推荐 0 不推荐　１　推荐

	public String getLive_id() {
		return live_id;
	}

	public void setLive_id(String live_id) {
		this.live_id = live_id;
	}

	public String getLive_name() {
		return live_name;
	}

	public void setLive_name(String live_name) {
		this.live_name = live_name;
	}

	public String getLive_title() {
		return live_title;
	}

	public void setLive_title(String live_title) {
		this.live_title = live_title;
	}

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

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public int getLive_status() {
		return live_status;
	}

	public void setLive_status(int live_status) {
		this.live_status = live_status;
	}

	public String getLive_path() {
		return live_path;
	}

	public void setLive_path(String live_path) {
		this.live_path = live_path;
	}

	public int getIs_recoment() {
		return is_recoment;
	}

	public void setIs_recoment(int is_recoment) {
		this.is_recoment = is_recoment;
	}

	public String getLive_img() {
		return live_img;
	}

	public void setLive_img(String live_img) {
		this.live_img = live_img;
	}
	
	/**
	 * 是否过期
	 * @return
	 */
}
