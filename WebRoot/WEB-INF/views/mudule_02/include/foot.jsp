  		<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  		<div class="footer">
  		
		<div class="container">
			<div class="w3ls_footer_grid">
				<div class="col-md-6 w3ls_footer_grid_left">
					<div class="w3ls_footer_grid_left1">
						<h2>请联系我们</h2>
						<div class="w3ls_footer_grid_left1_pos">
							<form action="#" method="post">
								<input type="email" name="email" placeholder="你的邮箱" required="">
								<input type="submit" value="发送">
							</form>
						</div>
					</div>
				</div>
				<div class="col-md-6 w3ls_footer_grid_right">
					<a href="${base }"><h2>Rc_long<span>电影网</span></h2></a>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="col-md-5 w3ls_footer_grid1_left">
				<p>Copyright &copy; 2017.精彩世界需要我们努力去开启.<a target="_blank" href="${base }/">作者</a></p>
			</div>
			<div class="col-md-7 w3ls_footer_grid1_right">
				<ul>
					<li>
						<a href="genres.html">电影</a>
					</li>
					<li>
						<a href="faq.html">电视剧</a>
					</li>
					<li>
						<a href="horror.html">最新活动</a>
					</li>
					<li>
						<a href="genres.html">介绍</a>
					</li>
					<li>
						<a href="comedy.html">管理员</a>
					</li>
					<li>
						<a href="icons.html">酬谢</a>
					</li>
					<li>
						<a href="contact.html">联系我</a>
					</li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
<!-- //Bootstrap Core JavaScript -->
<!-- here stars scrolling icon -->
	<script type="text/javascript">
		$(document).ready(function() {
			/*
				var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
				};
			*/
								
			$().UItoTop({ easingType: 'easeOutQuart' });
								
			});
	</script>
<!-- //here ends scrolling icon -->
  

