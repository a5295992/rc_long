package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.VideoType;

public interface ModuleVideoTypeService {

	List<VideoType> getVideoType(int begin, int max, boolean b, String string);
	
}
