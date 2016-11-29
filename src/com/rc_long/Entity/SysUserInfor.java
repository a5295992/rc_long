package com.rc_long.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 用户详细信息实体�?
 * @author longge
 *
 */
@Entity
@Table(name="sys_user_infor")
public class SysUserInfor extends EntitiBaseBean<SysUserInfor>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String use_id;
	
	private long user_phone;
	
	private String user_email;//邮箱
	
	private String user_addr;//地ס�?
	
	private  char user_sex;
	
	private int age;//年龄
	
	private String desc;//描述
	
	private String user_attr1;//特点 

	public String getUse_id() {
		return use_id;
	}

	public void setUse_id(String use_id) {
		this.use_id = use_id;
	}

	public long getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(long user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_addr() {
		return user_addr;
	}

	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}

	public char getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(char user_sex) {
		this.user_sex = user_sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUser_attr1() {
		return user_attr1;
	}

	public void setUser_attr1(String user_attr1) {
		this.user_attr1 = user_attr1;
	}
	
	
	

	
	
	
}
