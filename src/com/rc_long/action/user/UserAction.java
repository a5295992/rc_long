package com.rc_long.action.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.ShiroUser;
import com.rc_long.Entity.SysUser;
import com.rc_long.Entity.SysUserBean;
import com.rc_long.service.user.UserService;
import com.rc_long.service.user.Impl.UserServiceImpl;
import com.rc_long.utils.CurrentSession;
import com.rc_long.utils.Pager;



@Controller
public class UserAction {
	public UserService userService = new UserServiceImpl();
	
	@RequestMapping(value=AnRequest.sys_user_init)
	public ModelAndView initUser(){
		Pager<SysUser> userPager=userService.getUserPager(null, userPager, null);
		return new ModelAndView("index/index").addObject("userPager",userPager);
	}
	@RequestMapping(value=AnRequest.sys_user_page)
	public ModelAndView loginAndRegist(){
		return new ModelAndView("index/loginAndregist");
	}
	@RequestMapping(value=AnRequest.sys_user_do)
	public ModelAndView dispather(HttpServletRequest req){
		return new ModelAndView("user/success");
	}
	/**
	 * 登出
	 * @param req
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_user_loginout)
	public ModelAndView logout(HttpServletRequest req){
		//移除session
		new CurrentSession(req).remove();
		return new ModelAndView("index/index");
	}
	/**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_user_create)
	public ModelAndView regist(HttpServletRequest req){
		String user_ssid=req.getParameter("user_ssid");
		if(user_ssid==null||user_ssid.trim().isEmpty()){
			return new ModelAndView("index/loginAndregist").addObject("error","用户名为空");
		}
		String user_key=req.getParameter("user_key");
		String user_name=req.getParameter("user_name");
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_ssid", user_ssid);
		map.put("user_key", user_key);
		map.put("user_name", user_name);
		//无组织
		map.put("user_group", 0);
		//默认 普通用户
		map.put("user_type",1 );
		map.put("user_staut", 1);
		//用户标志
		map.put("user_flag", 1);
		//默认值
		map.put("user_attr1", "1");
		map.put("user_attr2", "1");
		map.put("session_id", req.getSession().getId());
		map.put("user_last_time", new java.sql.Date(new Date().getTime()));
		map.put("user_regist_time", new java.sql.Date(new Date().getTime()));
		int index=userService.createUser(map);
		if(index<0){
			return new ModelAndView("index/loginAndregist").addObject("error", "用户名已存在");
		}else{
			return new ModelAndView("user/success").addObject("message", "注册");
		}
	}
	/**
	 * 加载个人信息界面
	 * @return
	 */
	@RequestMapping(value=AnRequest.sys_user_infor)
	public ModelAndView getUserInfor(HttpServletRequest req){
		String user_id=req.getParameter("user_id");
		SysUserBean userBean=userService.getBean(null);
		return new ModelAndView("user/singepage").addObject("userBean", userBean);
	}
	@RequestMapping(value=AnRequest.ajaxLogin)
	public void ajaxLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//返回用户当前页面
				PrintWriter writer=resp.getWriter();
				String user_ssid=req.getParameter("user_ssid");
				//用户密码
				String user_key=req.getParameter("user_key");
				if(user_ssid==null||user_ssid.trim().isEmpty()){
					writer.print(0);
				}
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
					map.clear();
					map.put("user_last_time", new java.sql.Date(new Date().getTime()));
					Map<String,Object> condtion =new HashMap<String,Object>();
					condtion.put("user_id", user.getUser_id());
					userService.updateInfor(map, condtion);
					writer.print(1);
				}else{
					writer.print(0);
				}
	}
}
