package com.rc_long.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysVideo;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.Pager;

@Controller
public class VideoAction {
	
	public VideoService videoService = new VideoServiceImpl();
	
	@RequestMapping(value=AnRequest.sys_video_init)
	public ModelAndView init(){
		Pager<SysVideo> videoPager=videoService.getVideoPager(null);
		return new ModelAndView("index/index").addObject("videoPager",videoPager);
	}
	/**
	 * 视频播放
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_video_play)
	public ModelAndView video_play(){
		System.out.println("====================");
		return new ModelAndView("video/video_play");
	}
	
}
