package com.rc_long.enumeration;


public enum VideoTypeConstants {
	self1("自媒体",1,""),
	movie4("电影",4,""),
	saop5("电视剧",5,""),
	forfun6("电影",6,""),
	fun7("电影",7,""),
	live8("直播",8,"backStage/live_room/recomment_live_room_list"),
	user9("用户视频",9,""),
	
	
	self101("重大新闻或公告",101,"backStage/selfRecomment/self_recomment"),
	self102("自编辑",102,"backStage/selfedit/self_edit_recomment"),
	self103("自影评",103,"backStage/selfMovie/self_movie_comment"),
	
	
    movie401("精选短片",401,"backStage/video/movie/main_recomment"),
    movie402("最新预告", 402,"backStage/video/movie/new_forcast_recomment"),
    movie403("院线强档", 403,"backStage/video/movie/cinemal_recomment"), 
    movie404("黄色", 404,"backStage/video/movie/back_edit_recomment"),
    
    
    soap501("网络热播", 501,"backStage/video/soap/net_hot_recomment"),
    soap502("强势推荐", 502,"backStage/video/soap/strong_recomment"),
    soap503("内地剧", 503,"backStage/video/soap/land_recomment"), 
    soap504("美剧", 504,"backStage/video/soap/american_recomment"),
    soap505("日剧", 504,"backStage/video/soap/janpanese_recomment"),
    soap506("资讯快递", 504,"backStage/video/soap/news_recomment"),
    
    
    forfun601("精选短片", 601,"backStage/video/forfun/hard_choose_recomment"),
    forfun602("最近更新", 602,"backStage/video/forfun/present_recomment"),
    forfun603("娱乐爆点", 603,"backStage/video/forfun/enter_hot_recomment"), 
    forfun604("大陆综艺", 604,"backStage/video/forfun/main_land_recomment"),
    forfun605("海外综艺", 604,"backStage/video/forfun/for_land_recomment");
    
    private int index ;
   private String name ;
   private String path ;
   public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}
    
   private VideoTypeConstants( String name , int index ,String path){
       this.name = name ;
       this.index = index ;
       this.path = path ;
   }
    
   public String getName() {
       return name;
   }
   public void setName(String name) {
       this.name = name;
   }
   public int getIndex() {
       return index;
   }
   public void setIndex(int index) {
       this.index = index;
   }
   
   public static String choose(int video_type){
	   VideoTypeConstants[] v=   VideoTypeConstants.values();
	   for (VideoTypeConstants videoTypeConstants : v) {
		   if(videoTypeConstants.index==video_type){
			   return videoTypeConstants.path;
		   }
	}
	   return "404";
   }
   
   public static String chooseName(int video_type){
	   VideoTypeConstants[] v=   VideoTypeConstants.values();
	   for (VideoTypeConstants videoTypeConstants : v) {
		   if(videoTypeConstants.index==video_type){
			   return videoTypeConstants.name;
		   }
	}
	   return "-";
   }
   public static void main(String[] args) {
	System.out.println(choose(401));
}
 
}
