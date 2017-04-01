package com.rc_long.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.AnRequest;
import com.rc_long.Entity.ResourceBean;
import com.rc_long.ThreadPool.task.FileCopyTask;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.enumeration.gobalUtils;
import com.rc_long.service.ReSourceBeanService;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.ReqUtils;
import com.rc_long.utils.ResouTools;
import com.rc_long.utils.ThreadPoolsUtils;

@Controller
public class FileUploadAction {
	@Autowired
	private ReSourceBeanService resourceBeanService;
	
	@RequestMapping(value = AnRequest.sys_file_swf_upload)
	public ModelAndView fileUpload() {
		return new ModelAndView(LocationConstant.sys_file_swf_upload);
	}

	@RequestMapping(value = AnRequest.sys_file_swf_upload_start)
	public ModelAndView fileUploadStart(HttpServletRequest req)
			throws FileUploadException, IOException {
		ReqUtils.Encoding(req);

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) req;
		CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest
				.getFile("Filedata");
		String fileName = file.getOriginalFilename();
		// 当前用户
		String user_id = req.getParameter("user_id");
		if (StringUtils.isNullOrEmpty(user_id)) {
			return new ModelAndView(LocationConstant.erro_404);
		}
		// 当前时间
		String current_time = new SimpleDateFormat("yyyy-MM-dd")
				.format(new Date());
		// 类型
		String type = ResouTools.getRrsourceType(fileName);

		// id
		String resource_id = CommoTools.getUUID();

		String path = gobalUtils.getpath()+"/"+type+"/"+resource_id;
		// 如果路径不存在的话 ，自动创建..
		path = ResouTools.makePath(path);

		BufferedInputStream buf = new BufferedInputStream(file.getInputStream());

	
		
		//rtmp服务器路径
		
		String rtmpPath = gobalUtils.getRtmpPath()+"/"+resource_id;
		
		
		//开启另外一个线程去 copy 内容到rtnp服务器
		if(fileName.endsWith("mp4")){
			path =path+".mp4";
			rtmpPath = rtmpPath+".mp4";
		}else if(fileName.endsWith("flv")){
			path =path+".flv";
			rtmpPath = rtmpPath+".flv";
			
		}else {
			path =path+"/"+fileName;
		}
		
		BufferedOutputStream os = new BufferedOutputStream(
				new FileOutputStream(path));
		CommoTools.saveFile(buf, os);
		
		ThreadPoolsUtils.execute(new FileCopyTask(path,rtmpPath));
		
		//截图片
		String resource_name =gobalUtils.getpath() + "/" + type+"/"+resource_id;
		CommoTools.screenPNG(path,resource_name,fileName);
		// 将结果保存到数据库
		ResourceBean  rb =new ResourceBean();
		rb.setPlay_path("=rtmp:/vod/mp4:"+fileName);
		rb.setUser_id(user_id);
		rb.setResource_id(resource_id);
		rb.setResource_name(fileName);
		rb.setUpload_date(current_time);
		resourceBeanService.save(rb);
		
		return new ModelAndView(LocationConstant.sys_file_swf_upload);
	}
	
	

}
