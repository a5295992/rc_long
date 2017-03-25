package com.rc_long.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.ShiroUser;
import com.rc_long.Entity.SysUser;
import com.rc_long.service.user.SysUserService;
import com.rc_long.utils.CurrentSession;

@Controller
public class LoginControler {
	
	@Autowired
	private SysUserService userService;
	@ResponseBody
	@RequestMapping(value=NewAnRequest.toLogin,produces="text/html;charset=UTF-8;")
	public String toLogin(String user_ssid,String password,HttpServletRequest request){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user_ssid", user_ssid);
		map.put("password", password);
		SysUser user = userService.searchUse(map);
		String message = "";
		if(user!=null){
			message = "success";
			//将当前用户加入到session中
			ShiroUser shiUser = new ShiroUser();
			
			shiUser.setUser_name(user.getUser_name());
			shiUser.setUser_id(user.getUser_id());
			shiUser.setUser_flag(user.getUser_flag());
			shiUser.setUser_img(user.getUser_img());
			shiUser.setUser_last_time(user.getUser_last_time());
			shiUser.setUser_staut(user.getUser_type());
			shiUser.setUser_staut(user.getUser_staut());
			
			new CurrentSession(request).setShiroUser(shiUser );
			user.setUser_last_time(new java.sql.Date(new Date().getTime()));
			//将最后登陆信息更改到数据库
			userService.updateUser(user);
		}else{
			message="用户名或密码错误";
		}
		return message ;
	}
}
