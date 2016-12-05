<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>电影首页</title>
    <!--<link rel="stylesheet" href="css/index.css"/>-->
    <script src="../www/jquery-1.11.1.min.js"></script>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        ul{list-style: none;}
        a{text-decoration: none;
            color: #666;
        }
        /*边距设置开始*/
        .distance{
            width: 100%;
            height: 10px;
        }
        /*头部样式设置开始*/
        header{
            width: 100%;
        }
        header .login{
            width: 100%;
            height: 86px;
        }
        header .login .main{
            width: 1120px;
            /*  height: 86px;*/
            margin: 0 auto;
            background-color: white;
        }
        header .login .main .login_img{
            float: left;
            width: 112px;
            height: 38px;
            margin-top: 24px;
            margin-right: 4px;
        }
        header .login .main .login_img a{
            display: block;
            width: 112px;
            height: 38px;
        }
        header .login .main .login_img a{
            width: 112px;
            height: 38px;
        }
        header .login .main .login_img a img{
            width: 112px;
            height: 38px;
        }
        header .login .main .login_date{
            float: left;
            width: 100px;
            height: 40px;
            margin-top: 24px;
            margin-right: 109px;
        }
        header .login .main .login_date a{
            display: block;
            width: 100px;
            height: 40px;
        }
        header .login .main .login_date a img{
            display: block;
            width: 100px;
            height: 40px;
        }
        header .login .main .login_second {
            float: left;
            width: 462px;
            margin-top: 22px;
        }
        header .login .main .login_second .login_secondF{
            width: 462px;
            height: 34px;
            border: 1px solid #cccccc;
        }
        header .login .main .login_second .login_secondF .in{
            float: left;
            width: 382px;
            height: 26px;
            padding: 3px;
            border: 0;
            line-height: 34px;
            color: #000;
            font-size: 16px;
            outline: none;
        }
        header .login .main .login_second .login_secondF .sub{
            float: left;
            width: 74px;
            height: 34px;
            background-color: red;
            text-align: center;
            font-size: 16px;
            line-height: 34px;
            color: white;
            cursor: pointer;
            border: none;
            font-family: "Microsoft YaHei";
        }
        header .login .main .login_second .login_secondS{
            width: 462px;
            height: 18px;
            padding: 4px 0 0 0;
        }
        header .login .main .login_second .login_secondS li{
            float: left;
            padding-right: 10px;
            color: #888;
            font-size: 14px;
        }
        header .login .main .login_second .login_secondS li a{

            color: #888;
            font-size: 14px;
        }
        header .login .main .login_second .login_secondS li a:hover{
            color: red;
        }


        header .login .main .login_third {
            float: right;
            width: 256px;
            height: 90px;
            font-size: 12px;
        }
        header .login .main .login_third li{
            float: left;
            width: 54px;
            margin-top: 18px;
            margin-left: 8px;
        }
        header .login .main .login_third li a{
            display: block;
            width: 54px;
            font-size: 12px;

        }

        header .login .main .login_third li .img{
            width: 54px;
            height: 36px;

        }
        header .login .main .login_third li .login_thirdDiv{
            width: 54px;
            height: 20px;
            text-align: center;
            line-height: 20px;
            color: #333;
            font-size: 12px;

        }
        header .login .main .login_third li.first{
            width: 54px;
            margin-top: 18px;
            margin-left: 8px;
            font-size: 14px;
            color: #333;
        }
        header .login .main .login_third li.first .img{
            width: 54px;
            height: 36px;
        }
        header .login .main .login_third li.first .login_thirdDiv{
            width: 54px;
            height: 20px;
        }
        header .login .main .login_third li .login_thirdDiv:hover{
            color: red;
        }
        header .login .main .login_third li.first .login_thirdDiv:hover{
            color: #333;
        }
        header .login .main .login_third li.first .login_thirdDiv .span1:hover{
            color: red;
        }
        header .login .main .login_third li.first .login_thirdDiv .span2:hover{
            color: red;
        }
        header .nav{
            width: 100%;
            background-color: red;
        }
        header .nav .center{
            width: 1120px;
            height: 32px;
            margin: 0 auto;
            border-top: 2px solid red;

        }
        header .nav .center li {
            float: left;

        }
        header .nav .center li a{
            display: block;
            font-size: 14px;
            line-height: 32px;
            color: white;
            padding-right: 20px;
            padding-left: 20px;
            cursor: pointer;
        }
        header .nav .center li a:hover{
            color: #dddddd;
            opacity: 0.5;
        }
        header .nav .center li.first a{
            color: red;
            background-color: white;
        }
        /*头部样式设置结束*/
        /*轮播图样式设置开始*/
        .box{
            margin-top: 5px;
            width: 100%;
            height: 300PX;
            overflow: hidden;
            /*background-color: rgba(0, 0, 0, 0.5);*/
            position: relative;
            /*border-radius: 30px;*/
        }
        .box .lunbo{
            list-style: none;
            width: 500%;
            height: 300px;
            position: absolute;
            top: 0;
            left: 0;

            /*background-color: aqua;*/
        }
        .box .lunbo li {
            float: left;
            width: 20%;
            height: 300px;
        }
        .box .lunbo li img{
            width: 100%;
            height: 300px;
        }
        .box .circle{
            width: 940px;
            height: 60px;
            position: absolute;
            left: 50%;
            bottom: 0;
            margin-left: -470px;
            background-color: rgba(0,0,0,0.5);

        }
        .box .circle .circleLeft{
              width: 380px;
              height: 40px;
              float: left;
           padding: 10px;
          }
        .box .circle .circleLeft img{
            width: 40px;
            height: 40px;
            float: left;
            opacity: 0.8;
        }
        .box .circle .circleLeft .text{
            width: 300px;
            height: 40px;
            float: left;
        }
        .box .circle .circleLeft .text h3{
            width: 300px;
            height: 20px;
            text-align: center;
            line-height: 20px;
            color: white;
        }
        .box .circle .circleLeft .text p{
            width: 300px;
            height: 20px;
            text-align: center;
            line-height: 20px;
            color: white;
        }
        .box .circle .circleLeft span{
            display: block;
            width: 40px;
            height: 40px;
            float: left;
            font-size: 60px;
            line-height: 40px;
            font-weight: 900;
            color: #333;

        }
        .box .circle .circleRight{
            width: 500px;
            height: 60px;
            float: left;
        }
        .box .circle .circleRight ul{
            width: 600px;
            height: 60px;

        }
        .box .circle .circleRight ul li{
            float: left;
            width: 90px;
            height: 40px;
            padding: 10px;
            opacity: 0.6;
        }
        .box .circle .circleRight ul li{

            padding-right: 0;
        }
        .box .circle .circleRight ul li img{
            width: 90px;
            height: 40px;
        }
        .box  .circle .arrow{
            float: left;
            width: 40px;
            height: 60px;
            font-size: 60px;
            line-height: 60px;
            font-weight: 900;
            color: #333;
            text-align: left;


        }
        .box .circle .circleRight ul .op img {
            width: 90px;
            height: 40px;
            opacity: 0.6;
        }
        /*轮播图样式设置结束*/

        /*热门推荐样式设置开始*/
        .hot{
            width: -webkit-calc(100% - 40px);
            width: -moz-calc(100% - 40px);
            width: calc(100% - 40px);
            padding:0 20px 0 20px;
            height: 400px;
            /*background-color: green;*/
        }
        .hot .hotTitle{
            width: 100%;
            height: 30px;

        }
        .hot .hotTitle h3{
            float: left;
            width: -webkit-calc(50% - 200px);
            width: -moz-calc(50% - 200px);
            width: calc(50% - 200px);
            padding:0 100px 0 100px;
            height: 30px;
            text-align: left;
            line-height: 30px;

        }
        .hot .hotTitle p{
            float: left;
            width: -webkit-calc(50% - 200px);
            width: -moz-calc(50% - 200px);
            width: calc(50% - 200px);
            padding:0 100px 0 100px;
            height: 30px;
            text-align: right;
            line-height: 30px;

        }
        .hot .hotContent{
            width: 100%;
            height: 370px;
            width: -webkit-calc(100% - 200px);
            width: -moz-calc(100% - 200px);
            width: calc(100% - 200px);
            padding:0 100px 0 100px;
            /*overflow: hidden;*/
        }
        .hot .hotContent .hotSmall{
            float: left;
            width: 33%;
            height: 370px;
        }
        .hot .hotContent .hotSmall img{
            width: 100%;
            height: 370px;

        }
        .hot .hotContent .hotBig{
            float: right;
             width: -webkit-calc(67% - 20px);
             width: -moz-calc(67% - 20px);
             width: calc(67% - 20px);
             padding:0 0px 0 20px;
            /*background-color: red;*/
         }
        .hot .hotContent .hotBig ul.bigFirst{
            width: 100%;
            height: 175px;
            padding-bottom: 10px;
        }
        .hot .hotContent .hotBig ul.bigSecond{
            width: 100%;
            height: 175px;
            /*padding-top: 10px;*/
        }
        .hot .hotContent .hotBig ul li{
            float: left;
            width: -webkit-calc(23% - 10px);
            width: -moz-calc(23% - 10px);
            width: calc(23% - 10px);
            padding:0 10px 0 0px;
            height: 185px;
        }
        .hot .hotContent .hotBig ul li.last{

            width: -webkit-calc(31% - 10px);
            width: -moz-calc(31% - 10px);
            width: calc(31% - 10px);
            padding:0 10px 0 0px;
            height: 185px;
        }
        .hot .hotContent .hotBig ul li img{
            width: 100%;
            padding:0 10px 0 0px;
            height: 125px;
        }
        .hot .hotContent .hotBig ul li  h6{
            font-size: 12px;
            line-height: 15px;
            text-align: left;
            height: 15px;
        }
        .hot .hotContent .hotBig ul li  p{
            font-size: 12px;
            line-height: 15px;
            text-align: left;
            height: 15px;

        }

        
        /*热门推荐样式设置结束*/

        /*底部样式设置开始*/
        footer{
            margin-top: 10px;
            width: 100%;
        }

        footer div{
            width: 100%;
        }
        footer div img{
            width: calc(100% - 50%);
            padding-left: 25%;
            padding-right: 25%;
            height: 60px;
            margin: 0 auto;
        }
        footer div p{
            width: 100%;
            height: 30px;
            text-align: center;
            line-height: 30px;
            font-size: 12px;
        }
        /*底部样式设置结束*/

    </style>

