var setting = {
	data : {
		key : {
			title : "path"
		},
		simpleData : {
			enable : true
		}
	},
	async : {
		enable : true,
		url : base + "/menu/list",
		autoParam : [ "id", "name", "level" ],
		otherParam : {
			"otherParam" : "zTreeAsyncTest"
		},
		dataFilter : filter
	},callback: {
		onClick: onClick
	}
};
function filter(treeId, parentNode, childNodes) {
	if (!childNodes)
		return null;
	for (var i = 0, l = childNodes.length; i < l; i++) {
		childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	}
	return childNodes;
}
function onClick(event, treeId, treeNode, clickFlag) {
	$("#menu_id_").val(treeNode.id);
	var id = treeNode.id;
	getContent(id);
	
}
$(document).ready(function() {
	$.get(base + '/menu/list', function(data) {
		// zNodes = data;
		alert(data);
	});
});




//获取 菜单下面的内容
function getContent(menu_id){
	
	
	$.ajax({
        cache: true,
        type: "GET",
        url:base+"/menu/content/"+menu_id,
        /*data:$('#exe_form_login').serialize(),// 你的formid
*/       
        async: false,
        error: function(request) {
            alert("Connection error");
        },
        success: function(data) {
        	
        	$("#content_id").html(data);
        }
    });
	
	
	
}







//修改
function add(){
	
	var menu_id = $("#menu_id_").val();
	
	if(menu_id==""){
		
		confirm("请选择菜单");
	}else{
		$.ajax({
	        cache: true,
	        type: "GET",
	        url:base+"/menu/add/"+menu_id,
	        /*data:$('#exe_form_login').serialize(),// 你的formid
	*/       
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	$("#content_id").html(data);
	        	
	        }
	    });
	}
	
	
}

//添加菜单
function addNew(){
	
	
		$.ajax({
	        cache: true,
	        type: "GET",
	        url:base+"/menu/add/0",
	        /*data:$('#exe_form_login').serialize(),// 你的formid
	*/       
	        async: false,
	        error: function(request) {
	            alert("Connection error");
	        },
	        success: function(data) {
	        	
	        	$("#content_id").html(data);
	        }
	    });
}



//添加菜单
function dele(){
var menu_id = $("#menu_id_").val();
	
	if(menu_id==""){
		
		confirm("请选择菜单");
	}else{
	  var enter = window.confirm("确定删除吗?");
	  if(enter==1){
		  $.ajax({
		        cache: true,
		        type: "GET",
		        url:base+"/menu/delete/"+menu_id,
		        /*data:$('#exe_form_login').serialize(),// 你的formid
		*/       
		        async: false,
		        error: function(request) {
		            alert("Connection error");
		        },
		        success: function(data) {
		        	
		        	if(data=="-1"){
		        		confirm("操作失败");
		        	}else{
		        		window.location.reload();
		        	}
		        }
		    });
		}
	  }
		
}




