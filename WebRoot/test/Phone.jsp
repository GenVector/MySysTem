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
	<link rel="stylesheet" type="text/css" href="style.css">
  </head>
  
  <body>
   <div class="body2">
     <br><br>
     <p>联系我们</p>
     <div class="bodyin">
                 三石科技有限公司，采用先进互联网云端技术，
                 专注为汽车维修、美容系统打造，提供智能化解决方案。
                 <br>目前客户遍及全国，上千家汽车服务企业使用三石科技管理业务，提升效益。
                 <br>我们的永久联系电话：15536686832
                 <br>联系地址：陕西省西安市长安区东大街道
                 <br>电子邮箱：794311913@NWPU.com
                 <br>联系人：郭诗雨
                 <br>三石集团竭诚为您服务
     </div>
   </div>
   
   <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
