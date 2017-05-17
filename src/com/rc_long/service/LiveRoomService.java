package com.rc_long.service;

import java.util.Map;

import com.rc_long.Entity.LiveRoom;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.Pager;

public interface LiveRoomService {

	Pager<LiveRoom> getPager(QueryCondition queryCondition);


	void addOrUpdateLiveRoom(LiveRoom liveRoom);


	LiveRoom getById(String liveRoomId);


	void deleteLiveRoom(String liveId);


	LiveRoom getByUserId(String user_id);


	void update(String live_id, Map<String, Object> map);



}
