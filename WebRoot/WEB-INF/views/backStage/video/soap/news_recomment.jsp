<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../../../../jsp/global.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${base }/www/css/base.css" />
<link rel="stylesheet" href="${base }/www/css/index.css" />
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<style type="text/css">
	.sec_Ful{
    width: 900px;
   margin-top: 20px;
    height: 153px;
}
.sec_Ful li{
     float: left;
     margin-right: 20px;
     width: 190px;
     height: 153px;
 }
.sec_Ful li.last{
    margin-right: 0px;
}
 .sec_Ful li .liF{
    width: 190px;
    height: 123px;
    position: relative;
}
.sec_Ful li .liF a{
    display: block;
    width: 190px;
    height: 123px;
}
 .sec_Ful li .liF a img{
    width: 190px;
    height: 123px;

}
 .sec_Ful li .liF .liS{
    width: 80px;
    padding-left: 110px;
    height: 24px;
  background-color: rgba(0,0,0,0.5);
    position: absolute;
    left: 0;
    bottom: 0;
}
.sec_Ful li .liF .liS span{
    height: 24px;
    line-height: 24px;
}
 .sec_Ful li .title{
    width: 180px;
    padding-left: 10px;
    height: 30px;
   line-height: 30px;
    color: #888;
    font-weight: 600;
}

</style>
<title>主页自编辑模块推荐</title>
</head>
<body style="background-color: 9990;margin: 7px">
	<h3>当前推荐信息:</h3>
	<div>
		<ul class="search" style="padding-left:10px;">
			<li><a class="button border-main icon-plus-square-o" href="#"
				id="changeLiveRec"> 自动推荐</a></li>
				<li><a class="button border-main icon-plus-square-o" href="#"
				id="self_control_rec"> 手动推荐</a></li>
		</ul>
	</div>
	<div class="sec_Ful">
		<ul>

			<!--自编辑  -->
			<c:forEach items="${self_edit_bean_list.list }" var="x">
				<li>
					<div class="liF">
						<a href="#"><img
							src="${base }/www/resources/images/${x.video_img}" alt="" /></a>
					</div> <span class="title">${x.video_name }</span>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<div id="self_edit_bean_list">
		<%@include file="news_recomment_list_already.jsp" %>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
	var video_type = "${video_type}";
</script>

<script type="text/javascript"
	src="${base }/www/js/backStage/js/movie_recomment/movie_recomment_list.js"></script>
<script type="text/javascript"
	src="${base }/www/js/backStage/js/movie_recomment/movie_recomment.js"></script>
</html>