package com.rc_long.Entity;

import java.util.List;

import javax.persistence.Entity;
/**
 * 文件 列表树
 * @author Administrator
 *
 */
@Entity
public class PoTree {

	public PoTree() {
		super();
	}

	public PoTree(String name, boolean open, boolean isParent, String url,
			List<PoTree> children, boolean isChecked, int id,String path,int level) {
		super();
		this.name = name;
		this.open = open;
		this.isParent = isParent;
		this.url = url;
		this.children = children;
		this.isChecked = isChecked;
		this.id = id;
		this.setPath(path);
		this.setLevel(level);
	}
	//资源类型
	private int level;
	private String path;
	
	private int id;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	// 树形 结构的名字
	private String name;
	// 是否打开
	private boolean open;
	// 是否是子节点
	private boolean isParent;
	// url
	private String url;

	// 子节点
	private List<PoTree> children;

	// 是否被选中
	private boolean isChecked;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<PoTree> getChildren() {
		return children;
	}

	public void setChildren(List<PoTree> children) {
		this.children = children;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	@Override
	public String toString() {
		return "PoTree [id=" + id + ", name=" + name + ", open=" + open
				+ ", isParent=" + isParent + ", url=" + url + ", children="
				+ children + ", isChecked=" + isChecked + "]";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}



	

}
