package com.rc_long.action.backStage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.Pager;

@Controller
public class BackStageVideo {
	
	/**
	 * 后台视频模块管理
	 * @return
	 */
	VideoService videoService =new VideoServiceImpl<SysVideoBean>(SysVideoBean.class);
	
	@RequestMapping(value=AnRequest.sys_back_video)
	public ModelAndView init(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("pageNum", "0");
		map.put("pageCount", "10");
		Pager<SysVideoBean> videoBean = videoService.getVideoBean(map);
		return new ModelAndView("backStage/video_list").addObject("videoBean", videoBean);
	}
}
