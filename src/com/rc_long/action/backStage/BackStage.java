package com.rc_long.action.backStage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.SysUser;
import com.rc_long.service.user.UserService;
import com.rc_long.service.user.Impl.UserServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;

/**
 * 后台管理
 * 
 * @author Administrator
 * 
 */
@Controller
public class BackStage {
	// 用戶
	UserService userService = new UserServiceImpl();

	@RequestMapping(value = AnRequest.sys_back)
	public ModelAndView init() {
		return new ModelAndView("backStage/index");
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = AnRequest.sys_back_user)
	public ModelAndView findUserList() {

		Map<String, String> map = new HashMap<String, String>();

		map.put("pagerCount", "10");
		map.put("pageNum", "0");

		// 条件
		Pager<SysUser> user_bean = userService.getSysUserPager(map);

		return new ModelAndView("backStage/user_list").addObject("user_bean",
				user_bean);
	}

	@RequestMapping(value = AnRequest.sys_back_user_qupdate)
	public ModelAndView queryBeforeupdate(HttpServletRequest req) {
		String queryThing = "user_id,user_name,user_ssid,user_flag,user_type,user_group";
		String user_id = req.getParameter("user_id");
		String condition = "{user_id:" + user_id + "}";
		SysUser user = userService.getUser(queryThing, condition);
		return new ModelAndView("backStage/user_edit").addObject("user", user);
	}

	@RequestMapping(value = AnRequest.sys_back_user_update)
	public void updateUser(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		PrintWriter writer = rep.getWriter();
		String user_id = req.getParameter("user_id");
		Map<String, Object> map = new HashMap<String, Object>();
		// 修改用户标志 和
		String user_type = req.getParameter("user_type");

		String user_flag = req.getParameter("user_flag");
		System.out.println("获取的 user_ttype为" + user_type);
		if (!user_type.trim().isEmpty()) {
			map.put("user_type", user_type);
		} else {
			map.put("user_type", 0);
		}
		if (!user_flag.trim().isEmpty()) {
			map.put("user_flag", user_flag);
		} else {
			map.put("user_flag", 0);
		}
		// 更新字段
		Map<String, Object> condition = new HashMap<String, Object>();
		// 条件
		condition.put("user_id", user_id);
		int result = userService.updateInfor(map, condition);
		// 如果修改成功
		writer.print(result);
	}

	@RequestMapping(value = AnRequest.sys_back_user_delete)
	public void deleteUser(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		PrintWriter writer = rep.getWriter();
		String user_id = req.getParameter("user_id");
		// 更新字段
		Map<String, Object> condition = new HashMap<String, Object>();
		// 条件
		condition.put("user_id", user_id);
		int result = userService.delete(condition);
		// 如果修改成功
		writer.print(result);
	}

	@RequestMapping(value = AnRequest.sys_back_user_search)
	public ModelAndView searchUser(HttpServletRequest req) throws IOException {
		ReqUtils.Encoding(req);
		String pageCount = req.getParameter("pageCount");
		String pageNum = req.getParameter("pageNum");
		// 更新字段
		String oderBy = req.getParameter("oderBy");
		String oder = req.getParameter("oder");
		String condition = "";
		String likeName = req.getParameter("likeName");
		String like = req.getParameter("like");
		Map<String, String> map = new HashMap<String, String>();
		map.put("pagerCount", pageCount);
		map.put("pageNum", pageNum);
		map.put("oderBy", oderBy);
		map.put("oder", oder);
		map.put("condition", condition);
		map.put("likeName", likeName);
		map.put("like", like);
		map =ReqUtils.parse(map,req);
		// 条件
		Pager<SysUser> user_bean = userService.getSysUserPager(map);
		if (oder==null || oder.trim().isEmpty()) {
			if (oderBy == null || oderBy.trim().isEmpty()) {
				map.put("oderBy", "user_id");
				map.put("oder", "desc");
			}
		}
		return new ModelAndView("backStage/user_list").addObject("user_bean",
				user_bean).addObject("likeName", likeName)
				.addObject("map", map);
	}

}
