package com.rc_long.action.backStage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.helpers.LogLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.LiveRoom;
import com.rc_long.service.LiveService;
import com.rc_long.service.Impl.LiveServiceImpl;
import com.rc_long.utils.Pager;
import com.rc_long.utils.ReqUtils;

/**
 * 直播间管理
 * 
 * @author Administrator
 * 
 */
@Controller
public class BackStageLiveRoomAction {
	LiveService liveService = new LiveServiceImpl();

	@RequestMapping(value = AnRequest.sys_back_live_room)
	public ModelAndView initLiveRoom() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("is_recoment", "1");// 推荐
		map.put("live_status", "1");// 正在直播
		LiveRoom liveRoom = liveService.getSingle(map);
		return new ModelAndView("backStage/live_room/recomment_live_room")
				.addObject("liveRoom", liveRoom);
	}

	@RequestMapping(value = AnRequest.sys_back_live_room_search)
	public ModelAndView searchLive(HttpServletRequest req) {
		ReqUtils.Encoding(req);
		Map<String, String> map = new HashMap<String, String>();
		map = ReqUtils.parseSearch(map, req);
		Pager<LiveRoom> live_bean = liveService.getPager(map);

		return new ModelAndView("backStage/live_room/recomment_live_room_list")
				.addObject("live_bean", live_bean);
	}

	@RequestMapping(value = AnRequest.sys_back_live_room_update)
	public void update(HttpServletRequest req, HttpServletResponse rsp)
			throws IOException {
		PrintWriter w = rsp.getWriter();
		ReqUtils.Encoding(req);
		Map<String, Object> map = new HashMap<String, Object>();

		map = ReqUtils.parseUpdate(map, req, LiveRoom.class);

		map.remove("live_id");

		String live_id = req.getParameter("live_id");
		String[] inConditions = null;
		int result = 0;
		if (!StringUtils.isNullOrEmpty(live_id)) {
			map.put("condition", "{live_id:" + live_id + "}");
			map.remove("live_id");
		} else {
			String inCondition = req.getParameter("inCondition");
			if (StringUtils.isNullOrEmpty(inCondition)) {
				inConditions = inCondition.split(",");
				map.put("inCondition", inConditions);
			}
		}
		result = liveService.updateSingle(map);

		w.print(result);
		w.close();
	}

	@RequestMapping(value = AnRequest.sys_back_live_room_delete)
	public void deleteLive(HttpServletRequest req, HttpServletResponse rsp)
			throws IOException {
		PrintWriter w = rsp.getWriter();
		Map<String, Object> map = new HashMap<String, Object>();
		String live_id = req.getParameter("live_id");
		String[] inConditions = null;
		if (!StringUtils.isNullOrEmpty(live_id)) {
			map.put("condition", "{live_id:" + live_id + "}");
			map.remove("live_id");
		} else {
			String inCondition = req.getParameter("inCondition");
			if (StringUtils.isNullOrEmpty(inCondition)) {
				inConditions = inCondition.split(",");
				map.put("inCondition", inConditions);
			}
		}
		int result = 0;
		result = liveService.deleteSingle(map);
		w.print(result);
	}
	/**
	 * 推荐
	 * @param req
	 * @param rep
	 * @throws IOException
	 */
	@RequestMapping(value = AnRequest.sys_back_live_room_recomment)
	public void recomment(HttpServletRequest req, HttpServletResponse rep)
			throws IOException {
		String live_id = req.getParameter("live_id");
		LogLog.warn(live_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("condition", "{live_id:" + live_id + "}");
		
		map.put("is_recoment", 1);

		int result = liveService.updateSingle(map);

		PrintWriter p = rep.getWriter();

		p.print(result);

		p.close();

	}
	/**
	 * 取消推荐
	 * @param req
	 * @param rep
	 * @throws IOException 
	 */
	@RequestMapping(value = AnRequest.sys_back_live_room_noRecomment)
	public void noRecomment(HttpServletRequest req, HttpServletResponse rep) throws IOException{
		String live_id = req.getParameter("live_id");
		LogLog.warn(live_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("condition", "{live_id:" + live_id + "}");
		
		map.put("is_recoment", 0);

		int result = liveService.updateSingle(map);

		PrintWriter p = rep.getWriter();

		p.print(result);

		p.close();
	}
}
