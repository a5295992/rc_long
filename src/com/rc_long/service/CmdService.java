package com.rc_long.service;
/**
 * 用来执行 cmd 命令的接口
 * @author Administrator
 *
 */
public interface CmdService {
	
	public void restartTomcat(String cmd);

	public String runBat(String string);

}
