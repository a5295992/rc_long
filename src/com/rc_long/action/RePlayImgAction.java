package com.rc_long.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.RePlayImg;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.ModuleMenuService;
import com.rc_long.service.RePlayImgService;
import com.rc_long.utils.Pager;

@Controller
@RequestMapping(value=NewAnRequest.replayImg)
public class RePlayImgAction {
	@Autowired
	private RePlayImgService rePlayImgService;
	
	@Autowired
	private ModuleMenuService moduleMenuService;
	
	//加载列表
	@RequestMapping(value=NewAnRequest.replayImg_list)
	public ModelAndView init(HttpServletRequest req){
		
		QueryCondition condition =new QueryCondition(req);
		
		condition.setClazz(RePlayImg.class);
		
		
		Pager<RePlayImg> list = rePlayImgService.getPager(condition );
		
		return  new ModelAndView(LocationConstant.repaly_list).addObject("pageBean", list);
	}
	
	
	
	@RequestMapping(value=NewAnRequest.toreplayImg_addOrupdate)
	public ModelAndView toadd(HttpServletRequest req){
		//
		String re_id = req.getParameter("re_id");
		if(StringUtils.isNullOrEmpty(re_id)){
			return  new ModelAndView(LocationConstant.repaly_add);
		}
		
		RePlayImg rePlayImg = rePlayImgService.get(re_id);
		
		List<ModuleMenu> menu_list = moduleMenuService.getMenu();
		return new ModelAndView(LocationConstant.repaly_update).
				addObject("rePlayImg", rePlayImg)
				.addObject("menu_list", menu_list);
		
	}
	//添加或添加
	@ResponseBody
	@RequestMapping(value=NewAnRequest.replayImg_addOrupdate)
	public String add(RePlayImg rePlayImg){
		
		try {
			rePlayImgService.saveOrUpdate(rePlayImg);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
	//删除
	@ResponseBody
	@RequestMapping(value=NewAnRequest.replayImg_dele+"/{re_id}")
	public String dele(@PathVariable String re_id){
		
		try {
			rePlayImgService.dele(re_id);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	
	//批量删除
	@ResponseBody
	@RequestMapping(value=NewAnRequest.replayImg_deles)
	public String deles(String re_ids){
		try {
			rePlayImgService.deles(re_ids);
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
		
}
