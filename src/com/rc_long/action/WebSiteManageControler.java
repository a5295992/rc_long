package com.rc_long.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.PoTree;
import com.rc_long.Entity.ShiroUser;
import com.rc_long.Entity.WiteSiteInfor;
import com.rc_long.ThreadPool.task.service.FileReadService;
import com.rc_long.ThreadPool.task.service.impl.FileReadServiceImpl;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.CmdService;
import com.rc_long.service.WiteSiteService;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.CurrentSession;
import com.rc_long.utils.PropUtils;

@Controller
@RequestMapping(value=NewAnRequest.system)
public class WebSiteManageControler {
	@Autowired
	private WiteSiteService witeSiteService;
	
	@RequestMapping(value=NewAnRequest.witeSet)
	public ModelAndView init(){
		
		WiteSiteInfor witeSiteInfor = witeSiteService.getBeanById("10001");
		
		return new ModelAndView(LocationConstant.witeSet)
		.addObject("witeSiteInfor",witeSiteInfor)
		;	
	}
	
	@RequestMapping(value=NewAnRequest.witeSetUpdate)
	public ModelAndView witeSet(HttpServletRequest req ,WiteSiteInfor witeSiteInfor){
		//是否拥有权限
		String message ="";
		if(CommoTools.ifAuth(req)){
			if(witeSiteInfor!=null){
				message = witeSiteService.update(witeSiteInfor);
			}
		}
		
		return new ModelAndView(LocationConstant.witeSet).
				addObject("message",message);
	}
	
	@RequestMapping(value=NewAnRequest.witeSetCreate)
	public ModelAndView witeSetCreate(HttpServletRequest req ,WiteSiteInfor witeSiteInfor){
		//是否拥有权限
		String message ="";
		if(CommoTools.ifAuth(req)){
			if(witeSiteInfor!=null){
				message = witeSiteService.create(witeSiteInfor);
			}
		}
		return new ModelAndView(LocationConstant.witeSet).
				addObject("message",message);
	}
	
	
	@RequestMapping(value=NewAnRequest.witeSetSearch+"/{id}")
	public ModelAndView witeSetCreate(@PathVariable(value="id") String id){
		
		WiteSiteInfor witeSiteInfor = witeSiteService.getBeanById(id);
		
		return new ModelAndView(LocationConstant.witeSet)
		.addObject("witeSiteInfor",witeSiteInfor)
		;
	}
	
	@RequestMapping(value=NewAnRequest.restart)
	public ModelAndView restratTomcat(HttpServletRequest req){
		//1判断是否登录 
		ShiroUser shirUser = new CurrentSession(req).getShiroUser();
		
		if(shirUser!=null){
			//2.验证管理员权限
			//是否是管理员
			if(shirUser.getUser_type()==1){
				CmdService cmdService = new CmdServiceImpl();
				//说明 只正对 非myeclibs 开启的服务器
				cmdService.restartTomcat("shutdown.bat");
				
				cmdService.restartTomcat("startup.bat");
			}
		}
		return new ModelAndView(LocationConstant.erro_403);
	}
	/**
	 * 获取所有的静态文件数据
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=NewAnRequest.fileList)
	public List<PoTree> getFileTreeList(){
		String resourcePath = new PropUtils("/global.properties").getValue("resourcePath");
		FileReadService fileReadService =new FileReadServiceImpl();
		
		List<PoTree>  list = fileReadService.getFileList(resourcePath);
		
		System.out.println(list);
		return list;
	}
}
