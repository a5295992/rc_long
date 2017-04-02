package com.rc_long.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.ModuleMenu;
import com.rc_long.Entity.News;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.ModuleMenuService;
import com.rc_long.service.ModuleNewsService;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.Pager;
/**
 * 新闻acation
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value=NewAnRequest.news)
public class NewsAction {
	
	@Autowired
	private ModuleNewsService moduleNewsService; 
	
	
	private ModelAndView modelAndView;
	
	@Autowired
	private ModuleMenuService moduleMenuService;
	/**
	 * 增
	 */
	@RequestMapping(value=NewAnRequest.news_add,method=RequestMethod.GET)
	public ModelAndView toAdd(){
		
		
		List<ModuleMenu> list  = moduleMenuService.getMenu(true);
		
		modelAndView = new ModelAndView(LocationConstant.addNews);
		return modelAndView.addObject("menu_list",list);
	}
	
	/**
	 * 增
	 */
	@ResponseBody
	@RequestMapping(value=NewAnRequest.news_add,method=RequestMethod.POST)
	public String add(News news){
		news.setCreate_time(CommoTools.getTime());
		moduleNewsService.add(news); 
		
		
		return "success";
	}
	/**
	 * 删
	 */
	
	@ResponseBody
	@RequestMapping(value=NewAnRequest.news_dele+"/{news_id}")
	public String dele(@PathVariable String news_id){
		String message = "";
		if(!StringUtils.isNullOrEmpty(news_id)){
			News news = moduleNewsService.getNews(news_id);
			
			if(news!=null){
				
				moduleNewsService.delete(news);
				message = "success";
			}else{
				message ="no record";
			}
		}else{
			message = "id no indetify";
		}
		
		return message;
	}
	/**
	 * 查
	 */
	@RequestMapping(value=NewAnRequest.news_list)
	public ModelAndView newsList(HttpServletRequest req){
		
		//这个构造方法中封装了简单的分页和模糊查询
		QueryCondition queryCondition = new QueryCondition(req);
		
		queryCondition.setClazz(News.class);
		
		Pager<News> newsPager = moduleNewsService.getPager(queryCondition );
		
		modelAndView = new ModelAndView(LocationConstant.newsList);
		
		return modelAndView.addObject("newsPager",newsPager);
	}
	
	/**
	 * 改
	 * 
	 */
	@RequestMapping(value=NewAnRequest.news_update+"/{news_id}",method=RequestMethod.GET)
	public ModelAndView toupdate(@PathVariable String news_id){
		
		News news = moduleNewsService.getNews(news_id);
		List<ModuleMenu> list  = moduleMenuService.getMenu(true);
		modelAndView = new ModelAndView(LocationConstant.updateNews);
		
		return modelAndView.addObject("news", news).addObject("menu_list", list);
	}
	
	/**
	 * 
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@ResponseBody
	@RequestMapping(value=NewAnRequest.news_update,method=RequestMethod.POST)
	public String update(News news){
		news.setCreate_time(CommoTools.getTime());
		moduleNewsService.update(news); 
		
		return "success";
	}
	
	
}
