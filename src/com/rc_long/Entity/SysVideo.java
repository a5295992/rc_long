package com.rc_long.Entity;
/**
 * 视频实体类
 * @author Administrator
 *
 */
public class SysVideo extends EntitiBaseBean<SysVideo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String videoId;
	
	private String  videoName;
	
	private String videoCname;
	
	private String videoPath;//视频播放路径
	
	private int groupId;
	
	private int isRecommend;//是否推荐 0 推荐 ，1 不推荐
	
	private String videoType;
	
	private String userId;
	
	private String videoLong;
	
	private String createTime;
	
	private long videoWathers;//视频观看人数 播放次数
	
	private int videoStatus;//视频状态， 0为成功 1为失败
	
	private int videoAuth;// 0 代表审核  1.未审核
	
	private int videoShare; //0 代表 公开观看，1 代表登录观看，2，代表Vip观看
	
	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoCname() {
		return videoCname;
	}

	public void setVideoCname(String videoCname) {
		this.videoCname = videoCname;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}

	public String getVideoType() {
		return videoType;
	}

	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVideoLong() {
		return videoLong;
	}

	public void setVideoLong(String videoLong) {
		this.videoLong = videoLong;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public long getVideoWathers() {
		return videoWathers;
	}

	public void setVideoWathers(long videoWathers) {
		this.videoWathers = videoWathers;
	}

	public int getVideoStatus() {
		return videoStatus;
	}

	public void setVideoStatus(int videoStatus) {
		this.videoStatus = videoStatus;
	}

	public int getVideoAuth() {
		return videoAuth;
	}

	public void setVideoAuth(int videoAuth) {
		this.videoAuth = videoAuth;
	}

	public int getVideoShare() {
		return videoShare;
	}

	public void setVideoShare(int videoShare) {
		this.videoShare = videoShare;
	}

	
}
