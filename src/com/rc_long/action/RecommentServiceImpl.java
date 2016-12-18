package com.rc_long.action;

import java.util.Map;

import com.rc_long.Entity.SysRecommentSearch;
import com.rc_long.dao.DateBase;
import com.rc_long.service.RecommentService;
import com.rc_long.utils.Pager;

public class RecommentServiceImpl implements RecommentService {

	@Override
	public Pager<SysRecommentSearch> getRecomment(Map<String,String> map) {
		Class<SysRecommentSearch> clazz=SysRecommentSearch.class;
		String conditionJson ="";
		String query="";
		String CondtionJson=map.get("CondtionJson");
		
		String likeName=map.get("likeName");
		String like=map.get("like");
		String likeQ =""+likeName+","+like;
		
		int count =DateBase.queryCount(clazz, CondtionJson, likeQ );
		Pager<SysRecommentSearch> limit =new Pager<SysRecommentSearch>();
		String orderJson = null ;
		DateBase.queryList(clazz, query, conditionJson, orderJson , limit, likeQ);
		return limit;
	}

}
