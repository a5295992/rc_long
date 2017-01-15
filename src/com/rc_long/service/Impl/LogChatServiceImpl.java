package com.rc_long.service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.rc_long.Entity.ChatLog;
import com.rc_long.ThreadPool.task.service.LogChatService;
import com.rc_long.dao.DateBase;
import com.rc_long.dao.DateBaseCount;
import com.rc_long.dao.DateBaseNew;

public class LogChatServiceImpl implements LogChatService {

	@Override
	public void setLogChat(ChatLog chatLog) {
		
		String log_id = UUID.randomUUID().toString().replace("-", "").substring(0, 15);

		String friend_id = chatLog.getFriendId();

		String user_id = chatLog.getUserId();

		String log_time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

		String log_content = chatLog.getLogContent();// 内容

		int status = 0;// 1 已读 0 未读
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("log_id", log_id);
		map.put("friend_id", friend_id);
		map.put("user_id", user_id);
		map.put("log_content", log_content);
		map.put("log_time", log_time);
		map.put("status", status);
		
		DateBase.insert(ChatLog.class, map);
	}

	@Override
	public Map<String, List<ChatLog>> getAllLog(String user_id) {
		
		String sql = "select *from chat_log where user_id = ? ";
		Object  []params ={user_id}; 
		List<ChatLog> list = DateBase.getBeanListRunsql(ChatLog.class, sql, params  );
		Map<String,List<ChatLog>> map = new HashMap<String, List<ChatLog>>();
		
		for (ChatLog chatLog : list) {
			if(map.containsKey(chatLog.getFriendId())){
				map.get(chatLog.getFriendId()).add(chatLog);
			}else{
				List<ChatLog> list2= new ArrayList<ChatLog>();
				list2.add(chatLog);
				map.put(chatLog.getFriendId(), list2);
			}
		}
		return map;
	}

	@Override
	public List<ChatLog> getOnesLog(String user_id, String receive_id) {
		
		String sql = "select *from chat_log where user_id = ? and friend_id= ?";
		
		Object  []params ={user_id,receive_id}; 
		return DateBase.getBeanListRunsql(ChatLog.class, sql, params  );
	}

	public int getAllLogCount(String user_id, int i) {
		String sql = "select count(*) from chat_log where user_id = ? and status = ?";
		Object  []params ={user_id,i}; 
		return DateBaseCount.queryCount(ChatLog.class,sql,params);
	}

	public void updateStauts(String user_id, int i) {
		
		String sql = "update chat_log  set status = 1 where user_id = ? and status = ?";
		Object  []params ={user_id,i}; 
		DateBaseNew.update(ChatLog.class, sql, params);
	}
}
