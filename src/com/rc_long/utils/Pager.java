package com.rc_long.utils;

import java.util.List;

/**
 * 分页查询
 * @author longge
 * @param <T>
 *
 */
public class Pager<T> {
	public Pager(){
		
	}
	public Pager(int pageCount,int count,int pageNum){
		this.pageCount=pageCount;
		this.count=count;
		this.pageNum=pageNum;
		if(count%pageCount==0){
			page=count/pageCount;
		}else{
			page=count/pageCount+1;
		}
		this.start=pageNum*pageCount;
	}
	
	private int start;
	
	private int end;
	//多少页
	private int page;
	//当前页
	private int pageNum;
	
	private int count;
	//一页显示多少
	private int pageCount;
	//数据集合
	private List<T> list;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
