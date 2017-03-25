package com.rc_long.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;

/**
 * 视频分类
 * @author longge
 *
 */
@RcLongTable(name=TableName.VideoType)
@Entity
@Table(name="video_type")
public class VideoType extends EntitiBaseBean<VideoType> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String video_type_id;
	
	private String video_type_name;
	
	private Integer video_type_pid;
	
	@OneToOne(mappedBy="videoType",cascade=CascadeType.ALL)
	private MenuRole menuRole;
	
	
	@OneToMany(mappedBy="videoType",cascade=CascadeType.ALL)
	private List<SysVideo> videoList;

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

	public List<SysVideo> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<SysVideo> videoList) {
		this.videoList = videoList;
	}


	public MenuRole getMenuRole() {
		return menuRole;
	}

	public void setMenuRole(MenuRole menuRole) {
		this.menuRole = menuRole;
	}
}
