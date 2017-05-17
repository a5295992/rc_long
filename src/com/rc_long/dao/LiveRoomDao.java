package com.rc_long.dao;

import java.util.List;
import java.util.Map;

import com.rc_long.Entity.LiveRoom;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.Pager;

public interface LiveRoomDao {

	int getCount(QueryCondition queryCondition);

	List<LiveRoom> getList(QueryCondition queryCondition, Pager<LiveRoom> pager);

	void updateOrAddLiveRoom(LiveRoom liveRoom);

	LiveRoom getLiveRoom(String liveRoomId);

	void dele(String liveId);

	LiveRoom getLiveRoom(String hql, Map<String, Object> map);

	void update(String hql, Map<String, Object> map);
	
}
