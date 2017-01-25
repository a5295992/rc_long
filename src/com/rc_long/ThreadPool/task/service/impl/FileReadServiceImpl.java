package com.rc_long.ThreadPool.task.service.impl;

import java.io.File;

import javax.websocket.Session;

import com.rc_long.Entity.ResourceBean;
import com.rc_long.ThreadPool.MyTask;
import com.rc_long.ThreadPool.task.FileDelTask;
import com.rc_long.ThreadPool.task.service.FileReadService;
import com.rc_long.enumeration.gobalUtils;
import com.rc_long.service.Impl.ReSourceBeanServiceImpl;
import com.rc_long.utils.ThreadPoolsUtils;

public class FileReadServiceImpl implements FileReadService {

	@Override
	public void readFile(String a, Session session) {
		
		File file= new File(a);
		
		MyTask mt= new MyTask(file,session);
		
		ThreadPoolsUtils.execute(mt);
		
	}

	@Override
	public void delete(String[] split) {
		for (String reource_id : split) {
			ResourceBean rb = new ReSourceBeanServiceImpl().getSingle(reource_id);
			
			String path = gobalUtils.getpath()+"/"+rb.getResource_personal()+"/"+rb.getUser_id()+"/"+rb.getResource_type()+"/"+rb.getUpload_date()+"/"+rb.getResource_id()+"/"+rb.getResource_name();
			String path1 =gobalUtils.getpath()+"/"+rb.getResource_personal()+"/"+rb.getUser_id()+"/"+rb.getResource_type()+"/"+rb.getUpload_date()+"/"+rb.getResource_id()+"/"+rb.getResource_name()+".PNG";
			FileDelTask mt= new FileDelTask(path);
			FileDelTask mt2= new FileDelTask(path1);
			ThreadPoolsUtils.execute(mt);
			ThreadPoolsUtils.execute(mt2);
		}
	}
}
