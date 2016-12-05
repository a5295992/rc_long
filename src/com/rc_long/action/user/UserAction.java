package com.rc_long.action.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysUser;
import com.rc_long.service.user.UserService;
import com.rc_long.service.user.Impl.UserServiceImpl;
import com.rc_long.utils.Pager;



@Controller
public class UserAction {
	public UserService userService = new UserServiceImpl();
	
	@RequestMapping(value=AnRequest.sys_user_init)
	public ModelAndView initUser(){
		Pager<SysUser> userPager=userService.getUserPager();
		return new ModelAndView("index/index").addObject("userPager",userPager);
	}
}
