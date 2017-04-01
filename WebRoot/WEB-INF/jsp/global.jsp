<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="pager" uri="http://com.suse/jsp/jstl/sky"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fnc" uri="http://java.sun.com/jsp/jstl/functionsc" %>
<c:set var="base" value="${pageContext.request.contextPath }"></c:set>
<script type="text/javascript" >
	var base="${base}";
</script>
<link rel="stylesheet" href="${base }/www/css/ziDilog/Zidilog.css" />
<script src="${base }/www/resources/assets/js/jquery.2.1.1.min.js"></script>
<script type="text/javascript" src="${base }/www/js/zDialog.js"></script>
<script type="text/javascript" src="${base }/www/js/zDrag.js"></script>

<c:set var="module_02" value="${base }/www/module_02/static"></c:set>
<!--  ${module_02 }-->
<c:set var="module_02_player" value="${base }/www/module_02/player"></c:set>
<!--  ${module_02_player }-->
<c:set var="back_static" value="${base }/www/backStage"></c:set>
<!-- back_static -->

<script type="text/javascript" src="${back_static }/js/ztree/jquery.ztree.core.min.js"></script>
<link rel="stylesheet" href="${back_static }/css/ztree/zTreeStyle.css" />
<link rel="stylesheet" href="${module_02 }/css/font-awesome.min.css" />

<c:set var ="flash_player" value="${base }/www/player" ></c:set>


