package com.rc_long.service;

import java.util.Map;

import com.rc_long.Entity.SysRecommentSearch;
import com.rc_long.utils.Pager;

public interface RecommentService {
	public  Pager<SysRecommentSearch> getRecomment(Map<String,String> map);
}
