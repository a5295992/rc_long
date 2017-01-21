package com.rc_long.ThreadPool.task.service;

import javax.websocket.Session;

public interface FileReadService {


	void readFile(String a, Session session);

	void delete(String[] split);
	
	
}
