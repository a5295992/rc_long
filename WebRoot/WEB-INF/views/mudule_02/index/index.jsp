<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/mudule_02/include/head.jsp" %>
  <!-- //nav -->
<!-- banner -->

	<div id="slidey" style="display:none;">
		<ul >
			<!--  首页推荐新闻-->
			<c:forEach items="${newsList }" var="news">
				<li ><img src="${base }/${news.news_img }" alt="新闻封面"  ><p class='title'>${news.news_title }</p><p class='description'> <a></a>${news.news_content }<a href="${base }/news/${news.news_id}">|详情|</a></p></li>
			</c:forEach>
			<%-- <li><img src="${module_02 }/images/5.jpg" alt=" "><p class='title'>Tarzan</p><p class='description'> Tarzan, having acclimated to life in London, is called back to his former home in the jungle to investigate the activities at a mining encampment.</p></li>
			<li><img src="${module_02 }/images/2.jpg" alt=" "><p class='title'>Maximum Ride</p><p class='description'>Six children, genetically cross-bred with avian DNA, take flight around the country to discover their origins. Along the way, their mysterious past is ...</p></li>
			<li><img src="${module_02 }/images/3.jpg" alt=" "><p class='title'>Independence</p><p class='description'>The fate of humanity hangs in the balance as the U.S. President and citizens decide if these aliens are to be trusted ...or feared.</p></li>
			<li><img src="${module_02 }/images/4.jpg" alt=" "><p class='title'>Central Intelligence</p><p class='description'>Bullied as a teen for being overweight, Bob Stone (Dwayne Johnson) shows up to his high school reunion looking fit and muscular. Claiming to be on a top-secret ...</p></li>
			<li><img src="${module_02 }/images/6.jpg" alt=" "><p class='title'>Ice Age</p><p class='description'>In the film's epilogue, Scrat keeps struggling to control the alien ship until it crashes on Mars, destroying all life on the planet.</p></li>
			<li><img src="${module_02 }/images/7.jpg" alt=" "><p class='title'>X - Man</p><p class='description'>In 1977, paranormal investigators Ed (Patrick Wilson) and Lorraine Warren come out of a self-imposed sabbatical to travel to Enfield, a borough in north ...</p></li> --%>
		</ul>   	
    </div>
    <script src="${module_02 }/js/jquery.slidey.js"></script>
    <script src="${module_02 }/js/jquery.dotdotdot.min.js"></script>
	   <script type="text/javascript">
			$("#slidey").slidey({
				interval: 8000,
				listCount: 5,
				autoplay: false,
				showList: true
			});
			$(".slidey-list-description").dotdotdot();
		</script>
<!-- //banner -->
<!-- 电视剧 -->
	<div class="banner-bottom">
		<div class="container">
			<div class="w3_agile_banner_bottom_grid">
				<div id="owl-demo" class="owl-carousel owl-theme">
					<c:forEach  items="${wholeVido }" var="tVideo">
						<div class="item">
						<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
							<a href="${base }/video/${tVideo.video_id}" class="hvr-shutter-out-horizontal"><img src="${base }/${tVideo.video_img}" title="album-name" class="img-responsive" alt=" "  style="width: 250px;height: 250px"/>
								<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
									<h6><a href="${base }/video/${tVideo.video_id}">${fn:substring(tVideo.video_name,0,8) }</a></h6>							
								</div>
								<div class="mid-2 agile_mid_2_home">
									<p>${fn:substring(tVideo.create_time,0,4) }</p>
									<div class="block-stars">
										<ul class="w3l-ratings">
											<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
											<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
										</ul>
									</div>
									<div class="clearfix"></div>
								</div>
							</div>
							<div class="ribben">
								<p>最新</p>
							</div>
						</div>
					</div>
					</c:forEach>
					
				</div>
			</div>			
		</div>
	</div>
