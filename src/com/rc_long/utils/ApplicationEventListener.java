package com.rc_long.utils;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

public class ApplicationEventListener implements ApplicationListener {
	public void onApplicationEvent(ApplicationEvent event) {
	
		 //容器关闭时触发的事件
		if(event instanceof ContextClosedEvent ){
			//
			System.out.println("A 容器关闭了");
			JedisUtils.clear();
		}else{
			
		}
	
	}
}