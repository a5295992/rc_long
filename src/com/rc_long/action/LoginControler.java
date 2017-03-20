package com.rc_long.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.SysUser;
import com.rc_long.service.user.SysUserService;

@Controller
public class LoginControler {
	
	@Autowired
	private SysUserService userService;
	@ResponseBody
	@RequestMapping(value=NewAnRequest.toLogin,produces="text/html;charset=UTF-8;")
	public String toLogin(String user_ssid,String password){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user_ssid", user_ssid);
		map.put("password", password);
		SysUser user = userService.searchUse(map);
		String message = "";
		if(user!=null){
			message = "success";	
		}else{
			message="用户名或密码错误";
		}
		return message ;
	}
}
