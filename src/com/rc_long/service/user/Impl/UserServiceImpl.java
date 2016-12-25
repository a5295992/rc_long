package com.rc_long.service.user.Impl;

import java.util.Map;
import java.util.UUID;

import org.apache.log4j.helpers.LogLog;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Entity.SysUser;
import com.rc_long.Entity.SysUserBean;
import com.rc_long.Entity.SysUserInfor;
import com.rc_long.dao.DateBase;
import com.rc_long.service.user.UserService;
import com.rc_long.utils.Pager;

public class UserServiceImpl implements UserService {

	@Override
	public Pager<SysUser> getUserPager(String condition, Pager<SysUser> pager,
			String oder) {
		int count = DateBase.queryCount(SysUser.class, null, null);
		pager.setCount(count);
		return DateBase
				.queryList(
						SysUser.class,
						"user_ssid,user_id,user_name,user_img,user_staut,user_last_time,user_regist_time,user_type",
						condition, oder, pager, null);
	}

	@Override
	public int createUser(Map<String, Object> map) {
		SysUser su = getUser("user_name",
				"{user_ssid:" + (String) map.get("user_ssid") + "}");
		if (su != null) {
			return -1;
		} else {
			map.put("user_id", UUID.randomUUID().toString());
			return DateBase.insert(SysUser.class, map);
		}
	}

	@Override
	public SysUser login(Map<String, Object> map) {

		return DateBase
				.querySingle(
						SysUser.class,
						"user_name,user_ssid,user_id,user_flag,user_staut,user_type,user_img,user_last_time,user_ssid",
						"{user_ssid:'" + map.get("user_ssid") + "',user_key='"
								+ map.get("user_key") + "'}");
	}

	@Override
	public int updateInfor(Map<String, Object> map,
			Map<String, Object> condition) {
		
		return DateBase.update(SysUser.class, map, condition,null);
	}

	@Override
	public int delete(Map<String, Object> condition) {

		return DateBase.delete(SysUser.class, condition,null);
	}

	@Override
	public int createUserInfor(Map<String, Object> map) {

		return DateBase.insert(SysUserInfor.class, map);
	}

	@Override
	public int updateUserInfor(Map<String, Object> map,
			Map<String, Object> condition) {
		return DateBase.update(SysUserInfor.class, map, condition,null);
	}

	@Override
	public int deleteUserInfor(Map<String, Object> map) {

		return DateBase.delete(SysUserInfor.class, map,null);
	}

	@Override
	public SysUserBean getBean(Map<String, Object> map) {
		String sql = "select *from sys_user ";
		DateBase.runSql(sql, SysUserBean.class, new Object[] {});
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

	@Override
	public Pager<SysUser> getSysUserPager(Map<String, String> map) {

		int pageCount = 0;
		int count = 0;
		int pageNum = 0;
		String likeName = map.get("likeName");

		String like = map.get("like");
		String likeQ = null;
		if (likeName != null && (!likeName.trim().isEmpty())) {
			if (like != null && (!like.trim().isEmpty())) {
				likeQ = "" + likeName + "," + like + "";
				count = DateBase.queryCount(SysUser.class, null, "" + likeName
						+ "," + like + "");
			}
		} else {
			count = DateBase.queryCount(SysUser.class, null, null);
		}
		try {
			pageNum = StringUtils.getInt(map.get("pageNum").getBytes());
			pageCount = StringUtils.getInt(map.get("pagerCount").getBytes());
		} catch (Exception e) {
			pageCount = 10;
			LogLog.error("数据格式转换异常-UserServiceImpl-SysUserPager113行-pagerCount");
		}
		Pager<SysUser> userPager = new Pager<SysUser>(pageCount, count, pageNum);
		String query = "user_ssid,user_id,user_name,user_img,user_staut,user_last_time,user_regist_time,user_type,user_flag";

		String conditionJson = "";

		try {
			conditionJson = map.get("condition");
		} catch (Exception e1) {
			LogLog.error("条件为空");
		}
		// desc asc

		String oder = map.get("oder");

		String oderBy = map.get("oderBy");
		String orderJson = null;
		if (oder != null && (!oder.trim().isEmpty())) {
			if (oderBy != null && (!oderBy.trim().isEmpty())) {
				orderJson = "" + oderBy + "," + oder + "";
			} else {
				orderJson = "" + oderBy + ",'desc'";
			}
		}

		try {
			DateBase.queryList(SysUser.class, query, conditionJson, orderJson,
					userPager, likeQ);
		} catch (Exception e) {
			LogLog.error("queryList=数据查询失败=");
		}

		if (userPager.getPage() == 0) {
			userPager.setPage(1);
		}
		return userPager;
	}
}
