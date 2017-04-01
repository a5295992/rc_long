package com.rc_long.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.Comment;
import com.rc_long.Entity.ResourceBean;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.Entity.VideoGroup;
import com.rc_long.Entity.VideoType;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.enumeration.PutLocation;
import com.rc_long.enumeration.VideoTypeManage;
import com.rc_long.service.CommentService;
import com.rc_long.service.ModuleGroupService;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.service.ModuleVideoTypeService;
import com.rc_long.service.Impl.ReSourceBeanServiceImpl;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ResouTools;

@Controller
public class VideoAction {

	@Autowired
	private ModuleVideoService moduleVideoService;
	@Autowired
	private ModuleGroupService moduleGroupService;
	@Autowired
	private ModuleVideoTypeService moduleVideoTypeService;

	public VideoService videoService = new VideoServiceImpl<SysVideo>(
			SysVideo.class);
	
	@Autowired
	private CommentService commentService;
	

	/**
	 * 视频播放
	 * 
	 * @return
	 */
	@RequestMapping(value = AnRequest.sys_video_play)
	public ModelAndView video_play(HttpServletRequest req) {
		String video_id = req.getParameter("vd");
		System.out.println(video_id);
		Map<String, String> map = new HashMap<String, String>();
		map.put("like", video_id);
		map.put("likeName", "video_id");
		SysVideoBean videoBean = null;
		try {
			videoBean = new VideoServiceImpl<SysVideoBean>(SysVideoBean.class)
					.getVideoBean(map).getList().get(0);
			ResourceBean rb = new ReSourceBeanServiceImpl().getSingle(videoBean
					.getResource_id());
			String path = ResouTools.getRrsorcePath(rb);
			videoBean.setVideo_img(path + ".PNG");
			videoBean.setVideo_path(path);
		} catch (Exception e) {
			return new ModelAndView(LocationConstant.erro_404);
		}

		return new ModelAndView("video/video_play").addObject("videoBean",
				videoBean);

	}

	@RequestMapping(value = AnRequest.sys_video_play_rtmb)
	public void video_play_rtmb(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		InputStream file = new FileInputStream(
				"E:/git_gui/rc_long/WebRoot/www/resources/data_data/57b1368741321.mp4");
		OutputStream out = rep.getOutputStream();
		IOUtils.copy(file, out);
	}

	// 加載flash播放器
	@RequestMapping(value = AnRequest.sys_video_flash_play)
	public ModelAndView flashPlay() {

		return new ModelAndView(LocationConstant.sys_video_flowPlayer);
	}

	@RequestMapping(value = NewAnRequest.index)
	public ModelAndView initIndex() {
		// 加载推荐信息（首页电影轮播图）
		List<SysVideo> videoList = moduleVideoService
				.getVideoListByIsRecomment(1, VideoTypeManage.movie,
						PutLocation.head,true,"videoList");
		
		// 电视剧

		List<SysVideo> tvList = moduleVideoService.getVideoListByIsRecomment(1,
				VideoTypeManage.tv, PutLocation.second,true,"tvList");
		//

		List<VideoType> videoTypeList = moduleVideoTypeService.getVideoType(0,
				5,true,"videoTypeList");

		// 加载热门专辑
		List<VideoGroup> groupList = moduleGroupService.getVideoGroupList(true,"groupList");

		return new ModelAndView(LocationConstant.index)
				.addObject("videoList", videoList).addObject("tvList", tvList)
				.addObject("videoTypeList", videoTypeList)
				.addObject("groupList", groupList);
	}
	
	
	@RequestMapping(value=NewAnRequest.toSingle+"/{video_id}")
	public ModelAndView toSingle(@PathVariable(value="video_id") String video_id ){
		
		if(StringUtils.isNullOrEmpty(video_id)){
			return new ModelAndView(LocationConstant.erro_404);
		}
		//第一步 得到 该视频
		SysVideo sysVideo = moduleVideoService.getVideoById(video_id);
		if(sysVideo!=null){
			
			//2加载评论
			Pager<Comment> commentPager= commentService.getComentList(sysVideo.getVideo_id(),0,2,0);
			//3加载相关的电影
			
			//加载同专辑
			VideoGroup videoGroup = moduleGroupService.getVideoGroupByTyId(true,"singleGroup",sysVideo.getGroup_id());
			
			List<SysVideo> tvList = moduleVideoService.getVideoListByIsRecomment(1,
					VideoTypeManage.tv, PutLocation.second,true,"tvList");
			//
			return new ModelAndView(LocationConstant.singeVideo)
			.addObject("sysVideo",sysVideo)
			.addObject("commentPager", commentPager)
			.addObject("videoGroup",videoGroup)
			.addObject("tvList",tvList);
		}else{
			return new ModelAndView(LocationConstant.erro_404);
		}
		
	}
	
}
