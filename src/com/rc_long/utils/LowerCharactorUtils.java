package com.rc_long.utils;


/**
 * 敏感字符集 工具类
 * @author Administrator
 *
 */
public class LowerCharactorUtils {
	
	
	private static String[] arr;
	
	static{
		arr=new String[]{"傻逼","脑残","智障","儿子","狗东西","垃圾","贱人","日你妈","操你爸","草你妈","日你爸","你大爷"};
	}
	
	public static int isLower(String comment_data) {
		
		for (int i = 0; i < arr.length; i++) {
			
			if(comment_data.contains(arr[i])){
				return -5;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(isLower("智障儿子"));
	}

}
