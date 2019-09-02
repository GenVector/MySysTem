<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>汽修资料</title>
<%
  List<String> list=(List<String>)request.getAttribute("list");
 %> 
	<link rel="stylesheet" type="text/css" href="styles.css">


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
     <div class="box2">
      <form name="form" method="post" action="SelectServlet">
       <table align="center">
         <tr>
           <td>
                                  输入检索:
           </td>
           <td>
             <input type="text" name="key" value="">
           </td>
           <td>
             <input type="submit" name="submit" value="点击检索">
           </td>
         </tr>
       </table>
       </form>
       <table style="align:center;">
       <%int i=0;
         for(String s:list){ 
           i++;
       %>
         <tr>
           <td>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="SelectServlet?name=<%=s%>"><%=i+"、"+s %></a>
           </td>
         </tr>
       <%} %>
       </table>
       
     </div>
     <div class="box3">
      <image src="/MySystem/picture/car6.jpg" height="150px" width="300px"><br><br><br>
      <image src="/MySystem/picture/npu2.jpg" height="150px" width="300px">
     </div>
   </div>
   <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
