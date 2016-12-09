package com.rc_long.action.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.ShiroUser;
import com.rc_long.Entity.SysUser;
import com.rc_long.service.user.UserService;
import com.rc_long.service.user.Impl.UserServiceImpl;
import com.rc_long.utils.CurrentSession;
import com.rc_long.utils.Pager;



@Controller
public class UserAction {
	public UserService userService = new UserServiceImpl();
	
	@RequestMapping(value=AnRequest.sys_user_init)
	public ModelAndView initUser(){
		Pager<SysUser> userPager=userService.getUserPager();
		return new ModelAndView("index/index").addObject("userPager",userPager);
	}
	@RequestMapping(value=AnRequest.sys_user_page)
	public ModelAndView loginAndRegist(){
		return new ModelAndView("index/loginAndregist");
	}
	@RequestMapping(value=AnRequest.sys_user_login)
	public ModelAndView login(HttpServletRequest req){
		//返回用户当前页面
		String user_ssid=req.getParameter("user_ssid");
		//用户密码
		String user_key=req.getParameter("user_key");
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("user_ssid", user_ssid);
		map.put("user_key", user_key);
		SysUser user=userService.login(map);
		ShiroUser shiUser=new ShiroUser();
		if(user!=null){
			shiUser.setUser_name(user.getUser_name());
			shiUser.setUser_id(user.getUser_id());
			shiUser.setUser_flag(user.getUser_flag());
			shiUser.setUser_img(user.getUser_img());
			shiUser.setUser_last_time(user.getUser_last_time());
			shiUser.setUser_staut(user.getUser_type());
			shiUser.setUser_staut(user.getUser_staut());
			new CurrentSession(req).setShiroUser(shiUser);
			System.out.println("=============");
			String userCurrentPage=req.getParameter("userCurrentPage");
			//返回用户前页
			return new ModelAndView("index/index");
		}else{
			return new ModelAndView("index/loginAndregist").addObject("erroMessage", "密码或账号错误");
		}
	}
}
