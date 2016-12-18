package com.rc_long.service.video.impl;

import java.util.List;
import java.util.Map;

import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.dao.DateBase;
import com.rc_long.service.video.VideoService;
import com.rc_long.utils.Pager;

public class VideoServiceImpl implements VideoService{

	@Override
	public Pager<SysVideo> getVideoPager(String conditionJson,int pageCount,int pageNum) {
		String query="video_id,video_name,video_cname,video_path,video_type,user_id,create_time,video_wathers,video_img,video_desc";
		int count =DateBase.queryCount(SysVideo.class, conditionJson, null);
		Pager<SysVideo> limit=new Pager<SysVideo>(pageCount,count,pageNum);
		return DateBase.queryList(SysVideo.class, query, conditionJson, null, limit, null);
	}
	
	
	@Override
	public SysVideo getVideo(String conditionJoson) {
		
		return DateBase.querySingle(SysVideo.class, "video_id,video_name,video_path,video_cname,user_id,create_time", conditionJoson);
	}

	@Override
	public int updateVideo(Map<String, Object> map, Map<String, Object> conditon) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteVideo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createVideo(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Pager<SysVideoBean> getPargerBean() {
		
		String sql="select v.video_name,v.video_cname,v.video_path,v.video_desc,v.video_wathers,v.video_img,v.user_id,u.user_img,u.user_ssid,u.user_name from sys_video v left join sys_user u on v.user_id=u.user_id where v.video_type= '901' limit 0,8";
		List<SysVideoBean> list=DateBase.getBeanRunsql(SysVideoBean.class, sql);
		Pager<SysVideoBean> p=new Pager<SysVideoBean>();
		p.setList(list);
		return p;
	}


	
}
