package com.rc_long.action.backStage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.enumeration.MenuConstants;
import com.rc_long.service.ModuleMenuService;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.utils.Pager;

/**
 * 菜单管理
 * @author Administrator
 *
 */
@RequestMapping(value=NewAnRequest.system_menu)
@Controller
public class BackStageManage {
	
	@Autowired
	private ModuleMenuService  moduleMenuService;
	
	@Autowired
	private ModuleVideoService moduleVideoService;
	
	
	@RequestMapping(value=NewAnRequest.system_menu_)
	public ModelAndView init(){
		
		
		//获取 所有菜单 父级别菜单
		
		return new ModelAndView("backStage/manage_index");
	}
	//首页
	@ResponseBody
	@RequestMapping(value=NewAnRequest.system_menu_list)
	public List<ModuleMenu> menuList(){
		List<ModuleMenu> list  = moduleMenuService.getMenu();
		return list;
	}
	
	//首页
	@RequestMapping(value=NewAnRequest.system_menu_content+"/{menu_id}")
	public ModelAndView getContent(@PathVariable(value="menu_id") Integer menu_id){
		ModuleMenu moduleMenu = moduleMenuService.getMenuById(menu_id);
		Pager<SysVideo> commoPager = null;
		String type ="";
		if(moduleMenu!=null){
			type = moduleMenu.getType();
			if(MenuConstants.VIDEO.equals(type)){
				
				QueryCondition condition = new QueryCondition();
				condition.setPageNum(0);
				condition.setClazz(SysVideo.class);
				condition.setCondition("WHERE menu_id=?");
				condition.setConditionObject(new Object[]{menu_id});
				commoPager = moduleVideoService.getVideoList(condition);
				//视频模型
			}else if(MenuConstants.NEWS.equals(type)){
				
				//新闻模型
			}else if(MenuConstants.TV.equals(type)){
				
				//电视剧
			}else if(MenuConstants.LIVE.equals(type)){
				//直播模型
				
			}else {
				
				//通用模型
			}
		}
		return new ModelAndView(LocationConstant.commView)
		.addObject("commoPager",commoPager).addObject("type",type);
	}
		
	
	
	/**
	 * 删除 菜单
	 */
	
	
	/**
	 * 进入 添加菜单 或者更改菜单页面
	 */
	@RequestMapping(value=NewAnRequest.system_menu_add,method=RequestMethod.POST)
	public ModelAndView toAddOrUpdateOrDelete(ModuleMenu menu){
		
		String message = "success";
		try {
			moduleMenuService.add(menu);
		} catch (Exception e) {
			message = "failed";
			e.printStackTrace();
		}
		//获取 所有菜单 父级别菜单
		
		List<ModuleMenu> list  = moduleMenuService.getMenu();
		ModuleMenu moduleMenu = moduleMenuService.getMenuById(menu.getId());
		return new ModelAndView(LocationConstant.manage_index)
		.addObject("message", message).addObject("moduleMenu",moduleMenu)
		.addObject("menu_list", list);
	}
	@RequestMapping(value=NewAnRequest.system_menu_add+"/{menu_id}",method=RequestMethod.GET)
	public ModelAndView toAdd(@PathVariable(value="menu_id") Integer menu_id){
		
		
		ModuleMenu moduleMenu = moduleMenuService.getMenuById(menu_id);
		
		List<ModuleMenu> list  = moduleMenuService.getMenu();
		
		 //移除自己先
		for (ModuleMenu moduleMenu1 : list) {
			if(moduleMenu1.getId()==menu_id&&moduleMenu1.getParents_id_()!=0){
				list.remove(moduleMenu1);
			}
		}
		return new ModelAndView(LocationConstant.menu_add)
		.addObject("moduleMenu",moduleMenu).
		
		addObject("menu_list", list);
	}
	
	/**
	 * 删除菜单
	 * 
	 * 
	 */
	@ResponseBody
	@RequestMapping(value=NewAnRequest.system_menu_delete+"/{menu_id}")
	public String  dele(@PathVariable(value="menu_id") Integer menu_id){
		
		
		ModuleMenu moduleMenu = moduleMenuService.getMenuById(menu_id);
		
		if(moduleMenu!=null){
			try {
				moduleMenuService.dele(moduleMenu);
			} catch (Exception e) {
				
				e.printStackTrace();
				return  "-1";
			}
		}
		
		return "1";
	}
	
		
	
	/**
	 * 更改菜单
	 */
}
