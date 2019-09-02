<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改车辆资料</title>
<%String carId=new String(request.getParameter("carId").getBytes("ISO-8859-1"),"UTF-8");
String carType=new String(request.getParameter("carType").getBytes("ISO-8859-1"),"UTF-8");
String color=new String(request.getParameter("color").getBytes("ISO-8859-1"),"UTF-8");
String cMark=new String(request.getParameter("cMark").getBytes("ISO-8859-1"),"UTF-8");
String date=new String(request.getParameter("date").getBytes("ISO-8859-1"),"UTF-8");
String IDCard=new String(request.getParameter("IDCard").getBytes("ISO-8859-1"),"UTF-8");
%>   

	<link rel="stylesheet" type="text/css" href="style2.css">

  </head>
  
  <body>
   <div class="update">
    <form action="CarServlet" method="get">
      <table class="tb">
        <tr>
          <td class="tr1">车辆牌号：</td>
          <td><%=carId %><input type="hidden" name="carId" value="<%=carId%>"></td>
        </tr>
        <tr>
          <td class="tr1">车型款式：</td>
          <td><input class="input" type="text" name="carType" value="<%=carType%>"></td>
        </tr>
        <tr>
          <td class="tr1">所属人证件：</td>
          <td><input class="input" type="text" name="IDCard" value="<%=IDCard%>"></td>
        </tr>
        <tr>
          <td class="tr1">车辆颜色：</td>
          <td><input class="input" type="text" name="color" value="<%=color%>"></td>
        </tr>
        <tr>
          <td class="tr1">上次检修日期：</td>
          <td><input class="input" type="text" name="date" value="<%=date%>"></td>
        </tr>
        <tr>
          <td class="tr1">车辆备注：</td>
          <td><input class="input" type="text" name="cMark" value="<%=cMark%>"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" class="input1" value="确定修改"></td>
        </tr>
      </table>
    </form>
   </div>
  </body>
</html>
