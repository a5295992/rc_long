package com.rc_long.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * 菜单实体
 * @author Administrator
 *
 */
@Entity
@Table(name="module_menu")
public class ModuleMenu  extends EntitiBaseBean<ModuleMenu>{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	private int id;
	
	private String name;
	//菜单类型
	// movie tv news lives
	private String type;
	
	
	private boolean isChecked;
	
	//访问路径 http://localhost:6662/rc_long/system/menu/manage/id
	private String url;


	private boolean open =false;
	
	private boolean isParent;
	
	private int parents_id_;
	
	private String path;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=ModuleMenu.class)
	@JoinColumn(name="parents_id_",insertable=false,updatable=false)
	@NotFound(action = NotFoundAction.IGNORE)
	private ModuleMenu moduleMenu;
	
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity= ModuleMenu.class)
	@NotFound(action = NotFoundAction.IGNORE)
	private List<ModuleMenu> children = new ArrayList<ModuleMenu>();
	
	
	@OneToMany(cascade=CascadeType.ALL,targetEntity=SysVideo.class)
	@NotFound(action=NotFoundAction.IGNORE)
	private List<SysVideo> videoList;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}


	public List<ModuleMenu> getChildren() {
		return children;
	}

	public void setChildren(List<ModuleMenu> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public int getParents_id_() {
		return parents_id_;
	}

	public void setParents_id_(int parents_id_) {
		this.parents_id_ = parents_id_;
	}

	public ModuleMenu getModuleMenu() {
		return moduleMenu;
	}

	public void setModuleMenu(ModuleMenu moduleMenu) {
		this.moduleMenu = moduleMenu;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<SysVideo> getVideoList() {
		return videoList;
	}

	public void setVideoList(List<SysVideo> videoList) {
		this.videoList = videoList;
	}

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

}
