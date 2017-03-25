package com.rc_long.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;
/**
 * 菜单实体类
 * @author long
 */
@RcLongTable(name=TableName.SysMenu)
@Entity
@Table(name="sys_menu")
public class SysMenu extends EntitiBaseBean<SysMenu>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String co_id;
	@Id
	private String menu_id;//菜单id
	
	private String menu_pid;//父类菜单ID
	
	private String menu_name; //菜单名字
	
	private String menu_path;//请求路径 sys/video
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="menu_pid",unique = true,insertable=false,updatable=false)
	private SysMenu sysMenuS;
	
	@OneToMany(targetEntity=SysMenu.class,cascade=CascadeType.ALL)
	private List<SysMenu> sysMenuList;
	
	//区分 index 和back
	private String menu_flag;

	


	public String getCo_id() {
		return co_id;
	}

	public void setCo_id(String co_id) {
		this.co_id = co_id;
	}

	public String getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}

	public String getMenu_pid() {
		return menu_pid;
	}

	public void setMenu_pid(String menu_pid) {
		this.menu_pid = menu_pid;
	}

	public String getMenu_name() {
		return menu_name;
	}

	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}

	public String getMenu_path() {
		return menu_path;
	}

	public void setMenu_path(String menu_path) {
		this.menu_path = menu_path;
	}

	public String getMenu_flag() {
		return menu_flag;
	}

	public void setMenu_flag(String menu_flag) {
		this.menu_flag = menu_flag;
	}


	public List<SysMenu> getSysMenuList() {
		return sysMenuList;
	}

	public void setSysMenuList(List<SysMenu> sysMenuList) {
		this.sysMenuList = sysMenuList;
	}

	public SysMenu getSysMenuS() {
		return sysMenuS;
	}

	public void setSysMenuS(SysMenu sysMenuS) {
		this.sysMenuS = sysMenuS;
	}
	
	
}
