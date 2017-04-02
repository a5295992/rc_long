package com.rc_long.action.backStage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.ModuleMenuService;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.JedisUtils;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;

@Controller
public class BackStageVideo {
	
	@Autowired
	private ModuleVideoService moduleVideoService;
	
	@Autowired
	private ModuleMenuService  moduleMenuService;
	/**
	 * 后台视频模块管理
	 * @return
	 */
	VideoService videoService =new VideoServiceImpl<SysVideoBean>(SysVideoBean.class);
	
	@RequestMapping(value=AnRequest.sys_back_video)
	public ModelAndView init(){
		
		Pager<SysVideo> video_bean  = moduleVideoService.getVideoList(0,10);
		
		
		return new ModelAndView("backStage/video_list").addObject("video_bean", video_bean);
	}
	@RequestMapping(value=AnRequest.sys_back_video_search)
	public ModelAndView videoSearch(HttpServletRequest req){
		ReqUtils.Encoding(req);
		String pageCount = req.getParameter("pageCount");
		String pageNum = req.getParameter("pageNum");
		// 更新字段
		String orderBy = req.getParameter("oderBy");
		String order = req.getParameter("oder");
		String likeName = req.getParameter("likeName");
		String like = req.getParameter("like");
		
		QueryCondition queryCondition = new QueryCondition();
		if(!StringUtils.isNullOrEmpty(pageNum)){
			queryCondition.setPageNum(Integer.parseInt(pageNum));
		}
		if(!StringUtils.isNullOrEmpty(pageCount)){
			queryCondition.setMax(Integer.parseInt(pageCount));
		}
		queryCondition.setClazz(SysVideo.class);
		queryCondition.setOrderBy(orderBy);
		
		queryCondition.setOrder(order);
		
		queryCondition.setLike(likeName);
		
		queryCondition.setLikeName(like);
		
		
		Pager<SysVideo> video_bean1  = moduleVideoService.getVideoList(queryCondition);
		
		return new ModelAndView("backStage/video_list").addObject("video_bean",video_bean1);
	}
	/**
	 * 视频 权限及分组管理
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_back_video_manage+"/{video_id}")
	public ModelAndView manage(@PathVariable(value="video_id") String video_id ){
		SysVideo videoBean = null;
		if(!StringUtils.isNullOrEmpty(video_id)){
			videoBean = moduleVideoService.getVideoById(video_id);
			JedisUtils.saveObject("currentVideo", videoBean);
		}else {
			String to = "/admin";
			return new ModelAndView(LocationConstant.erro_404).addObject("message","没有找到该视频").addObject("to",to);
		}
		List<ModuleMenu> menu_list  = moduleMenuService.getMenu(true);
		
		return new ModelAndView("backStage/video/video_manage").addObject("videoBean", videoBean )
				.addObject("menu_list", menu_list);
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
	
	@ResponseBody
	@RequestMapping(value=NewAnRequest.updatePath)
	public String updatePath(HttpServletRequest req ){
		String  video_id = req.getParameter("video_id");
		
		String resource_name = req.getParameter("resource_name");
		resource_name = "rtmp:/vod/mp4:"+resource_name;
		
		return moduleVideoService.update(video_id,resource_name);
		
	}
/*	@DateTimeFormat(pattern="yyyy-MM-dd")
*/	@RequestMapping(value=NewAnRequest.video_update)
	public ModelAndView updateOrInsert(HttpServletRequest req ){
			//第一步  查询该视频信息
		//视频id
		String video_id = req.getParameter("video_id");
		if(StringUtils.isNullOrEmpty(video_id)){
			return new ModelAndView(LocationConstant.erro_404)
			.addObject("message", "没有找到该视频");
		}
		//视频名字
		String video_name = req.getParameter("video_name");
		//视频别名
		String video_cname = req.getParameter("video_cname");
		//封面
		String video_img = req.getParameter("video_img");
		//菜单id
		String menu_id = req.getParameter("menu_id");
		//关键字
		String key_words = req.getParameter("key_words");
		//视频描述
		String video_desc = req.getParameter("video_desc");
		
		SysVideo sysVideo = moduleVideoService.getVideoById(video_id);
		if(sysVideo!=null){
			if(!StringUtils.isNullOrEmpty(video_name)){
				sysVideo.setVideo_name(video_name);
			}
			if(!StringUtils.isNullOrEmpty(video_cname)){
				sysVideo.setVideo_cname(video_cname);
			}
			if(!StringUtils.isNullOrEmpty(video_img)){
				sysVideo.setVideo_img(video_img);
			}
			if(!StringUtils.isNullOrEmpty(menu_id)){
				int menu_id_ = Integer.parseInt(menu_id);
				sysVideo.setMenu_id(menu_id_);;
			}
			if(!StringUtils.isNullOrEmpty(key_words)){
				sysVideo.setKey_words(key_words);
			}
			if(!StringUtils.isNullOrEmpty(video_desc)){
				sysVideo.setVideo_desc(video_desc);
			}
			moduleVideoService.update(sysVideo);
			
			List<ModuleMenu> menu_list  = moduleMenuService.getMenu(true);
			
			return new ModelAndView("backStage/video/video_manage").addObject("videoBean", sysVideo)
					.addObject("menu_list", menu_list);
		}
		return new ModelAndView(LocationConstant.erro_404)
		.addObject("message", "发生了不可预知的错误");
	}
}
