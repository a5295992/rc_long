<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>

<!-- single -->
<div class="single-page-agile-main">
<div class="container">
		<!-- /w3l-medile-movies-grids -->
			<div class="agileits-single-top">
				<ol class="breadcrumb">
				  <li><a href="${base }">主页</a></li>
				  <li class="active">${sysVideo.video_name }</li>
				</ol>
			</div>
			<div class="single-page-agile-info">
                   <!-- /movie-browse-agile -->
                           <div class="show-top-grids-w3lagile">
				<div class="col-sm-8 single-left">
					<div class="song">
						<div class="song-info">
							<h3>${sysVideo.video_name }</h3>	
					</div>
					<c:forEach items="${videoGroup.videoList }" var="video" >
							<input type="text" name="video_id_id" value="${video.video_id}" style="display: none">
					</c:forEach>
					
					<div id="play_list" style="width:145px;height:360px;position: relative;left: 600px;top: -360px;display:none;scoller;overflow:auto">
						<ul style="width:140px;height:320px">
						<li><font size="3px" ,color="red">播放列表</font></li>
						<c:forEach items="${videoGroup.videoList }" var="video" end="5">
							<li ><a href="${base }/video/${video.video_id}" ><img alt="" src="${base }/${video.video_img }"style="height: 60px;width: 140"/>
								<p style="height: 15px">${video.video_name }</p>
								</a>
							</li>
							
						</c:forEach>
						</ul>
					</div>
						
						<div class="video-grid-single-page-agileits">
							<div data-video="dLmKio67pVQ" id="video"> 
							<img src="${base }/${sysVideo.video_img}" alt="" class="img-responsive" /> 
								
							</div>
							简介:<span style="color: black;">${sysVideo.video_desc }[...]</span>
						</div>
					</div>
					<div class="song-grid-right">
						<div class="share">
							<h5>播放地址</h5>
							<div class="single-agile-shar-buttons">
							<ul>
								<li>
									<!-- <div class="fb-like" data-href="https://www.facebook.com/w3layouts" data-layout="button_count" data-action="like" data-size="small" data-show-faces="false" data-share="false"></div>
									<script>(function(d, s, id) {
									  var js, fjs = d.getElementsByTagName(s)[0];
									  if (d.getElementById(id)) return;
									  js = d.createElement(s); js.id = id;
									  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.7";
									  fjs.parentNode.insertBefore(js, fjs);
									}(document, 'script', 'facebook-jssdk'));</script> -->
									<a href="javascript:void(0)" onclick="videoPlay('${sysVideo.video_path}')">[高清]播放线路1</a>
								</li>
								<!-- <li>
									<div class="fb-share-button" data-href="https://www.facebook.com/w3layouts" data-layout="button_count" data-size="small" data-mobile-iframe="true"><a class="fb-xfbml-parse-ignore" target="_blank" href="https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fwww.facebook.com%2Fw3layouts&amp;src=sdkpreparse">Share</a></div>
								</li>
								<li class="news-twitter">
									<a href="https://twitter.com/w3layouts" class="twitter-follow-button" data-show-count="false">Follow @w3layouts</a><script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
								</li>
								<li>
									<a href="https://twitter.com/intent/tweet?screen_name=w3layouts" class="twitter-mention-button" data-show-count="false">Tweet to @w3layouts</a><script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
								</li>
								<li>
									Place this tag where you want the +1 button to render.
									<div class="g-plusone" data-size="medium"></div>

									Place this tag after the last +1 button tag.
									<script type="text/javascript">
									  (function() {
										var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
										po.src = 'https://apis.google.com/js/platform.js';
										var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
									  })();
									</script>
								</li> -->
							</ul>
						</div>
						</div>
					</div>
					<div class="clearfix"> </div>

					<div class="all-comments">
					<c:choose>
						<c:when test="${ShiroUser eq null}">
						<div class="all-comments-info">
							<a href="#">评论留言</a>
							<div class="agile-info-wthree-box">
								<form>
									<input type="text" placeholder="你的名字" required="">			           					   
									<input type="text" placeholder="邮箱" required="">
									<input type="text" placeholder="手机号" required="">
									<textarea placeholder="评论内容" required=""></textarea>
									<input type="submit" value="发送">
									<div class="clearfix"> </div>
								</form>
							</div>
						</div>
						
						
						
						</c:when>
						
						<c:otherwise>
							<div class="all-comments-info">
							<a href="#">评论留言</a>
							<div class="agile-info-wthree-box">
								<form>
									<textarea placeholder="我也要说一句" required=""></textarea>
									<input type="submit" value="发送">
									<div class="clearfix"> </div>
								</form>
							</div>
						</div>
						</c:otherwise>
					</c:choose>
						
						<div class="media-grids">
						<c:forEach items="${commentPager.list}" var="comment">
						<div class="media" >
								<span style="color: #C7C7C7;size: 14px" ></span><h5>${comment.sysUser.user_name }</h5>
								<div class="media-left">
									<a href="#">
										<img src="${base }/${comment.sysUser.user_img}" title="One movies" alt=" " />
									</a>
								</div>
								<div class="media-body">
									<p>${comment.text}</p>
									<span>${comment.date }</span>
								</div>
						</div>
						<hr/>
						<c:forEach items="${comment.recomment }" var="rcomment" end="1">
							<div class="media" style="margin-left: 50px;margin-top: 10px">
								<h5>${rcomment.sysUser.user_name }<span style="color: #C7C7C7;size: 14px" ><font color="red" size="5px">回复:</font>${comment.sysUser.user_name }</span></h5>
								<div class="media-left">
									<a href="#">
									<img src="${base }/${rcomment.sysUser.user_img }" title="One movies" alt=" " />
									</a>
								</div>
								<div class="media-body">
									<p>${rcomment.text}</p>
									<span>${rcomment.date }</span>
								</div>
							</div>
						
						</c:forEach>
						<hr/>
						</c:forEach>
							<a href="#"><p>查看所有留言</p></a>
						</div>
					</div>
				</div>
				<div class="col-md-4 single-right">
					<h3>同名专辑</h3>
					<div class="single-grid-right">
					<c:forEach items="${videoGroup.videoList}" var="video">
					<div class="single-right-grids">
							<div class="col-md-4 single-right-grid-left">
								<a href="${base }/video/${video.video_id}"><img src="${base }/${video.video_img}" alt="" /></a>
							</div>
							<div class="col-md-8 single-right-grid-right">
								<a href="${base }/video/${video.video_id}" class="title"> ${fn:substring(video.video_name,0,8)}</a>
								<p class="author"><a href="${base }/fuser/${video.sysUser.user_id}" class="author">${video.sysUser.user_name}</a></p>
								<p class="views">${video.video_wathers }人看过</p>
							</div>
							<div class="clearfix"> </div>
						</div>
					
					</c:forEach>

					</div>
				</div>
				

				
				<div class="clearfix"> </div>
			</div>
				<!-- //movie-browse-agile -->
				<!--body wrapper start-->
			<div class="w3_agile_banner_bottom_grid">
				<div id="owl-demo" class="owl-carousel owl-theme">
					<c:forEach items="${tvList }" var="video">
						<div class="item">
						<div class="w3l-movie-gride-agile w3l-movie-gride-agile1">
							<a href="${base }/video/${video.video_id}" class="hvr-shutter-out-horizontal"><img src="${base }/${video.video_img}" title="album-name" class="img-responsive" alt=" " />
								<div class="w3l-action-icon"><i class="fa fa-play-circle" aria-hidden="true"></i></div>
							</a>
							<div class="mid-1 agileits_w3layouts_mid_1_home">
								<div class="w3l-movie-text">
									<h6><a href="${base }/video/${video.video_id}">${fn:substring(video.video_name,0,8) }</a></h6>							
								</div>
								<div class="mid-2 agile_mid_2_home">
									<p>${fn:substring(video.create_time,0,8) }</p>
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
								<p>${fn:substring(video.videoType.video_type_name,0,2) }</p>
							</div>
						</div>
					</div>
					
					</c:forEach>
					
				</div>
			</div>
		<!--body wrapper end-->
						
							 
				</div>
				<!-- //w3l-latest-movies-grids -->
			</div>	
		</div>
	<!-- //w3l-medile-movies-grids -->
	<script type="text/javascript" >
	var $player = "${module_02_player}";
	</script>
	<script type="text/javascript" src="${base }/www/module_02/single/single.js">
<!--

//-->
</script>
	<%@ include file="../include/foot.jsp"%>