<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>结果页面</title>
    <%
      String message=request.getAttribute("message").toString();
     %>
	<link rel="stylesheet" type="text/css" href="styles.css">


  </head>
  
  <body>
    <%=message %>
  </body>
</html>
