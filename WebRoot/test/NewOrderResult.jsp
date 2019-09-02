<%@ page language="java" import="java.util.*" import="bean.*;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加订单结果页面</title>
    
<%
  Orders o=(Orders)request.getAttribute("order");
 %>
	<link rel="stylesheet" type="text/css" href="style.css">

  </head>
  
  <body>
    <p>添加成功</p>
    <table width="700px">
             <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td>订单号</td>
             <td>车牌号</td>
             <td>姓名</td>
             <td>业务类型</td>
             <td>负责技师</td>
             <td>日期</td>
             <td>当前状态</td>
             <td>备注</td>
          </tr>
          <tr>
            <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
            <td><%=o.getOId() %></td>
            <td><%=o.getCarId() %></td>
            <td><%=o.getName() %></td>
            <td><%=o.getOType() %></td>
            <td><%=o.getWorkId() %></td>
            <td><%=o.getODate() %></td>            
            <td><%=o.getIfOk() %></td>
            <td><%=o.getOMark() %></td>           
          </tr>
      </table>
  </body>
</html>
