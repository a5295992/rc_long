package com.rc_long.dao_001;

import com.rc_long.entity_001.User;

public interface UserDao {
	
	/**
	 * �� userʵ�����浽���ݿ�
	 * @param u
	 */
	public abstract void save(User u);
	
	/**
	 * �����ݿ������ȡUser ʵ��
	 * @param id
	 * @return
	 */
	public abstract User getUser(String id);
}
