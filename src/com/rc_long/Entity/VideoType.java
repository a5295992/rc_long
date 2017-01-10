package com.rc_long.Entity;

import javax.persistence.Entity;

/**
 * 视频分类
 * @author longge
 *
 */
@Entity
public class VideoType extends EntitiBaseBean<VideoType> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String video_type_id;
	
	private String video_type_name;
	
	private int video_type_pid;

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

	public int getVideo_type_pid() {
		return video_type_pid;
	}

	public void setVideo_type_pid(int video_type_pid) {
		this.video_type_pid = video_type_pid;
	}
}
