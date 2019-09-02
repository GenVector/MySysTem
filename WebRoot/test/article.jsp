<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看文章</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>
  <div class="top">
     <div class="tlp">
       <image src="/MySystem/picture/npu.jpg" height="70px" width="70px">
     </div>
     <div class="linka">
       <a href="http:index.jsp">首页</a>
     </div>
     <div class="linka">
       <a href="ArticleListServlet" target="view_frame">汽修资料</a>
     </div>
     <div class="linka">
       <a href="" target="view_frame">关于企业</a>
     </div>
     <div class="linka">
       <a href="test/Phone.jsp" target="view_frame">联系我们</a>
    </div>
      <div class="in2">
                     资料数据库
        <a href="index.jsp">关闭</a>
      </div>      
   </div>
   <div class="body">
     <div class="box1">
       <image src="/MySystem/picture/npu0.jpg" height="150px" width="300px"><br><br><br>
       <image src="/MySystem/picture/sys1.jpg" height="150px" width="300px">
     </div>
    <div class="box4">
       <p><%=request.getAttribute("name") %></p>
       <%=request.getAttribute("str") %>
    </div>
    <div class="box5">
      <image src="/MySystem/picture/car6.jpg" height="150px" width="300px"><br><br><br>
      <image src="/MySystem/picture/npu2.jpg" height="150px" width="300px">
     </div>
    </div>
    <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
