package com.rc_long.service.userFriend;

import java.util.Map;

import com.rc_long.Entity.UserFriend;
import com.rc_long.utils.Pager;

public interface UserFriendService {
	
	public Pager<UserFriend> initFriend(Map<String,Object> map);
	
	public int createFriend(Map<String,Object> map);
	
	public int deleteFriend(Map<String,Object> map);
	
	public UserFriend getBean(String queryThing,String condition);
	
	public int update(Map<String,Object> map,Map<String,Object> conditon);
}
