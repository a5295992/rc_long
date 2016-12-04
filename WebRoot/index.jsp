<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>56网</title>
    <meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" href="/css/base.css"/>
    <link rel="stylesheet" href="/css/index.css"/>
  </head>

<body>
<!--头部开始-->
<header>
    <!--头部首导航开始-->
    <nav class="login">
        <div class="main">
                <div class="login_img">
                    <a href="#">
                        <img src="images/007.PNG" alt="图标"/>
                    </a>
                </div>
                <div class="login_date">
                    <a href="#"><img  src="images/date.gif" alt="动图"></a>
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
                            <div class="img"><img src="images/001.PNG" alt=""/></div>
                            <div class="login_thirdDiv">
                                <span class="span1">登陆</span>
                               <span class="span2">注册</span>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="img"><img src="images/002.PNG" alt=""/></div>

                            <div class="login_thirdDiv">
                                上传
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="img"><img src="images/003.PNG" alt=""/></div>
                            <div class="login_thirdDiv">
                                消息
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <div class="img"><img src="images/003.PNG" alt=""/></div>
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
               <li class="first"><a href="#">首页</a></li>
               <li><a href="#">电视剧</a></li>
               <li><a href="movie.html">电影</a></li>
               <li><a href="#">综艺</a></li>
               <li><a href="#">搞笑</a></li>
               <li><a href="#">直播</a></li>
           </ul>
       </div>
    </nav>
    <!-- 头部子导航结束-->
</header>
<!--头部结束-->

