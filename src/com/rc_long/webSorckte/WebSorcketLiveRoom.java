package com.rc_long.webSorckte;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

import com.rc_long.ThreadPool.MyTaskInterface;
import com.rc_long.utils.ThreadPoolsUtils;

@ServerEndpoint(value = "/websocketToLiveRoom")
public class WebSorcketLiveRoom {
	
	
	private static int onlineCount = 0;

	// concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识

	// 与某个客户端的连接会话，需要通过它来给客户端发送数据
	private Session session;
	private static Set<WebSorcketLiveRoom> webSorcketLiveRoom =new HashSet<WebSorcketLiveRoom>();
	private static Map<String,Integer> user = new HashMap<String,Integer>();
	
	/**
	 * 连接建立成功调用的方法
	 * 
	 * @param session
	 *            可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
	 * @throws EncodeException 
	 * @throws IOException 
	 */
	@OnOpen
	public void onOpen(Session session, EndpointConfig config) throws IOException, EncodeException {
		
		
		this.session = session;
		webSorcketLiveRoom.add(this);
		addOnlineCount(); // 在线数加1
		
	}

	/**
	 * 连接关闭调用的方法
	 */
	@OnClose
	public void onClose() {
		subOnlineCount(); // 在线数减1
		webSorcketLiveRoom.remove(this);
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
		if(json.get("live_fid")!=null){
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("count", getOnlineCount());
			map.put("live_id", json.get("live_fid"));
			JSONObject json2 = JSONObject.fromObject(map);
			sendMessage(json2.toString());
		}
		String  user_name = (String) json.get("user_name");
		if(json.get("user_name")!=null){
			if(user.containsKey(user_name)){
				if(user.get(user_name)==0){
					sendMessage(message);
				}else{
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("errorMessage", "发言过于频繁");
					JSONObject json2 = JSONObject.fromObject(map);
					for (WebSorcketLiveRoom element : webSorcketLiveRoom) {
						element.sendMessage(json2.toString());
					}
				}
			}else{
				user.put(user_name, 3);
				for (WebSorcketLiveRoom element : webSorcketLiveRoom) {
					element.sendMessage(message);
				}
				sendMessage(message);
				ThreadPoolsUtils.execute(new CountThred(user,user_name));
			}
		}
		// 获取数据信息
		
		// 是否新加入
		

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
		WebSorcketLiveRoom.onlineCount++;
	}

	public static synchronized void subOnlineCount() {
		WebSorcketLiveRoom.onlineCount--;
	}
	
/*	public static void main(String[] args) {
		Set<String> user = new HashSet<String>();
		user.add("111");
		user.add("111");
		user.add("111");
		user.add("111");
		
	}*/
	
	
}

class CountThred implements MyTaskInterface<CountThred>{
	
	private Map<String, Integer> user;
	private String key;
	 public CountThred(){
		
	}
	
	 public CountThred(Map<String, Integer> user ,String key){
		this.user=user;
		this.key =key;
	}
	@Override
	public void run() {
		for (int i = user.get(key); i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			user.put(key, i);
		}
		user.remove(key);
	}
	
}
