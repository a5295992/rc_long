package com.rc_long.ThreadPool.task.service;

import java.util.List;

import javax.websocket.Session;

import com.rc_long.Entity.PoTree;

public interface FileReadService {


	void readFile(String a, Session session);

	void delete(String[] split);
	/**
	 * 获取网站静态文件
	 * jpg 
	 * mp4 doc
	 * @param resourcePath
	 * @return
	 */
	List<PoTree> getFileList(String resourcePath);
	
	
}
