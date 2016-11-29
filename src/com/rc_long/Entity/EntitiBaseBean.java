package com.rc_long.Entity;

import java.io.Serializable;

/**
 * base  µÃÂ¿‡
 * @author longge
 * @param <T>
 *
 */
public class EntitiBaseBean<T> implements Serializable ,Comparable<T>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public String toString() {
		
		return super.toString();
	}
	
	

	@Override
	public int compareTo(T o) {
		
		return 0;
	}
	
	

}
