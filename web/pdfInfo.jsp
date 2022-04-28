<%@ page import="java.util.*,algorithm.algorithm_data_type.myStack" %>
<%@ page pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PDF Information</title>
    <link rel="stylesheet" href="source/css/pdfInfo.css">
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
                        <li><a href="">电子书</a></li>
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
            <span><% String name=(String)request.getAttribute("name");out.println(name);%></span>
        </div>
    </div>

    <div class="pdfHeader">
        <div class="pdfimg">
            <%--<img src="source/surface/Head_First_Jsp.jpg">--%>
            <%
               Integer id=(Integer)request.getAttribute("id"); 
               out.println("<img src=\"source/surface/"+id+".jpg\">");
            %>
            <form action="PDF.read" method="post">
                <%--<input type="hidden" name="id" value="0">--%>
                <%
                    out.println("<input type=\"hidden\" name=\"id\" value="+id+">");
                %>
                <input type="submit" value="阅读" class="read">
            </form>
        </div>
        <div class="pdfBrief">
            <h1>
                <%
                    HashMap<String,String> idSt=(HashMap<String,String>)request.getAttribute("idTree");
                    String filename=idSt.get("alias");
                    out.println(filename);
                %>
            </h1>
            <span>这是一个简介，哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈hhhhhfffffffffffffffffffff
            ffffffffffffffffffffffffffffffffffffff
            ffffffffffffffffffffffffffffffffffffffffffffffffffffffffff</span>
        </div>
    </div>
    <div class="pdfInfo">
        <div class="tab_list">
            <ul>
                <li class="tab_current">作者简介</li>
                <li>目录</li>
                <li>评论</li>
            </ul>
        </div>
        <div class="tab_content">
            <div class="tab_item" style="display: block;">
                作者简介
            </div>
            <div class="tab_item">
                目录
            </div>
            <div class="tab_item">
                <div>
                    <form action="pdfInfoProvider.do" method="post" target="myIframe">
                        <%--<input type="hidden" name="id" value="0">--%>
                        <%
                            out.println("<input type=\"hidden\" name=\"id\" value="+id+">");
                        %>
                        <span>发表评论:</span> 
                        <textarea name="comment" placeholder="请输入评论" class="comment" required="required" ></textarea>
                        <input type="submit" value="发送" class="submit">
                    </form>
                    <iframe id="myIframe" name="myIframe" style="display: none;"></iframe>
                </div>
                <ul class="commentList">
                    <%
                        HashMap<Integer,String> st=(HashMap<Integer,String>)request.getAttribute("comments");
                        for(int i=0;i<st.size();i++){
                            String line=st.get(i);
                            String[] line_splits=line.split("_");
                            try{
                                out.println("<li><span>"+line_splits[0]+":</span>\n<div>\n"+line_splits[1]+"</div></li>");
                            }catch(Exception e){
                                continue;
                            }
                        }
                    %>
                    <!-- <li> -->
                    <!--     <span>name:</span> -->
                    <!--     <div>这是一条评论fffffffffffffffffffffffffffff分隔符过付过过过过过过过过过过过过过过过过过过过</div> -->
                    <!-- </li> -->
                </ul>
            </div>
        </div>
    </div>

     <script src="source/javascript/pdfInfo.js"></script>
</body>
</html>
