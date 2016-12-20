package com.rc_long.action.backStage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysVideo;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.Pager;

@Controller
public class BackStageVideo {
	
	/**
	 * 后台视频模块管理
	 * @return
	 */
	VideoService videoService =new VideoServiceImpl();
	
	@RequestMapping(value=AnRequest.sys_back_video)
	public ModelAndView init(){
		Pager<SysVideo> videoBean=videoService.getVideoPager(null, 10, 0);
		return new ModelAndView("backStage/video_list").addObject("videoBean", videoBean);
	}
}
