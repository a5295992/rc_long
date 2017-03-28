package com.rc_long.service;

import com.rc_long.Entity.WiteSiteInfor;

public interface WiteSiteService {
	
	public String update(WiteSiteInfor witeSiteInfor);
	
	
	public String create(WiteSiteInfor witeSiteInfor);
	
	
	public WiteSiteInfor getBeanById(String id);
}
