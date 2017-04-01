package com.rc_long.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.ResourceBean;
import com.rc_long.Entity.UserResourceBean;
import com.rc_long.ThreadPool.task.service.FileReadService;
import com.rc_long.ThreadPool.task.service.impl.FileReadServiceImpl;
import com.rc_long.ThreadPool.task.service.impl.ServiceUtils;
import com.rc_long.dao.DateBase;
import com.rc_long.dao.DateBaseNew;
import com.rc_long.dao.ReSourceBeanDao;
import com.rc_long.service.ReSourceBeanService;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.Pager;
@Component
public class ReSourceBeanServiceImpl implements ReSourceBeanService {
	@Autowired
	private ReSourceBeanDao reSourceBeanDao;
	/**
	 * 获取 ResourceBean 的分页
	 */
	public Pager<UserResourceBean> getBean(Map<String, String> map) {
		
		
		String condition = map.get("condition");
		ServiceUtils.getMap(map);
		
		Class<UserResourceBean> clazz = UserResourceBean.class;
		;
		String queryThing = map.get("queryThing");
		if (com.mysql.jdbc.StringUtils.isNullOrEmpty(queryThing)) {
			queryThing = "a2.user_id,a2.user_name,upload_date,resource_format,resource_name,resource_id,resource_type,resource_personal";
		}

		String order = map.get("order");

		String like = map.get("like");

		List<UserResourceBean> list = DateBase.newQueryList(clazz, condition,
				queryThing, order, like);

		int pageCount = ServiceUtils.getPageCount(map);

		int count = DateBase
				.newQueryCount(clazz, condition, queryThing, order, like);
		int pageNum = ServiceUtils.getPageNum(map);

		// 获取pager 并将集合指定到其中

		Pager<UserResourceBean> pager = new Pager<UserResourceBean>(pageCount,
				count, pageNum);
		pager.setList(list);
		return pager;
	}
	
	/**
	 * 删除
	 * @param map
	 * @return
	 */
	public int delete(Map<String, Object> map) {
		
		String someThingIn = (String) map.get("someThingIn");
		
		String inCondition = (String) map.get("inCondition");
		
		//删除 用户文件夹中的文件
		FileReadService fileService= new FileReadServiceImpl();
		
		fileService.delete(inCondition.split(","));
		//将数据加上'号
		inCondition = CommoTools.addHot(inCondition);
		
		inCondition = someThingIn+" in ("+inCondition+")";
		
		String condition = (String) map.get("condition");
		
		return DateBaseNew.delete(ResourceBean.class, condition, inCondition);
	}
	
	/**
	 * 获取单个对象
	 * @param reource_id
	 * @return
	 */
	public ResourceBean getSingle(String reource_id) {
		
		String condtion = " resource_id='"+reource_id+"'";
		String queryThing = "user_id,resource_format,resource_name,resource_id,resource_type,resource_personal,upload_date";
		
		return DateBase.newQueryList(ResourceBean.class, condtion, queryThing, null, null).get(0);
	}

	public int saveBean(Map<String, Object> map) {
		
		ResourceBean resource = new ResourceBean();
		//默认0 公开的
		resource.setIs_personal(0);
		//1
		String type = (String) map.get("type");
		
		resource.setResource_format(type );
		//2
		String resource_id = (String) map.get("resource_id");
		
		resource.setResource_id(resource_id );
		//3
		String fileName = (String) map.get("fileName");
		
		resource.setResource_name(fileName);
		
		resource.setResource_personal("public");
		
		resource.setResource_type(type);
		//5
		String current_time = (String) map.get("current_time");
		resource.setUpload_date(current_time);
		//4
		String user_id = (String) map.get("user_id");
		resource.setUser_id(user_id );
		
		Map<String,Object> newMap = CommoTools.beanToMap(resource);
		newMap.remove("class");
		return DateBase.insert(ResourceBean.class, newMap);
	}

	@Override
	public void save(ResourceBean rb) {
		reSourceBeanDao.save(rb);
	}
}
