package com.rc_long.Entity;

import java.sql.Date;
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

import com.rc_long.Anrequest.TableName;
import com.rc_long.anotation.RcLongTable;

/**
 * 视频实体类
 * @author Administrator
 *
 */
@RcLongTable(name=TableName.SysVideo)
@Entity
@Table(name="sys_video")
public class SysVideo extends EntitiBaseBean<SysVideo> {
	/**
	 * 
	 */
	@OneToMany(targetEntity=Comment.class,cascade=CascadeType.ALL)
	private List<Comment> commentList;
	private static final long serialVersionUID = 1L;
	
	private String key_words;
	
	//视频分类
	private String video_kinds;
	//在首页摆放的位置
	private String index_flag;
	
	@Id
	private String video_id;
	
	private Integer video_rating;
	//菜单id
	
	private Integer menu_id;
	
	@ManyToOne(cascade=CascadeType.ALL,targetEntity=ModuleMenu.class)
	@JoinColumn(name="menu_id",insertable=false,updatable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	private ModuleMenu moduleMenu;
	
	private String  video_name;
	
	private String video_cname;
	
	private String video_path;//视频播放路径
	
	private String  group_id;
	
	private Integer is_recommend;//是否推荐 1 推荐 ，0 不推荐
	
	private String video_type;//movie tv enter
	
	private String user_id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="video_type_id",insertable=false,updatable=false)
	private VideoType videoType;
	
	public VideoType getVideoType() {
		return videoType;
	}

	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="group_id",insertable=false,updatable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	private VideoGroup videoGroup;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",insertable=false,updatable=false)
	private SysUser sysUser;
	
	private String video_long;
	
	private Date create_time;
	
	private Long video_wathers;//视频观看人数 播放次数

	private Integer video_status;//视频状态， 0为成功 1为失败
	
	private Integer video_auth;// 0 代表审核  1.未审核
	
	private Integer video_share; //0 代表 公开观看，1 代表登录观看，2，代表Vip观看
	
	private String video_img;
	
	private String video_desc;
	
