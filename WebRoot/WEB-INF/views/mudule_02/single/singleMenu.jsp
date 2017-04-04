<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/mudule_02/include/head.jsp" %>
  <!-- //nav -->
<!-- banner -->


<!-- general -->
   <div class="general">
		<h4 class="latest-text w3_latest_text">${menu_name }</h4>
		<div class="container">
			<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
				<!-- <ul id="myTab" class="nav nav-tabs" role="tablist">
					<li role="presentation" class="active"><a href="#home" id="home-tab" role="tab" data-toggle="tab" aria-controls="home" aria-expanded="true">最新</a></li>
					<li role="presentation"><a href="#profile" role="tab" id="profile-tab" data-toggle="tab" aria-controls="profile" aria-expanded="false">最热</a></li>
					<li role="presentation"><a href="#rating" id="rating-tab" role="tab" data-toggle="tab" aria-controls="rating" aria-expanded="true">评分最高</a></li>
					<li role="presentation"><a href="#imdb" role="tab" id="imdb-tab" data-toggle="tab" aria-controls="imdb" aria-expanded="false">经典</a></li>
				</ul> -->
				<div id="myTabContent" class="tab-content">
						
						<div role="tabpanel" class="tab-pane fade active in" id="${menu_2.name }" aria-labelledby="${menu_2.id }">
						<div class="w3_agile_featured_movies">
							<c:forEach items="${videoList.list }" var="tVideo">
								<div class="col-md-2 w3l-movie-gride-agile">
								<a href="${base }/video/${tVideo.video_id}" class="hvr-shutter-out-horizontal"><img src="${base }/${tVideo.video_img}" title="album-name" class="img-responsive" alt=" " />
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
								<a href="single.html" class="hvr-shutter-out-horizontal"><img src="${base }/www/module_02/static/images/更多.jpg" title="album-name" class="img-responsive" alt=" " />
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
					
					
				</div>
			</div>
		</div>
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
