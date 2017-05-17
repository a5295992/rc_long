<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/mudule_02/include/head.jsp"%>
<!-- //nav -->
<!-- banner -->
<div id="slidey" style="display:none;">
	<ul>
		<!--  首页推荐新闻-->
		<c:forEach items="${inmList }" var="reimg">

			<li><img src="${base }/${reimg.img }" alt="封面图">
			<p class='title'>${reimg.title }</p>
				<p class='description'>
					<a></a>${reimg.intruduction }<a href="${base }/${href }">|详情|</a>
				</p></li>
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
		interval : 8000,
		listCount : 5,
		autoplay : false,
		showList : true
	});
	$(".slidey-list-description").dotdotdot();
</script>

<c:forEach items="${menuList }" var="menu_2">
${menu_2.livelist.page}
	<!--22222  -->
	<!-- /w3l-medile-movies-grids -->
	<div class="general-agileits-w3l">
		<div class="w3l-medile-movies-grids">

			<!-- /movie-browse-agile -->

			<div class="movie-browse-agile">
				<!--/browse-agile-w3ls -->
				<div class="browse-agile-w3ls general-w3ls">
					<div class="tittle-head">
						<h4 class="latest-text">${menu_2.menu_name }</h4>
						<div class="container">
							<div class="agileits-single-top">
								<ol class="breadcrumb">
									<li><a href="${base }"></a>主页</li>
									<li class="active">${menu_2.menu_name }</li>
								</ol>
							</div>
						</div>
					</div>
					<div class="container">
						<div class="browse-inner" id="video${menu_2.menu_id }">
							<c:forEach items="${menu_2.livelist.list }" var="live">



								<div class="col-md-2 w3l-movie-gride-agile">
									<a href="${base }/live/${live.live_id}"
										class="hvr-shutter-out-horizontal"><img
										src="${base }/${live.live_img }" title="album-name" alt=" "
										style="width: 200px;height: 300px" />
										<div class="w3l-action-icon">
											<i class="fa fa-play-circle" aria-hidden="true"></i>
										</div> </a>
									<div class="mid-1">
										<div class="w3l-movie-text">
											<h6>
												<a href="${base }/live/${live.live_id}">${fn:substring(live.live_name,0,8) }</a>
											</h6>
										</div>
										<div class="mid-2">

											<div class="clearfix"></div>
										</div>

									</div>
									<div class="ribben two">
										<p>直播</p>
									</div>
								</div>
							</c:forEach>


						</div>
					</div>
				</div>
				
				<!--//browse-agile-w3ls -->
				<div class="blog-pagenat-wthree" id="wheel${menu_2.menu_id }">
					<ul>
						<c:choose>
							<c:when test="${menu_2.livelist.pageNum == 0 }">
								<li><a class="frist" href="javascript:void(0)">上一页</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:void(0)"
									onclick="lastview('${menu_2.menu_id}','${menu_2.livelist.pageNum-1 }')">上一页</a></li>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${menu_2.livelist.page >5 }">
								<c:set value="5" var="max"></c:set>
							</c:when>
							<c:otherwise>
								<c:set value="${menu_2.livelist.page}" var="max"></c:set>
							</c:otherwise>
						</c:choose>

						<c:forEach begin="${menu_2.livelist.pageNum}" end="${max }"
							var="x">
							<c:choose>
								<c:when test="${menu_2.livelist.pageNum eq x }">
									<li><a class="last" href="javascript:void(0)"
										onclick="lastview('${menu_2.menu_id}','${x }')">${x+1 }</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="javascript:void(0)"
										onclick="lastview('${menu_2.menu_id}','${x }')"">${x+1 }</a></li>
								</c:otherwise>
							</c:choose>

						</c:forEach>

						<c:choose>
							<c:when
								test="${menu_2.livelist.pageNum eq menu_2.livelist.page }">
								<li><a class="last" href="javascript:void(0)"></a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:void(0)"
									onclick="lastview('${menu_2.menu_id}','${menu_2.livelist.pageNum+1 }')">下一页</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
</c:forEach>
<!--33333  -->
<!-- general -->

</section>
<!-- flexSlider -->
<link rel="stylesheet" href="${module_02 }/css/flexslider.css"
	type="text/css" media="screen" property="" />
<script defer src="${module_02 }/js/jquery.flexslider.js"></script>
<script type="text/javascript">
	$(window).load(function() {
		$('.flexslider').flexslider({
			animation : "slide",
			start : function(slider) {
				$('body').removeClass('loading');
			}
		});
	});

	function lastview(menu_id, pageNum) {
		$.ajax({
			cache : true,
			type : "GET",
			url : base + "/singles/live/" + menu_id + "/" + pageNum,
			/*  data:$('#exe_form_login').serialize(),// 你的formid */
			async : true,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				$("#video" + menu_id).html(data);
			}
		});

	}
</script>
<!-- //flexSlider -->
</div>
</div>
<!-- pop-up-box -->
<script src="${module_02 }/js/jquery.magnific-popup.js"
	type="text/javascript"></script>
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
			type : 'inline',
			fixedContentPos : false,
			fixedBgPos : true,
			overflowY : 'auto',
			closeBtnInside : true,
			preloader : false,
			midClick : true,
			removalDelay : 300,
			mainClass : 'my-mfp-zoom-in'
		});

	});
</script>
<%@ include file="/WEB-INF/views/mudule_02/include/foot.jsp"%>
<script type="text/javascript"
	src="${base }/www/module_02/index/js/index.js"></script>
