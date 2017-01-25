package com.rc_long.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.StringUtils;
import com.rc_long.Anrequest.AnRequest;
import com.rc_long.enumeration.LocationConstant;
import com.rc_long.enumeration.gobalUtils;
import com.rc_long.service.Impl.ReSourceBeanServiceImpl;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.ReqUtils;
import com.rc_long.utils.ResouTools;

@Controller
public class FileUploadAction {

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
		fileName = new String(fileName.getBytes("iso-8859-1"), "utf-8");
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
		String resource_id = UUID.randomUUID().toString().replace("-", "");

		String path = gobalUtils.getpath() + "/public/" + user_id + "/" + type
				+ "/" + current_time + "/" + resource_id;
		// 如果路径不存在的话 ，自动创建..
		path = ResouTools.makePath(path) + "/" + fileName;

		BufferedInputStream buf = new BufferedInputStream(file.getInputStream());

		BufferedOutputStream os = new BufferedOutputStream(
				new FileOutputStream(path));

		CommoTools.saveFile(buf, os);
		//截图片
		String resource_name =gobalUtils.getpath() + "/public/" + user_id + "/" + type
				+ "/" + current_time + "/" + resource_id;
		CommoTools.screenPNG(path,resource_name,fileName);
		// 将结果保存到数据库
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("type", type);
		map.put("resource_id", resource_id);
		map.put("fileName", fileName);
		map.put("user_id", user_id);
		map.put("current_time", current_time);
		new ReSourceBeanServiceImpl().saveBean(map);
		return new ModelAndView(LocationConstant.sys_file_swf_upload);
	}

}
