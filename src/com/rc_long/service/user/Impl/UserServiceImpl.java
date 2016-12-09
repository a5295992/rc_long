package com.rc_long.service.user.Impl;

import java.util.Map;
import java.util.UUID;

import com.rc_long.Entity.SysUser;
import com.rc_long.Entity.SysUserBean;
import com.rc_long.Entity.SysUserInfor;
import com.rc_long.dao.DateBase;
import com.rc_long.service.user.UserService;
import com.rc_long.utils.Pager;

public class UserServiceImpl implements UserService {

	@Override
	public Pager<SysUser> getUserPager() {
		int count =DateBase.queryCount(SysUser.class);
		
		return DateBase.queryList(SysUser.class, "user_id,user_name,user_img,user_staut,user_last_time,user_regist_time", "{user_flag:'1'}", "user_id,desc", new Pager<SysUser>(10,count,0), null);
	}

	@Override
	public int createUser(Map<String,Object> map) {
			SysUser su=getUser("user_name", "{user_name:"+map.get("user_name")+"}");
			if(su!=null){
				return -1;
			}else{
				map.put("user_id", UUID.randomUUID().toString());
				return DateBase.insert(SysUser.class, map);
			}
	}

	@Override
	public SysUser login(Map<String,Object> map) {
		
		return DateBase.querySingle(SysUser.class, "user_name,user_ssid,user_id,user_flag,user_staut,user_type,user_img,user_last_time", "{user_ssid:'"+map.get("user_ssid")+"',user_key='"+map.get("user_key")+"'}");
	}

	@Override
	public int  updateInfor(Map<String, Object> map,Map<String, Object> condition) {
		return DateBase.update(SysUser.class, map, condition);
	}

	@Override
	public int delete(Map<String, Object> condition) {
		
		return DateBase.delete(SysUser.class, condition);
	}

	@Override
	public int createUserInfor(Map<String, Object> map) {
		
		return DateBase.insert(SysUserInfor.class, map);
	}

	@Override
	public int updateUserInfor(Map<String, Object> map,
			Map<String, Object> condition) {
		return DateBase.update(SysUserInfor.class, map, condition);
	}

	@Override
	public int deleteUserInfor(Map<String, Object> map) {
		
		return DateBase.delete(SysUserInfor.class, map);
	}

	@Override
	public SysUserBean getBean(Map<String, Object> map) {
		
		return null;
	}

	@Override
	public SysUser getUser(String queryThing, String condition) {
		
		return DateBase.querySingle(SysUser.class, queryThing, condition);
	}

	@Override
	public SysUserInfor getUserInfor(String queryThing, String condition) {
		
		return DateBase.querySingle(SysUserInfor.class, queryThing, condition);
	}

	
}