<!--内容区域开始-->
<div class="content">
    <!-- 直播间-->
    <section class="section1">
        <div class="sec_F">

           <div class="sec_Fbox">
                <a href="#"><img src="images/0023.jpg" alt=""/></a>
                <div class="small">
                    <span><img src="images/008.PNG" alt=""/></span>
                    <span>速来围观逆天颜值！气质女神完美娃娃脸</span>
                </div>
            </div>
            <div class="sec_Ful">
                <ul>
                    <li>
                        <div class="liF">
                            <a href="#"><img src="images/0024.jpg" alt=""/></a>
                           <div class="liS">
                               <span><img src="images/009.PNG" alt=""/></span>
                               <span>154133</span>
                           </div>
                        </div>
                        <span class="title">快评《吓死鬼》的死亡套路</span>
                    </li>
                    <li>
                        <div class="liF">
                            <a href="#"><img src="images/0025.jpg" alt=""/></a>
                            <div class="liS">
                                <span><img src="images/009.PNG" alt=""/></span>
                                <span>154133</span>
                            </div>
                        </div>
                        <span class="title">[人物] 铁三角人老心不老</span>
                    </li>
                    <li class="last">
                        <div class="liF">
                            <a href="#"><img src="images/0026.jpg" alt=""/></a>
                            <div class="liS">
                                <span><img src="images/009.PNG" alt=""/></span>
                                <span>154133</span>
                            </div>
                        </div>
                        <span class="title">[电影] 20分钟看懂李安</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="sec_S">
            <div class="sec_sbig">
                <ul>
                    <li>
                        <div class="liF">
                            <a href="#"><img src="images/0027.jpg" alt=""/></a>
                            <div class="liS">
                                <span><img src="images/009.PNG" alt=""/></span>
                                <span>154133</span>
                            </div>
                        </div>
                        <span class="title">谁说一个人不能去旅行</span>
                    </li>

                    <li>
                        <div class="liF">
                            <a href="#"><img src="images/0028.jpg" alt=""/></a>
                            <div class="liS">
                                <span><img src="images/009.PNG" alt=""/></span>
                                <span>154133</span>
                            </div>
                        </div>
                        <span class="title">男神周柏豪：我对henry很心动</span>
                    </li>

                    <li class="last">
                        <div class="liF">
                            <a href="#"><img src="images/0029.jpg" alt=""/></a>
                            <div class="liS">
                                <span><img src="images/009.PNG" alt=""/></span>
                                <span>154133</span>
                            </div>
                        </div>
                        <span class="title">邓紫棋穿皮裤为谁站台</span>
                    </li>
                </ul>
            </div>
            <div class="sec_ssmal">
                <ul>
                    <li>
                        <div class="liF">
                            <a href="#"><img src="images/0030.jpg" alt=""/></a>
                            <div class="liS">
                                <span><img src="images/009.PNG" alt=""/></span>
                                <span>154133</span>
                            </div>
                        </div>
                        <span class="title">欢迎加入搜狐视频自媒体</span>
                    </li>

                    <li>
                        <div class="liF">
                            <a href="#"><img src="images/0031.jpg" alt=""/></a>
                            <div class="liS">
                                <span><img src="images/009.PNG" alt=""/></span>
                                <span>154133</span>
                            </div>
                        </div>
                        <span class="title">[特别推荐] 第三届搜狐视频出品人大会</span>
                    </li>

                    <li>
                        <div class="liF">
                            <a href="#"><img src="images/0032.jpg" alt=""/></a>
                            <div class="liS">
                                <span><img src="images/009.PNG" alt=""/></span>
                                <span>154133</span>
                            </div>
                        </div>
                        <span class="title">[千帆直播] 千帆直播年度盛典隆重启动</span>
                    </li>
                </ul>
            </div>
        </div>
    </section>
    <!--猜你喜欢-->
    <section class="section2">
        <!-- 猜你喜欢左侧 -->
        <div class="side-left fl">
            <h2>猜你喜欢</h2>
            <div class="like">
                <div class="item-like">
                    <div class="pic-list">
                        <div class="pic">
                            <img src="images/like1.jpg" alt="" class="pic-big"/>
                            <div class="list">
                                <div class="vid">
                                    <span></span><span>2345</span>
                                </div>
                            </div>
                            <img src="images/likes1.jpg" alt="" class="pic-small"/>
                            <span class="list-tit">枣集娱乐传媒</span>
                        </div>
                    </div>
                    <p>《闺蜜嫁到》夏晴出现疑似情</p>
                </div>
                <div class="item-like">
                    <div class="pic-list">
                        <div class="pic">
                            <img src="images/like2.jpg" alt="" class="pic-big"/>
                            <div class="list">
                                <div class="vid">
                                    <span></span><span>2164</span>
                                </div>
                            </div>
                            <img src="images/likes2.jpg" alt="" class="pic-small"/>
                            <span class="list-tit">好丹娱乐</span>
                        </div>
                    </div>
                    <p>王菲女儿窦静童出席盛典造型</p>
                </div>
                <div class="item-like">
                    <div class="pic-list">
                        <div class="pic">
                            <img src="images/like3.jpg" alt="" class="pic-big"/>
                            <div class="list">
                                <div class="vid">
                                    <span></span><span>106</span>
                                </div>
                            </div>
                            <img src="images/likes3.jpg" alt="" class="pic-small"/>
                            <span class="list-tit">美拍明星制造</span>
                        </div>
                    </div>
                    <p>鲜肉咨询：以撩妹方式打开安</p>
                </div>
                <div class="item-like">
                    <div class="pic-list">
                        <div class="pic">
                            <img src="images/like4.jpg" alt="" class="pic-big"/>
                            <div class="list">
                                <div class="vid">
                                    <span></span><span>2568</span>
                                </div>
                            </div>
                            <img src="images/likes4.jpg" alt="" class="pic-small"/>
                            <span class="list-tit">飞鹰传媒</span>
                        </div>
                    </div>
                    <p>权志龙同款昂贵项链竟被</p>
                </div>
                <div class="item-like">
                    <div class="pic-list">
                        <div class="pic">
                            <img src="images/like5.png" alt="" class="pic-big"/>
                            <div class="list">
                                <div class="vid">
                                    <span></span><span>142</span>
                                </div>
                            </div>
                            <img src="images/likes5.jpg" alt="" class="pic-small"/>
                            <span class="list-tit">中视彩华</span>
                        </div>
                    </div>
                    <p>流浪猫</p>
                </div>
                <div class="item-like">
                    <div class="pic-list">
                        <div class="pic">
                            <img src="images/like6.jpg" alt="" class="pic-big"/>
                            <div class="list">
                                <div class="vid">
                                    <span></span><span>48万</span>
                                </div>
                            </div>
                            <img src="images/likes6.jpg" alt="" class="pic-small"/>
                            <span class="list-tit">棒呼Bongho</span>
                        </div>
                    </div>
                    <p>【独播】科技龙卷风</p>
                </div>
                <div class="item-like">
                    <div class="pic-list">
                        <div class="pic">
                            <img src="images/like7.png" alt="" class="pic-big"/>
                            <div class="list">
                                <div class="vid">
                                    <span></span><span>43</span>
                                </div>
                            </div>
                            <img src="images/likes7.jpg" alt="" class="pic-small"/>
                            <span class="list-tit">视频绝活</span>
                        </div>
                    </div>
                    <p>大爷公园秀球技引围观</p>
                </div>
                <div class="item-like">
                    <div class="pic-list">
                        <div class="pic">
                            <img src="images/like8.jpg" alt="" class="pic-big"/>
                            <div class="list">
                                <div class="vid">
                                    <span></span><span>341</span>
                                </div>
                            </div>
                            <img src="images/likes8.jpg" alt="" class="pic-small"/>
                            <span class="list-tit">大话风水脱口秀</span>
                        </div>
                    </div>
                    <p>《大话风水》第30集神秘的风</p>
                </div>
            </div>
        </div>
        <!-- 猜你喜欢右侧 -->
        <div class="side-right fl">
            <h3>精品栏目</h3>
            <div class="">
                <ul class="culm">
                    <li class="culm-list">
                        <img src="images/jplm1.jpg" alt=""/>
                        <span class="tit">囧闻一箩筐</span>
                        <span class="time">11-28更新597集</span>
                    </li>
                    <li class="culm-list">
                        <img src="images/jplm2.jpg" alt=""/>
                        <span class="tit">二更人物</span>
                        <span class="time">11-28更新307集</span>
                    </li>
                    <li class="culm-list">
                        <img src="images/jplm3.jpg" alt=""/>
                        <span class="tit">山下智博</span>
                        <span class="time">11-28更新642集</span>
                    </li>
                    <li class="culm-list">
                        <img src="images/jplm4.jpg" alt=""/>
                        <span class="tit">暴走大事件</span>
                        <span class="time">11-28更新39集</span>
                    </li>
                    <li class="culm-list">
                        <img src="images/jplm5.jpg" alt=""/>
                        <span class="tit">飞碟说第二季</span>
                        <span class="time">11-28更新98集</span>
                    </li>
                    <li class="culm-list">
                        <img src="images/jp_06.jpg" alt=""/>
                        <span class="tit">电影速放室</span>
                        <span class="time">11-28更新61集</span>
                    </li>
                </ul>
            </div>
        </div>
    </section>

    <!-- 电影-->
    <section class="section3">
        <!-- 电影左侧 -->
        <div class="side-left fl">
            <div class="movie-tit">
                <ul>
                    <li><h2>电影</h2></li>
                    <li class="tit-item first"><a href="" class="active">精选短片</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">最新预告</a>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">院线强档</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">幕后特辑</a></li>
                </ul>
            </div>
            <div class="item">
                <ul>
                    <li>
                        <img src="images/dy1.jpg" alt=""/>
                        <div class="pic-tit">战斗民族的动漫展</div>
                        <div class="smalltit">最真实漫展记录</div>
                    </li>
                    <li>
                        <img src="images/dy2.jpg" alt=""/>
                        <div class="pic-tit">女人要的就是这种惊喜</div>
                        <div class="smalltit">男人的觉悟</div>
                    </li>
                    <li>
                        <img src="images/dy3.jpg" alt=""/>
                        <div class="pic-tit">漫威超萌小剧场</div>
                        <div class="smalltit">当打斗变成过家家</div>
                    </li>
                    <li>
                        <img src="images/dy4.jpg" alt=""/>
                        <div class="pic-tit">一碗泡面成就一个梦想</div>
                        <div class="smalltit">总会有闪耀的一天</div>
                    </li>
                </ul>
            </div>
        </div>
        <!-- 电影右侧 -->
        <div class="side-right fl">
            <h3>每周精选</h3>
            <ul>
                <li>
                    <img src="images/dy5.jpg" alt=""/>
                    <span>男人临死前始终绕不过这一生最爱的女人</span>
                </li>
                <li>
                    <img src="images/dy6.jpg" alt=""/>
                    <span>踏雪寻梅《曾经我也想过一了百了》</span>
                </li>
            </ul>
        </div>
    </section>
    <!-- 电视剧-->
    <section class="section4">
        <div class="side-left fl">
            <div class="movie-tit">
                <ul>
                    <li><h2>电视剧</h2></li>
                    <li class="tit-item first"><a href="" class="active">网络热播</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">强势推荐</a>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">内地剧</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">美剧</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">日韩剧</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">资讯速递</a></li>
                </ul>
            </div>
            <div class="item">
                <ul>
                    <li>
                        <div class="picBox">
                            <img src="images/dsj1.jpg" alt=""/>
                            <span class="bg"><span class="count">更新至第16集</span></span>
                        </div>
                        <div class="pic-tit">秦明父亲的谜题终要解开</div>
                        <div class="smalltit">法医秦明</div>
                    </li>
                    <li>
                        <div class="picBox">
                            <img src="images/dsj2.jpg" alt=""/>
                            <span class="bg"><span class="count">更新至第6集</span></span>
                        </div>
                        <div class="pic-tit">爆笑 ！全家一起学英语</div>
                        <div class="smalltit">心里的声音</div>
                    </li>
                    <li>
                        <div class="picBox">
                            <img src="images/dsj3.jpg" alt=""/>
                            <span class="bg"><span class="count">更新至第20集</span></span>
                        </div>
                        <div class="pic-tit">一边是爱情一边是信仰</div>
                        <div class="smalltit">无名者</div>
                    </li>
                    <li>
                        <div class="picBox">
                            <img src="images/dsj5.jpg" alt=""/>
                            <span class="bg"><span class="count">45集全</span></span>
                        </div>
                        <div class="pic-tit">"流氓头儿"于震的抗日故事</div>
                        <div class="smalltit">不可能完成的任务</div>
                    </li>
                </ul>
            </div>
        </div>
        <div class="side-right fl">
            <h3>热剧榜</h3>
            <div class="list-names">
                <ul class="fl">
                    <li>
                        <span class="num">1</span>
                        <a href="">法医秦明</a>
                    </li>
                    <li>
                        <span class="num">2</span>
                        <a href="">麻雀</a>
                    </li>
                    <li>
                        <span class="num">3</span>
                        <a href="">胭脂</a>
                    </li>
                    <li>
                        <span class="num">4</span>
                        <a href="">双刺</a>
                    </li>
                    <li>
                        <span class="num">5</span>
                        <a href="">小别离</a>
                    </li>
                </ul>
                <ul class="fl">
                    <li>
                        <span class="num">6</span>
                        <a href="">刺客列传</a>
                    </li>
                    <li>
                        <span class="num">7</span>
                        <a href="">新边城浪子</a>
                    </li>
                    <li>
                        <span class="num">8</span>
                        <a href="">亲爱的公主病</a>
                    </li>
                    <li>
                        <span class="num">9</span>
                        <a href="">好家伙</a>
                    </li>
                    <li>
                        <span class="num">10</span>
                        <a href="">生活大爆炸</a>
                    </li>
                </ul>
            </div>
        </div>
    </section>
    <!-- 综艺-->
    <section class="section5">
        <div class="side-left fl">
            <div class="movie-tit">
                <ul>
                    <li><h2>综艺</h2></li>
                    <li class="tit-item first"><a href="" class="active">精选短片</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">最新更新</a>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">娱乐爆点</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">大陆综艺</a></li>
                    <li><span></span></li>
                    <li class="tit-item"><a href="">海外综艺</a></li>
                </ul>
            </div>
            <div class="item">
                <ul>
                    <li>
                        <img src="images/zy1.jpg" alt=""/>
                        <div class="pic-tit">辛颖CP穿越50年扮老</div>
                        <div class="smalltit">如果爱</div>
                    </li>
                    <li>
                        <img src="images/zy2.jpg" alt=""/>
                        <div class="pic-tit">孟非口误惹谢以霖罢录</div>
                        <div class="smalltit">四大名助</div>
                    </li>
                    <li>
                        <img src="images/zy3.jpg" alt=""/>
                        <div class="pic-tit">池子深夜放歌遭毒打</div>
                        <div class="smalltit">今晚80后脱口秀</div>
                    </li>
                    <li>
                        <img src="images/zy4.jpg" alt=""/>
                        <div class="pic-tit">本世纪最人性化的发明</div>
                        <div class="smalltit">Lady聊聊时尚圈</div>
                    </li>
                    <li class="last">
                        <img src="images/zy5.jpg" alt=""/>
                        <div class="pic-tit">我陪你长大陪你变老</div>
                        <div class="smalltit">一个六十年的约定</div>
                    </li>
                </ul>
            </div>
        </div>
    </section>
</div>
<!--内容区域结束-->
<!--底部区域开始-->
<footer>
    <div>
        <img src="images/footer.jpg" alt=""/>
        <p>不良信息举报电话：020-85533243举报邮箱：56kf#sohu-inc.com (使用时将#号改为@)</p>
        <p>网络视听许可证1908336中国互联网诚信联盟粤通管BBS【2009】第175号粤ICP备05006774号-1粤ICP证粤B2-20041027穗公网监备案证号：4401060102823</p>
        <p>增值电信业务经营许可证B2-20090492互联网药品信息服务资格证(粤)-非经营性-2014-0018节目制作经营许可证粤第735号粤网文[2013]0244-094</p>
        <p>粤公网安备 44010602000140号中国互联网举报中心</p>
        <p>Copyright ©2016 56.com 版权所有</p>
    </div>
</footer>
<!--底部区域结束-->
</body>
</html>