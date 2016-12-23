package com.rc_long.action.backStage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

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
		map=ReqUtils.parseSearch(map, req);
		Pager<LiveRoom> live_bean =liveService.getPager(map);
		
		return new ModelAndView("backStage/live_room/recomment_live_room_list").addObject("live_bean", live_bean);
	}
	@RequestMapping(value = AnRequest.sys_back_live_room_search)
	public void update(HttpServletRequest req,HttpServletResponse rsp) throws IOException {
		PrintWriter w =rsp.getWriter();
		ReqUtils.Encoding(req);
		Map<String, String> map = new HashMap<String, String>();
		
		map=ReqUtils.parseUpdate(map, req);
		
		int result =liveService.updateSingle(map);
		
		w.print(result);
	}
	
}
