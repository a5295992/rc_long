package com.rc_long.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.SysVideo;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.service.ModuleVideoService;
import com.rc_long.utils.Pager;
/**
 * 查询 操作action
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value=NewAnRequest.toSearch)
public class SearchAction {
	
	@Autowired
	private ModuleVideoService moduleVideoService;
	/**\
	 * 进入查询页面
	 * @return
	 */
	@RequestMapping(value="/")
	public ModelAndView toSearch(String search){
		long time1 =System.currentTimeMillis();
		QueryCondition queryCondition = new QueryCondition();
		queryCondition.setClazz(SysVideo.class);
		queryCondition.setPageNum(0);
		queryCondition.setMax(10);
		queryCondition.setCondition(" WHERE key_words LIKE ?");
		queryCondition.setConditionObject(new Object[]{search});
		Pager<SysVideo> videoPager = moduleVideoService.getVideoList(queryCondition);
		long time2 =System.currentTimeMillis();
		return new ModelAndView(LocationConstant.search).addObject("searchResult",videoPager)
				.addObject("time",time2-time1)
				.addObject("key",search);
	}
}
