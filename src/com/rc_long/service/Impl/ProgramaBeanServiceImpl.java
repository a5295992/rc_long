package com.rc_long.service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.helpers.LogLog;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.ProgramaBean;
import com.rc_long.action.backStage.ProgramaBeanService;
import com.rc_long.dao.DateBase;
import com.rc_long.dao.DateBaseNew;
import com.rc_long.utils.Pager;

public class ProgramaBeanServiceImpl implements ProgramaBeanService {

	@Override
	public Pager<ProgramaBean> getPager(Map<String, String> map) {
		
		String queryThing = map.get("queryThing");
		if(StringUtils.isNullOrEmpty(queryThing)){
			queryThing= "programa_name,programa_id,programa_desc,programa_img,programa_wathers,programa_videos";
		}
		
		String likeName = map.get("likeName");
		
		String like=map.get("like");
		
		String order = map.get("order");
		
		String orderBy = map.get("orderBy");
		
		String conditionJson= map.get("conditionJson");
		
		Integer pageNum;
		Integer pageCount;
		
		try {
			pageNum = Integer.parseInt(map.get("pageNum"));
		} catch (Exception e) {
			pageNum=0;
			LogLog.warn("当前页为0");
		}
		
		try {
			pageCount = Integer.parseInt(map.get("pageCount"));
		} catch (Exception e) {
			pageCount=10;
			LogLog.warn("当前显示10条数据");
		}
		
		int count = DateBase.queryCount(ProgramaBean.class, conditionJson, like);
		Pager<ProgramaBean> limit = new Pager<ProgramaBean>(pageCount,count,pageNum);
		if (limit.getPage() == 0) {
			limit.setPage(1);
		}
		
		//以,分割的字符串
		String orderJson = null ;
		if(bothNotEandN(orderBy,order)){
			orderJson=orderBy+","+order;
		}
		//以,分割的字符串
		String likeQ = null ;
		if(bothNotEandN(likeName,like)){
			likeQ=likeName+","+like;
		}
		
		
		return DateBase.queryList(ProgramaBean.class, queryThing, conditionJson, orderJson , limit, likeQ);
		
	}
	/**
	 * 两者都不为空
	 * @param orderBy
	 * @param order
	 * @return
	 */
	private boolean bothNotEandN(String orderBy, String order) {
		
		if(!StringUtils.isNullOrEmpty(order)){
			if(!StringUtils.isNullOrEmpty(orderBy)){
				return true;
			}
		}
		return false;
	}

	@Override
	public ProgramaBean getSingle(Map<String, String> map) {
		return null;
	}

	@Override
	public int updateSingle(Map<String, Object> map) {
		return 0;
	}

	@Override
	public int updateWhole(List<Map<String, Object>> all) {
		return 0;
	}

	@Override
	public int insertSingle(Map<String, Object> map) {
		return 0;
	}

	@Override
	public int insertWhole(List<Map<String, Object>> all) {
		return 0;
	}

	@Override
	public int deleteSingle(Map<String, Object> map) {
		
		String programa_id = (String) map.get("programa_id");
		String inCondition = (String) map.get("inCondition");
		String condition = null; 
		
		if(!StringUtils.isNullOrEmpty(programa_id)){
			condition="programa_id = "+programa_id;
		}
		
		return DateBaseNew.delete(ProgramaBean.class, condition, inCondition);
	}

	@Override
	public int deleteWhole(List<Map<String, Object>> all) {
		return 0;
	}

}
