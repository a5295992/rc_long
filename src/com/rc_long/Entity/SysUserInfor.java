package com.rc_long.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;


/**
 * 用户详细信息实体�?
 * @author longge
 *
 */
@RcLongTable(name=TableName.SysUserInfor)
@Entity
@Table(name="sys_user_infor")
public class SysUserInfor extends EntitiBaseBean<SysUserInfor>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String user_id;
	
	private Long user_phone;
	
	private String user_email;//邮箱
	
	private String user_addr;//地ס�?
	
	private  Character user_sex;
	
	private Integer age;//年龄
	
	private String user_desc;//描述
	
	private String user_attr1;//特点 
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "user_id", unique = true)  
	private SysUser sysUser;

	public String getUser_id() {
		return user_id;
	}

	public void setUse_id(String use_id) {
		this.user_id = use_id;
	}

	

	public Long getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(Long user_phone) {
		this.user_phone = user_phone;
	}

	public Character getUser_sex() {
		return user_sex;
	}

	public void setUser_sex(Character user_sex) {
		this.user_sex = user_sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	

	


	public String getUser_attr1() {
		return user_attr1;
	}

	public void setUser_attr1(String user_attr1) {
		this.user_attr1 = user_attr1;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getUser_desc() {
		return user_desc;
	}

	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}
	
	
	

	
	
	
}
