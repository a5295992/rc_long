package com.rc_long.action.backStage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;

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
		Pager<SysVideoBean> video_bean = videoService.getVideoBean(map);
		return new ModelAndView("backStage/video_list").addObject("video_bean", video_bean);
	}
	@RequestMapping(value=AnRequest.sys_back_video_search)
	public ModelAndView videoSearch(HttpServletRequest req){
		ReqUtils.Encoding(req);
		Map<String,String> map=new HashMap<String,String>();
		String pageCount = req.getParameter("pageCount");
		String pageNum = req.getParameter("pageNum");
		// 更新字段
		String orderBy = req.getParameter("oderBy");
		String order = req.getParameter("oder");
		String condition = "";
		String likeName = req.getParameter("likeName");
		String like = req.getParameter("like");
		map.put("pagerCount", pageCount);
		map.put("pageNum", pageNum);
		map.put("orderBy", orderBy);
		map.put("order", order);
		map.put("condition", condition);
		map.put("likeName", likeName);
		map.put("like", like);
		Pager<SysVideoBean> video_bean = new VideoServiceImpl<SysVideoBean>(SysVideoBean.class).getVideoBean(map);
		
		return new ModelAndView("backStage/video_list").addObject("video_bean",video_bean);
	}
	/**
	 * 视频 权限及分组管理
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_back_video_manage)
	public ModelAndView manage(){
		Map<String, String> map = new HashMap<String,String>();
		List<SysVideoBean> videoBean = new VideoServiceImpl<SysVideoBean>(SysVideoBean.class).getSysVideoBean(map);
		return new ModelAndView("backStage/video/video_manage");
	}
}
