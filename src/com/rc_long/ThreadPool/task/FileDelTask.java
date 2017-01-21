package com.rc_long.ThreadPool.task;

import java.io.File;

import com.rc_long.ThreadPool.MyTaskInterface;

public class FileDelTask implements MyTaskInterface<FileDelTask>{
	
	private String path;
	
	public FileDelTask(String path) {
		this.path=path;
	}
	
	public FileDelTask() {
	}

	@Override
	public void run() {
		File file = new File(this.path);
		if(file.exists()){
			file.delete();
		}
	}
	
}
