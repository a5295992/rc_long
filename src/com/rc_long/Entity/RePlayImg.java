package com.rc_long.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
/**
 * 轮播图
 * @author Administrator
 *
 */
@Entity
@Table(name="re_play")
public class RePlayImg  extends EntitiBaseBean<RePlayImg>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String img;
	
	private String resource_id;
	
	private String href;
	
	private Integer menu_id;
	
	private String intruduction;
	private String title;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=ModuleMenu.class)
	@JoinColumn(name="menu_id",insertable=false,updatable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	private ModuleMenu moduleMenu;

	public ModuleMenu getModuleMenu() {
		return moduleMenu;
	}

	public void setModuleMenu(ModuleMenu moduleMenu) {
		this.moduleMenu = moduleMenu;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public String getIntruduction() {
		return intruduction;
	}

	public void setIntruduction(String intruduction) {
		this.intruduction = intruduction;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