</head>
<body>
<!--头部开始-->
<header>
    <!--头部首导航开始-->
    <nav class="login">
        <div class="main">
            <div class="login_img">
                <a href="#">
                    <img src="../www/resources/images/007.PNG" alt="图标"/>
                </a>
            </div>
            <div class="login_date">
                <a href="#"><img  src="../www/resources/images/date.gif" alt="动图"></a>
            </div>

            <div class="login_second">
                <div class="login_secondF">
                    <input type="text" class="in" value="上课别看"/>
                    <input type="submit" class="sub" value="乐搜"/>
                </div>
                <div class="login_secondS">
                    <ul>
                        <li><a href="#">上课别看</a></li>
                        <li><a href="#">赵薇资助希拉里</a></li>
                        <li><a href="#">56音乐下午茶</a></li>
                        <li><a href="#">微体兔菜谱</a></li>
                    </ul>
                </div>

            </div>
            <div class="login_third">
                <ul>
                    <li class="first">
                        <a href="#">
                            <div class="img"><img src="../www/resources/images/001.PNG" alt=""/></div>
                            <div class="login_thirdDiv">
                                <span class="span1">登陆</span>
                                <span class="span2">注册</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="img"><img src="../www/resources/images/002.PNG" alt=""/></div>

                            <div class="login_thirdDiv">
                                上传
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="img"><img src="../www/resources/images/003.PNG" alt=""/></div>
                            <div class="login_thirdDiv">
                                消息
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="img"><img src="../www/resources/images/003.PNG" alt=""/></div>
                            <div class="login_thirdDiv">
                                看过
                            </div>
                        </a>
                    </li>
                </ul>
            </div>

        </div>
    </nav>
    <!-- 头部首导航结束-->
    <!-- 头部子导航开始-->
    <nav class="nav">
        <div class="center">
            <ul>
                <li><a href="../sys/video">首页</a></li>
                <li><a href="#">电视剧</a></li>
                <li class="first"><a href="../sys/movie">电影</a></li>
                <li><a href="#">综艺</a></li>
                <li><a href="#">搞笑</a></li>
                <li><a href="#">直播</a></li>
            </ul>
        </div>
    </nav>
    <!-- 头部子导航结束-->
