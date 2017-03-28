<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<%@include file="../../../jsp/global.jsp"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>

<style type="text/css">
.tu_a {
	width: 200px;
	height: 192px;
	position: relative;
}

.tu_a img {
	width: 53px;
	height: 53px;
	vertical-align: top;
	margin-top: 30px;
}

.tu_a p {
	width: 100%;
	height: 30px;
	line-height: 30px;
	text-align: center;
	margin-top: 10px;
	font-size: 16px;
	color: #FFF;
}

.tu_a em {
	display: inline-block;
	*display: inline;
	zoom: 1;
	height: 25px;
	line-height: 25px;
	font-size: 16px;
	padding: 0 15px;
	border-bottom: 1px solid #fff;
	color: #FFF;
}

.tu_a i {
	display: block;
	width: 31px;
	height: 14px;
	position: absolute;
	left: 50%;
	margin-left: -15px;
	bottom: -14px;
}

.i_m li .li_m {
	background: #FFF;
	height: 536px;
	overflow: hidden;
}

.tu_a i {
	background: url(../images/icon2.png) no-repeat;
}

.tu_a {
	background: #005BAB;
}

.tu_a i {
	background: url(../images/icon3.png) no-repeat;
}

.tu_a {
	background: #3EEADB;
}
</style>
</head>
<body style="width: 500px;height: 500px" >



	<div style="width: 150px;height: 500px">
		<ul id="ztreeDeme" class="ztree"></ul>
	</div>

	<div id="show"
		style="width: 300px;position: absolute;left:200px;top:0px;height: 500px;background-color: #f7f7f7;">
		<div style="width: 300;height: 30;color: green;" >
			<ur >
				<li style="width: 80px"><i class="fa fa-arrow-circle-o-up" aria-hidden="true"></i><a href="#" id="upload_href">上传</a></li>
				<li style="position: absolute;top: 0px;left: 90px" ><i class="fa fa-refresh" aria-hidden="true"></i>
				<a href="#" onclick="reload()">刷新</a></li>
			</ur>
		
			
		</div>
		<hr>
			<div style="" id="flash_upload">
			<p id="show_name">预览</p>
			<img alt="" src=""id="showImg" style="width: 300px;">
		</div>
		
	</div>
	<div style="position: absolute;left:500px;top:30px; id="swf_upload">
		<hr>
		<div><p id="message"><p></div>
		<iframe src="${base }/sys/file/swf/upload" style="width:630px;height: 380px" >
		</div>
			
		</iframe>
	</div>
</body>
<SCRIPT type="text/javascript">
var base="${base}";
var setting = {  
        data: {
        	key: {
				title:"path"
			},
            simpleData: {  
                enable: true  
            }  
        } ,
        async: {
            enable: true,
            url:"${base}/system/file",
            autoParam:["id", "name", "level"],
            otherParam:{"otherParam":"zTreeAsyncTest"},
            dataFilter: filter
        },
        callback: {
			onClick: onClick
		}
};  
function filter(treeId, parentNode, childNodes) {
    if (!childNodes) return null;
    for (var i=0, l=childNodes.length; i<l; i++) {
        childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
    }
    return childNodes;
}
function onClick(event, treeId, treeNode, clickFlag) {
	var path = treeNode.path;
	if(path.lastIndexOf(".txt")!=-1){
		alert(path);
	}else{
		$("#show_name").html("路径:"+path);
		$("#showImg").attr("src","${base}/"+path);
	}
}
$(document).ready(function(){  
	 $.get('${base}/system/file', function(data){
	       console.info(data);  
	       //zNodes = data;  
	       zTreeObj = $.fn.zTree.init($("#ztreeDeme"), setting, data);  
	   });   
});  
</SCRIPT>

<%-- $(document).ready(function(){  
   $.get('<%=request.getContextPath()%>/part_01', function(data){  
       console.info(data);  
       //zNodes = data;  
       zTreeObj = $.fn.zTree.init($("#ztreeDeme"), setting, data);  
   });  
  //console.info($.fn.zTree.getZTreeObj("dormitoryTree"));  
  //console.info(zTreeObj.getNodes());  
  }); --%>
</SCRIPT>
<script type="text/javascript"
	src="${base }/www/js/backStage/js/sys_web_static_resource_manage/sys_web_static_resource_manage_public.js">
	
</script>
</html>
