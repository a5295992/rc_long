package com.rc_long.ThreadPool;

import java.io.File;

import javax.websocket.Session;

import com.rc_long.utils.FileManage;

public class MyTask extends Thread{
	
	private File file;
	
	private Session session;
	public MyTask(File file, Session session){
		this.file= file;
		this.session= session;
	}
	
	public MyTask(File file){
		this.file= file;
	}
	
	
	@Override
	public void run() {
		taskStart();
		super.run();
	}

	private void taskStart() {
		//1.获取文件名 和文件夹名
		FileManage.getFileList(file,session);
	}
}
