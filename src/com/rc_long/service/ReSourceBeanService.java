package com.rc_long.service;

import java.util.Map;

import com.rc_long.Entity.UserResourceBean;
import com.rc_long.utils.Pager;

public interface ReSourceBeanService {
	
	public Pager<UserResourceBean> getBean(Map<String,String> map);	
	
	public int delete(Map<String, Object> map);
}
