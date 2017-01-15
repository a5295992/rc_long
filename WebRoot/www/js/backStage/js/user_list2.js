var w = window.location;
function del(user_id) {
	var enter = window.confirm("警告！删除该用户后,用户无法再使用该账号");
	if (enter == 1) {
		$.ajax({
			cache : true,
			type : "POST",
			url : base + "/sys/back/user/delete",
			// data:$('#exe_form_login').serialize(),// 你的formid
			data : {
				"user_id" : user_id
			},
			async : false,
			error : function(request) {
				alert("Connection error");
			},
			success : function(data) {
				if (data > 0) {
					window.confirm("操作成功");
					w.replace(base + "/sys/back");
				} else {
					window.confirm("操作失败");
				}
			}
		});
	}
};

function dealForm() {
	$("#listform").attr("method", "post");
	$("#listform").attr("action", base + "/sys/back/user/search");
}
function lastVal() {
	$("#pageNum").val(pageNum - 1);
	dealForm();

	$("#listform").submit();
}
function nextVal() {
	dealForm();
	$("#pageNum").val(pageNum + 1);
	$("#listform").submit();
}
// 转到哪一页
function turnPage() {
	dealForm();
	var pa = $("input[name='inputPageNum']").val();
	$("#pageNum").val(pa);
	$("#listform").submit();
}

// 模糊查询

function changesearch() {
	var like = $("#likeSearch").val();
	var likeName = $("#likeName_serach").val();
	$("#like").val(like);
	$("#likeName").val(likeName);
	dealForm();
	$("#listform").submit();
}
// 排序
function sorts() {
	var oder = $("#oder").val();
	if (oder == "desc") {
		$("#oder").val("asc");
	} else {
		$("#oder").val("desc");
	}
	dealForm();
	$("#listform").submit();
}
// 更改排序内容
function changgeThingOder() {
	var oderNam = $("select[name='ishome']").val();
	$("#oderBy").val(oderNam);
}

// 全选删除

function DelSelect() {
	var Checkbox = false;
	$("input[name='id[]']").each(function() {
		if (this.checked == true) {
			Checkbox = true;
		}
	});
	if (Checkbox) {
		var t = confirm("您确认要删除选中的内容吗？");
		if (t == false)
			return false;
		$("#listform").submit();
	} else {
		alert("请选择您要删除的内容!");
		return false;
	}
}
// 全选择
$("#checkall").click(function() {
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			this.checked = false;
		} else {
			this.checked = true;
		}
	});
});

// 获取选中的用户id
function getSelectUserId() {
	var index = 0;
	var user_id ="";
	$("input[name='id[]']").each(function() {
		if (this.checked) {
			index = index + 1;
			user_id = $(this).val();
		}
	});
	if (index!=1) {
		window.confirm("选且仅能选择一位用户!");
	}else{
		return user_id;
	}
}
// 打开会话对话框
var openMessageDialog = function() {
	var user_id = getSelectUserId();

		var websocket = null;
   
  //判断当前浏览器是否支持WebSocket
  if('WebSocket' in window){
      websocket = new WebSocket("ws://localhost:6662/rc_long/websocketToUser");
      send("{user_id:'10000'}");
  }
  else{
      alert('Not support websocket');
  }
   
  //连接发生错误的回调方法
  websocket.onerror = function(){
  };
   
  //连接成功建立的回调方法
  websocket.onopen = function(event){
	  alert("openn");
  };
   
  //接收到消息的回调方法
  websocket.onmessage = function(event){
	  alert(event.data);
  };
   
  //连接关闭的回调方法
  websocket.onclose = function(){
  };
   
  //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
  window.onbeforeunload = function(){
      websocket.close();
  };
   
  //将消息显示在网页上
  function setMessageInnerHTML(innerHTML){
  }
   
  //关闭连接
  function closeWebSocket(){
      websocket.close();
  }
  
  //发送消息
  function send(message){
	  setTimeout(function(){
			websocket.send(message);
		}, 1000);
  }
	var diag = new Dialog();

	diag.Title = "推送消息";

	diag.URL = "test.html";

	diag.OKEvent = function() {
		var message = diag.innerFrame.contentWindow.document
				.getElementById('a').value;
		var data = {
			"user_id" : "10000",
			"message" : message,
			"receive_id" : user_id
		};
		send(JSON.stringify(data));
		diag.close();

	};

	diag.show();

	var doc = diag.innerFrame.contentWindow.document;

	doc.open();

	doc.write('<html><body><input id="a" type="text"/>请输入消息内容</body></html>');

	doc.close();
};

$("#sendMessageToUsers").click(openMessageDialog);