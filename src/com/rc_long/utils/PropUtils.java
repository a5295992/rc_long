package com.rc_long.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtils {
	
	private String propName;
	private Properties prop;
	public PropUtils() {
		
	}
	
	public PropUtils(String propName) {
		this.propName=propName;
		//注册 properies 
		registProp();
		try {
			this.prop.load(PropUtils.class.getResourceAsStream(propName));
		} catch (IOException e) {
			e.printStackTrace();
		};
	}
	
	public PropUtils(InputStream ins) {
		//注册 properies 
		registProp();
		try {
			this.prop.load(ins);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void registProp() {
		this.prop = new Properties();
	}
	
	public String getKeys(){
		return propName;
	}
	
	public String getValue(String key){
		
		return this.prop.getProperty(key, "");
	}
}
