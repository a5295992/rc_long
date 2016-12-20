package com.rc_long.action.backStage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysMenu;
import com.rc_long.service.Menu.Impl.MenuServiceImpl;
import com.rc_long.utils.Pager;

@Controller
public class BackMenuAction {
	
	MenuServiceImpl menuService=new MenuServiceImpl(SysMenu.class);
	@RequestMapping(value=AnRequest.sys_back_menu)
	public ModelAndView init(){
		Map<String, String> map=new HashMap<String,String>();
		Pager<SysMenu> menuPager=menuService.getPager(map);
		return new ModelAndView("backStage/cate").addObject("menuPager", menuPager);
	}
	
}
