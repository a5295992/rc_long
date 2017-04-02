package com.rc_long.dao;

import java.util.List;

import com.rc_long.Entity.News;
import com.rc_long.dao.dataSource.QueryCondition;

public interface ModuleNewsDao {

	void add(News news);

	void update(News news);

	void dele(News news);

	News get(Class<News> class1, String id);

	int getCount(QueryCondition queryCondition);

	List<News> getList(QueryCondition queryCondition, int i, int j);

	void dele(String hql, News news);
	
}
