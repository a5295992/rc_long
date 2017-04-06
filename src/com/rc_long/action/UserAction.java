package com.rc_long.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.ShiroUser;
import com.rc_long.Entity.SysUser;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.user.SysUserService;
import com.rc_long.utils.CurrentSession;
@Controller
public class UserAction {
	
	@Autowired
	private SysUserService userService;
	/**
	 * 加载个人信息界面
	 * @return
	 */
	@RequestMapping(value=NewAnRequest.user_infor+"/{user_id}")
	public ModelAndView getUserInfor(HttpServletRequest req,@PathVariable String user_id){
		SysUser userBean =null;
		ShiroUser shiroUser= new CurrentSession(req).getShiroUser();
		if(shiroUser!=null){
			return new ModelAndView("user/singepage").addObject("userBean", userBean);
		}else{
			return  new ModelAndView(LocationConstant.erro_403).addObject("message","on permission");
		}
		
	}
	
}
