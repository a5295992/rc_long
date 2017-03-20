<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<div class="modal video-modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					登录 | 注册
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>						
				</div>
				<section>
					<div class="modal-body">
						<div class="w3_login_module">
							<div class="module form-module">
							  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
								<div class="tooltip">没有账号?</div>
							  </div>
							  <div class="form">
								<h3> 请输入您的账号</h3>
								<font color="red" id="message_font"></font>
								<form action="${base }/user/login" method="post" id="loginForm">
								  <input type="text" name="user_ssid" placeholder="账号" required="" onfocus="recove()">
								  <input type="password" name="password" placeholder="密码" required=""onfocus="recove()">
								  <input type="button" value="登录" onclick="login()">
								</form>
							  </div>
							  <div class="form">
								<h3>创建账号</h3>
								<form action="#" method="post">
								  <input type="text" name="Username" placeholder="请输入账号" required="">
								  <input type="password" name="Password" placeholder="请输入密码" required="">
								  <input type="password" name="Password_comfirm" placeholder="确认密码" required="">
								  <input type="email" name="Email" placeholder="您的邮箱 " required="">
								  <input type="text" name="Phone" placeholder="您的手机号" required="">
								  <input type="submit" value="注册">
								</form>
							  </div>
							  <div class="cta"><a href="#">忘记密码了?</a></div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
	<script>
		$('.toggle').click(function(){
		  // Switches the Icon
		  $(this).children('i').toggleClass('fa-pencil');
		  // Switches the forms  
		  $('.form').animate({
			height: "toggle",
			'padding-top': 'toggle',
			'padding-bottom': 'toggle',
			opacity: "toggle"
		  }, "slow");
		});
	</script>
<!-- //bootstrap-pop-up -->
<!-- nav -->
  <script type="text/javascript" src="${base }/www/module_02/login/login.js"></script>
  </body>
</html>
