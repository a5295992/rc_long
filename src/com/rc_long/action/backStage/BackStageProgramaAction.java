package com.rc_long.action.backStage;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.ProgramaBean;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.Impl.ProgramaBeanServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;

@Controller
public class BackStageProgramaAction {
	ProgramaBeanService programaBeanService= new  ProgramaBeanServiceImpl();
	/**
	 * 初始化查询
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_back_programa_manage)
	public ModelAndView init(){
		Map<String,String>map = new HashMap<String, String>();
		
		Pager<ProgramaBean> programaBean = programaBeanService.getPager(map);
		
		return new ModelAndView(LocationConstant.sys_back_programa_manage).addObject("programaBean", programaBean);
	}
	/**
	 * 规律化查询
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_back_programa_manage_search)
	public ModelAndView search(HttpServletRequest req){
		ReqUtils.Encoding(req);
		
		Map<String,String>map = new HashMap<String, String>();
		
		map = ReqUtils.parseSearch(map, req);
		
		Pager<ProgramaBean> programaBean = programaBeanService.getPager(map);
		
		return new ModelAndView(LocationConstant.sys_back_programa_manage).addObject("programaBean", programaBean).addObject("map",map);
	}
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_back_programa_manage_delete)
	public ModelAndView delete(HttpServletRequest req,HttpServletResponse rep){
		ReqUtils.Encoding(req);
		
		Map<String,String>map = new HashMap<String, String>();
		
		map = ReqUtils.parseSearch(map, req);
		
		Pager<ProgramaBean> programaBean = programaBeanService.getPager(map);
		
		return new ModelAndView(LocationConstant.sys_back_programa_manage).addObject("programaBean", programaBean).addObject("map",map);
	}
	
}
