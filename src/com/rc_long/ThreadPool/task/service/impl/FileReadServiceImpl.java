package com.rc_long.ThreadPool.task.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.apache.commons.lang.math.RandomUtils;

import com.rc_long.Entity.PoTree;
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

	@Override
	public List<PoTree> getFileList(String resourcePath) {
		//先响应一部分数据
		int i = 0;
		List<PoTree> list  = new ArrayList<PoTree>();
		PoTree  poTree = new PoTree();
		poTree.setId(RandomUtils.nextInt(100000));
		poTree.setName("RESOURCES");
		poTree.setParent(false);
		list.add(poTree);
		getFileList(resourcePath,poTree);
		
		return list;
	}
	//采取递归的方法
	private void getFileList(String resourcePath, PoTree poTree) {
		File file = new File(resourcePath);
		File[] files = file.listFiles();
		for (File file2 : files) {
			if(file2.isDirectory()){
				PoTree  poTree2= new PoTree();
				poTree2.setId(RandomUtils.nextInt(100000));
				poTree2.setName(file2.getName());
				poTree2.setParent(false);
				if(poTree.getChildren()==null){
					poTree.setChildren(new ArrayList<PoTree>());
				}
				poTree.getChildren().add(poTree2);
				getFileList(file2.getAbsolutePath(),poTree2);
			}else{
				PoTree  poTree2= new PoTree();
				poTree2.setId(RandomUtils.nextInt(100000));
				poTree2.setName(file2.getName());
				poTree2.setParent(false);
				poTree2.setPath(getContextPath(file2));
				if(poTree.getChildren()==null){
					poTree.setChildren(new ArrayList<PoTree>());
				}
				poTree.getChildren().add(poTree2);
			}
		}
	}
	private String getContextPath(File file2) {
		String a = file2.getAbsolutePath();
		String arr [] = a.split("RESOURCES");
		return "RESOURCES"+arr[1];
	}

	public static void main(String[] args) {
		String a= new FileReadServiceImpl().getContextPath(new File("E:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/rc_long/RESOURCES/public"));
		System.out.println(a);
	}

	private static void readList(List<PoTree> list) {
		for (PoTree poTree : list) {
			System.out.println("father:"+poTree.getName());
			if(poTree.getChildren()!=null){
				readList(poTree.getChildren());
			}
		}
	}
	
}
