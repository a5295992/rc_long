package com.rc_long.Entity;

import javax.persistence.Entity;

/**
 * 视频分组表
 * @author Administrator
 *
 */
@Entity
public class VideoGroup  extends EntitiBaseBean<VideoGroup>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int groupId;
	
	private String groupName;
	
	private int groupPid;//上级分组

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getGroupPid() {
		return groupPid;
	}

	public void setGroupPid(int groupPid) {
		this.groupPid = groupPid;
	}
	
}
