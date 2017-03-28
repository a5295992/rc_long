<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@include file="../../../jsp/global.jsp" %>
<%@include file="../include/head.jsp" %>

	<div class="leftnav">
		<div class="leftnav-title"
			style="background:url(${base}/www/resources/backStage/images/bg.jpg) no-repeat 0 -1000px;">
			<strong><span class="icon-list"></span>菜单列表</strong>
		</div>
		<h2>
			<span class="icon-user"></span>基本设置
		</h2>
		<ul style="display:block">
			<li><a href="${base }/system/witeSet" target="right"><span
					class="icon-caret-right"></span>网站设置</a></li>
			<li><a href="${base }/admin/updatekey" target="right"><span
					class="icon-caret-right"></span>修改密码</a></li>
			<li><a href="${base }/sys/back/index/manage" target="right" ><span
					class="icon-caret-right"></span>单页管理</a></li>
			<li><a href="${base }/www/html/adv.html" target="right"><span
					class="icon-caret-right"></span>首页轮播</a></li>
			<li><a href="${base }/www/html/book.html" target="right"><span
					class="icon-caret-right"></span>留言管理</a></li>
			<li><a href="${base }/sys/back/programa/manage" target="right"><span
					class="icon-caret-right"></span>栏目管理</a></li>
			<li><a href="${base }/sys/back/video" target="right"><span
					class="icon-caret-right"></span>视频管理</a></li>
			<li><a href="${base }/www/html/column.html" target="right"><span
					class="icon-caret-right"></span>直播管理</a></li>
			<li><a href="${base }/sys/back/user" target="right"><span
					class="icon-caret-right"></span>用户管理</a></li>
		</ul>
		<h2>
			<span class="icon-pencil-square-o"></span>资源管理
		</h2>
		<ul>
			<li><a href="${base }/sys/web/static/resource/manage" target="right"><span
					class="icon-caret-right"></span>网站静态资源管理</a></li>
			<li><a href="${base }/sys/web/static/resource/manage/database" target="right"><span
					class="icon-caret-right"></span>静态资源数据管理</a></li>
			<li><a href="${base }/sys/back/menu" target="right"><span
					class="icon-caret-right"></span>分类管理</a></li>
		</ul>
	</div>
	<script type="text/javascript">
		$(function() {
			$(".leftnav h2").click(function() {
				$(this).next().slideToggle(200);
				$(this).toggleClass("on");
			})
			$(".leftnav ul li a").click(function() {
				$("#a_leader_txt").text($(this).text());
				$(".leftnav ul li a").removeClass("on");
				$(this).addClass("on");
			})
		});
	</script>
	<ul class="bread">
		<li><a href="{:U('Index/info')}" target="right" class="icon-home">
				首页</a></li>
		<li><a href="##" id="a_leader_txt">网站信息</a></li>
		<li><b>当前语言：</b><span style="color:red;">中文</php></span>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;切换语言：<a href="##">中文</a> &nbsp;&nbsp;<a
			href="##">英文</a></li>
	</ul>
	
	<div class="admin">
		 <iframe scrolling="auto" rameborder="0" src="${base }/admin/welecom"
			name="right" width="100%" height="100%"></iframe> 
	</div>
	<div style="text-align:center;"></div>
	<script type="text/javascript">
		var base = "${base}";
		function clearCach(){
			$.ajax({
		        cache: true,
		        type: "GET",
		        url:base+"/admin/clearCach",
		       // data:$('#exe_form_login').serialize(),// 你的formid
		        async: false,
		        error: function(request) {
		            alert("Connection error");
		        },
		        success: function(data) {
		            if(data=="success"){
		            	window.confirm(data);
		            }else{
		            	alert("清除失败");
		            }
		        }
		    });
		}
		
	</script>

