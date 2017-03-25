package com.rc_long.test;

import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rc_long.service.MenuService;
public class TestMenuService {
	
	private MenuService munuService;
	
	@Test
	public void testGetMunuList(){
		System.out.println(munuService);
	}
	
}
