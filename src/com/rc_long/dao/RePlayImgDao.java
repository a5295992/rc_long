package com.rc_long.dao;

import java.util.List;
import java.util.Map;

import com.rc_long.Entity.RePlayImg;
import com.rc_long.dao.dataSource.QueryCondition;

public interface RePlayImgDao {

	void saveorUpdate(RePlayImg rePlayImg);


	int getCount(QueryCondition condition);

	List<RePlayImg> getList(QueryCondition condition, int start, int max);

	RePlayImg get(Class<RePlayImg> class1, String id);

	void dele(String hql);


	void dele(String hql, Map<String, Object> map);

}
