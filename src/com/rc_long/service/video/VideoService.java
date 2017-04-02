package com.rc_long.service.video;

import java.util.List;
import java.util.Map;

import com.rc_long.Entity.SysVideo;
import com.rc_long.Entity.SysVideoBean;
import com.rc_long.utils.Pager;

public interface VideoService {
	
	public Pager<SysVideo> getVideoPager(String conditon,int pageCount,int pageNum);

	
	public Pager<SysVideoBean> getPargerBean();
	
	/**
	 * 获取带有用户属性的
	 * @param map
	 * @return
	 */
	public Pager<SysVideoBean> getVideoBean(Map<String,String> map);
	
	
	public List<SysVideoBean> getSysVideoBean(Map<String,String> map);
	
}
