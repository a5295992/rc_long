package com.rc_long.dao;

import com.rc_long.Entity.WiteSiteInfor;

public interface WiteSiteDao {

	WiteSiteInfor get(String id);

	void save(WiteSiteInfor witeSiteInfor);

	void update(WiteSiteInfor witeSiteInfor);

}
