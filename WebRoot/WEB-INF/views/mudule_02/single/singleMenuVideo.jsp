<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../jsp/global.jsp"%>

<c:forEach items="${videoBean.list }" var="video">
	<div class="col-md-2 w3l-movie-gride-agile">
		<a href="${base }/video/${video.video_id}"
			class="hvr-shutter-out-horizontal"><img
			src="${base }/${video.video_img }" title="album-name" alt=" "
			style="width: 200px;height: 300px" />
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
						<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
						<li><a href="#"><i class="fa fa-star" aria-hidden="true"></i></a></li>
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

<div class="blog-pagenat-wthree" id="wheel_id">
	<ul>
		<c:choose>
			<c:when test="${videoBean.pageNum == 0 }">
				<li><a class="frist" href="javascript:void(0)">上一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:void(0)"
					onclick="lastview('${menus_id}','${videoBean.pageNum-1 }')">上一页</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${videoBean.page >5 }">
				<c:set value="5" var="max"></c:set>
			</c:when>
			<c:otherwise>
				<c:set value="${videoBean.page-1}" var="max"></c:set>
			</c:otherwise>
		</c:choose>

		<c:forEach begin="${videoBean.pageNum}" end="${max }" var="x">
			<c:choose>
				<c:when test="${videoBean.pageNum eq x }">
					<li><a class="last" href="javascript:void(0)"
						onclick="lastview('${menus_id}','${x }')">${x+1 }</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="javascript:void(0)"
						onclick="lastview('${menus_id}','${x }')"">${x+1 }</a></li>
				</c:otherwise>
			</c:choose>

		</c:forEach>

		<c:choose>
			<c:when test="${videoBean.pageNum eq videoBean.page }">
				<li><a class="last" href="javascript:void(0)"></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:void(0)"
					onclick="lastview('${menus_id}','${videoBean.pageNum+1 }')">下一页</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
<script>
	var menus_id ="${menus_id}";
	$("#wheel"+menus_id).html($("#wheel_id").html());
	$("#wheel_id").html("")
</script>
