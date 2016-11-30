package com.rc_long.Entity;

import javax.persistence.Entity;

@Entity
public class ChatLog extends EntitiBaseBean<ChatLog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String logId;
	
	private String friendId;
	
	private String userId;
	
	private String logTime;
	
	private String logContent;//内容
	
	private int status;//1 已读 0 未读

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLogTime() {
		return logTime;
	}

	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
