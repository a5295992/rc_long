package com.rc_long.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rc_long.Anrequest.NewAnRequest;
import com.rc_long.Entity.Comment;
import com.rc_long.Entity.ReComment;
import com.rc_long.Entity.SysUser;
import com.rc_long.service.CommentService;
import com.rc_long.service.user.SysUserService;
import com.rc_long.utils.CommoTools;
import com.rc_long.utils.LowerCharactorUtils;
/**
 * 评论管理controler
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value=NewAnRequest.comment)
public class CommentAction {
	
	@Autowired
	private SysUserService userService;
	@Autowired
	private CommentService commentService;
	
	/**
	 * 评论
	 * @param comment_data
	 * @param user_id
	 * @param video_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=NewAnRequest.comment_create)
	public int commentCreate(String  comment_data,String user_id,String video_id){
		
		//该用户是否拥有发言权
		SysUser sysUser  =userService.searchUserById(user_id);
		int status =1;
		if(sysUser!=null&&sysUser.getUser_flag()==1){
			int in = LowerCharactorUtils.isLower(comment_data);
			//无敏感词汇
			if(in==-1){
				Comment commmet = new Comment();
				commmet.setComment_id(CommoTools.getUUID());
				commmet.setDate(CommoTools.getTime());
				commmet.setUser_id(user_id);
				commmet.setVideo_id(video_id);
				commmet.setText(comment_data);
				commentService.save(commmet);
			}else{
				//有敏感词汇
				status =-5;
			}
			
		}else{
			status = -2;
		}
		
		return status;
	}
	
	/**
	 * 回复 
	 * @param comment_data
	 * @param user_id
	 * @param video_id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value=NewAnRequest.comment_create+"/{comment_id}")
	public int commentCreateRecom(@PathVariable(value="comment_id") String comment_id,String  comment_data,String user_id,String video_id){
		
		//该用户是否拥有发言权
		SysUser sysUser  =userService.searchUserById(user_id);
		int status =1;
		if(sysUser!=null&&sysUser.getUser_flag()==1){
			int in = LowerCharactorUtils.isLower(comment_data);
			//无敏感词汇
			if(in==-1){
				ReComment commmet = new ReComment();
				commmet.setReComment_id(CommoTools.getUUID());
				commmet.setDate(CommoTools.getTime());
				commmet.setUser_id(user_id);
				commmet.setComment_id(comment_id);
				commmet.setText(comment_data);
				commentService.save(commmet);
				
			}else{
				//有敏感词汇
				status =-5;
			}
			
		}else{
			status = -2;
		}
		
		return status;
	}
}
