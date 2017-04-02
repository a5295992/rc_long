package com.rc_long.dao.dataSource;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.StringUtils;

public class QueryCondition {
	
	public QueryCondition() {
	}
	private Class<?> clazz;
	//自定义 查询条件
	private String condition;
	//自定义条件数组
	private Object [] conditionObject =new Object []{};
	private int pageNum;
	private int begin = 0;
	
	private int max = 10;
	
	private String order;
	
	private String orderBy;
	
	private String like;
	
	private Object likeName;
	
	private String groupByName;
	
	private String count ="*";
	
	/**
	 * 专门用来封装查询条件的constractor
	 * @param req
	 */
	public QueryCondition(HttpServletRequest req) {
		String pageNum_ = req.getParameter("pageNum");	
		
		String pageCount = req.getParameter("pageCount");
		
		String like = req.getParameter("like");
		
		String likeName = req.getParameter("likeName");
		
		if(!StringUtils.isNullOrEmpty(pageCount)){
			this.max=Integer.parseInt(pageCount);
		}
		if(!StringUtils.isNullOrEmpty(pageNum_)){
			this.pageNum=Integer.parseInt(pageNum_);
		}
		if(!StringUtils.isNullOrEmpty(like)&&!StringUtils.isNullOrEmpty(likeName)){
			this.like=likeName;
			this.likeName=like;
		}
		
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	private Object [] obj = new Object[]{};
	
	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getLike() {
		return like;
	}

	public void setLike(String like) {
		this.like = like;
	}

	public Object getLikeName() {
		return likeName;
	}

	public void setLikeName(Object likeName) {
		this.likeName = likeName;
	}

	public String getGroupByName() {
		return groupByName;
	}

	public void setGroupByName(String groupByName) {
		this.groupByName = groupByName;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public Object [] getObj() {
		return obj;
	}

	public void setObj(Object [] obj) {
		this.obj = obj;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public Object [] getConditionObject() {
		return conditionObject;
	}

	public void setConditionObject(Object [] conditionObject) {
		this.conditionObject = conditionObject;
	}
	
	
}
