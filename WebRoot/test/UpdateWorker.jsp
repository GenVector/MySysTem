<%@ page language="java" import="java.util.*" import="bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <%
      Worker w=(Worker)request.getAttribute("worker");
     %>
    <title>修改员工资料页面</title>    
	<link rel="stylesheet" type="text/css" href="style2.css">

  </head>
  
  <body>
   <div class="update">
    <form action="WorkerServlet" method="post">
      <table class="tb">
        <tr>
          <td class="tr1">员工工号：</td>
          <td><%=w.getWorkId() %><input type="hidden" name="workId" value="<%=w.getWorkId()%>"></td>
        </tr>
        <tr>
          <td class="tr1">员工姓名：</td>
          <td><input class="input" type="text" name="wName" value="<%=w.getWName()%>"></td>
        </tr>
        <tr>
          <td class="tr1">性别：</td>
          <td><input class="input" type="text" name="wSex" value="<%=w.getWSex()%>"></td>
        </tr>
        <tr>
          <td class="tr1">业务类型：</td>
          <td><input class="input" type="text" name="wType" value="<%=w.getWType()%>"></td>
        </tr>
        <tr>
          <td class="tr1">联系方式：</td>
          <td><input class="input" type="text" name="wPhone" value="<%=w.getWPhone()%>"></td>
        </tr>
        <tr>
          <td class="tr1">技能等级：</td>
          <td><input class="input" type="text" name="wClass" value="<%=w.getWClass()%>"></td>
        </tr>
        <tr>
          <td class="tr1">绩效：</td>
          <td><input class="input" type="text" name="ahieve" value="<%=w.getAchieve()%>"></td>
        </tr>
        <tr>
          <td class="tr1">优先级：</td>
          <td><input class="input" type="text" name="wLine" value="<%=w.getWLine()%>"></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><input type="submit" class="input1" value="确定修改"></td>
        </tr>
      </table>
    </form>
   </div>
  </body>
</html>
