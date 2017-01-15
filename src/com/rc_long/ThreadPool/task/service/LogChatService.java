package com.rc_long.ThreadPool.task.service;

import java.util.List;
import java.util.Map;

import com.rc_long.Entity.ChatLog;

public interface LogChatService {
	
	public abstract void setLogChat(ChatLog chatLog);
	
	public abstract Map<String,List<ChatLog>> getAllLog(String user_id);
	
	public abstract List<ChatLog> getOnesLog(String user_id,String receive_id);
}
