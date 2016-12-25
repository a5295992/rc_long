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
		StringBuilder sql=new StringBuilder();
		sql.append("select ");
		// 如果为空 则进行平常操做
		if (map == null) {
			return (Pager<SysVideoBean>) DateBase.queryList(clazz, null, null, null, null, null);
		} else {
			String queryThing = map.get("queryThing");// 查询字段
			if (!StringUtils.isNullOrEmpty(queryThing)) {
				sql.append(queryThing);
			}else{
				sql.append("a.video_id,a.video_cname,a.video_auth,");
				sql.append("a.create_time,a.user_id,b.user_name,");
				sql.append("a.video_img,a.video_desc");
				sql.append(" from sys_video a ");
				sql.append("left join sys_user b");
			}
			
			String oncondition = map.get("on");
			if (!StringUtils.isNullOrEmpty(oncondition)) {
				sql.append(oncondition);
			}else{
				sql.append(" on a.user_id = b.user_id");
			}

			String orderBy = map.get("orderBy");

			String order = map.get("order");
			if ((!StringUtils.isNullOrEmpty(orderBy))
					&& (!StringUtils.isNullOrEmpty(order))) {
				sql.append("order by "+orderBy+" "+order);
			}

			String like = map.get("like");
			String likeName = map.get("likeName");

			if ((!StringUtils.isNullOrEmpty(like))
					&& (!StringUtils.isNullOrEmpty(likeName))) {
				if(sql.toString().contains("where")){
					sql.append("and "+likeName+"like"+"%"+"'"+like+"'"+"%");
				}
			}
			List<SysVideoBean> list=(List<SysVideoBean>) DateBase.runSqlJoin(sql.toString(), clazz);
			int count = 0;
			int pageCount;
			try {
				count = list.size();
				pageCount = StringUtils.getInt(map.get("pageCount").getBytes());
			} catch (Exception e) {
				pageCount = 10;
				LogLog.error("类型转换异常");
			}

			int pageNum = 0;
			try {
				pageNum = StringUtils.getInt(map.get("pageNum").getBytes());
			} catch (Exception e) {
				pageNum = 0;
				LogLog.error("当前页为0");
			}

			Pager<SysVideoBean> limit = new Pager<SysVideoBean>(pageCount, count, pageNum);
			
			try {
				sql.append(" limit "+limit.getStart()+","+limit.getPageCount());
			} catch (Exception e) {
				LogLog.error(e.getMessage());
			}
			System.out.println(sql.toString());
			list=(List<SysVideoBean>) DateBase.runSqlJoin(sql.toString(), clazz);
			if (limit.getPage() == 0) {
				limit.setPage(1);
			}
			limit.setList( list);
			return (Pager<SysVideoBean>) limit;
		}
	}

	@Override
	public Pager<SysVideo> getPager(Map<String, String> map) {
		return null;
	}

	@Override
	public SysVideo getSingle(Map<String, String> map) {
		String queryThing =map.get("queryThing");
		if(StringUtils.isNullOrEmpty(queryThing)){
			queryThing="video_id,video_name,video_cname,video_path,video_type,user_id,create_time,video_wathers,video_img,video_desc";
		}
		String condition =map.get("condition");
		return DateBase.querySingle(SysVideo.class, queryThing, condition);
	}

	@Override
	public int updateSingle(Map<String, Object> map) {
		// TODO Auto-generated method stub
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
		return 0;
	}

	@Override
	public int deleteWhole(List<Map<String, Object>> all) {
		return 0;
	}


}
