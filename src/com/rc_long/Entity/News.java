package com.rc_long.Entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * news 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="news")
public class News extends EntitiBaseBean<News> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String news_id;
	
	//是否推荐
	private Integer isRecomment;
	//关键字
	private String key_words;
	
	
	public Integer getIsRecomment() {
		return isRecomment;
	}

	public void setIsRecomment(Integer isRecomment) {
		this.isRecomment = isRecomment;
	}

	public String getKey_words() {
		return key_words;
	}

	public void setKey_words(String key_words) {
		this.key_words = key_words;
	}

	private String news_title;
	
	private String news_img;
	
	
	private Date create_time;
	
	
	private String news_content;
	
	private String user_id;
	private int menu_id;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=SysUser.class)
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	private SysUser sysUser;
	
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

	public String getNews_id() {
		return news_id;
	}

	public void setNews_id(String news_id) {
		this.news_id = news_id;
	}

	public String getNews_title() {
		return news_title;
	}

	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}

	public String getNews_img() {
		return news_img;
	}

	public void setNews_img(String news_img) {
		this.news_img = news_img;
	}


	public String getNews_content() {
		return news_content;
	}

	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	
	
}
