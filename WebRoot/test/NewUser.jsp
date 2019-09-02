<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户注册页面</title>
    
	<link rel="stylesheet" type="text/css" href="style.css">
<script type="text/javascript">
	  function check(form){
	    with(form){
	      if(name.value==""||phone.value==""||IDCard.value==""||password.value==""||password1.value==""){
	        alert("信息输入不完整");
	        return false;
	      }
	      if(password.value!=password1.value){
	        alert("两次输入密码不一致，请重新输入");
	        return false;
	      }
	      if(IDCard.value.length!=18){
	        alert("证件格式错误");
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
       <a href="ArticleListServlet">汽修资料</a>
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
    <div class="form">
     <p> 实名登记</p>
     <form method="post" action="AddNewUserServlet" name="form" onsubmit="return check(this);">
       <pre>
姓    名：<input type="text" name="name" value=""><br>
性    别：男<input type="radio" checked="checked" name="sex" value="male"> 女<input type="radio" name="sex" value="female"><br>
手    机：<input type="text" name="phone" value=""><br>
证件号码：<input type="text" name="IDCard" value=""><br>
输入密码：<input type="password" name="password" value=""><br>
确认密码：<input type="password" name="password1" value=""><br><br>
<input type="submit" value="确认提交" class="btn1" name="submit">
        </pre>
        </form>
    </div>
    <div class="NUbody">
      <image src="/MySystem/picture/car6.jpg" height="150px" width="350px"><br><br><br><br>
      <image src="/MySystem/picture/npu2.jpg" height="150px" width="350px">
    </div>
   </div>
   <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
