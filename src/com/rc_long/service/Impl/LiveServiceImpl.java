package com.rc_long.service.Impl;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.helpers.LogLog;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.LiveRoom;
import com.rc_long.dao.DateBase;
import com.rc_long.service.LiveService;
import com.rc_long.utils.Pager;

public class LiveServiceImpl implements LiveService {

	@Override
	public Pager<LiveRoom> getPager(Map<String, String> map) {
		//如果为空 则进行平常操做
		Class<LiveRoom> clazz=LiveRoom.class;
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
			} catch (Exception e) {
				pageCount=10;
				LogLog.error("类型转换异常");
			}
			
			int pageNum=0;
			try {
				pageNum = StringUtils.getInt(map.get("pageCount").getBytes());
			} catch (Exception e) {
				LogLog.error("当前页为0");
			}
			
			Pager<LiveRoom> limit=new Pager<LiveRoom>(pageCount, count, pageNum);
			
			DateBase.queryList(clazz, queryThing, conditionJson, oder, limit, likeQ);
			if (limit.getPage() == 0) {
				limit.setPage(1);
			}
			return limit;
		}
	}

	@Override
	public LiveRoom getSingle(Map<String, String> map) {
		Class<LiveRoom> clazz = LiveRoom.class;
		String live_id = map.get("live_id");
		String live_name = map.get("live_name");
		String live_title = map.get("live_title");
		String video_id = map.get("video_id");
		String user_id = map.get("user_id");
		String live_status = map.get("live_status");
		String live_path = map.get("live_path");

		String is_recoment = map.get("is_recoment");

		String conditionjson = map.get("conditionjson");

		String queryThing = map.get("queryThing");

		if (StringUtils.isNullOrEmpty(queryThing)) {
			queryThing = "live_id,live_name,live_title,live_path,user_id,live_img";
		}

		if (StringUtils.isNullOrEmpty(conditionjson)) {

			if (!StringUtils.isNullOrEmpty(live_id)) {
				conditionjson = "{live_id:" + live_id + "}";
			}

			if (!StringUtils.isNullOrEmpty(live_name)) {
				conditionjson = "{live_name:" + live_name + "}";
			}

			if (!StringUtils.isNullOrEmpty(live_title)) {
				conditionjson = "{live_title:" + live_title + "}";
			}
			if (!StringUtils.isNullOrEmpty(user_id)) {
				conditionjson = "{user_id:" + user_id + "}";
			}

			if (!StringUtils.isNullOrEmpty(live_path)) {
				conditionjson = "{live_path:" + live_path + "}";
			}
			if (!StringUtils.isNullOrEmpty(live_status)) {
				conditionjson = "{live_status:" + live_status + "}";
			}

			if (!StringUtils.isNullOrEmpty(video_id)) {
				conditionjson = "{video_id:" + video_id + "}";
			}
			if (!StringUtils.isNullOrEmpty(is_recoment)) {
				conditionjson = "{is_recoment:" + is_recoment + "}";
			}
		}

		return DateBase.querySingle(clazz, queryThing, conditionjson);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int updateSingle(Map<String,Object> map) {
		
		Class<Object> clazz = null;
		String condition = (String) map.get("condition");
		
		String [] inCondition =(String[]) map.get("inCondition");
		
		Map<String,Object> conditions= null;
		if(!StringUtils.isNullOrEmpty(condition)){
			conditions= (Map<String, Object>)JSONObject.fromObject(condition);
		}
		map.remove("condition");
		map.remove("inCondition");
		
		return DateBase.update(clazz, map, conditions,inCondition);
	}


	@Override
	public int updateWhole(List<Map<String,Object>> all) {
		int result =0;
		for (Map<String, Object> map : all) {
			
			try {
				result = updateSingle(map);
			} catch (Exception e) {
				LogLog.error(e.getMessage());
			}
		}
		return result;
	}


	@Override
	public int deleteSingle(Map<String, Object> map) {
		
		String []inCondition = (String[]) map.get("inCondition");
		map.remove("inCondition");
		return DateBase.delete(LiveRoom.class, map,inCondition);
	}

	@Override
	public int deleteWhole(List<Map<String, Object>> all) {
		int result =0; 
		for (Map<String, Object> map : all) {
			result = deleteSingle(map);
		}
		return result;
	}

	@Override
	public int insertSingle(Map<String, Object> map) {
		
		return DateBase.insert(LiveRoom.class, map);
	}

	@Override
	public int insertWhole(List<Map<String, Object>> all) {
		int result =0; 
		for (Map<String, Object> map : all) {
			result = insertSingle(map);
		}
		return result;
	}

	
}
