package com.rc_long.action.backStage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;
@Controller
public class BackStageSelfEditAction {
	
	/**
	 * 加载自编辑
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_back_self_edit)
	public ModelAndView init(HttpServletRequest req){
		
		ReqUtils.Encoding(req);
		VideoService videoService =new VideoServiceImpl<SysVideoBean>(SysVideoBean.class);
		String conditionJson = "{video_type:'103',is_recommend:'1'}";
		Map<String,String> map =new HashMap<String,String>();
		map = ReqUtils.parseSearch(map, req);
		
		map.put("conditionJson", conditionJson);
		
		Pager<SysVideoBean> self_edit_bean_list
		= videoService.getVideoBean(map);
		
		return new ModelAndView("backStage/selfedit/self_edit_recomment").addObject("self_edit_bean_list", self_edit_bean_list);
	}
	
	/**
	 * 加载所有 自编辑视频
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_back_self_edit_search)
	public ModelAndView searchVideo(HttpServletRequest req){
		ReqUtils.Encoding(req);
		VideoService videoService =new VideoServiceImpl<SysVideoBean>(SysVideoBean.class);
		String conditionJson = "{video_type:'103'}";
		Map<String,String> map =new HashMap<String,String>();
		map = ReqUtils.parseSearch(map, req);
		
		map.put("conditionJson", conditionJson);
		
		Pager<SysVideoBean> self_edit_bean = videoService.getVideoBean(map);
		return  new ModelAndView("backStage/selfedit/self_edit_recomment_list").addObject("self_edit_bean", self_edit_bean);
	}
	
	
}
