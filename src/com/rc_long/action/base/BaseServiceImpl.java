package com.rc_long.action.base;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.helpers.LogLog;

import com.mysql.jdbc.StringUtils;
import com.rc_long.dao.DateBase;
import com.rc_long.utils.Pager;

/**
 * baseService 
 * @author long
 * @param <T>
 */
public class BaseServiceImpl<T> implements BaseService<T>{
	
	public Class<T> clazz;
	public BaseServiceImpl(Class<T> clazz){
		super();
		this.clazz=clazz;
	}
	
	@Override
	public Pager<T> getPager(Map<String, String> map) {
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
			
			Pager<T> limit=new Pager<T>(pageCount, count, pageNum);
			
			DateBase.queryList(clazz, queryThing, conditionJson, oder, limit, likeQ);
			if (limit.getPage() == 0) {
				limit.setPage(1);
			}
			return limit;
		}
	}
	
	@Override
	public T getSingle(Map<String, String> map) {
		String queryThing=map.get("queryThing");
		
		if(StringUtils.isNullOrEmpty(queryThing)){
			queryThing=null;
		}
		
		String condition=map.get("condition");
		if(StringUtils.isNullOrEmpty(condition)){
			condition=null;
		}
		
		return DateBase.querySingle(clazz, queryThing, condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int updateSingle(Map<String, String> map) {
		String condition = map.get("condition");
		
		String field=map.get("changeFiled");
		Map<String,Object> condt=null;
		if(StringUtils.isNullOrEmpty(condition)){
			condition=null;
		}else{
			condt=JSONObject.fromObject(condition);
		}
		Map<String,Object> fileds=null;
		if(StringUtils.isNullOrEmpty(field)){
			condition=null;
		}else{
			fileds=JSONObject.fromObject(field);
		}
		return DateBase.update(clazz, fileds, condt);
	}

	@Override
	public int updateWhole(List<T> all) {
		return 0;
	}

	@Override
	public int insertSingle(T T) {
		return 0;
	}

	@Override
	public int insertWhole(List<T> all) {
		return 0;
	}

	@Override
	public int deleteSingle(Map<String, String> map) {
		return 0;
	}

	@Override
	public int deleteWhole(List<T> all) {
		return 0;
	}

}
