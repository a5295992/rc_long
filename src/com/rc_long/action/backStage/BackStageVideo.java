package com.rc_long.action.backStage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.Entity.VideoType;
import com.rc_long.service.Impl.VideoTypeServiceImpl;
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
	public ModelAndView manage(HttpServletRequest req ){
		ReqUtils.Encoding(req);
		String video_id  = req.getParameter("video_id");
		Map<String, String> map = new HashMap<String,String>();
		map.put("video_id", video_id);
		SysVideoBean videoBean = new VideoServiceImpl<SysVideoBean>(SysVideoBean.class).getSysVideoBean(map).get(0);
		
		List<VideoType> video_type_bean =  new  VideoTypeServiceImpl().getVideoTypeBean();
		return new ModelAndView("backStage/video/video_manage").addObject("videoBean", videoBean).addObject("video_type_bean", video_type_bean);
	}
	/**
	 * 视频 权限更新
	 * @param req
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value=AnRequest.sys_back_video_manage_update)
	public void manageUpdate(HttpServletRequest req,HttpServletResponse rep ) throws IOException{
		ReqUtils.Encoding(req);
		PrintWriter pw  = rep.getWriter();
		String video_id  = req.getParameter("video_id");
		Map<String, Object> map = new HashMap<String,Object>();
		map = ReqUtils.parseUpdate(map, req, SysVideo.class);
		map.remove("video_id");
		map.put("condition", "{video_id:'"+video_id+"'}");
		int result = new VideoServiceImpl<SysVideo>(SysVideo.class).updateSingle(map);	
		pw.print(result);
		pw.close();
	}
	
	/**
	 * 视频 关联资源更新
	 * @param req
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value=AnRequest.sys_back_video_manage_update_resource)
	public void manageUpdateResource(HttpServletRequest req,HttpServletResponse rep ) throws IOException{
		ReqUtils.Encoding(req);
		PrintWriter pw  = rep.getWriter();
		String video_id  = req.getParameter("video_id");
		String resource_id = req.getParameter("resource_id");
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("video_id", video_id);
		map.put("resource_id", resource_id);
		int result = new VideoServiceImpl<SysVideo>(SysVideo.class).update(map);	
		pw.print(result);
		pw.close();
	}
	
}
