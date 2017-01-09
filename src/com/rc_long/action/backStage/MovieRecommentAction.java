package com.rc_long.action.backStage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.enumeration.VideoTypeConstants;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;

@Controller
public class MovieRecommentAction {
		
	@RequestMapping(value = AnRequest.sys_back_movie_recomment)
	public ModelAndView init(HttpServletRequest req){
		ReqUtils.Encoding(req);
		String video_type  = req.getParameter("video_type");
		VideoService videoService = new VideoServiceImpl<SysVideoBean>(
				SysVideoBean.class);
		String conditionJson = "{video_type:'"+video_type+"',is_recommend:'1'}";
		Map<String, String> map = new HashMap<String, String>();
		map = ReqUtils.parseSearch(map, req);

		map.put("conditionJson", conditionJson);

		Pager<SysVideoBean> self_edit_bean_list = videoService
				.getVideoBean(map);
		
		return new ModelAndView(VideoTypeConstants.choose(Integer.parseInt(video_type)))
				.addObject("self_edit_bean_list", self_edit_bean_list).addObject("video_type",video_type);
	}
	
	@RequestMapping(value = AnRequest.sys_back_movie_recomment_search)
	public ModelAndView searchVideo(HttpServletRequest req) {
		ReqUtils.Encoding(req);
		VideoService videoService = new VideoServiceImpl<SysVideoBean>(
				SysVideoBean.class);
		String video_type  = req.getParameter("video_type");
		String conditionJson = "{video_type:'"+video_type+"'}";
		Map<String, String> map = new HashMap<String, String>();
		map = ReqUtils.parseSearch(map, req);

		map.put("conditionJson", conditionJson);

		Pager<SysVideoBean> self_edit_bean = videoService.getVideoBean(map);
		return new ModelAndView(VideoTypeConstants.choose(Integer.parseInt(video_type))+"_list")
				.addObject("self_edit_bean", self_edit_bean).addObject("video_type",video_type);
	}
	
	@RequestMapping(value = AnRequest.sys_back_movie_recomment_update)
	public void update(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		ReqUtils.Encoding(req);
		PrintWriter pw = rep.getWriter();
		String data_id = req.getParameter("data_id");
		if(StringUtils.isNullOrEmpty(data_id)){
			pw.print(-1);
		}
		String video_type  = req.getParameter("video_type");
		String all = ReqUtils.dealData(data_id);
		int result = new VideoServiceImpl<SysVideo>(SysVideo.class)
				.updateAuth(all,video_type);
		pw.print(result);
	}
}
