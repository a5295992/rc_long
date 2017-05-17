package com.rc_long.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rc_long.Entity.LiveRoom;
import com.rc_long.dao.LiveRoomDao;
import com.rc_long.dao.dataSource.HQLCostants;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.service.LiveRoomService;
import com.rc_long.utils.Pager;

@Component
@Transactional
public class LiveRoomServiceImpl implements LiveRoomService {
	@Autowired
	private LiveRoomDao liveRoomDao;
	@Override
	public Pager<LiveRoom> getPager(QueryCondition queryCondition) {
		int count  = liveRoomDao.getCount(queryCondition);
		
		Pager<LiveRoom> pager = new Pager<LiveRoom>(queryCondition.getMax(),count,queryCondition.getPageNum());
		
		List<LiveRoom> list = liveRoomDao.getList(queryCondition,pager);
		
		pager.setList(list);
			
		return pager;
	}

	@Override
	public void addOrUpdateLiveRoom(LiveRoom liveRoom) {
		
		liveRoomDao.updateOrAddLiveRoom(liveRoom);

	}

	@Override
	public LiveRoom getById(String liveRoomId) {
		return liveRoomDao.getLiveRoom(liveRoomId);
	}

	@Override
	public void deleteLiveRoom(String liveId) {
		
		liveRoomDao.dele(liveId);

	}

	@Override
	public LiveRoom getByUserId(String user_id) {
		String hql ="FROM LiveRoom as c WHERE c.user_id=:user_id ";
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		
		
		return liveRoomDao.getLiveRoom(hql,map);
	}

	@Override
	public void update(String live_id, Map<String, Object> map) {
		
		String hql = HQLCostants.updateById(LiveRoom.class,"live_id",map);
		
		map.put("live_id", live_id);
		
		liveRoomDao.update(hql,map);
		
	}


}
