package com.rc_long.action.backStage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;

@Controller
public class BackStageWebInforAction {
	@RequestMapping(value=AnRequest.sys_back_infor)
	public ModelAndView init(){
		
		return new ModelAndView("backStage/webInfor");
	}
}
