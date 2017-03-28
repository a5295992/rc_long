package com.rc_long.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.helpers.LogLog;

import com.mysql.jdbc.StringUtils;
import com.rc_long.service.CmdService;
import com.rc_long.utils.PropUtils;

public class CmdServiceImpl implements CmdService {
	PropUtils prop  ;
	
	public  PropUtils getProp(){
		if(prop==null){
			return new PropUtils("/global.properties");
		}
		return prop;
	}
	@Override
	public void restartTomcat(String cmd) {
	
		prop = getProp();
		
		Runtime run  =Runtime.getRuntime();
		
		
		Process pro = null;
		try {
			pro = run.exec(prop.getValue("cmdtomcatRestart")+cmd);
		} catch (IOException e) {
			LogLog.error(e.getMessage().substring(0, 20));
		}
		InputStream fis = pro.getInputStream();
		 //用一个读输出流类去读    
        InputStreamReader isr=new InputStreamReader(fis);    
       //用缓冲器读行    
        BufferedReader br=new BufferedReader(isr);    
        String line=null;    
       //直到读完为止    
       try {
		while((line=br.readLine())!=null)    
		    {    
			   LogLog.debug(line);
		    }
	} catch (IOException e) {
		LogLog.error(e.getMessage().substring(0, 20));
	}  
	}
	@Override
	public String runBat(String string) {
	prop = getProp();
		
		Runtime run  =Runtime.getRuntime();
		
		
		Process pro = null;
		try {
			pro = run.exec(prop.getValue("cmdtomcatRestart")+string);
		} catch (IOException e) {
			e.printStackTrace();
		}
		InputStream fis = pro.getInputStream();
		 //用一个读输出流类去读    
        InputStreamReader isr=new InputStreamReader(fis);    
       //用缓冲器读行    
        BufferedReader br=new BufferedReader(isr);    
        String line=null;    
       //直到读完为止   
        StringBuilder sb = new StringBuilder();
       try {
    	   int index=0;
		while((line=br.readLine())!=null)    
		    {
				String line2 = new String(line.getBytes("GBK"),"UTF-8");
				if(!StringUtils.isNullOrEmpty(line2)){
					sb.append(line2.split(":")[1].trim());
					if(index<1){
						sb.append("/");
					}
					index=index+1;
				}
		    }
	} catch (IOException e) {
		e.printStackTrace();
	} 
		return sb.toString();
	}
	public static void main(String[] args) {
		CmdService cmdService = new CmdServiceImpl();
		System.out.println(cmdService.runBat("findmemery.bat"));
	}
	
}
