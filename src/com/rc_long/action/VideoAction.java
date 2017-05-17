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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.Comment;
import com.rc_long.Entity.LiveRoom;
import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.News;
import com.rc_long.Entity.ResourceBean;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.Entity.VideoGroup;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.enumeration.PutLocation;
import com.rc_long.enumeration.VideoTypeManage;
import com.rc_long.service.CommentService;
import com.rc_long.service.LiveRoomService;
import com.rc_long.service.ModuleGroupService;
import com.rc_long.service.ModuleMenuService;
import com.rc_long.service.ModuleNewsService;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.service.Impl.ReSourceBeanServiceImpl;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.JedisUtils;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ResouTools;

@Controller
public class VideoAction {

	@Autowired
	private ModuleVideoService moduleVideoService;
	@Autowired
	private ModuleGroupService moduleGroupService;

	public VideoService videoService = new VideoServiceImpl<SysVideo>(
			SysVideo.class);

	@Autowired
	private CommentService commentService;
	@Autowired
	private ModuleNewsService moduleNewsService;

	@Autowired
	private ModuleMenuService moduleMenuService;

	@Autowired
	private LiveRoomService liveRoomService;

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

		// 加载 新闻轮播

		List<News> newsList = JedisUtils.getObject("newsList");
		if (newsList == null) {
			QueryCondition queryCondition = new QueryCondition();
			queryCondition.setClazz(News.class);
			queryCondition.setPageNum(0);
			queryCondition.setMax(7);
			queryCondition.setCondition("WHERE isRecomment = ?");
			queryCondition.setConditionObject(new Object[] { 1 });
			newsList = moduleNewsService.getList(queryCondition);
			if (newsList != null) {
				JedisUtils.saveObject("newsList", newsList);
			}

		}

		// 轮播电影
		List<SysVideo> wholeVido = JedisUtils.getObject("wholeVido");
		if (wholeVido == null) {
			QueryCondition queryCondition3 = new QueryCondition();
			queryCondition3.setClazz(SysVideo.class);
			queryCondition3.setPageNum(0);
			queryCondition3.setMax(7);
			queryCondition3.setCondition("WHERE is_recommend = ?");
			queryCondition3.setConditionObject(new Object[] { 1 });
			wholeVido = moduleVideoService.getVideoList(queryCondition3)
					.getList();
			if (wholeVido != null) {
				JedisUtils.saveObject("wholeVido", wholeVido);
			}

		}

		List<ModuleMenu> videoMenuList = JedisUtils.getObject("videoMenuList");

		if (videoMenuList == null) {
			videoMenuList = moduleMenuService.getVideoMenu(0, true, "video");

			getVideos(videoMenuList);
			if (videoMenuList != null) {
				JedisUtils.saveObject("videoMenuList", videoMenuList);
			}

		}
		// 电影
		// 电视剧

		List<ModuleMenu> tvMenuList = JedisUtils.getObject("tvMenuList");

		if (tvMenuList == null) {
			tvMenuList = moduleMenuService.getVideoMenu(0, true, "tv");
			getVideos(tvMenuList);
			if (tvMenuList != null) {
				JedisUtils.saveObject("tvMenuList", tvMenuList);
			}
		}
		// 栏目
		List<VideoGroup> groupList = moduleGroupService.getVideoGroupList(true,
				"groupList");

		return new ModelAndView(LocationConstant.index)
				.addObject("newsList", newsList)
				.addObject("groupList", groupList)
				.addObject("videoMenuList", videoMenuList)
				.addObject("tvMenuList", tvMenuList)
				.addObject("wholeVido", wholeVido);
	}

	private void getVideos(List<ModuleMenu> videoMenuList) {

		for (ModuleMenu moduleMenu : videoMenuList) {

			for (ModuleMenu moduleMenu2 : moduleMenu.getChildren()) {
				QueryCondition queryCondition = new QueryCondition();
				queryCondition.setClazz(SysVideo.class);
				queryCondition.setPageNum(0);
				queryCondition.setMax(12);
				queryCondition.setCondition("WHERE menu_id = ?");
				queryCondition.setConditionObject(new Object[] { moduleMenu2
						.getId() });
				moduleMenu2.setVideoList(moduleVideoService
						.getVideoList(queryCondition));
			}
		}
	}

	@RequestMapping(value = NewAnRequest.toSingle + "/{video_id}")
	public ModelAndView toSingle(
			@PathVariable(value = "video_id") String video_id) {

		if (StringUtils.isNullOrEmpty(video_id)) {
			return new ModelAndView(LocationConstant.erro_404);
		}
		// 第一步 得到 该视频
		SysVideo sysVideo = moduleVideoService.getVideoById(video_id);
		if (sysVideo != null) {

			// 2加载评论
			Pager<Comment> commentPager = commentService.getComentList(
					sysVideo.getVideo_id(), 0, 2, 0);
			// 3加载相关的电影

			// 加载同专辑
			VideoGroup videoGroup = moduleGroupService.getVideoGroupByTyId(
					true, "singleGroup", sysVideo.getGroup_id());

			List<SysVideo> tvList = moduleVideoService
					.getVideoListByIsRecomment(1, VideoTypeManage.tv,
							PutLocation.second, true, "tvList");
			//
			return new ModelAndView(LocationConstant.singeVideo)
					.addObject("sysVideo", sysVideo)
					.addObject("commentPager", commentPager)
					.addObject("videoGroup", videoGroup)
					.addObject("tvList", tvList);
		} else {
			return new ModelAndView(LocationConstant.erro_404);
		}

	}

	@RequestMapping({ "/live/{live_id}" })
	public ModelAndView toLivePlay(@PathVariable("live_id") String live_id,
			HttpServletRequest req) {
		String pageNum = req.getParameter("pageNum");
		if (StringUtils.isNullOrEmpty(live_id)) {
			return new ModelAndView(LocationConstant.erro_404);
		}

		LiveRoom liveRoom = this.liveRoomService.getById(live_id);
		if (liveRoom != null) {
			QueryCondition queryCondition = new QueryCondition();
			queryCondition.setClazz(LiveRoom.class);
			if (!(StringUtils.isNullOrEmpty(pageNum)))
				queryCondition.setPageNum(Integer.parseInt(pageNum));
			else
				queryCondition.setPageNum(0);

			queryCondition.setMax(7);
			queryCondition
					.setCondition("WHERE menu_id = ? AND live_status =? AND live_id !=?");
			queryCondition.setConditionObject(new Object[] {
					liveRoom.getMenu_id(), Integer.valueOf(1), live_id });
			Pager<LiveRoom> liveBean = this.liveRoomService.getPager(queryCondition);
			liveBean.getList().remove(liveRoom);

			return new ModelAndView(LocationConstant.livePlay).addObject(
					"liveRoom", liveRoom).addObject("liveBean", liveBean);
		}
		return new ModelAndView(LocationConstant.erro_404);
	}

	// 是否推荐
	@ResponseBody
	@RequestMapping(value = NewAnRequest.updateVideoRecomment
			+ "/{video_id}/{isre}")
	public String recomment(@PathVariable String video_id,
			@PathVariable Integer isre) {

		SysVideo sysVideo = moduleVideoService.getVideoById(video_id);

		if (sysVideo != null) {

			sysVideo.setIs_recommend(isre);

			moduleVideoService.update(sysVideo);
		}
		return "";
	}

}
