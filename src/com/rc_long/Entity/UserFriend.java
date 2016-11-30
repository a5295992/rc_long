package com.rc_long.Entity;

import javax.persistence.Entity;

@Entity
public class UserFriend extends EntitiBaseBean<UserFriend>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String friendId; 
	
	private String userIdA;
	
	private String usrIdB;
	
	private int statusA;//A的申请 回复状态
	
	private int statusB;//B的申请回复状态

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getUserIdA() {
		return userIdA;
	}

	public void setUserIdA(String userIdA) {
		this.userIdA = userIdA;
	}

	public String getUsrIdB() {
		return usrIdB;
	}

	public void setUsrIdB(String usrIdB) {
		this.usrIdB = usrIdB;
	}

	public int getStatusA() {
		return statusA;
	}

	public void setStatusA(int statusA) {
		this.statusA = statusA;
	}

	public int getStatusB() {
		return statusB;
	}

	public void setStatusB(int statusB) {
		this.statusB = statusB;
	}
	
	
}
