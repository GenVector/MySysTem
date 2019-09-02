<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>瓜大4S</title>
    <% String result="";
       if(request.getAttribute("result")!=null)result=(String)request.getAttribute("result");
     %>
	<link rel="stylesheet" type="text/css" href="style.css">
	<script type="text/javascript">
	  function check(form){
	    with(form){
	      if(name.value==""){
	        alert("请输入姓名");
	        return false;
	      }
	      if(password.value==""){
	        alert("请输入密码");
	        return false;
	      }
	    }
	  }
	</script>
  </head>
  
  <body>
   <div class="top">
     <div class="tlp">
       <image src="/MySystem/picture/npu.jpg" height="70px" width="70px">
     </div>
     <div class="linka">
       <a href="index.jsp">首页</a>
     </div>
     <div class="linka">
       <a href="ArticleListServlet" target="view_frame">汽修资料</a>
     </div>
     <div class="linka">
       <a href="test/AboutUs.jsp" target="view_frame">关于企业</a>
     </div>
     <div class="linka">
       <a href="test/Phone.jsp" target="view_frame">联系我们</a>
    </div>
      <div class="in">
        <a href="index.jsp">登陆</a>
      </div>
      <div class="in1">
        <a href="test/NewUser.jsp">注册新用户</a>
      </div>
   </div>
   <div class="body1">
    <div class="body1left">
      <image src="/MySystem/picture/npu1.jpg" height="500px" width="800px">
    </div>
    <div class="body1right">
      <p>用户登录|<a href="test/manage.jsp">管理员</a></p>
      <span class="mess"><%=result %></span>
      <form name="login" method="post" action="MainPageServlet" onsubmit="return check(this);">
               姓名：<input name="name" value=""type="text"><br><br>
               密码：<input type="password" name="password" value=""><br><br>
      <input type="submit" value="登录" class ="btn1"name="submit">
      </form>
    </div>
   </div>
   <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
