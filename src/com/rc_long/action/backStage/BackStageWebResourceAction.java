package com.rc_long.action.backStage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.enumeration.LocationConstant;
/**
 * 网站资源管理器
 * @author longge
 *
 */
@Controller
public class BackStageWebResourceAction {
	@RequestMapping(value=AnRequest.sys_web_static_resource_manage)
	public ModelAndView init(HttpServletRequest req){
		String path =req.getRealPath("/RESOURCES/");
		return new ModelAndView(LocationConstant.sys_web_static_resource_manage).addObject("path", path);
		
	}
	
	@RequestMapping(value=AnRequest.sys_web_static_resource_manage_public)
	public ModelAndView publicResource(HttpServletRequest req){
		@SuppressWarnings("deprecation")
		String path =req.getRealPath("/RESOURCES/");
		
		//采用websorcket 推送差咨询信息
		String message = "正在加载...";
		return new ModelAndView(LocationConstant.sys_web_static_resource_manage_public).addObject("message",message).addObject("path", path+"/public");
	}
}
