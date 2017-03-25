package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.VideoGroup;

public interface ModuleGroupService {

	public List<VideoGroup> getVideoGroupList(boolean b, String string);

	public VideoGroup getVideoGroupByTyId(boolean fromCach,String cachName,String  group_id);
}
