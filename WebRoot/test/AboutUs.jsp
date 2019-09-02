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
  </head>
  
  <body>
   <div class="body2">
     <br><br>
     <p>关于我们</p>
     <div class="bodyin">
                 三石科技有限公司，采用先进互联网云端技术，
                 专注为汽车维修、美容系统打造，提供智能化解决方案。<br>
                 目前客户遍及全国，上千家汽车服务企业使用三石科技管理业务，提升效益。
     </div>
   </div>
   <div class="body3">
     <div class="box1">
       February 2015
       <div class="boxin">
                       公司成立<br>确定云端汽车服务软<br>件为核心产品方向
       </div>
     </div>
     <div class="box2">
       October 2016
       <div class="boxin">
                       第一款产品上线<br>首款产品推出上线,并<br>确定每周迭代更新原则
       </div>
     </div>
      <div class="box1">
       January 2017
       <div class="boxin">
                       首次重大更新<br>功能界面各方面全面提升<br>，客户满意度大增
       </div>
     </div><br><br><br>
     <div class="box3">
       October 2017
       <div class="boxin">
                       第一款产品上线<br>首款产品推出上线,并<br>确定每周迭代更新原则
       </div>
     </div>
   </div>
   <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
