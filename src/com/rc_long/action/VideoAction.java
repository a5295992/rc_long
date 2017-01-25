package com.rc_long.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.ResourceBean;
import com.rc_long.Entity.SysMenu;
import com.rc_long.Entity.SysRecommentSearch;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.RecommentService;
import com.rc_long.service.Impl.ReSourceBeanServiceImpl;
import com.rc_long.service.Impl.RecommentServiceImpl;
import com.rc_long.service.Menu.Impl.MenuServiceImpl;
import com.rc_long.service.video.VideoService;
import com.rc_long.service.video.impl.VideoServiceImpl;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ResouTools;

@Controller
public class VideoAction {

	public VideoService videoService = new VideoServiceImpl<SysVideo>(SysVideo.class);
	public  MenuServiceImpl menuService =new MenuServiceImpl(SysMenu.class);
	@RequestMapping(value = AnRequest.sys_video_init)
	public ModelAndView init() {
		// 加载主页菜单
		HashMap<String, String> map=new HashMap<String,String>();
		List<SysMenu> menuList = menuService.getPager(map).getList();
		//加载推荐内容
		RecommentService recommentService =new RecommentServiceImpl(SysRecommentSearch.class);
		map.clear();
		map.put("pageCount", "4");
		map.put("pageNum", "0");
		Pager<SysRecommentSearch> recomPager =recommentService .getPager(map);
		
		String conditionJson = "{video_type:'401'}";
		// 电影 精选
		Pager<SysVideo> videoPager = videoService.getVideoPager(conditionJson,
				4, 0);
		// 电视剧精选

		conditionJson = "{video_type:'501'}";
		Pager<SysVideo> soapPager = videoService.getVideoPager(conditionJson,
				4, 0);
		// 综艺精选
		conditionJson = "{video_type:'601'}";
		Pager<SysVideo> lifePager = videoService.getVideoPager(conditionJson,
				5, 0);
		// 猜你喜欢
		Pager<SysVideoBean> likePager = videoService.getPargerBean();
		// 直播
		conditionJson = "{video_type:'801',is_recommend:'1'}";
		Pager<SysVideo> recPager = videoService.getVideoPager(conditionJson, 1,
				0);
		// 自编辑
		conditionJson = "{video_type:'103'}";
		Pager<SysVideo> editPager = videoService.getVideoPager(conditionJson,
				3, 0);
		// 自影评
		conditionJson = "{video_type:'102'}";
		Pager<SysVideo> commentPager = videoService.getVideoPager(
				conditionJson, 3, 0);
		// 重大新闻
		conditionJson = "{video_type:'101'}";
		Pager<SysVideo> newsPager = videoService.getVideoPager(conditionJson,
				3, 0);
		return new ModelAndView("index/index")
				.addObject("videoPager", videoPager)
				.addObject("soapPager", soapPager)
				.addObject("lifePager", lifePager)
				.addObject("likePager", likePager)
				.addObject("recPager", recPager)
				.addObject("editPager", editPager)
				.addObject("commentPager", commentPager)
				.addObject("newsPager", newsPager)
				.addObject("menuList",menuList)
				.addObject("recomPager", recomPager);

	}

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
		SysVideoBean videoBean =null ;
		try {
			videoBean =  new VideoServiceImpl<SysVideoBean>(SysVideoBean.class).getVideoBean(map).getList().get(0);
			ResourceBean  rb= new ReSourceBeanServiceImpl().getSingle(videoBean.getResource_id());
			String path = ResouTools.getRrsorcePath(rb);
			videoBean.setVideo_img(path+".PNG");
			videoBean.setVideo_path(path );
		} catch (Exception e) {
			return new ModelAndView(LocationConstant.erro_404);
		}
		
		return new ModelAndView("video/video_play").addObject("videoBean",
				videoBean);

	}
	@RequestMapping(value=AnRequest.sys_video_play_rtmb)
	public void video_play_rtmb(HttpServletRequest req,HttpServletResponse rep) throws IOException{
		InputStream file = new FileInputStream("E:/git_gui/rc_long/WebRoot/www/resources/data_data/57b1368741321.mp4");
		OutputStream out= rep.getOutputStream();
		IOUtils.copy(file, out);
	}
	public static void main(String[] args) throws FileNotFoundException {
		InputStream file = new FileInputStream("E:/git_gui/rc_long/WebRoot/www/resources/data_data/57b1368741321.mp4");
		System.out.println(file);
	}
}
