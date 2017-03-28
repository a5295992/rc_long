package com.rc_long.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.WiteSiteInfor;
import com.rc_long.dao.WiteSiteDao;
@Component
public class WiteSiteDaoImpl implements WiteSiteDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public WiteSiteInfor get(String id) {
		return Daoutils.getBeanById(sessionFactory,id,WiteSiteInfor.class);
	}

	@Override
	public void save(WiteSiteInfor witeSiteInfor) {
		Daoutils.saveBean(sessionFactory,witeSiteInfor);
	}

	@Override
	public void update(WiteSiteInfor witeSiteInfor) {
		Daoutils.updateBean(sessionFactory,witeSiteInfor);
	}

}
