<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/mudule_02/include/head.jsp" %>
  <!-- //nav -->
<!-- banner -->
	<div id="slidey" style="display:none;">
		<ul>
			<!--  首页推荐新闻-->
			<c:forEach items="${inmList }" var="reimg">
			
				<li><img src="${base }/${reimg.img }" alt="封面图" ><p class='title'>${reimg.title }</p><p class='description'> <a></a>${reimg.intruduction }<a href="${base }/${href }">|详情|</a></p></li>
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

<c:forEach items="${menu_list }" var="menu_2">
<!--22222  -->
<!-- /w3l-medile-movies-grids -->
	<div class="general-agileits-w3l">
		<div class="w3l-medile-movies-grids">

				<!-- /movie-browse-agile -->
				
				      <div class="movie-browse-agile">
					     <!--/browse-agile-w3ls -->
							<div class="browse-agile-w3ls general-w3ls">
								<div class="tittle-head">
									<h4 class="latest-text">${menu_2.name }</h4>
									<div class="container">
										<div class="agileits-single-top">
											<ol class="breadcrumb">
												<li><a href="index.html"></a>${menu_2.moduleMenu.name }</li>
												<li class="active">${menu_2.name }</li>
											</ol>
										</div>
									</div>
								</div>
								<div class="container">
									<div class="browse-inner">
										
								<c:forEach items="${menu_2.videoList }" var="video">
								
								
								
								<div class="col-md-2 w3l-movie-gride-agile">
											<a href="${base }/video/${video.video_id}" class="hvr-shutter-out-horizontal"><img
												src="${base }/${video.video_img }" title="album-name" alt=" " style="width: 200px;height: 300px"/>
												<div class="w3l-action-icon">
													<i class="fa fa-play-circle" aria-hidden="true"></i>
												</div> </a>
											<div class="mid-1">
												<div class="w3l-movie-text">
													<h6>
														<a href="${base }/video/${video.video_id}">${fn:substring(video.video_name,0,8) }</a>
													</h6>
												</div>
												<div class="mid-2">

													<p>2016</p>
													<div class="block-stars">
														<ul class="w3l-ratings">
															<li><a href="#"><i class="fa fa-star"
																	aria-hidden="true"></i></a></li>
															<li><a href="#"><i class="fa fa-star"
																	aria-hidden="true"></i></a></li>
															<li><a href="#"><i class="fa fa-star"
																	aria-hidden="true"></i></a></li>
															<li><a href="#"><i class="fa fa-star-half-o"
																	aria-hidden="true"></i></a></li>
															<li><a href="#"><i class="fa fa-star-o"
																	aria-hidden="true"></i></a></li>


														</ul>
													</div>
													<div class="clearfix"></div>
												</div>

											</div>
											<div class="ribben two">
												<p>NEW</p>
											</div>
										</div>
								</c:forEach>	
									</div>
								</div>
							</div>
							<!--//browse-agile-w3ls -->
						<div class="blog-pagenat-wthree">
							<ul>
								<li><a class="frist" href="#">Prev</a></li>
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4</a></li>
								<li><a href="#">5</a></li>
								<li><a class="last" href="#">Next</a></li>
							</ul>
						</div>
					</div>



</c:forEach>
<!--33333  -->
<!-- general -->
						
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