	private String resource_id;
	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}

	public String getVideo_name() {
		return video_name;
	}

	public void setVideo_name(String video_name) {
		this.video_name = video_name;
	}

	public String getVideo_cname() {
		return video_cname;
	}

	public void setVideo_cname(String video_cname) {
		this.video_cname = video_cname;
	}

	public String getVideo_path() {
		return video_path;
	}

	public void setVideo_path(String video_path) {
		this.video_path = video_path;
	}

	

	public int getIs_recommend() {
		return is_recommend;
	}

	public void setIs_recommend(int is_recommend) {
		this.is_recommend = is_recommend;
	}

	public String getVideo_type() {
		return video_type;
	}

	public void setVideo_type(String video_type) {
		this.video_type = video_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getVideo_long() {
		return video_long;
	}

	public void setVideo_long(String video_long) {
		this.video_long = video_long;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	
	public String getVideo_img() {
		return video_img;
	}

	public void setVideo_img(String video_img) {
		this.video_img = video_img;
	}

	public String getVideo_desc() {
		return video_desc;
	}

	public void setVideo_desc(String video_desc) {
		this.video_desc = video_desc;
	}

	public String getResource_id() {
		return resource_id;
	}

	public void setResource_id(String resource_id) {
		this.resource_id = resource_id;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	
	public Long getVideo_wathers() {
		return video_wathers;
	}

	public void setVideo_wathers(Long video_wathers) {
		this.video_wathers = video_wathers;
	}

	public Integer getVideo_status() {
		return video_status;
	}

	public void setVideo_status(Integer video_status) {
		this.video_status = video_status;
	}

	public Integer getVideo_auth() {
		return video_auth;
	}

	public void setVideo_auth(Integer video_auth) {
		this.video_auth = video_auth;
	}

	public Integer getVideo_share() {
		return video_share;
	}

	public void setVideo_share(Integer video_share) {
		this.video_share = video_share;
	}

	

	public void setIs_recommend(Integer is_recommend) {
		this.is_recommend = is_recommend;
	}

	public Integer getVideo_rating() {
		return video_rating;
	}

	public void setVideo_rating(Integer video_rating) {
		this.video_rating = video_rating;
	}

	public VideoGroup getVideoGroup() {
		return videoGroup;
	}

	public void setVideoGroup(VideoGroup videoGroup) {
		this.videoGroup = videoGroup;
	}

	public String getIndex_flag() {
		return index_flag;
	}

	public void setIndex_flag(String index_flag) {
		this.index_flag = index_flag;
	}

	public String getVideo_kinds() {
		return video_kinds;
	}

	public void setVideo_kinds(String video_kinds) {
		this.video_kinds = video_kinds;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((commentList == null) ? 0 : commentList.hashCode());
		result = prime * result
				+ ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result
				+ ((group_id == null) ? 0 : group_id.hashCode());
		result = prime * result
				+ ((index_flag == null) ? 0 : index_flag.hashCode());
		result = prime * result
				+ ((is_recommend == null) ? 0 : is_recommend.hashCode());
		result = prime * result
				+ ((resource_id == null) ? 0 : resource_id.hashCode());
		result = prime * result + ((sysUser == null) ? 0 : sysUser.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result
				+ ((videoGroup == null) ? 0 : videoGroup.hashCode());
		result = prime * result
				+ ((videoType == null) ? 0 : videoType.hashCode());
		result = prime * result
				+ ((video_auth == null) ? 0 : video_auth.hashCode());
		result = prime * result
				+ ((video_cname == null) ? 0 : video_cname.hashCode());
		result = prime * result
				+ ((video_desc == null) ? 0 : video_desc.hashCode());
		result = prime * result
				+ ((video_id == null) ? 0 : video_id.hashCode());
		result = prime * result
				+ ((video_img == null) ? 0 : video_img.hashCode());
		result = prime * result
				+ ((video_kinds == null) ? 0 : video_kinds.hashCode());
		result = prime * result
				+ ((video_long == null) ? 0 : video_long.hashCode());
		result = prime * result
				+ ((video_name == null) ? 0 : video_name.hashCode());
		result = prime * result
				+ ((video_path == null) ? 0 : video_path.hashCode());
		result = prime * result
				+ ((video_rating == null) ? 0 : video_rating.hashCode());
		result = prime * result
				+ ((video_share == null) ? 0 : video_share.hashCode());
		result = prime * result
				+ ((video_status == null) ? 0 : video_status.hashCode());
		result = prime * result
				+ ((video_type == null) ? 0 : video_type.hashCode());
		result = prime * result
				+ ((video_wathers == null) ? 0 : video_wathers.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SysVideo other = (SysVideo) obj;
		if (commentList == null) {
			if (other.commentList != null)
				return false;
		} else if (!commentList.equals(other.commentList))
			return false;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (group_id == null) {
			if (other.group_id != null)
				return false;
		} else if (!group_id.equals(other.group_id))
			return false;
		if (index_flag == null) {
			if (other.index_flag != null)
				return false;
		} else if (!index_flag.equals(other.index_flag))
			return false;
		if (is_recommend == null) {
			if (other.is_recommend != null)
				return false;
		} else if (!is_recommend.equals(other.is_recommend))
			return false;
		if (resource_id == null) {
			if (other.resource_id != null)
				return false;
		} else if (!resource_id.equals(other.resource_id))
			return false;
		if (sysUser == null) {
			if (other.sysUser != null)
				return false;
		} else if (!sysUser.equals(other.sysUser))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (videoGroup == null) {
			if (other.videoGroup != null)
				return false;
		} else if (!videoGroup.equals(other.videoGroup))
			return false;
		if (videoType == null) {
			if (other.videoType != null)
				return false;
		} else if (!videoType.equals(other.videoType))
			return false;
		if (video_auth == null) {
			if (other.video_auth != null)
				return false;
		} else if (!video_auth.equals(other.video_auth))
			return false;
		if (video_cname == null) {
			if (other.video_cname != null)
				return false;
		} else if (!video_cname.equals(other.video_cname))
			return false;
		if (video_desc == null) {
			if (other.video_desc != null)
				return false;
		} else if (!video_desc.equals(other.video_desc))
			return false;
		if (video_id == null) {
			if (other.video_id != null)
				return false;
		} else if (!video_id.equals(other.video_id))
			return false;
		if (video_img == null) {
			if (other.video_img != null)
				return false;
		} else if (!video_img.equals(other.video_img))
			return false;
		if (video_kinds == null) {
			if (other.video_kinds != null)
				return false;
		} else if (!video_kinds.equals(other.video_kinds))
			return false;
		if (video_long == null) {
			if (other.video_long != null)
				return false;
		} else if (!video_long.equals(other.video_long))
			return false;
		if (video_name == null) {
			if (other.video_name != null)
				return false;
		} else if (!video_name.equals(other.video_name))
			return false;
		if (video_path == null) {
			if (other.video_path != null)
				return false;
		} else if (!video_path.equals(other.video_path))
			return false;
		if (video_rating == null) {
			if (other.video_rating != null)
				return false;
		} else if (!video_rating.equals(other.video_rating))
			return false;
		if (video_share == null) {
			if (other.video_share != null)
				return false;
		} else if (!video_share.equals(other.video_share))
			return false;
		if (video_status == null) {
			if (other.video_status != null)
				return false;
		} else if (!video_status.equals(other.video_status))
			return false;
		if (video_type == null) {
			if (other.video_type != null)
				return false;
		} else if (!video_type.equals(other.video_type))
			return false;
		if (video_wathers == null) {
			if (other.video_wathers != null)
				return false;
		} else if (!video_wathers.equals(other.video_wathers))
			return false;
		return true;
	}

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	public ModuleMenu getModuleMenu() {
		return moduleMenu;
	}

	public void setModuleMenu(ModuleMenu moduleMenu) {
		this.moduleMenu = moduleMenu;
	}

	public String getKey_words() {
		return key_words;
	}

	public void setKey_words(String key_words) {
		this.key_words = key_words;
	}
}
