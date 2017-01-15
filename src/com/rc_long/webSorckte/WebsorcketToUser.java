package com.rc_long.webSorckte;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import com.rc_long.Entity.ChatLog;
import com.rc_long.ThreadPool.task.service.LogChatService;
import com.rc_long.service.Impl.LogChatServiceImpl;

//该注解用来指定一个URI，客户端可以通过这个URI来连接到WebSocket。类似Servlet的注解mapping。无需在web.xml中配置。
@ServerEndpoint(value = "/websocketToUser")
public class WebsorcketToUser {
	/**
	 * 
	 */

	// 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	private static int onlineCount = 0;

	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
	private static Map<String, WebsorcketToUser> webSocketSet = new HashMap<String, WebsorcketToUser>();

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	
	private String  key;

	/**
	 * 连接建立成功调用的方法
	 * 
	 * @param session
	 *            可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) {
		
		
		this.session = session;

		addOnlineCount(); // 在线数加1
		
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		webSocketSet.remove(this.key); // 从set中删除
		subOnlineCount(); // 在线数减1
	}

	/**
	 * 收到客户端消息后调用的方法
	 * 
	 * @param message
	 *            客户端发送过来的消息
	 * @param session
	 *            可选的参数
	 * @throws EncodeException
	 * @throws IOException
	 * @throws JSONException
	 */
	// 用流也可以
	// 用字符串也可以
	@OnMessage
	public void onMessage(String message, Session session)
			throws EncodeException, IOException, JSONException {
		// 数据转json
		JSONObject json = JSONObject.fromObject(message);
		// 获取数据信息
		String user_id = json.getString("user_id");

		// 是否新加入
		if (!webSocketSet.containsKey(user_id)) {
			key = user_id;
			webSocketSet.put(user_id, this);
		} else {
			String receive_id = null;
			String message1 = null;
			try {
				receive_id = json.getString("receive_id");
				message1 = json.getString("message");
			} catch (Exception e1) {
				receive_id = null;
				message1 = "";
			}
			if (receive_id != null) {
				WebsorcketToUser webSocketSet1 = webSocketSet.get(receive_id);
				LogChatService logChatService = new LogChatServiceImpl();
				ChatLog chatLog = new ChatLog();
				chatLog.setFriendId(user_id);//
				chatLog.setUserId(receive_id);
				chatLog.setLogContent(message1);
				if (webSocketSet1 != null) {
					webSocketSet1.sendMessage(message1);
					chatLog.setStatus(1);
					logChatService.setLogChat(chatLog);
				} else {
					chatLog.setStatus(0);
					// 如果没人的话 ，说明该用户还没有加入 会话 那么
					// 调用 会话储存 service 将数据保存到数据库
					logChatService.setLogChat(chatLog);
				}
			}else{
				
			}

		}

	}

	/**
	 * 发生错误时调用
	 * 
	 * @param session
	 * @param error
	 */
	@OnError
	public void onError(Session session, Throwable error) {
		System.out.println("发生错误");
		error.printStackTrace();
	}

	/**
	 * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
	 * 
	 * @param message
	 * @throws IOException
	 * @throws EncodeException
	 */
	public void sendMessage(String message) throws IOException, EncodeException {
		System.out.println("sendMessage::" + message);
		// this.session.getRemote().sendObject(message);
		// System.out.println(this.session.getId());
		// this.session.getAsyncRemote().sendText(message);
		// System.out.println(this.session.getContainer());
		this.session.getBasicRemote().sendText(message);

	}

	public static synchronized int getOnlineCount() {
		return onlineCount;
	}

	public static synchronized void addOnlineCount() {
		WebsorcketToUser.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebsorcketToUser.onlineCount--;
	}

}