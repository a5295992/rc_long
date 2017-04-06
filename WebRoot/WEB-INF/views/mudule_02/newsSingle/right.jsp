<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<div class="col-md-4 wthree-news-right">
						<!-- news-right-top -->
					
						
						<div class="news-right-top" >
							<div class="wthree-news-right-heading">
							<h3> 猜你喜欢</h3>
							</div>
							<div class="wthree-news-right-top" style="height: 200px">
								<div class="news-grids-bottom">
									<!-- date -->
									<div id="design" class="date">
										<div id="cycler">   
										<c:forEach items="${news_list.list }" var="news">	
											<div class="date-text" style="width: 300px;height: 80px">
												<div style="height: 80px;width: 200px">
													<p>
														<a>${news.news_title }</a>
													</p>
													<p>${fn:substring(news.news_content,0,20) }</p>
												</div>
												<div style="height: 80px;width: 100px;position: relative;left: 200px;top:-80px">
												<img alt="" src="${base }/${news.news_img}" style="width: 100px;height: 80px"/></p>
												</div>
												<%-- <a href="${base }/singles/newst/${news.news_id}">${news.news_title }</a> --%>
												<%-- <p style="width: 100px"><img alt="" src="${base }/${news.news_img}" style="width: 150px;height: 100px"/></p> --%>
												
											</div>
											</c:forEach>
											
											<a href="#" >换一批</a>
											<hr>
											<div style="width: 320px;height: 450px;">
												<h4>评论列表</h4>
												<div style="padding-top: 40px">
													<ul>
														<li style="height: 50px">
														<p >#阿龙:</p>
														<p style="color: gray;">彪悍人生 不解释呀</p>
														</li style="height: 50px">
														<hr>
														<li style="height: 50px">
														<p >#阿龙:</p>
														<p style="color: gray;">彪悍人生 不解释呀</p>
														</li>
														<hr>
														<li  style="height: 50px">
														<p >#阿龙:</p>
														<p style="color: gray;">彪悍人生 不解释呀</p>
														</li>
													</ul>
													<a href="#" >所有回复留言</a>
												
												</div>
											</div>
										</div>
									<!-- 	<script>
										function blinker() {
											$('.blinking').fadeOut(500);
											$('.blinking').fadeIn(500);
										}
										setInterval(blinker, 1000);
										</script> -->
										<!-- <script>
											function cycle($item, $cycler){
												setTimeout(cycle, 2000, $item.next(), $cycler);
												
												$item.slideUp(1000,function(){
													$item.appendTo($cycler).show();        
												});
												}
											cycle($('#cycler div:first'),  $('#cycler'));
										</script> -->
									</div>
									<!-- //date -->
								</div>
							</div>
						</div>
						
						<!-- //news-right-top -->
						<!-- news-right-bottom -->
						