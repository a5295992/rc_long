package com.rc_long.service.Impl;

import java.util.List;

import com.rc_long.Entity.VideoType;
import com.rc_long.dao.DateBase;
import com.rc_long.service.VideoTypeService;

public class VideoTypeServiceImpl implements VideoTypeService {

	public List<VideoType> getVideoTypeBean() {
		
		String sql = "select * from video_type";
		
		return DateBase.getBeanListRunsql(VideoType.class, sql);
	}

}
