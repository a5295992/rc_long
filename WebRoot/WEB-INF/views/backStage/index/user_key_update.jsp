<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="../../../jsp/global.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
 <body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改会员密码</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="" id="update_form">
      <div class="form-group">
        <div class="label">
          <label for="sitename">管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
          	${ShiroUser.user_ssid }
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="mpass" name="user_key" size="50" placeholder="请输入原始密码" required="required" />       
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="user_key_comfirm" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" required="required" maxlength="10" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" name="c_user_key_comfirm" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,c_user_key_comfirm#user_key_comfirm:两次输入的密码不一致" required="required" />          
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="button" onclick="update('${ShiroUser.user_id}')"> 提交</button>   
        </div>
      </div>      
    </form>
  </div>
</div>
  <script type="text/javascript" scr="${back_static }/js/update.js">
//打印
  function update(user_id){
  	//前段校验

  	//获取原始密码
  	var mpass= $("#mpass").val();

  	//获取 新密码

  	var user_key_comfirm=$("input[name='user_key_comfirm']").val();

  	//确认密码

  	var c_user_key_comfirm =$("input[name='c_user_key_comfirm']").val();
  	
  	if(user_key_comfirm!=c_user_key_comfirm){
  		window.confirm("两次输入的密码不一致");
  	}else{
  		if(user_key_comfirm.length<5){
  			window.confirm("密码长度过短");
  		}else{
  			$.ajax({
  		        cache: true,
  		        type: "POST",
  		        url:base+"/admin/updatekey/"+user_id,
  		        data:$("#update_form").serialize(),// 你的formid
  		        async: false,
  		        error: function(request) {
  		            alert("Connection error");
  		        },
  		        success: function(data) {
  		            if(data=="修改成功"){
  		            	var enter = window.confirm(data);
  		            	if(enter==1){
  		            		window.location.reload();
  		            	}
  		            }else{
  		            	window.confirm(data);
  		            }
  		        }
  		    });
  		}
  	}
  	
  }
  
  </script>
  </body>
</html>
