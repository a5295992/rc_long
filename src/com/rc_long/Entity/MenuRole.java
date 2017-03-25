package com.rc_long.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="video_type")
public class MenuRole extends EntitiBaseBean<MenuRole> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="video_type_id",unique=true)
	private VideoType videoType;

	private String href;
	
	
	private String clazz;
	private String active_in;
	
	@Id
	private String id;
	
	private String data_toggle;
	
	private String aria_expanded;
	
	private String aria_controls;
	
	private String role;
	
	
	public VideoType getVideoType() {
		return videoType;
	}

	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getData_toggle() {
		return data_toggle;
	}

	public void setData_toggle(String data_toggle) {
		this.data_toggle = data_toggle;
	}

	public String getAria_expanded() {
		return aria_expanded;
	}

	public void setAria_expanded(String aria_expanded) {
		this.aria_expanded = aria_expanded;
	}

	public String getAria_controls() {
		return aria_controls;
	}

	public void setAria_controls(String aria_controls) {
		this.aria_controls = aria_controls;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getActive_in() {
		return active_in;
	}

	public void setActive_in(String active_in) {
		this.active_in = active_in;
	}
}
