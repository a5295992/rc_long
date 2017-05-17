<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>

<!-- single -->
<div class="single-page-agile-main">
	<div class="container">
		<!-- /w3l-medile-movies-grids -->
		<div class="agileits-single-top">
			<ol class="breadcrumb">
				<li><a href="${base }">主页</a></li>
				<li class="active">${liveRoom.live_name }</li>
			</ol>
		</div>
		<div class="single-page-agile-info">
			<!-- /movie-browse-agile -->
			<div class="show-top-grids-w3lagile">
				<div class="col-sm-8 single-left">
					<div class="song">
						<div class="song-info">
							<h3>${liveRoom.live_name }</h3>
						</div>

						<div class="video-grid-single-page-agileits">
							<div data-video="dLmKio67pVQ" id="video"  style="width: 680px;height: 380px;">

								<object width='600' height='0' id='videoPlayer'
									name='videoPlayer' type='application/x-shockwave-flash'
									classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000'>
									<param name='movie'
										value='${flash_player }/swfs/videoPlayer.swf' />
									<param name='quality' value='high' />
									<param name='bgcolor' value='#000000' />
									<param name='allowfullscreen' value='true' />
									<param name='flashvars'
										value='&videoWidth=600&videoHeight=380&dsControl=manual&dsSensitivity=100&serverURL=rtmp://172.24.168.84/live/liveStream&DS_Status=true&streamType=live&autoStart=true' />
									<embed src='${flash_player }/swfs/videoPlayer.swf' width='100%'
										height='100%' id='videoPlayer' quality='high'
										bgcolor='#000000' name='videoPlayer' allowfullscreen='true'
										pluginspage='http://www.adobe.com/go/getflashplayer'
										flashvars='&videoWidth=0&videoHeight=0&dsControl=manual&dsSensitivity=100&serverURL=rtmp://${baseServer }/live/${liveRoom.live_path }&DS_Status=true&streamType=live&autoStart=true'
										type='application/x-shockwave-flash' menu='true'
										ALIGN="middle">
									</embed>
								</object>
							</div>
							简介:<span style="color: black;">${liveRoom.live_desc }[...]</span>
						</div>
					</div>
					<div class="song-grid-right">
						<div class="share">
							<h5>在线人数</h5>(<font id="count_s_p${liveRoom.live_id }"></font>)
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
					<div class="clearfix"></div>

				</div>
				<div class="col-md-4 single-right">
					<h3>你可能还喜欢看</h3>
					<div class="single-grid-right">
						<c:forEach items="${liveBean.list}" var="live">
							<div class="single-right-grids">
								<div class="col-md-4 single-right-grid-left">
									<a href="${base }/live/${live.live_id}"><img
										src="${base }/${live.live_img}" alt=""
										style="height: 60px;width: 120" /></a>
								</div>
								<div class="col-md-8 single-right-grid-right">
									<a href="${base }/live/${live.live_id}" class="title">
										${fn:substring(live.live_name,0,8)}</a>
									<p class="author">
										<a href="${base }/fuser/${video.sysUser.user_id}"
											class="author">${live.sysUser.user_name}</a>
									</p>
									<p class="views">正在直播..</p>
								</div>
								<div class="clearfix"></div>
							</div>

						</c:forEach>

					</div>
				</div>



				<div class="clearfix"></div>
			<div class="all-comments">
						<div class="all-comments-info">
							<a href="#">聊天室</a>
							<div class="agile-info-wthree-box">
								<div id="chat${liveRoom.live_id }">
								<p name="chat_name" style="color: gray;">来发表第一条消息吧</p>
								</div>
								
								<textarea placeholder="我也要说一句" required="" name="comment_data" id="comment_data"></textarea>
									<input type="button" value="发送" style="outline: none;font-style: normal;padding: 8px 20px;background: #ff8d1b;font-size: 14px;color: #fff;display: block;border: none;transition: .5s all; -webkit-transition: .5s all;-moz-transition: .5s all;-o-transition: .5s all;-ms-transition: .5s all;" onclick="sendMs('${ShiroUser.user_name}')" id="button_send"/>
							</div>
						</div>
			</div>
			<!-- //movie-browse-agile -->
			<!--body wrapper start-->
		


		</div>
		<!-- //w3l-latest-movies-grids -->
	</div>
</div>
<!-- //w3l-medile-movies-grids -->
<script type="text/javascript">
	var $player = "${module_02_player}";
	var $flash_player = "${flash_player}";
	var live_id="${liveRoom.live_id }";
</script>
<script type="text/javascript"
	src="${base }/www/module_02/single/singleLive.js">
</script>
<%@ include file="../include/foot.jsp"%>