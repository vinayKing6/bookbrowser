<%@ page import="java.util.*" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>学习资源</title>
    <link rel="stylesheet" href="source/css/studySourceStyle.css">
</head>

<body>
    <div class="w header" id="header">
        <div class="showSub"></div>
        <div class="logo">
            <img src="source/images/myLogo.png" alt="">
        </div>
        <div class="nav">
            <ul class="items">
                <li class="itemsList">
                    <a href="" class="title">关于我们</a>
                    <ul class="subList">
                        <li><a href="">联系我们</a></li>
                        <li><a href="">加入我们</a></li>
                        <li><a href="">我们的故事</a></li>
                        <li><a href="">我们的产业</a></li>
                    </ul>
                </li>
                <li class="itemsList">
                    <a href="" class="title">工具</a>
                    <ul class="subList">
                        <li>
                            <a href="#">office</a>
                        </li>
                        <li><a href="#">自动化</a></li>
                        <li><a href="#">python脚本</a></li>
                        <li><a href="#">工业化</a></li>
                        <li><a href="#">辅助工具</a></li>
                        <li><a href="#">图形化工具</a></li>
                        <li><a href="#">教学工具</a></li>
                    </ul>
                </li>
                <li class="itemsList">
                    <a href="" class="title">资源</a>
                    <ul class="subList">
                        <li><a href="">软件</a></li>
                        <li><a href="pdf.html">电子书</a></li>
                        <li><a href="">项目实战</a></li>
                        <li><a href="">笔记</a></li>
                    </ul>
                </li>
                <li class="itemsList">
                    <a href="" class="title">学习</a>
                    <ul class="subList">
                        <li><a href="">python</a></li>
                        <li><a href="">java</a></li>
                        <li><a href="">c</a></li>
                        <li><a href="">c++</a></li>
                        <li><a href="">前端</a></li>
                        <li><a href="">算法</a></li>
                    </ul>
                </li>
            </ul>
        </div>
        <div class="search">
            <input type="text" placeholder="请输入关键词">
            <button><span>搜索</span></button>
        </div>
        <div class="user">
            <img src="source/images/headImg.png" alt="">
            <%
                String name=(String)request.getAttribute("name");
                out.println(name);
            %>
        </div>
    </div>
    <div class="banner">
        <div class="w box1">
            <div class="image1">
                <img src="source/images/math1.png" alt="">
                <a href="#" class="prev">
                    < </a>
                        <a href="#" class="afterv">></a>
                        <div class="gotoBar">
                            <a href="#"></a>
                            <a href="#"></a>
                            <a href="#"></a>
                            <a href="#"></a>
                        </div>
            </div>
            <div class="subnav">
                <ul>
                    <li><a href="#">高数 </a></li>
                    <li><a href="#">线性代数</a></li>
                    <li><a href="#">大学物理</a></li>
                    <li><a href="#">c语言</a></li>
                    <li><a href="#">计算机网络</a></li>
                    <li><a href="#">概率统计</a></li>
                    <li><a href="#">英语口语</a></li>
                    <li><a href="#">写作表达</a></li>
                    <li><a href="#">计算机组成原理</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="w goods">
        <h3>精品推荐</h3>
        <ul>
            <li><a href="#">python</a></li>
            <li><a href="#">java</a></li>
            <li><a href="#">c++</a></li>
            <li><a href="#">html+css</a></li>
            <li><a href="#">javascript</a></li>
        </ul>
        <a href="" class="mod">修改兴趣</a>
    </div>
    <div class="w command-hd">
        <h3>精品推荐</h3>
        <a href="#" class="checkall">查看全部</a>
    </div>
    <div class="w command-hb clearfix">
        <ul>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
            <li>
                <div class="image">
                    <img src="source/images/project1.png" alt="">
                    <div class="playicon"></div>
                </div>
                <h3>手把手教学java小游戏：飞机大战</h3>
                <div class="info">
                    <a href="#">点击学习</a> |已有10000人学习
                </div>
                <em>
                    <img src="source/images/hot.png" alt="">
                </em>
            </li>
        </ul>
    </div>
    <div class="w gotopages">
        <a href="#">&lt;&lt;上一页</a>
        <a href="#" class="current">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">6</a>
        <a href="#">...</a>
        <a href="#">&gt;&gt;下一页</a>
        <button class="btn">显示系统时间</button>
        <div class="time"></div>
    </div>
    <div class="footer">
        <div class="w box2 clearfix">
            <div class="copyright">
                <img src="source/images/mylogo.png" alt="">
                <p>此网站致力于提供学习资源及项目练习，所有资源皆可免费使用<br> @2021年9月28日
                </p>
                <a href="#">下载app</a>
            </div>
            <div class="links">

            </div>
        </div>
    </div>
    <a href="#header" class="gototop"></a>
    <!-- 通常将javascript放在body的最后 -->
    <!-- <script src="javascript/example.js"></script>
    <script src="javascript/array.js"></script>
    <script src="javascript/function.js"></script> -->
    <script src="source/javascript/web_api.js"></script>
</body>

</html>