</header>
<!--轮播图内容区域开始-->
<div id="box" class="box">
    <ul id="lunbo" class="lunbo">
        <li><a href="#"><img src="../www/resources/images/lunbo1.jpg" alt=""/></a></li>
        <li><a href="#"><img src="../www/resources/images/lunbo2.jpg" alt=""/></a></li>
        <li><a href="#"><img src="../www/resources/images/lunbo3.jpg" alt=""/></a></li>
        <li><a href="#"><img src="../www/resources/images/lunbo4.jpg" alt=""/></a></li>
        <li><a href="#"><img src="../www/resources/images/lunbo2.jpg" alt=""/></a></li>
    </ul>
    <div class="circle">
        <div class="circleLeft">
            <img src="images/video.PNG" alt=""/>
           <div class="text">
               <h3>《长城发布刘德华幕后特辑</h3>
               <p>无影禁军神秘军师现身</p>
           </div>
            <span> < </span>
        </div>
        <div class="circleRight">
            <ul>
                <li title="0"><a href="#" ><img src="../www/resources/images/lunbo1.jpg" alt=""/></a></li>
                <li title="-1"><a href="#" ><img src="../www/resources/images/lunbo2.jpg" alt=""/></a></li>
                <li title="-2"><a href="#" ><img src="../www/resources/images/lunbo3.jpg" alt=""/></a></li>
                <li title="-3"><a href="#" title="3"><img src="../www/resources/images/lunbo4.jpg" alt=""/></a></li>
                <li title="-4"><a href="#"><img src="../www/resources/images/lunbo5.jpg" alt=""/></a></li>
            </ul>
        </div>
        <div class="arrow"> > </div>
    </div>
