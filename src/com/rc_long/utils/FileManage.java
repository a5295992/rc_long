package com.rc_long.utils;

import java.io.File;
import java.io.IOException;

import javax.websocket.Session;

public class FileManage {
	/**
	 * 获取 指定目录下所有文件和文件夹的名字
	 * @param session 
	 * @param file2
	 * @return
	 */
	public static void getFileList(File file, Session session) {
		
		if(file.isFile()){
			try {
				WebSorcketUtils.send(file.getName(), session);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			getFileName(file,session);
		}
	}
	/**
	 * 获取名字
	 * @param list
	 * @param file
	 * @param session 
	 */
	private static void getFileName( File file, Session session) {
		File[]  file1 = file.listFiles();
		for (File file2 : file1) {
				try {
					WebSorcketUtils.send(file2.getName(),session);
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
