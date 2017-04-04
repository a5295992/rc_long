<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../jsp/global.jsp" %> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>网站信息</title>
<link rel="stylesheet" href="${base }/www/css/backStage/css/admin.css">
<link rel="stylesheet" href="${base }/www/css/backStage/css/pintuer.css">
<script src="${base }/www/js/backStage/js/jquery.js"></script>
</head>

<body>
	<div class="panel admin-panel">
		<div class="panel-head">
			<strong><span class="icon-pencil-square-o"></span>菜单信息</strong>
			
		</div>
		<div class="body-content">
			<form method="post" class="form-x" action="${base }/menu/add" >
			<c:choose>
				<c:when test="${moduleMenu.id eq null}">
				<input type="hidden" value="<%=new Random().nextInt(10000) %>" name="id">
				</c:when>
				<c:otherwise>
				<input type="hidden" value="${moduleMenu.id }" name="id">
				</c:otherwise>
			</c:choose>
				<div class="form-group">
					<div class="label">
						<label>菜单名称：</label>
					</div>
					<div class="field">
						<input type="text" class="input" name="name" value="${moduleMenu.name }" />
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>父级别ID：</label>
					</div>
					<div class="field">
					
					<select onchange="toValue()" id="p_id_sele">
						<option  name= "parents_id"value="0" >不选择默认为顶级</option>
					<c:forEach items="${menu_list }" var="x">
						<option  name= "parents_id"value="${x.id }" 
						
						<c:if test="${x.id ==moduleMenu.parents_id_}">
						
						selected="selected"
						</c:if>
						
						> ${x.name }
						
						</option>
					</c:forEach>
					</select>
					<c:choose>
						<c:when test="${moduleMenu.parents_id_ eq null }">
							<input name="parents_id_" value="0" />
						</c:when>
						<c:otherwise>
						<input name="parents_id_" value="${moduleMenu.parents_id_ }" />
						</c:otherwise>
					</c:choose>
					</div>
				</div>
				<div class="form-group" ">
					<div class="label">
						<label>是否展开：</label>
					</div>
					<div class="field">
					
					<select >
						<option  name= "open"value="true" <c:if test="${moduleMenu.open ==true}">selected="selected"</c:if>> 是</option>
						<option name= "open" value="false" <c:if test="${moduleMenu.open ==false}">selected="selected"</c:if>>否</option>
					</select>
						<div class="tips"></div>
					</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>类型：</label>
					</div>
					<div class="field">
					<select onchange="toType()" id="type_id">
						<option  name= "type"value="video" <c:if test="${moduleMenu.type eq 'video'}">selected="selected"</c:if>> 视频</option>
						<option name= "type" value="tv" <c:if test="${moduleMenu.type eq 'tv'}">selected="selected"</c:if>>电视剧</option>
						<option name= "type" value="news" <c:if test="${moduleMenu.type eq 'news'}">selected="selected"</c:if>>新闻</option>
						<option name= "type" value="live" <c:if test="${moduleMenu.type eq 'live'}">selected="selected"</c:if>>直播</option>
					</select>
					<input name="type" value="${moduleMenu.type }" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>是否在首页显示：</label>
					</div>
					<div class="field">
					<select onchange="toIndex()" id="_showindex_id">
						<option  name= "indexShow"value="true" <c:if test="${moduleMenu.indexShow eq 'true'}">selected="selected"</c:if>> 是</option>
						<option name= "indexShow" value="false" <c:if test="${moduleMenu.indexShow eq 'false'}">selected="selected"</c:if>>否</option>
					</select>
					<input name="indexShow" value="${moduleMenu.indexShow }" />
						<div class="tips"></div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="label">
						<label>默认显示方式：</label>
					</div>
					<div class="field">
					<select onchange="toStyle()" id="showstyle">
						<option  name= "clazz"value="tab-pane fade active in" <c:if test="${moduleMenu.clazz eq 'tab-pane fade active in'}">selected="selected"</c:if>> 活跃</option>
						<option name= "clazz" value="tab-pane fade" <c:if test="${moduleMenu.indexShow eq 'tab-pane fade'}">selected="selected"</c:if>>默认</option>
					</select>
					<input name="clazz" value="${moduleMenu.clazz }" />
						
					</div>
					<div class="tips">[tips:每个菜单只能有一个活跃子菜单]</div>
				</div>
				<div class="form-group">
					<div class="label">
						<label>路径：</label>
					</div>
					<div class="field">
					<input name="path" value="${moduleMenu.path }" />
					</div>
				</div>

				<div class="form-group">
					<div class="label">
						<label></label>
					</div>
					<div class="field">
						<button class="button bg-main icon-check-square-o" type="submit"  id="submit">
							提交</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	var base = "${base}";
	
	function toValue(){
		
		$("input[name='parents_id_']").val($("#p_id_sele").val());
		
	}
	
	function toType(){
		$("input[name='type']").val($("#type_id").val());
		
	}
	function toIndex(){
		$("input[name='indexShow']").val($("#_showindex_id").val());
		
	}
	
	function toStyle(){
		$("input[name='clazz']").val($("#showstyle").val());
		
	}
	
	
</script>
<script type="text/javascript" src="${back_static }/js/webinfor.js"></script>
</html>
