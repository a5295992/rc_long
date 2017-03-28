package com.rc_long.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.WiteSiteInfor;
import com.rc_long.dao.WiteSiteDao;
import com.rc_long.service.WiteSiteService;
@Component
public class WiteSiteServiceImpl implements WiteSiteService {
	@Autowired
	private WiteSiteDao witeSiteDao;
	@Override
	public String update(WiteSiteInfor witeSiteInfor) {
		try {
			witeSiteDao.update(witeSiteInfor);
			return "修改成功";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "修改失败";
	}

	@Override
	public String create(WiteSiteInfor witeSiteInfor) {
		
		witeSiteDao.save(witeSiteInfor);
		return "";
	}

	@Override
	public WiteSiteInfor getBeanById(String id) {
		
		return witeSiteDao.get(id);
	}

}
