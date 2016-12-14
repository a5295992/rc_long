<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>56网</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<!--头部结束-->

	<!--内容区域开始-->
	<div class="content">
		<!-- 直播间-->
		<section class="section1">
		<div class="sec_F">
			<c:forEach items="${recPager.list }" var="x">
				<div class="sec_Fbox">
				<a href="${base }/sys/video/play?vd=10001"><img src="${base }/www/resources/images/${x.video_img}"
					alt="" /></a>
				<div class="small">
					<span><img src="${base }/www/resources/images/008.PNG"
						alt="" /></span> <span>${x.video_name }</span>
				</div>
			</div>
			</c:forEach>
			
			
			<div class="sec_Ful">
				<ul>
				
				<!--自编辑  -->
				<c:forEach items="${editPager.list }" var="x">
						<li>
						<div class="liF">
							<a href="#"><img src="${base }/www/resources/images/${x.video_img}"
								alt="" /></a>
							<div class="liS">
								<span><img src="${base }/www/resources/images/009.PNG"
									alt="" /></span> <span>${x.video_wathers }</span>
							</div>
						</div> <span class="title">${x.video_name }</span>
					</li>
				</c:forEach> 
				</ul>
			</div>
		</div>
		<div class="sec_S">
			<div class="sec_sbig">
				<ul>
					<c:forEach items="${commentPager.list }" var="x">
						<li>
						<div class="liF">
							<a href="${base }/sys/video/play?vd=10001"><img src="${base }/www/resources/images/${x.video_img}"
								alt="" /></a>
							<div class="liS">
								<span><img src="${base }/www/resources/images/009.PNG"
									alt="" /></span> <span>${x.video_wathers }</span>
							</div>
						</div> <span class="title">${x.video_name }</span>
					</li>
					
					</c:forEach>
				</ul>
			</div>
			<div class="sec_ssmal">
				<ul>
				
				<c:forEach items="${newsPager.list }" var="x">
					<li>
						<div class="liF">
							<a href="#"><img src="${base }/www/resources/images/${x.video_img}"
								alt="" /></a>
							<div class="liS">
								<span><img src="${base }/www/resources/images/009.PNG"
									alt="" /></span> <span>${x.video_wathers}</span>
							</div>
						</div> <span class="title">${x.video_name}</span>
					</li>
				
				</c:forEach>
					
				</ul>
			</div>
		</div>
		</section>
		<!--猜你喜欢-->
		<section class="section2"> <!-- 猜你喜欢左侧 -->
		<div class="side-left fl">
			<h2>猜你喜欢</h2>
			<div class="like">
			<c:forEach items="${likePager.list }" var="x">
					<div class="item-like">
					<div class="pic-list">
						<div class="pic">
							<img src="${base }/www/resources/images/${x.user_img}" alt=""
								class="pic-big" />
							<div class="list">
								<div class="vid">
									<span></span><span>${x.video_wathers }</span>
								</div>
							</div>
							<img src="${base }/www/resources/images/${x.video_img}" alt=""
								class="pic-small" /> <span class="list-tit">${x.user_name }</span>
						</div>
					</div>
					<p>${x.video_cname }</p>
				</div>
			</c:forEach>
			</div>
		</div>
		<!-- 猜你喜欢右侧 -->
		<div class="side-right fl">
			<h3>精品栏目</h3>
			<div class="">
				<ul class="culm">
					<li class="culm-list"><img
						src="${base }/www/resources/images/jplm1.jpg" alt="" /> <span
						class="tit">囧闻一箩筐</span> <span class="time">11-28更新597集</span></li>
					<li class="culm-list"><img
						src="${base }/www/resources/images/jplm2.jpg" alt="" /> <span
						class="tit">二更人物</span> <span class="time">11-28更新307集</span></li>
					<li class="culm-list"><img
						src="${base }/www/resources/images/jplm3.jpg" alt="" /> <span
						class="tit">山下智博</span> <span class="time">11-28更新642集</span></li>
					<li class="culm-list"><img
						src="${base }/www/resources/images/jplm4.jpg" alt="" /> <span
						class="tit">暴走大事件</span> <span class="time">11-28更新39集</span></li>
					<li class="culm-list"><img
						src="${base }/www/resources/images/jplm5.jpg" alt="" /> <span
						class="tit">飞碟说第二季</span> <span class="time">11-28更新98集</span></li>
					<li class="culm-list"><img
						src="${base }/www/resources/images/jp_06.jpg" alt="" /> <span
						class="tit">电影速放室</span> <span class="time">11-28更新61集</span></li>
				</ul>
			</div>
		</div>
		</section>

		<!-- 电影-->
		<section class="section3"> <!-- 电影左侧 -->
		<div class="side-left fl">
			<div class="movie-tit">
				<ul>
					<li><h2>电影</h2></li>
					<li class="tit-item first"><a href="" class="active">精选短片</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">最新预告</a>
					<li><span></span></li>
					<li class="tit-item"><a href="">院线强档</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">幕后特辑</a></li>
				</ul>
			</div>
			<div class="item">
				<ul>
				<c:forEach  items="${videoPager.list }" var="x" >
						<li><img src="${base }/www/resources/images/${x.video_img}" alt="" />
						<div class="pic-tit">${x.video_name}</div>
						<div class="smalltit">${x.video_cname}</div></li>
				</c:forEach>
				</ul>
			</div>
		</div>
		<!-- 电影右侧 -->
		<div class="side-right fl">
			<h3>每周精选</h3>
			<ul>
				<li><img src="${base }/www/resources/images/dy5.jpg" alt="" />
					<span>男人临死前始终绕不过这一生最爱的女人</span></li>
				<li><img src="${base }/www/resources/images/dy6.jpg" alt="" />
					<span>踏雪寻梅《曾经我也想过一了百了》</span></li>
			</ul>
		</div>
		</section>
		<!-- 电视剧-->
		<section class="section4">
		<div class="side-left fl">
			<div class="movie-tit">
				<ul>
					<li><h2>电视剧</h2></li>
					<li class="tit-item first"><a href="" class="active">网络热播</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">强势推荐</a>
					<li><span></span></li>
					<li class="tit-item"><a href="">内地剧</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">美剧</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">日韩剧</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">资讯速递</a></li>
				</ul>
			</div>
			<div class="item">
				<ul>
				<c:forEach items="${soapPager.list }" var="x">
					<li>
						<div class="picBox">
							<img src="${base }/www/resources/images/${x.video_img}" alt="" /> <span
								class="bg"><span class="count">${x.video_desc }</span></span>
						</div>
						<div class="pic-tit">${x.video_name }</div>
						<div class="smalltit">${x.video_cname }</div>
					</li>
				</c:forEach>
				</ul>
			</div>
		</div>
		<div class="side-right fl">
			<h3>热剧榜</h3>
			<div class="list-names">
				<ul class="fl">
					<li><span class="num">1</span> <a href="">法医秦明</a></li>
					<li><span class="num">2</span> <a href="">麻雀</a></li>
					<li><span class="num">3</span> <a href="">胭脂</a></li>
					<li><span class="num">4</span> <a href="">双刺</a></li>
					<li><span class="num">5</span> <a href="">小别离</a></li>
				</ul>
				<ul class="fl">
					<li><span class="num">6</span> <a href="">刺客列传</a></li>
					<li><span class="num">7</span> <a href="">新边城浪子</a></li>
					<li><span class="num">8</span> <a href="">亲爱的公主病</a></li>
					<li><span class="num">9</span> <a href="">好家伙</a></li>
					<li><span class="num">10</span> <a href="">生活大爆炸</a></li>
				</ul>
			</div>
		</div>
		</section>
		<!-- 综艺-->
		<section class="section5">
		<div class="side-left fl">
			<div class="movie-tit">
				<ul>
					<li><h2>综艺</h2></li>
					<li class="tit-item first"><a href="" class="active">精选短片</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">最新更新</a>
					<li><span></span></li>
					<li class="tit-item"><a href="">娱乐爆点</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">大陆综艺</a></li>
					<li><span></span></li>
					<li class="tit-item"><a href="">海外综艺</a></li>
				</ul>
			</div>
			<div class="item">
				<ul>
				<c:forEach items="${lifePager.list }" var="x">
					<li><img src="${base }/www/resources/images/${x.video_img}" alt="" />
						<div class="pic-tit">${x.video_name }</div>
						<div class="smalltit">${x.video_cname }</div></li>
				</c:forEach>
				</ul>
			</div>
		</div>
		</section>
	</div>
	<!--内容区域结束-->
	<!--底部区域开始-->
	<footer>
	<div>
		<img src="${base }/www/resources/images/footer.jpg" alt="" />
		<p>不良信息举报电话：020-85533243举报邮箱：56kf#sohu-inc.com (使用时将#号改为@)</p>
		<p>网络视听许可证1908336中国互联网诚信联盟粤通管BBS【2009】第175号粤ICP备05006774号-1粤ICP证粤B2-20041027穗公网监备案证号：4401060102823</p>
		<p>增值电信业务经营许可证B2-20090492互联网药品信息服务资格证(粤)-非经营性-2014-0018节目制作经营许可证粤第735号粤网文[2013]0244-094</p>
		<p>粤公网安备 44010602000140号中国互联网举报中心</p>
		<p>Copyright ©2016 56.com 版权所有</p>
	</div>
	</footer>
	<!--底部区域结束-->
</body>
<script type="text/javascript">
	var base="${base}";	
</script>
<script type="text/javascript" src="${base }/www/js/index/index.js"></script>

</html>