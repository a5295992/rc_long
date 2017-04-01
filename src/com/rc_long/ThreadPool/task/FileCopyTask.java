package com.rc_long.ThreadPool.task;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.rc_long.ThreadPool.MyTaskInterface;
import com.rc_long.utils.CommoTools;

public class FileCopyTask implements MyTaskInterface<FileCopyTask> {
	
	private String theOneFile;
	
	private String theOtherFile;
	
	public FileCopyTask() {
		// TODO Auto-generated constructor stub
	}
	
	public FileCopyTask(String theOneFile,String theOtherFile) {
		
		this.theOneFile=theOneFile;
		
		this.theOtherFile=theOtherFile;
	}

	@Override
	public void run() {
		
		
		
		try {
			
			BufferedInputStream buf = new BufferedInputStream(new FileInputStream(theOneFile));
			
			
			BufferedOutputStream bof = new BufferedOutputStream(new FileOutputStream(theOtherFile));
			
			
			CommoTools.saveFile(buf, bof);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
