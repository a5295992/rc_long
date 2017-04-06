<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <%@ include file="/WEB-INF/views/mudule_02/include/head.jsp" %>
  <!-- //nav -->
<!-- banner -->
	
<!-- faq-banner -->
	<div class="faq" >
			<div class="container">
				<div class="agileits-news-top">
					<ol class="breadcrumb">
					  <li><a href="${base }">主页</a></li>
					  <li class="active">新闻</li>
					</ol>
				</div>
				<div class="agileinfo-news-top-grids">
					<div class="col-md-8 wthree-top-news-left" >
						<div class="wthree-news-left">
							<div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
								<ul id="myTab" class="nav nav-tabs" role="tablist">
									<li role="presentation" class="active"><a href="#home1" id="home1-tab" role="tab" data-toggle="tab" aria-controls="home1" aria-expanded="true">最新新闻</a></li>
								</ul>
								<div id="myTabContent" class="tab-content">
									<div role="tabpanel" class="tab-pane fade in active" id="home1" aria-labelledby="home1-tab">
										<c:forEach items="${newsList }" var="news">
											<div class="col-md-6 w3-agileits-news-left">
												<div class="col-sm-5 wthree-news-img">
													<a href="news-single.html"><img src="${base }/${news.news_img}" alt=""  style="width: 150px;height: 200px"/></a>
												</div>
												<div class="col-sm-7 wthree-news-info">
													<h5><a href="${base }/singles/newst/${news.news_id}">${news.news_title }.</a></h5>
													<p>${news.news_content }.</p>
													<ul>
														<li><i class="fa fa-clock-o" aria-hidden="true"></i> ${news.create_time }</li>
														<li><i class="fa fa-eye" aria-hidden="true"></i> 2642</li>
													</ul>
												</div>
												<div class="clearfix"> </div>
											</div>
											
											</c:forEach>
											<div class="clearfix"> </div>
										</div>
									</div>
									
								</div>
							</div>
						</div>
					<div>
					
					</div>
					<%@include file="right2.jsp" %>
					<div class="clearfix"> </div>
					<div style="width: 350px;height: 330px;padding-top:20px;background-color: white">
					网站公告:
					<hr>
					
					</div>
				</div>
			</div>
	</div>  

  <%@ include file="/WEB-INF/views/mudule_02/include/foot.jsp" %>
  <script type="text/javascript" src="${base }/www/module_02/index/js/index.js"></script>
