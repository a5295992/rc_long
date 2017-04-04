package com.rc_long.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.RePlayImg;
import com.rc_long.dao.RePlayImgDao;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.service.RePlayImgService;
import com.rc_long.utils.Pager;

@Component
public class RePlayImgServiceImpl implements RePlayImgService {
	
	@Autowired
	private RePlayImgDao rePlayImgDao;
	
	@Override
	public void save(RePlayImg rePlayImg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(RePlayImg rePlayImg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dele(String re_id) {
		
	}

	@Override
	public RePlayImg get(String id) {
		
		
		return rePlayImgDao.get(RePlayImg.class,id);
	}

	@Override
	public Pager<RePlayImg> getPager(QueryCondition condition) {
		
		int count  = rePlayImgDao.getCount(condition);
		Pager<RePlayImg> pager = new Pager<RePlayImg>(condition.getMax(),count,condition.getPageNum());
		
		List<RePlayImg> list = rePlayImgDao.getList(condition,pager.getStart(),condition.getMax());
		pager.setList(list);
		return pager;
	}

	@Override
	public List<RePlayImg> getList(QueryCondition condition) {
		
		
		List<RePlayImg> list = rePlayImgDao.getList(condition,condition.getBegin(),condition.getMax());
		
		return list;
	}

	@Override
	public void saveOrUpdate(RePlayImg rePlayImg) {
		
		rePlayImgDao.saveorUpdate(rePlayImg);

	}

	@Override
	public void deles(String re_ids) {
		
		String sql = "delete from re_play as r where r.id in "+re_ids;
		
		rePlayImgDao.dele(sql);
	}

	@Override
	public void dele(Map<String, Object> map) {
		
		String hql = "DELETE FROM RePlayImg as r WHERE r.id=:id ";
		
		rePlayImgDao.dele(hql,map);
		
	}

}
