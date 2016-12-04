package com.rc_long.service.video.impl;

import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.DateBase;
import com.rc_long.service.video.VideoService;
import com.rc_long.utils.Pager;

public class VideoServiceImpl implements VideoService{

	@Override
	public Pager<SysVideo> getVideoPager() {
		
		return  DateBase.queryList(SysVideo.class, null, "{user_id:'0001'}", "video_id,desc", new Pager<SysVideo>(3,3,0), null);
		
	}
	public static void main(String[] args) {
		Pager<SysVideo> p=new VideoServiceImpl().getVideoPager();
		for (SysVideo m:p.getList()) {
			System.out.println(m.getVideo_cname());
		}
	}
}
