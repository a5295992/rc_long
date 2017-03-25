package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.VideoType;

public interface ModuleVideoTypeDao {

	List<VideoType> getVideoType(String hql, Object[] obj,int begin,int max);

}
