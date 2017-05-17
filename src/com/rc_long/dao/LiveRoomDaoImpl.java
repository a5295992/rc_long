package com.rc_long.dao;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.LiveRoom;
import com.rc_long.dao.dataSource.HQLCostants;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.dao.impl.Daoutils;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.Pager;
import com.rc_long.utils.SessionUtils;
@Component
public class LiveRoomDaoImpl implements LiveRoomDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public int getCount(QueryCondition queryCondition) {
		String hql = HQLCostants.getALL(queryCondition);
		
		Session session  = SessionUtils.getSession(sessionFactory);
		
		SQLQuery query = session.createSQLQuery(hql);
		
		CommoTools.setValues(queryCondition.getObj(), query);
		
		BigInteger bin = (BigInteger) query.uniqueResult();
		return bin.intValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LiveRoom> getList(QueryCondition queryCondition,
			Pager<LiveRoom> pager) {
		String hql = HQLCostants.getSQL(queryCondition);
		Session session  = SessionUtils.getSession(sessionFactory);
		Query query = session.createQuery(hql);
		
		CommoTools.setValues(queryCondition.getObj(), query);
		
		return query.list();
	}

	@Override
	public void updateOrAddLiveRoom(LiveRoom liveRoom) {
		Daoutils.saveOrupdate(sessionFactory, liveRoom);

	}

	@Override
	public LiveRoom getLiveRoom(String liveRoomId) {
		return Daoutils.getBeanById(sessionFactory, liveRoomId, LiveRoom.class);
	}

	@Override
	public void dele(String liveId) {
		
		String hql = "DELETE FROM LiveRoom WHERE live_id =:liveId"; 
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("liveId", liveId);
		
		Daoutils.delete(sessionFactory, hql, map );
	}

	@Override
	public LiveRoom getLiveRoom(String hql, Map<String, Object> map) {
		
		
		return Daoutils.getBeanByHqlAndMapCondition(sessionFactory,hql,map);
	}

	@Override
	public void update(String hql, Map<String, Object> map) {
		
		Daoutils.updateMap(sessionFactory, hql, map);
		
	}

}
