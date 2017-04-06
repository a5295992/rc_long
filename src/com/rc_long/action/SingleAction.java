package com.rc_long.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.MenuBean;
import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.News;
import com.rc_long.Entity.RePlayImg;
import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.ModuleMenuService;
import com.rc_long.service.ModuleNewsService;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.service.RePlayImgService;
import com.rc_long.utils.Pager;

@RequestMapping(value = NewAnRequest.singles)
@Controller
public class SingleAction {

	@Autowired
	private ModuleMenuService mkoduleMenuService;

	@Autowired
	private RePlayImgService rePlayImgService;

	@Autowired
	private ModuleVideoService moduleVideoService;

	@Autowired
	private ModuleNewsService moduleNewsService;

	@RequestMapping(value = "/{menu_id}")
	public ModelAndView init(@PathVariable Integer menu_id) {
		// 查找菜单

		ModuleMenu menu = mkoduleMenuService.getMenuById(menu_id);

		if (menu == null) {
			return new ModelAndView(LocationConstant.erro_404).addObject(
					"message", "no this menu");
		}
		// 顶级菜单
		if (menu.getParents_id_() == 0) {
			// 菜单轮播图

			if ("video".equals(menu.getType())) {
				QueryCondition condition = new QueryCondition();
				condition.setClazz(RePlayImg.class);
				condition.setPageNum(0);
				condition.setMax(6);
				condition.setCondition("WHERE menu_id = ?");
				condition.setConditionObject(new Object[] { menu.getId() });
				List<RePlayImg> inmList = rePlayImgService.getList(condition);
				List<ModuleMenu> list = mkoduleMenuService.getVideoMenu(
						menu.getId(), menu.getType());
				getVideos(list);
				return new ModelAndView(LocationConstant.indexMenuList)
						.addObject("menu_list", list).addObject("inmList",
								inmList);
				// 新闻页面
			} else if ("news".equals(menu.getType())) {

				QueryCondition queryCondition = new QueryCondition();
				queryCondition.setClazz(News.class);
				queryCondition.setPageNum(0);
				queryCondition.setMax(16);
				queryCondition.setCondition("WHERE isRecomment = ?");
				queryCondition.setConditionObject(new Object[] { 1 });
				List<News> newsList = moduleNewsService.getList(queryCondition);

				List<ModuleMenu> list = mkoduleMenuService.getVideoMenu(1003,
						"news");
				List<MenuBean> menuBean = getNews(list);
				return new ModelAndView(LocationConstant.indeNewsList)
						.addObject("newsList", newsList).addObject("menuBean",
								menuBean);
			} else if ("tv".equals(menu.getType())) {

				QueryCondition condition = new QueryCondition();
				condition.setClazz(RePlayImg.class);
				condition.setPageNum(0);
				condition.setMax(6);
				condition.setCondition("WHERE menu_id = ?");
				condition.setConditionObject(new Object[] { menu.getId() });
				List<RePlayImg> inmList = rePlayImgService.getList(condition);
				List<ModuleMenu> list = mkoduleMenuService.getVideoMenu(
						menu.getId(), menu.getType());
				getVideos(list);
				return new ModelAndView(LocationConstant.indexMenuList)
						.addObject("menu_list", list).addObject("inmList",
								inmList);
			}

		}

		// 如果不是顶级菜单

		QueryCondition condition = new QueryCondition();
		condition.setClazz(RePlayImg.class);
		condition.setPageNum(0);
		condition.setMax(6);
		condition.setCondition("WHERE menu_id = ?");
		condition.setConditionObject(new Object[] { menu.getId() });
		Pager<SysVideo> list = moduleVideoService.getVideoList(condition);
		// 单个菜单显示页面
		return new ModelAndView(LocationConstant.singlemenu).addObject(
				"videoList", list);
	}

