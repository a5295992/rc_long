package com.rc_long.enumeration;

import com.rc_long.utils.PropUtils;

public class gobalUtils {

	public static String getpath() {
		return new PropUtils("/global.properties").getValue("resourcePath");
	}

}
