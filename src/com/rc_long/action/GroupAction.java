package com.rc_long.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.VideoGroup;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.ModuleGroupService;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.Pager;

/**
 * 分组管理 action
 * 
 * @author Administrator
 * 
 */
@Controller
@RequestMapping(value = NewAnRequest.group)
public class GroupAction {

	@Autowired
	private ModuleGroupService moduleGroupService;

	@Autowired
	private ModuleVideoService moduleVideoService;

	@RequestMapping(value = NewAnRequest.toGroupManage)
	public ModelAndView toGroupManage() {
		QueryCondition queryCondition = new QueryCondition();

		queryCondition.setClazz(VideoGroup.class);

		queryCondition.setPageNum(0);

		queryCondition.setMax(10);

		Pager<VideoGroup> videoGroup = moduleGroupService
				.getPager(queryCondition);

		return new ModelAndView(LocationConstant.sys_back_programa_manage)
				.addObject("videoGroup", videoGroup);
	}

	/**
	 * 添加或者修改
	 * 
	 * @param group_id
	 * @param group_name
	 * @param group_desc
	 * @param group_pid
	 * @param group_img
	 * @return
	 */
	@RequestMapping(value = NewAnRequest.group_create)
	public ModelAndView create(String group_id, String group_name,
			String group_desc, String group_pid, String group_img) {

		if (StringUtils.isNullOrEmpty(group_id)) {

			VideoGroup videoGroup = new VideoGroup();
			videoGroup.setGroup_id(CommoTools.getUUID());
			videoGroup.setGroup_create_time(CommoTools.getTime());
			videoGroup.setGroup_desc(group_desc);
			group_img = CommoTools.rePlace_(group_img, "\\", "/");
			videoGroup.setGroup_img(group_img);
			videoGroup.setGroup_name(group_name);
			videoGroup.setGroup_desc(group_desc);
			videoGroup.setGroup_pid(group_pid);
			moduleGroupService.save(videoGroup);

		} else {
			VideoGroup videoGroup = moduleGroupService.getVideoGroupByTyId(
					false, null, group_id);
			videoGroup.setGroup_desc(group_desc);
			group_img = CommoTools.rePlace_(group_img, "\\", "/");
			videoGroup.setGroup_img(group_img);
			videoGroup.setGroup_name(group_name);
			videoGroup.setGroup_desc(group_desc);
			videoGroup.setGroup_pid(group_pid);
			moduleGroupService.update(videoGroup);

		}
		QueryCondition queryCondition = new QueryCondition();

		queryCondition.setClazz(VideoGroup.class);

		queryCondition.setPageNum(0);

		queryCondition.setMax(10);

		Pager<VideoGroup> videoGroup = moduleGroupService
				.getPager(queryCondition);

		return new ModelAndView(LocationConstant.sys_back_programa_manage)
				.addObject("videoGroup", videoGroup);
	}

	/**
	 * 
	 * @param group_id
	 * @return
	 */

	// 查看 栏目下 所有视频
	@RequestMapping(value = NewAnRequest.findAllVideoInGroup + "/{group_id}")
	public ModelAndView findAllVideosInGroup(
			@PathVariable(value = "group_id") String group_id) {
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setClazz(SysVideo.class);
		queryCondition.setPageNum(0);
		queryCondition.setMax(10);
		queryCondition.setCondition("WHERE group_id = ?");
		queryCondition.setConditionObject(new Object[] { group_id });
		Pager<SysVideo> pager = moduleVideoService.getVideoList(queryCondition);

		return new ModelAndView(LocationConstant.video_list).addObject(
				"video_bean", pager);

	}

	// 查看 栏目下 所有视频
	@RequestMapping(value = NewAnRequest.addVideosToGroup + "/{group_id}")
	public ModelAndView addVideosInGroup(
			@PathVariable(value = "group_id") String group_id) {
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setClazz(SysVideo.class);
		queryCondition.setPageNum(0);
		queryCondition.setMax(10);
		queryCondition.setCondition("WHERE group_id != ?");
		queryCondition.setConditionObject(new Object[] { group_id });
		Pager<SysVideo> pager = moduleVideoService.getVideoList(queryCondition);

		return new ModelAndView(LocationConstant.video_list).addObject(
				"video_bean", pager);

	}

	// 添加 视频
	/**
	 * 添加 或者 删掉视频
	 * 
	 * @param group_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = NewAnRequest.addVideosToGroup)
	public String addVideoToGroup(HttpServletRequest req) {

		String group_id = req.getParameter("group_id");

		String videos = req.getParameter("videos");

		String in_videos = "(" + videos + ")";


		return moduleVideoService.updateGroupId(group_id, in_videos);

	}

	// 删除栏目 支持批量删除
	@ResponseBody
	@RequestMapping(value = NewAnRequest.deleteGroup)
	public String deleteGroup(HttpServletRequest req) {

		String group_ids = req.getParameter("group_ids");

		return moduleGroupService.delete(group_ids);

	}

	// 查询栏目

	@RequestMapping(value = NewAnRequest.group_search + "/{pageNum}")
	public ModelAndView search(@PathVariable(value = "pageNum") int pageNum,
			String likeName, String like) {

		QueryCondition queryCondition = new QueryCondition();

		queryCondition.setClazz(VideoGroup.class);

		queryCondition.setLike(likeName);

		queryCondition.setLikeName(like);

		queryCondition.setPageNum(pageNum);

		queryCondition.setMax(10);

		Pager<VideoGroup> videoGroup = moduleGroupService
				.getPager(queryCondition);

		return new ModelAndView(LocationConstant.sys_back_programa_manage)
				.addObject("videoGroup", videoGroup);

	}

}
