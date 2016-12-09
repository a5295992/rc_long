package com.rc_long.service.user;

import java.util.Map;

import com.rc_long.Entity.SysUser;
import com.rc_long.Entity.SysUserBean;
import com.rc_long.Entity.SysUserInfor;
import com.rc_long.utils.Pager;

public interface UserService {
	/**
	 * 初始化
	 * @return
	 */
	public Pager<SysUser> getUserPager();
	/**
	 * 创建新用户
	 * @param map
	 * @return
	 */
	public int  createUser(Map<String,Object> map);
	/**
	 * 创建新用户详细信息
	 * @param map
	 * @return
	 */
	public int createUserInfor(Map<String,Object> map);
	/**
	 * 登录
	 * @param map 用户名和密码
	 * @return
	 */
	public SysUser login(Map<String,Object> map); 
	/**
	 * 更新用户信息 
	 * @param map 更新的字段
	 * @param condition 约束条件
	 * @return -1代表 失败 大于0 代表成功
	 */
	public int  updateInfor(Map<String,Object> map,Map<String, Object> condition);
	/**
	 * 更新用户详细信息表 
	 * @param map 要更改的字段
	 * @param condition 约束条件
	 * @return -1代表 失败 大于0 代表成功
	 */
	public int updateUserInfor(Map<String,Object> map,Map<String, Object> condition); 
	
	public int delete(Map<String,Object> map);
	
	public int deleteUserInfor(Map<String,Object> map);
	/**
	 * 获取用户 和详细信息结合表
	 * @param map
	 * @return 
	 */
	public SysUserBean getBean(Map<String,Object> map);
	/**
	 * 获取用户表
	 * @param queryThing
	 * @param condition
	 * @return 
	 */
	public SysUser getUser(String queryThing,String condition);
	/**
	 * 获取用户详细信息表
	 * @param queryThing 要查找的字段
	 * @param condition 条件
	 * @return
	 */
	public SysUserInfor getUserInfor(String queryThing,String condition);
}
