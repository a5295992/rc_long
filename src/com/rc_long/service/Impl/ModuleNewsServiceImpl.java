package com.rc_long.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.Entity.News;
import com.rc_long.dao.ModuleNewsDao;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.service.ModuleNewsService;
import com.rc_long.utils.Pager;

@Component
public class ModuleNewsServiceImpl implements ModuleNewsService {
	
	@Autowired
	private ModuleNewsDao moduleNewsDao;
	@Override
	public void add(News news) {
		
		moduleNewsDao.add(news);
	}

	@Override
	public void update(News news) {
		moduleNewsDao.update(news);
	}

	@Override
	public void delete(News news) {
		String hql = "delete from news where news_id =:news_id";
		
		moduleNewsDao.dele(hql,news);
	}

	@Override
	public News getNews(String id) {
		return moduleNewsDao.get(News.class,id);
	}

	@Override
	public Pager<News> getPager(QueryCondition queryCondition) {
		
		int count = moduleNewsDao.getCount(queryCondition);
		
		Pager<News> pager = new Pager<News>(queryCondition.getMax(),count,queryCondition.getPageNum());
		
		List<News> list = moduleNewsDao.getList(queryCondition,pager.getStart(),queryCondition.getMax());
		
		pager.setList(list);
		return pager;
	}

	@Override
	public List<News> getList(QueryCondition queryCondition) {
		List<News> list = moduleNewsDao.getList(queryCondition,queryCondition.getBegin(),queryCondition.getMax());
		return list;
	}

}
