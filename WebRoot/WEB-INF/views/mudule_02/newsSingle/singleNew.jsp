<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/mudule_02/include/head.jsp" %>
  <!-- //nav -->
<!-- banner -->
	
<!-- faq-banner -->
	<div class="faq">
			<div class="container">
				<div class="agileits-news-top">
					<ol class="breadcrumb">
					  <li><a href="${base }">主页</a></li>
					  <li> <a href="${base }/singles/1003">新闻</a></li>
					   <li class="active">${news.news_title }</li>
					</ol>
				</div>
				<div class="agileinfo-news-top-grids">
					<div class="col-md-8 wthree-top-news-left">
						<div class="wthree-news-left">
							<div class="wthree-news-left-img">
								<img src="${base }/${news.news_img }" alt="" style="width: 100%"/>
								标题:<h4>${news.news_title }</h4>
								<div class="s-author">
									<p>发稿人 <a href="#"><i class="fa fa-user" aria-hidden="true"></i> ${news.sysUser.user_name }</a> &nbsp;&nbsp; <i class="fa fa-calendar" aria-hidden="true"></i> ${news.create_time } &nbsp;&nbsp; <a href="#"><i class="fa fa-comments" aria-hidden="true"></i> 评论 (10)</a></p>
								</div>
								<div id="fb-root"></div>
								<div class="news-shar-buttons">
									<ul>
										<li>
											<div class="fb-like" data-href="https://www.facebook.com/w3layouts" data-layout="button_count" data-action="like" data-size="small" data-show-faces="false" data-share="false"></div>
											<script>(function(d, s, id) {
											  var js, fjs = d.getElementsByTagName(s)[0];
											  if (d.getElementById(id)) return;
											  js = d.createElement(s); js.id = id;
											  js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.7";
											  fjs.parentNode.insertBefore(js, fjs);
											}(document, 'script', 'facebook-jssdk'));</script>
										</li>
										
										<li>
											<!-- Place this tag where you want the +1 button to render. -->
											<div class="g-plusone" data-size="medium"></div>

											<!-- Place this tag after the last +1 button tag. -->
										</li>
									</ul>
								</div>
								<div class="w3-agile-news-text">
								<br>
									<hr>
									&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
									${news.news_content }|<a href="#">
										详细
									</a>
									
								</div>
							</div>
						</div>
						
						<!-- agile-comments -->
						<div class="agile-news-comments">
							<div class="agile-news-comments-info">
								<h4></h4>
								<div class="fb-comments" data-href="https://w3layouts.com/" data-width="100%" data-numposts="5"></div>
							</div>
						</div>
						<!-- //agile-comments -->
						<div class="news-related">
							
						</div>
					</div>
					</div>
					
					<%@include file="right.jsp" %>
					
					
					<div class="clearfix" > </div>
						<div style="width: 730px;height: 415px;position: relative;top:-415px;float: right;left: -380px;background-color: white">
				
					<div class="all-comments-info" style="padding: 20px">
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
				
				
				
				
				</div>
				
				</div>
				
				
			</div>
	</div>  






  <%@ include file="/WEB-INF/views/mudule_02/include/foot.jsp" %>
  <script type="text/javascript" src="${base }/www/module_02/index/js/index.js"></script>
