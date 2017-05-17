package com.rc_long.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.LiveRoom;
import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.ShiroUser;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.LiveRoomService;
import com.rc_long.service.ModuleMenuService;
import com.rc_long.service.user.SysUserService;
import com.rc_long.utils.CurrentSession;
import com.rc_long.utils.Pager;

@Controller

@RequestMapping(value=NewAnRequest.LiveRoom)//blive/xxx
public class LiveRoomAction {
	 
	@Autowired
	private LiveRoomService liveRoomService;
	@Autowired
	private SysUserService  sysUserService;
	@Autowired
	private ModuleMenuService moduleMenuService;
	
	
	//新增直播间
	@RequestMapping(value=NewAnRequest.toAddOrUpdate)
	public ModelAndView toAddOrUpdate(HttpServletRequest req){
		
		String liveRoomId = req.getParameter("liveId");
		if(StringUtils.isNullOrEmpty(liveRoomId)){
			List<ModuleMenu> menu_list = moduleMenuService.getMenu(true);
			ShiroUser sysUser = new CurrentSession(req).getShiroUser();
			if(sysUser==null){
				return new ModelAndView(LocationConstant.erro_403).addObject("message", "未登录");
			}
			LiveRoom liveRoom = liveRoomService.getByUserId(sysUser.getUser_id());
			if(liveRoom!=null){
				return new ModelAndView(LocationConstant.liveRoomAdd).addObject("message", "直播房间超过限制");
			}
			return new ModelAndView(LocationConstant.liveRoomAdd)
			.addObject("menu_list", menu_list);
		}else{
			LiveRoom liveRoom = liveRoomService.getById(liveRoomId);
			List<ModuleMenu> menu_list = moduleMenuService.getMenu(true);
			return new ModelAndView(LocationConstant.liveRoomUpdate)
			.addObject("liveRoom", liveRoom)
			.addObject("menu_list", menu_list);
		}
	}
	@ResponseBody
	@RequestMapping(value=NewAnRequest.addLiveRoom)
	public String add(LiveRoom liveRoom,HttpServletRequest req){
		
		
		liveRoomService.addOrUpdateLiveRoom(liveRoom);
		
		return "ok";
	}
	
	//删除直播间
	@ResponseBody
	@RequestMapping(value=NewAnRequest.deleLiveRoom+"/{liveId}")
	public String delete(@PathVariable String liveId){
		
		liveRoomService.deleteLiveRoom(liveId);
		
		return "ok";
	}
	//查询直播间
	
	@RequestMapping(value=NewAnRequest.findLiveRoom)
	public ModelAndView search(HttpServletRequest req){
		
		QueryCondition queryCondition = new QueryCondition(req);
		queryCondition.setClazz(LiveRoom.class);
		
		Pager<LiveRoom> liveRooms = liveRoomService.getPager(queryCondition);
		return new ModelAndView(LocationConstant.LiveRoomList).addObject("liveRooms", liveRooms);
	}
	
	//授权对象
	@RequestMapping(value=NewAnRequest.bliveupdate+"/{live_id}/{auth}")
	public String search(@PathVariable String live_id,@PathVariable Integer auth){
		
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("auth", auth);
		
		liveRoomService.update(live_id,map);
		return "ok";
	}
	
	
}
