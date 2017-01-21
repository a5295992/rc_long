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

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.UserResourceBean;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.enumeration.gobalUtils;
import com.rc_long.service.Impl.ReSourceBeanServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;

/**
 * 网站资源管理器
 * 
 * @author longge
 * 
 */
@Controller
public class BackStageWebResourceAction {
	@RequestMapping(value = AnRequest.sys_web_static_resource_manage)
	public ModelAndView init(HttpServletRequest req) {
		String path = gobalUtils.getpath();
		return new ModelAndView(LocationConstant.sys_web_static_resource_manage)
				.addObject("path", path);

	}

	@RequestMapping(value = AnRequest.sys_web_static_resource_manage_public)
	public ModelAndView publicResource(HttpServletRequest req) {
		String path = gobalUtils.getpath();

		// 采用websorcket 推送差咨询信息
		String message = "正在加载...";
		return new ModelAndView(
				LocationConstant.sys_web_static_resource_manage_public)
				.addObject("message", message).addObject("path",
						path + "/public");
	}

	// 数据库查找相应文件
	@RequestMapping(value = AnRequest.sys_web_static_resource_manage_database)
	public ModelAndView resourceDateBase(HttpServletRequest req) {
		// 查找是否私是个人
		// 或者是共有
		ReqUtils.Encoding(req);
		String is_personal = req.getParameter("is_personal");
		Map<String, String> map = new HashMap<String, String>();
		ReqUtils.parseSearch(map, req);

		if (!StringUtils.isNullOrEmpty(is_personal)) {

			map.put("condition", " is_personal = " + is_personal);
		}

		Pager<UserResourceBean> resource_bean = new ReSourceBeanServiceImpl()
				.getBean(map);

		return new ModelAndView(
				LocationConstant.sys_web_static_resource_manage_database)
				.addObject("resource_bean", resource_bean);
	}

	// 数据库查找相应文件
	@RequestMapping(value = AnRequest.sys_web_static_resource_manage_database_search)
	public ModelAndView resourceDateBaseResearch(HttpServletRequest req) {
		// 查找是否私是个人
		// 或者是共有
		ReqUtils.Encoding(req);
		String likeName = req.getParameter("likeName");
		String is_personal = req.getParameter("is_personal");
		Map<String, String> map = new HashMap<String, String>();
		ReqUtils.parseSearch(map, req);

		if (!StringUtils.isNullOrEmpty(is_personal)) {

			map.put("condition", " is_personal = " + is_personal);
		}

		Pager<UserResourceBean> resource_bean = new ReSourceBeanServiceImpl()
				.getBean(map);

		return new ModelAndView(
				LocationConstant.sys_web_static_resource_manage_database)
				.addObject("resource_bean", resource_bean).addObject(
						"likeName", likeName);
	}

	/**
	 * 删除
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = AnRequest.sys_web_static_resource_manage_database_delete)
	public void delete(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		PrintWriter pw = rep.getWriter();
		ReqUtils.Encoding(req);
		String resource_list = req.getParameter("resource_list");
		if (StringUtils.isNullOrEmpty(resource_list)) {
			pw.print(-1);

		} else {
			resource_list=ReqUtils.dealData(resource_list);

			Map<String, Object> map = new HashMap<String, Object>();

			map.put("someThingIn", "resource_id");

			map.put("inCondition", resource_list);

			int result = new ReSourceBeanServiceImpl().delete(map);
			pw.print(result);
		}
		pw.close();
	}

}