<!-- //banner-bottom -->
<div class="general_social_icons">
	<nav class="social">
		<ul>
			<li class="w3_twitter"><a href="#">新浪微博 <i class="fa fa-weibo"></i></a></li>
			<li class="w3_facebook"><a href="#">腾讯QQ <i class="fa fa-qq"></i></a></li>
			<li class="w3_dribbble"><a href="#">微信 <i class="fa fa-weixin"></i></a></li>
			<li class="w3_g_plus"><a href="#">人人网 <i class="fa fa-renren"></i></a></li>				  
		</ul>
  </nav>
</div>
<!-- general -->
<c:forEach items="${tvMenuList }" var="menu">
   <div class="general">
		<h4 class="latest-text w3_latest_text">${menu.name }</h4>
		<div class="container">
			<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
				<ul id="myTab" class="nav nav-tabs" role="tablist">
					<c:forEach items="${menu.children }" var="menu_">
						<li role="presentation" class="active"><a href="#'${menu_.name }'" id="${menu_.id }" role="tab" data-toggle="tab" aria-controls="${menu_.name }">${fn:substring(menu_.name,0,6)}</a></li>
					</c:forEach>
					<!-- <li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">最新</a></li>
					<li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile" aria-expanded="false">最热</a></li>
					<li role="presentation"><a href="#rating" id="rating-tab" role="tab" data-toggle="tab" aria-controls="rating" aria-expanded="true">评分最高</a></li>
					<li role="presentation"><a href="#imdb" role="tab" id="imdb-tab" data-toggle="tab" aria-controls="imdb" aria-expanded="false">经典</a></li> -->
				</ul>
				<div id="myTabContent" class="tab-content">
					<c:forEach items="${menu.children }" var="menu_2">
						
						<div role="tabpanel" class="tab-pane fade active in" id="${menu_2.name }" aria-labelledby="${menu_2.id }">
						<div class="w3_agile_featured_movies">
							<c:forEach items="${menu_2.videoList.list }" var="tVideo">
								<div class="col-md-2 w3l-movie-gride-agile">
								<a href="${base }/video/${tVideo.video_id}" class="hvr-shutter-out-horizontal"><img src="${base }/${tVideo.video_img}" title="album-name" class="img-responsive" alt=" "  style="width: 200px;height: 250px"/>
									<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
								</a>
								<div class="mid-1 agileits_w3layouts_mid_1_home">
									<div class="w3l-movie-text">
										<h6><a href="${base }/video/${tVideo.video_id}">${fn:substring(tVideo.video_name,0,8) }</a></h6>							
									</div>
									<div class="mid-2 agile_mid_2_home">
										<p>${fn:substring(tVideo.create_time,0,4) }</p>
										<div class="block-stars">
											<ul class="w3l-ratings">
												<c:forEach begin="0" end="${tVideo.video_rating }">
												<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
												</c:forEach>
												<!-- <li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li> -->
											</ul>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="ribben">
									<p>最新</p>
								</div>
							</div>
							
							</c:forEach>
							<div class="col-md-2 w3l-movie-gride-agile">
								<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${base }/www/module_02/static/images/更多.jpg" title="album-name" class="img-responsive" alt=" " style="width: 200px;height: 250px"/>
									<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
								</a>
								<div class="mid-1 agileits_w3layouts_mid_1_home">
									<div class="w3l-movie-text">
										<h6><a href="single.html">更多</a></h6>							
									</div>
									<div class="mid-2 agile_mid_2_home">
										
										
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="ribben">
									
								</div>
							</div>
							
							<div class="clearfix"> </div>
						</div>
					</div>
					</c:forEach>
					
					
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
	
	
	
	<c:forEach items="${videoMenuList }" var="menu">
   <div class="general">
		<h4 class="latest-text w3_latest_text">${menu.name }</h4>
		<div class="container">
			<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
				<ul id="myTab" class="nav nav-tabs" role="tablist">
					<c:forEach items="${menu.children }" var="menu_">
						<c:choose>
							<c:when test="${menu_.clazz eq 'tab-pane fade active in' }">
								<li role="presentation" class="active"><a href="#ad${menu_.path }" id="${menu_.id }" role="tab" data-toggle="tab" aria-controls="ad${menu_.path }">${fn:substring(menu_.name,0,6)}</a></li>
							</c:when>
							<c:otherwise>
								<li role="presentation" ><a href="#ad${menu_.path }" id="${menu_.id }" role="tab" data-toggle="tab" aria-controls="ad${menu_.path }">${fn:substring(menu_.name,0,6)}</a></li>
							</c:otherwise>
						</c:choose>
						
					</c:forEach>
					<!-- <li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">最新</a></li>
					<li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile" aria-expanded="false">最热</a></li>
					<li role="presentation"><a href="#rating" id="rating-tab" role="tab" data-toggle="tab" aria-controls="rating" aria-expanded="true">评分最高</a></li>
					<li role="presentation"><a href="#imdb" role="tab" id="imdb-tab" data-toggle="tab" aria-controls="imdb" aria-expanded="false">经典</a></li> -->
				</ul>
				<div id="myTabContent" class="tab-content">
					<c:forEach items="${menu.children }" var="menu_2">
						
						<div role="tabpanel" class="${menu_2.clazz }" id="ad${menu_2.path }" aria-labelledby="${menu_2.id }">
						<div class="w3_agile_featured_movies">
							<c:forEach items="${menu_2.videoList.list }" var="tVideo">
								<div class="col-md-2 w3l-movie-gride-agile">
								<a href="${base }/video/${tVideo.video_id}" class="hvr-shutter-out-horizontal"><img src="${base }/${tVideo.video_img}" title="album-name" class="img-responsive" alt=" " style="width: 200px;height: 250px"/>
									<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
								</a>
								<div class="mid-1 agileits_w3layouts_mid_1_home">
									<div class="w3l-movie-text">
										<h6><a href="${base }/video/${tVideo.video_id}">${fn:substring(tVideo.video_name,0,8) }</a></h6>							
									</div>
									<div class="mid-2 agile_mid_2_home">
										<p>${fn:substring(tVideo.create_time,0,4) }</p>
										<div class="block-stars">
											<ul class="w3l-ratings">
												<c:forEach begin="0" end="${tVideo.video_rating }">
												<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
												</c:forEach>
												<!-- <li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li> -->
											</ul>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="ribben">
									<p>最新</p>
								</div>
							</div>
							</c:forEach>
							<div class="col-md-2 w3l-movie-gride-agile">
								<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${base }/www/module_02/static/images/更多.jpg" title="album-name" class="img-responsive" alt=" "style="width: 200px;height: 250px" />
									<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
								</a>
								<div class="mid-1 agileits_w3layouts_mid_1_home">
									<div class="w3l-movie-text">
										<h6><a href="single.html">更多</a></h6>							
									</div>
									<div class="mid-2 agile_mid_2_home">
										
										
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="ribben">
									
								</div>
							</div>
							
							<div class="clearfix"> </div>
						</div>
					</div>
					</c:forEach>
					
					
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
<!-- //general -->
<!--热门专辑  -->
<!-- Latest-tv-series -->
	<div class="Latest-tv-series">
		<h4 class="latest-text w3_latest_text w3_home_popular">热门专辑</h4>
		<div class="container">
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
					
					
					<c:forEach items="${groupList }" var="group">
						
						<li>
							<div class="agile_tv_series_grid">
								<div class="col-md-6 agile_tv_series_grid_left">
									<div class="w3ls_market_video_grid1">
										<img src="${base }/${group.group_img}" alt=" " class="img-responsive" style="height: 313px;width: 570px"/>
										<a class="w3_play_icon" href="#small-dialog">
											<span class="glyphicon glyphicon-play-circle" aria-hidden="true"></span>
										</a>
									</div>
								</div>
								<!--part1_start  -->
								<div class="col-md-6 agile_tv_series_grid_right">
									<p class="fexi_header">${group.group_name }</p>
									<p class="fexi_header_para"><span class="conjuring_w3">描述<label>:</label></span> ${group.group_desc }</p>
									<p class="fexi_header_para"><span>创建日期<label>:</label></span> ${group.group_create_time } </p>
									<p class="fexi_header_para">
										<span>标签<label>:</label> </span>
										<a href="genres.html">Drama</a> | 
										<a href="genres.html">Adventure</a> | 
										<a href="genres.html">Family</a>								
									</p>
									<p class="fexi_header_para fexi_header_para1"><span>当前评分<label>:</label></span>
										<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
										<a href="#"><i class="fa fa-star" aria-hidden="true"></i></a>
										<a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a>
										<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
										<a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a>
									</p>
								</div>
								<!-- part1_end -->
								<div class="clearfix"> </div>
								<div class="agileinfo_flexislider_grids">
								<c:forEach items="${group.videoList }" var="video" >
									
								
									
									<div class="col-md-2 w3l-movie-gride-agile">
										<a href="${base }/video/${video.video_id}" class="hvr-shutter-out-horizontal"><img src="${module_02 }/images/m22.jpg" title="album-name" class="img-responsive" alt=" " />
											<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
										</a>
										<div class="mid-1 agileits_w3layouts_mid_1_home">
											<div class="w3l-movie-text">
												<h6><a href="${base }/video/${video.video_id}">${fn:substring(video.video_name,0,8) }</a></h6>							
											</div>
											<div class="mid-2 agile_mid_2_home">
												<p>${fn:substring(video.create_time,0,4) } </p>
												<div class="block-stars">
													<ul class="w3l-ratings">
														<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
														<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
														<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
														<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
														<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													</ul>
												</div>
												<div class="clearfix"></div>
											</div>
										</div>
										<div class="ribben">
											<p>最新</p>
										</div>
									</div>
									
							
								</c:forEach>
								
								<div class="col-md-2 w3l-movie-gride-agile">
										<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${module_02 }/images/更多.jpg" title="album-name" class="img-responsive" alt=" " />
											<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
										</a>
										<div class="mid-1 agileits_w3layouts_mid_1_home">
											<div class="w3l-movie-text">
												<h6><a href="#">更多内容..</a></h6>							
											</div>
											<div class="mid-2 agile_mid_2_home">
												<p></p>
												<!-- <div class="block-stars">
													<ul class="w3l-ratings">
														<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
														<li><a href="#"><i class="fa fa-star-half-o" aria-hidden="true"></i></a></li>
														<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
														<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
														<li><a href="#"><i class="fa fa-star-o" aria-hidden="true"></i></a></li>
													</ul>
												</div> -->
												<div class="clearfix"></div>
											</div>
										</div>
										<div class="ribben">
											<p>MORE</p>
										</div>
									</div>
								<div class="clearfix"> </div>
								</div>
							</div>
						</li>
						
					</c:forEach>>
						
						
						
						
						
						
						
					</ul>
				</div>
			</section>
			<!-- flexSlider -->
				<link rel="stylesheet" href="${module_02 }/css/flexslider.css" type="text/css" media="screen" property="" />
				<script defer src="${module_02 }/js/jquery.flexslider.js"></script>
				<script type="text/javascript">
				$(window).load(function(){
				  $('.flexslider').flexslider({
					animation: "slide",
					start: function(slider){
					  $('body').removeClass('loading');
					}
				  });
				});
			  </script>
			<!-- //flexSlider -->
		</div>
	</div>
	<!-- pop-up-box -->  
		<script src="${module_02 }/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box -->
	<div id="small-dialog" class="mfp-hide">
		<!---<iframe src="https://player.vimeo.com/video/164819130?title=0&byline=0"></iframe>--->
	</div>
	<div id="small-dialog1" class="mfp-hide">
		<!---<iframe src="https://player.vimeo.com/video/148284736"></iframe>--->
	</div>
	<div id="small-dialog2" class="mfp-hide">
		<!---<iframe src="https://player.vimeo.com/video/165197924?color=ffffff&title=0&byline=0&portrait=0"></iframe>--->
	</div>
	<script>
		$(document).ready(function() {
		$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
			type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in'
		});
																		
		});
	</script>
  <%@ include file="/WEB-INF/views/mudule_02/include/foot.jsp" %>
  <script type="text/javascript" src="${base }/www/module_02/index/js/index.js"></script>