</div>
<!--盒子之间的边距-->
<div class="distance"></div>
<!--轮播图内容区域结束-->
<!--热门推荐内容区域开始-->
<div class="hot">
    <div class="hotTitle">
        <h3>热门推荐</h3>
        <p>每周精选</p>
    </div>
    <div class="hotContent">
        <div class="hotSmall">
            <a href="#">
                <img src="../www/resources/images/hot.jpg" alt=""/>
            </a>
        </div>
        <div class="hotBig">
            <ul class="bigFirst">
                <li>
                    <a href="#">
                        <img src="../www/resources/images/hot1.jpg" alt=""/>
                        <h6>漫威超萌小剧场</h6>
                        <p>当打斗变成过家家</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="../www/resources/images/hot2.jpg" alt=""/>
                        <h6>洗剪吹的拼搏之路</h6>
                        <p>不要小看勤奋的力量</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="../www/resources/images/lunbo3.jpg" alt=""/>
                        <h6>历尽美好与灾难只为遇见</h6>
                        <p>雪人的旅程</p>
                    </a>
                </li>
                <li class="last">
                    <a href="#">
                        <img src="../www/resources/images/hot3.jpg" alt=""/>
                        <h6>《美人私房菜》马天宇郑爽再度合作</h6>
                        <p>雪人的旅程</p>
                    </a>
                </li>

            </ul>
            <ul class="bigSecond">
                <li>
                    <a href="#">
                        <img src="../www/resources/images/hot4.jpg" alt=""/>
                        <h6>一碗泡面成就一个梦想</h6>
                        <p>总会有闪耀的一天</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="../www/resources/images/hot5.jpg" alt=""/>
                        <h6>重绘爱伦笔下的死亡之诗</h6>
                        <p>雪人的旅程</p>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <img src="../www/resources/images/lunbo3.jpg" alt=""/>
                        <h6>历尽美好与灾难只为遇见</h6>
                        <p>雪人的旅程</p>
                    </a>
                </li>
                <li class="last">
                    <a href="#">
                        <img src="../www/resources/images/hot6.jpg" alt=""/>
                        <h6>肖旭青睐睡师称太美好</h6>
                        <p>雪人的旅程</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</div>
<!--热门推荐内容区域结束-->
<!--底部区域开始-->
<footer>
    <div>
        <img src="../www/resources/images/footer.jpg" alt=""/>
        <p>不良信息举报电话：020-85533243举报邮箱：56kf#sohu-inc.com (使用时将#号改为@)</p>
        <p>网络视听许可证1908336中国互联网诚信联盟粤通管BBS【2009】第175号粤ICP备05006774号-1粤ICP证粤B2-20041027穗公网监备案证号：4401060102823</p>
        <p>增值电信业务经营许可证B2-20090492互联网药品信息服务资格证(粤)-非经营性-2014-0018节目制作经营许可证粤第735号粤网文[2013]0244-094</p>
        <p>粤公网安备 44010602000140号中国互联网举报中心</p>
        <p>Copyright ©2016 56.com 版权所有</p>
    </div>
</footer>
<!--底部区域结束-->
<script>
    //轮播图js行为开始
    var box = document.getElementById('box');
    var boxUl = document.getElementById('lunbo');
    var num = 0;
    var timer1 = null;
    var timer2 = null;
    var timer3 = null;
    var timer4 = null;
//    console.log()
var clientW = document.documentElement.clientWidth;
    function autoPlay(){
        num -= document.documentElement.clientWidth ;
//        console.log(num);
        num <= -4316? num = 0 : num;
        boxUl.style.left = num + 'px';
    }

  timer1 =  setInterval(autoPlay,3000);
    $('.circleRight li').mouseenter(function(){
      timer2 =  clearInterval(timer1);
      timer4 =  clearInterval(timer3);
        $(this).css('opacity','1').siblings('li').css('opacity','0.6');
        var cw = $(this).attr('title') * clientW + 'px';
//        console.log(cw)
        $('#lunbo').css('left',cw);
    });
    $('.circleRight li').mouseleave(function(){
        clearInterval(timer1);
        var lefte = boxUl.offsetLeft;
       timer3 = setInterval(function(){
           lefte -= clientW ;
           console.log(lefte);
           lefte <= -4316? lefte = 0 : lefte;
           boxUl.style.left = lefte + 'px';
       },3000)
    });
//轮播图js行为结束

//热门推荐js行为开始
    $('.hotContent li').mouseenter(function(){
        $(this).css('opacity','0.6').siblings('li').css('opacity','1');
    });
    //热门推荐js行为结束
</script>
</body>
</html>