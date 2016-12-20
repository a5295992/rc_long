package com.rc_long.service.video.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.helpers.LogLog;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.action.base.BaseService;
import com.rc_long.dao.DateBase;
import com.rc_long.service.video.VideoService;
import com.rc_long.utils.Pager;

public class VideoServiceImpl<T> implements VideoService, BaseService<SysVideo> {
	
	public Class<T> clazz;
	public VideoServiceImpl(Class<T> clazz){
		super();
		this.clazz=clazz;
	}

	@Override
	public Pager<SysVideo> getVideoPager(String conditionJson, int pageCount,
			int pageNum) {
		String query = "video_id,video_name,video_cname,video_path,video_type,user_id,create_time,video_wathers,video_img,video_desc";
		int count = DateBase.queryCount(SysVideo.class, conditionJson, null);
		Pager<SysVideo> limit = new Pager<SysVideo>(pageCount, count, pageNum);
		return DateBase.queryList(SysVideo.class, query, conditionJson, null,
				limit, null);
	}

	@Override
	public Pager<SysVideoBean> getPargerBean() {

		String sql = "select v.video_name,v.video_cname,v.video_path,v.video_desc,v.video_wathers,v.video_img,v.user_id,u.user_img,u.user_ssid,u.user_name from sys_video v left join sys_user u on v.user_id=u.user_id where v.video_type= '901' limit 0,8";
		List<SysVideoBean> list = DateBase.getBeanRunsql(SysVideoBean.class,
				sql);
		Pager<SysVideoBean> p = new Pager<SysVideoBean>();
		p.setList(list);
		return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Pager<SysVideoBean> getVideoBean(Map<String,String> map) {
		// 如果为空 则进行平常操做
		if (map == null) {
			return (Pager<SysVideoBean>) DateBase.queryList(clazz, null, null, null, null, null);
		} else {
			String queryThing = map.get("queryThing");// 查询字段
			if (StringUtils.isNullOrEmpty(queryThing)) {
				queryThing = null;
			}

			String conditionJson = map.get("condition");
			if (StringUtils.isNullOrEmpty(queryThing)) {
				conditionJson = null;
			}

			String orderBy = map.get("orderBy");

			String order = map.get("order");
			String oder = null;
			if ((!StringUtils.isNullOrEmpty(orderBy))
					&& (!StringUtils.isNullOrEmpty(order))) {
				oder = orderBy + "," + order;
			}

			String like = map.get("like");
			String likeName = map.get("likeName");
			String likeQ = null;

			if ((!StringUtils.isNullOrEmpty(like))
					&& (!StringUtils.isNullOrEmpty(likeName))) {
				likeQ = likeName + "," + like;
			}

			int count = 0;
			int pageCount;
			try {
				count = DateBase.queryCount(clazz, conditionJson, likeQ);
				pageCount = StringUtils.getInt(map.get("pageCount").getBytes());
			} catch (Exception e) {
				pageCount = 10;
				LogLog.error("类型转换异常");
			}

			int pageNum = 0;
			try {
				pageNum = StringUtils.getInt(map.get("pageCount").getBytes());
			} catch (Exception e) {
				pageNum = 0;
				LogLog.error("当前页为0");
			}

			Pager<T> limit = new Pager<T>(pageCount, count, pageNum);

			DateBase.queryList(clazz, queryThing, conditionJson, oder, limit,
					likeQ);
			if (limit.getPage() == 0) {
				limit.setPage(1);
			}
			
			return (Pager<SysVideoBean>) limit;
		}
	}

	@Override
	public Pager<SysVideo> getPager(Map<String, String> map) {
		return null;
	}

	@Override
	public SysVideo getSingle(Map<String, String> map) {
		return null;
	}

	@Override
	public int updateSingle(Map<String, String> map) {
		return 0;
	}

	@Override
	public int updateWhole(List<SysVideo> all) {
		return 0;
	}

	@Override
	public int insertSingle(SysVideo T) {
		return 0;
	}

	@Override
	public int insertWhole(List<SysVideo> all) {
		return 0;
	}

	@Override
	public int deleteSingle(Map<String, String> map) {
		return 0;
	}

	@Override
	public int deleteWhole(List<SysVideo> all) {
		return 0;
	}

}
