package com.rc_long.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rc_long.Anrequest.AnRequest;
import com.rc_long.enumeration.LocationConstant;

@Controller
public class FileUploadAction {
	
	@RequestMapping(value=AnRequest.sys_file_swf_upload)
	public ModelAndView fileUpload(){
		return new ModelAndView(LocationConstant.sys_file_swf_upload);
	}
	
	@RequestMapping(value=AnRequest.sys_file_swf_upload_start)
	public void fileUploadStart(HttpServletRequest req) throws FileUploadException{
		DiskFileItemFactory disk=new DiskFileItemFactory();
		ServletFileUpload up=new ServletFileUpload(disk);
		List<FileItem> items=up.parseRequest(req);
		System.out.println(items.size()+"大小");
	}
}
