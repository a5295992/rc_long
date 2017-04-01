package com.rc_long.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.ResourceBean;
import com.rc_long.dao.ReSourceBeanDao;
import com.rc_long.utils.SessionUtils;
@Component
public class ResourceBeanDaoImpl implements ReSourceBeanDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	
	@Override
	public void save(ResourceBean rb) {
		session = SessionUtils.getSession(sessionFactory);
		
		session.save(rb);
	}

}
