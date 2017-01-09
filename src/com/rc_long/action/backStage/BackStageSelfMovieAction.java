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
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;
@Controller
public class BackStageSelfMovieAction {
	
	@RequestMapping(value=AnRequest.sys_back_self_movie_comment)
	public ModelAndView init(HttpServletRequest req){
		ReqUtils.Encoding(req);
		VideoService videoService = new VideoServiceImpl<SysVideoBean>(
				SysVideoBean.class);
		String conditionJson = "{video_type:'102',is_recommend:'1'}";
		Map<String, String> map = new HashMap<String, String>();
		map = ReqUtils.parseSearch(map, req);

		map.put("conditionJson", conditionJson);

		Pager<SysVideoBean> self_edit_bean_list = videoService
				.getVideoBean(map);

		return new ModelAndView("backStage/selfMovie/self_movie_comment")
				.addObject("self_edit_bean_list", self_edit_bean_list);
	}
	
	/**
	 * 加载所有 自编辑视频
	 * 
	 * @return
	 */
	@RequestMapping(value = AnRequest.sys_back_self_movie_comment_search)
	public ModelAndView searchVideo(HttpServletRequest req) {
		ReqUtils.Encoding(req);
		VideoService videoService = new VideoServiceImpl<SysVideoBean>(
				SysVideoBean.class);
		String conditionJson = "{video_type:'102'}";
		Map<String, String> map = new HashMap<String, String>();
		map = ReqUtils.parseSearch(map, req);

		map.put("conditionJson", conditionJson);

		Pager<SysVideoBean> self_edit_bean = videoService.getVideoBean(map);
		return new ModelAndView("backStage/selfMovie/self_movie_comment_list")
				.addObject("self_edit_bean", self_edit_bean);
	}

	@RequestMapping(value = AnRequest.sys_back_self_movie_comment_update)
	public void update(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		ReqUtils.Encoding(req);
		PrintWriter pw = rep.getWriter();
		String data_id = req.getParameter("data_id");
		if(StringUtils.isNullOrEmpty(data_id)){
			pw.print(-1);
		}
		String all = ReqUtils.dealData(data_id);
		int result = new VideoServiceImpl<SysVideo>(SysVideo.class)
				.updateAuth(all,"102");
		pw.print(result);
	}
}
