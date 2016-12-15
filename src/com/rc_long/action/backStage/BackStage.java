package com.rc_long.action.backStage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;

/**
 * 后台管理
 * @author Administrator
 *
 */
@Controller
public class BackStage {
	@RequestMapping(value=AnRequest.sys_back)
	public ModelAndView init(){
		System.out.println("hellos");
		return new ModelAndView("backStage/index.jsp");
	}
}
