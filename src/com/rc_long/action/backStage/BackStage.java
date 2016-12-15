package com.rc_long.action.backStage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysUser;
import com.rc_long.service.user.UserService;
import com.rc_long.service.user.Impl.UserServiceImpl;
import com.rc_long.utils.Pager;
/**
 * 后台管理
 * @author Administrator
 *
 */
@Controller
public class BackStage {
	//用戶
	UserService userService=new UserServiceImpl();
	
	@RequestMapping(value=AnRequest.sys_back)
	public ModelAndView init(){
		System.out.println("hellos");
		return new ModelAndView("backStage/index");
	}
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_back_user)
	public ModelAndView findUserList(){
		
		Pager<SysUser> user_bean=userService.getUserPager();
		
		return new ModelAndView("backStage/user_list")
			.addObject("user_bean", user_bean);
	}
}
