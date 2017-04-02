package com.rc_long.service;

import java.util.List;

import com.rc_long.Entity.News;
import com.rc_long.dao.dataSource.QueryCondition;
import com.rc_long.utils.Pager;

/**
 * 新闻 service
 * @author Administrator
 *
 */
public interface ModuleNewsService {
	
	/**
	 * 增
	 * @param news
	 */
	public void add(News news);
	
	/**
	 * 删
	 * @param news
	 */
	public void update(News news);
	
	/**
	 * 删除
	 * @param news
	 */
	public void delete(News news);
	
	/**
	 * 单独
	 * @param id
	 * @return
	 */
	public News getNews(String id);
	
	/**
	 * 查询分页
	 * @param queryCondition
	 * @return
	 */
	public Pager<News> getPager(QueryCondition queryCondition);
	
	//获取集合
	public List<News> getList(QueryCondition queryCondition);
}
