package com.rc_long.utils;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.rc_long.ThreadPool.task.service.impl.FileReadServiceImpl;
@ServerEndpoint(value = "/websocket")
public class WebSorcketUtils {
	
	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
		private Session session;
	public static void send(String list, Session session2) throws IOException {
		session2.getBasicRemote().sendText(list);
	}
	
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		System.out.println("hello");
		this.session=session;
	}
	
	@OnClose
	public void onClose() {

	}
	@OnMessage
	public void OnMessage(String message){
		System.out.println(message);
		 message = "E:/Program Files/Apache Software Foundation/Tomcat 8.0/webapps/rc_long/RESOURCES/"+message;
		new FileReadServiceImpl().readFile(message,session);
	}
	
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}
	
	public void sendMessage(String message) throws IOException, EncodeException {
		
	}
}
