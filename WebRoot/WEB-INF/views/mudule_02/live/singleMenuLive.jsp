<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../jsp/global.jsp"%>

<c:forEach items="${liveBean.list }" var="live">
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
					<a href="${base }/live/${live.live_img}">${fn:substring(live.live_name,0,8) }</a>
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

<div class="blog-pagenat-wthree" id="wheel_id">
	<ul>
		<c:choose>
			<c:when test="${liveBean.pageNum == 0 }">
				<li><a class="frist" href="javascript:void(0)">上一页</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:void(0)"
					onclick="lastview('${menus_id}','${liveBean.pageNum-1 }')">上一页</a></li>
			</c:otherwise>
		</c:choose>
		<c:choose>
			<c:when test="${liveBean.page >5 }">
				<c:set value="5" var="max"></c:set>
			</c:when>
			<c:otherwise>
				<c:set value="${liveBean.page-1}" var="max"></c:set>
			</c:otherwise>
		</c:choose>

		<c:forEach begin="${liveBean.pageNum}" end="${max }" var="x">
			<c:choose>
				<c:when test="${liveBean.pageNum eq x }">
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
			<c:when test="${liveBean.pageNum eq liveBean.page }">
				<li><a class="last" href="javascript:void(0)"></a></li>
			</c:when>
			<c:otherwise>
				<li><a href="javascript:void(0)"
					onclick="lastview('${menus_id}','${liveBean.pageNum+1 }')">下一页</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
<script>
	var menus_id ="${menus_id}";
	$("#wheel"+menus_id).html($("#wheel_id").html());
	$("#wheel_id").html("")
</script>
