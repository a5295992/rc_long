package com.rc_long.Anrequest;

/**
 * 访问地址管理类
 * @author Administrator
 *
 */
public class NewAnRequest {
	
	public static final String index= "/";
	public static final String toLogin = "/user/login";
	public static final String user_infor = "/fuser/infor";
	public static final String tologinOut = "/fuser/loginOut";
	
	
	public static final String toSingle="/video";
	public static final String video_update = "/video/updateBean";
	public static final String updateVideoRecomment = "/video/updateRecomment";
	
	
	public static final String updatePath = "/video/updatePath";
	
	
	public  static final String back_tologin="/admin/login";
	public  static final String backlogin="/admin/login/determin";
	public static final String to_backIndex = "/admin";
	public static final String clearCach = "/admin/clearCach";
	public static final String updateUserKey = "/admin/updatekey";
	public static final String welecom = "/admin/welecom";
	
	
	
	public static final String comment = "/comment";
	
	public static final String comment_create ="/create";
	
	//分组管理
	public static final String group ="/group";
	public static final String toGroupManage = "/toGroup";
	
	public static final String group_create = "/create";
	public static final String group_search = "/search";
	public static final String  deleteGroup = "/delete";
	public static final String  findAllVideoInGroup = "/videos";
	
	public static final String  addVideosToGroup = "/videos/add";
	public static final String  deleteVideos = "videos/delete";
	
	//网站系统管理
	
	public static final String system = "/system";
	
	//重启tomcat 服务器
	public static final String restart ="/restart";
	public static final String witeSet = "/witeSet";
	public static final String witeSetUpdate = "/witeSet/update";
	public static final String witeSetCreate = "/witeSet/create";
	public static final String witeSetSearch = "/witeSet/search";
	public static final String fileList ="/file";
	//
	
	//BackStageManage [Controler]
	public static final String system_menu = "/menu";
	public static final String system_menu_ = "/";
	public static final String system_menu_list = "/list";
	public static final String system_menu_add = "/add";
	
	public static final String system_menu_delete = "/delete";
	
	public static final String system_menu_update = "/update";
	
	public static final String system_menu_content = "/content";
	
	
	//查询ation
	public static final String toSearch = "/search";
	
	
	
	
	//新闻
	public static final String news = "/news";
	public static final String news_list = "/list";
	public static final String news_add = "/add";
	public static final String news_dele = "/dele";
	public static final String news_update = "/update";
	
	
	
	
	//单页管理
	
	
	public static final String singles = "/singles";
	
	public static final String toSingleMenu = "/{menu_id}/{pageNum}";
	
	
	public static final String replayImg = "/replayImg";
	public static final String replayImg_list = "/list";
	
	public static final String replayImg_addOrupdate = "/add";
	
	public static final String replayImg_dele= "/dele";
	public static final String replayImg_deles= "/deles";
	public static final String toreplayImg_addOrupdate = "/toadd";
	public static final String toNewsSingle = "/newst";
	
	public static final String toNewsMore = "/newst/more";
	public static final String live = "live";
	
	  public static final String LiveRoom = "/blive";
	  public static final String addLiveRoom = "/add";
	  public static final String deleLiveRoom = "/dele";
	  public static final String updateLiveRoom = "/update";
	  public static final String findLiveRoom = "/find";
	  public static final String toAddOrUpdate = "/toAddorUpdate";
	  public static final String bliveupdate = "/update";
	
	
	
	
}
