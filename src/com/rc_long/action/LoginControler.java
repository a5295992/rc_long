package com.rc_long.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.ShiroUser;
import com.rc_long.Entity.SysUser;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.user.SysUserService;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.CurrentSession;
import com.rc_long.utils.JedisUtils;

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
			shiUser.setUser_type(user.getUser_type());
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
	//@PathVariable(value="name") String name,@PathVariable(value="age")String age
	//后台登录
	@RequestMapping(value=NewAnRequest.back_tologin)
	public ModelAndView toAdminLogin(HttpServletRequest req){
		ShiroUser shiro = new CurrentSession(req).getShiroUser();
		if(shiro!=null){
			req.getSession().removeAttribute("ShiroUser");
		}
		return new ModelAndView(LocationConstant.adminLogin);
	}
	
	//后台登录
	@ResponseBody
	@RequestMapping(value=NewAnRequest.backlogin,produces="text/html;charset=UTF-8;")
	public String tobackIndex(String userName,String password,HttpServletRequest req){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("user_ssid", userName);
		map.put("password", password);
		SysUser user = userService.searchUse(map);	
		if(user==null){
			return "密码或者账号错误";
		}else{
			if(user.getUser_type()==1){
				//将当前用户加入到session中
				ShiroUser shiUser = new ShiroUser();
				
				shiUser.setUser_name(user.getUser_name());
				shiUser.setUser_id(user.getUser_id());
				shiUser.setUser_flag(user.getUser_flag());
				shiUser.setUser_img(user.getUser_img());
				shiUser.setUser_last_time(user.getUser_last_time());
				shiUser.setUser_type(user.getUser_type());
				shiUser.setUser_staut(user.getUser_staut());
				shiUser.setUser_ssid(user.getUser_ssid());
				new CurrentSession(req).setShiroUser(shiUser );
				user.setUser_last_time(new java.sql.Date(new Date().getTime()));
				//将最后登陆信息更改到数据库
				userService.updateUser(user);
				//判断是否是管理员
				return "success";
			}else{
				return "错误(403)缺少对应的权限";
			}
		}
	}
	@RequestMapping(value=NewAnRequest.to_backIndex)
	public ModelAndView toBack(HttpServletRequest req ) {
		
		ShiroUser shiro = new CurrentSession(req).getShiroUser();
		if(shiro!=null&&shiro.getUser_type()==1){
			
			return new ModelAndView(LocationConstant.admin);
			
		}else{
			return new ModelAndView(LocationConstant.erro_403).
					addObject("message","未登录或缺少权限").
					addObject("deal","toLogin");
		}
	}
	/**
	 * 清除缓存
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=NewAnRequest.clearCach,produces="text/html;charset=UTF-8;")
	public String clearCach(){
		
		JedisUtils.clear();
		String message="success";
		
		
		return message;
	}
	
	
	@RequestMapping(value=NewAnRequest.updateUserKey)
	public ModelAndView updateUserKey(){
		
		return new ModelAndView(LocationConstant.updateUserKey);
	}
	@ResponseBody
	@RequestMapping(value=NewAnRequest.updateUserKey+"/{user_id}",produces="text/html;charset=UTF-8;")
	public String updateUserKey(@PathVariable(value="user_id") String user_id,String user_key,String user_key_comfirm){
		//都不是空值
		if(CommoTools.isAllNotEmpty(user_id,user_key,user_key_comfirm)){
			//确认密码
			if(user_key.equals(user_key_comfirm)){
				//根据id获取信息
				
				return "新旧密码不能一样";
			}else{
				
				SysUser sysUser= userService.searchUserById(user_id);
				if(user_key.equals(sysUser.getUser_key())){
					//密码确认 输入正确 执行操作
					sysUser.setUser_key(user_key_comfirm);
					userService.updateUser(sysUser);
					return "修改成功";
				}else{
					return "原始密码错误";
				}
				
			}
		}else{
			return "不能为空";
		}
	}
}
