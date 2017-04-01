<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>

<!--search-->
<div class="faq">

	<div class="container">
		<div class="agileits-news-top">
			<ol class="breadcrumb">
				<li>根据您的查询关键字#[${key }] 为您显示以下结果|用时[${time }]毫秒</li>
			</ol>

		</div>
		<div>
			<c:choose>
				<c:when test="${searchResult eq null }">
					<p>抱歉！没有找到您要找的结果！</p>

					<span>[tips]</span>
					<p>1:试试其他关键字</p>
					<p>2:试试高级搜索</p>

				</c:when>
				<c:otherwise>
					<table>
						<thead>
							<tr>
								<th>排序.</th>
								<th>视频 名</th>
								<th>年份</th>
								<th>状态</th>
								<th>国家</th>
								<th>作者</th>
								<th>评分</th>
							</tr>
						</thead>
						<tbody>
						
							<c:forEach items="${searchResult.list }" var="video">
							<tr>
								<td>
									<span>${video.video_auth }</span>
								</td>
								<td>
									<span>${video.video_name }</span>
								</td>
								<td>
									<span>${video.create_time }</span>
								</td>
								<td>
									<span>${video.video_rating }</span>
								</td>
							</tr>
							</c:forEach>
						</tbody>

					</table>

				</c:otherwise>
			</c:choose>
		</div>
	</div>


</div>
<c:if test="${searchResult eq null }">
	<div style="height:500px"></div>
</c:if>

<script type="text/javascript">
	var $player = "${module_02_player}";
	var $flash_player = "${flash_player}";
</script>
<script type="text/javascript"
	src="${base }/www/module_02/single/single.js">
	
</script>
<%@ include file="../include/foot.jsp"%>