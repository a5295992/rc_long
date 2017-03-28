package com.rc_long.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wite_site_infor")
public class WiteSiteInfor extends EntitiBaseBean<WiteSiteInfor> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWite_name() {
		return wite_name;
	}

	public void setWite_name(String wite_name) {
		this.wite_name = wite_name;
	}

	public String getWite_logo() {
		return wite_logo;
	}

	public void setWite_logo(String wite_logo) {
		this.wite_logo = wite_logo;
	}

	public String getWite_href() {
		return wite_href;
	}

	public void setWite_href(String wite_href) {
		this.wite_href = wite_href;
	}

	public String getWite_key() {
		return wite_key;
	}

	public void setWite_key(String wite_key) {
		this.wite_key = wite_key;
	}

	public String getWite_desc() {
		return wite_desc;
	}

	public void setWite_desc(String wite_desc) {
		this.wite_desc = wite_desc;
	}

	public String getWite_author() {
		return wite_author;
	}

	public void setWite_author(String wite_author) {
		this.wite_author = wite_author;
	}

	public String getConnet_email() {
		return connet_email;
	}

	public void setConnet_email(String connet_email) {
		this.connet_email = connet_email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCopy_right() {
		return copy_right;
	}

	public void setCopy_right(String copy_right) {
		this.copy_right = copy_right;
	}

	@Id
	private String id;
	//网站名字
	private String wite_name;
	//网站图标
	private String wite_logo;
	//网站链接
	private String wite_href;
	//关键字
	private String wite_key;
	//网站描述
	private String wite_desc;
	//作者
	private String wite_author;
	
	private String connet_email;
	
	private String qq;
	
	private String phone;
	
	private String copy_right;

	@Override
	public String toString() {
		return "WiteSiteInfor [id=" + id + ", wite_name=" + wite_name
				+ ", wite_logo=" + wite_logo + ", wite_href=" + wite_href
				+ ", wite_key=" + wite_key + ", wite_desc=" + wite_desc
				+ ", wite_author=" + wite_author + ", connet_email="
				+ connet_email + ", qq=" + qq + ", phone=" + phone
				+ ", copy_right=" + copy_right + "]";
	}
	
	
	
}
