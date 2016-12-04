package com.rc_long.service.video;

import org.springframework.stereotype.Service;

import com.rc_long.Entity.SysVideo;
import com.rc_long.utils.Pager;

@Service
public interface VideoService {
	
	public Pager<SysVideo> getVideoPager();
}
