package com.rc_long.ThreadPool.task.service.impl;

import java.io.File;

import javax.websocket.Session;

import com.rc_long.ThreadPool.MyTask;
import com.rc_long.ThreadPool.task.service.FileReadService;
import com.rc_long.utils.ThreadPoolsUtils;

public class FileReadServiceImpl implements FileReadService {

	@Override
	public void readFile(String a, Session session) {
		
		File file= new File(a);
		
		MyTask mt= new MyTask(file,session);
		
		ThreadPoolsUtils.execute(mt);
		
	}

	
	
}
