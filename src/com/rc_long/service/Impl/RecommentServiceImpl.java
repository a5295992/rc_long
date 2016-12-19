package com.rc_long.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.helpers.LogLog;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.SysRecommentSearch;
import com.rc_long.dao.DateBase;
import com.rc_long.service.RecommentService;
import com.rc_long.utils.Pager;

public class RecommentServiceImpl implements RecommentService {

	public Class<SysRecommentSearch> clazz;
	public RecommentServiceImpl(Class<SysRecommentSearch> clazz) {
		this.clazz=clazz;
	}
	@Override
	public Pager<SysRecommentSearch> getPager(Map<String, String> map) {
		//如果为空 则进行平常操做
				if(map==null){
					return DateBase.queryList(clazz, null, null, null, null, null);
				}else{
					String queryThing=map.get("queryThing");//查询字段
					if(StringUtils.isNullOrEmpty(queryThing)){
						queryThing=null;
					}
					
					String conditionJson=map.get("condition");
					if(StringUtils.isNullOrEmpty(queryThing)){
						conditionJson=null;
					}
					
					String orderBy=map.get("orderBy");
					
					String order=map.get("order");
					String oder=null;
					if((!StringUtils.isNullOrEmpty(orderBy))&&(!StringUtils.isNullOrEmpty(order))){
						 oder=orderBy+","+order;
					}
					
					String like=map.get("like");
					String likeName=map.get("likeName");
					String likeQ=null;
					
					if((!StringUtils.isNullOrEmpty(like))&&(!StringUtils.isNullOrEmpty(likeName))){
						likeQ=likeName+","+like;
					}
					
					int count=0;
					int pageCount;
					try {
						count = DateBase.queryCount(clazz, conditionJson, likeQ);
						pageCount = StringUtils.getInt(map.get("pageCount").getBytes());
					} catch (NumberFormatException e) {
						pageCount=10;
						LogLog.error("类型转换异常");
					}
					
					int pageNum=0;
					try {
						pageNum = StringUtils.getInt(map.get("pageCount").getBytes());
					} catch (NumberFormatException e) {
						LogLog.error("当前页为0");
					}
					
					Pager<SysRecommentSearch> limit=new Pager<SysRecommentSearch>(pageCount, count, pageNum);
					
					DateBase.queryList(clazz, queryThing, conditionJson, oder, limit, likeQ);
					if (limit.getPage() == 0) {
						limit.setPage(1);
					}
					return limit;
				}
			}
	

	@Override
	public SysRecommentSearch getSingle(Map<String, String> map) {
		return null;
	}

	@Override
	public int updateSingle(Map<String, String> map) {
		return 0;
	}

	@Override
	public int updateWhole(List<SysRecommentSearch> all) {
		return 0;
	}

	@Override
	public int insertSingle(SysRecommentSearch T) {
		return 0;
	}

	@Override
	public int insertWhole(List<SysRecommentSearch> all) {
		return 0;
	}

	@Override
	public int deleteSingle(Map<String, String> map) {
		return 0;
	}

	@Override
	public int deleteWhole(List<SysRecommentSearch> all) {
		return 0;
	}

	

}
