package com.rc_long.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.RePlayImg;
import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.ModuleMenuService;
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

	@RequestMapping(value ="/{menu_id}")
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
			return new ModelAndView(LocationConstant.indexMenuList).addObject(
					"menu_list", list).addObject("inmList", inmList);
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

	private void getVideos(List<ModuleMenu> videoMenuList) {

		for (ModuleMenu moduleMenu : videoMenuList) {
			
			QueryCondition queryCondition = new QueryCondition();
			queryCondition.setClazz(SysVideo.class);
			queryCondition.setPageNum(0);
			queryCondition.setMax(12);
			queryCondition.setCondition("WHERE menu_id = ?");
			queryCondition.setConditionObject(new Object[] { moduleMenu
					.getId() });
			moduleMenu.setVideoList(moduleVideoService.getVideoList(
					queryCondition).getList());

		}
	}

}