	private List<MenuBean> getNews(List<ModuleMenu> list) {
		List<MenuBean> list2 = new ArrayList<MenuBean>();
		for (ModuleMenu moduleMenu : list) {
			QueryCondition queryCondition = new QueryCondition();
			queryCondition.setClazz(News.class);
			queryCondition.setPageNum(0);
			queryCondition.setMax(7);
			queryCondition.setCondition("WHERE menu_id = ?");
			queryCondition
					.setConditionObject(new Object[] { moduleMenu.getId() });
			List<News> newsList = moduleNewsService.getList(queryCondition);
			MenuBean moBean = new MenuBean();
			moBean.setMenu_id(moduleMenu.getId());
			moBean.setMenu_name(moduleMenu.getName());
			moBean.setList(newsList);
			list2.add(moBean);
		}
		return list2;
	}

	private void getVideos(List<ModuleMenu> videoMenuList) {

		for (ModuleMenu moduleMenu : videoMenuList) {

			QueryCondition queryCondition = new QueryCondition();
			queryCondition.setClazz(SysVideo.class);
			queryCondition.setPageNum(0);
			queryCondition.setMax(12);
			queryCondition.setCondition("WHERE menu_id = ?");
			queryCondition
					.setConditionObject(new Object[] { moduleMenu.getId() });
			Pager<SysVideo> p = moduleVideoService.getVideoList(
					queryCondition);
			moduleMenu.setVideoList(p);

		}
	}

	@RequestMapping(value = NewAnRequest.toNewsSingle + "/{news_id}")
	public ModelAndView toNewsSingle(@PathVariable String news_id) {

		News news = moduleNewsService.getNews(news_id);

		if (news != null) {
			Integer menu_id = news.getMenu_id();

			QueryCondition queryCondition = new QueryCondition();
			queryCondition.setClazz(News.class);
			queryCondition.setPageNum(0);
			queryCondition.setMax(9);
			queryCondition.setCondition("WHERE menu_id = ?");
			queryCondition.setConditionObject(new Object[] { menu_id });

			Pager<News> news_list = moduleNewsService.getPager(queryCondition);
			return new ModelAndView(LocationConstant.indeNewsSingle).addObject(
					"news", news).addObject("news_list", news_list);
		}

		return new ModelAndView(LocationConstant.erro_404).addObject("message",
				"no this news");

	}

	@RequestMapping(value = NewAnRequest.toNewsMore + "/+/{menu_id}/{pageNum}")
	public ModelAndView toNewsSingle(@PathVariable Integer menu_id,
			@PathVariable Integer pageNum) {

		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setClazz(SysVideo.class);
		queryCondition.setPageNum(pageNum);
		queryCondition.setMax(9);
		queryCondition.setCondition("WHERE menu_id = ?");
		queryCondition.setConditionObject(new Object[] { menu_id });

		Pager<News> news_list = moduleNewsService.getPager(queryCondition);
		return new ModelAndView(LocationConstant.indeNewsSingleRight)
				.addObject("news_list", news_list);

	}
	
	/**
	 * 分页
	 * @return
	 */
	@RequestMapping(value=NewAnRequest.toSingleMenu)
	public ModelAndView toSingleMenu(@PathVariable Integer menu_id,@PathVariable Integer pageNum){
		
		
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setClazz(SysVideo.class);
		queryCondition.setPageNum(pageNum);
		queryCondition.setMax(12);
		queryCondition.setCondition("WHERE menu_id = ?");
		queryCondition
				.setConditionObject(new Object[] { menu_id });
		Pager<SysVideo> videoBean = moduleVideoService.getVideoList(
				queryCondition);	
		return new ModelAndView(LocationConstant.singleMenuVideo).
				addObject("videoBean", videoBean).
				addObject("menus_id", menu_id);
	}
	
	@RequestMapping(value=NewAnRequest.live)
	public ModelAndView toLiveRoom(){
		
		return new ModelAndView(LocationConstant.liveRoom);
	}

}
