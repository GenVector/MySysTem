<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改个人资料</title>
    <%
	  String name=request.getParameter("name");
	  String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
	  String phone=request.getParameter("phone");
	  String IDCard=request.getParameter("IDCard");
	 %>
	 <script type="text/javascript">
	  function check(form){
	    with(form){
	      if(name.value==""||phone.value==""||IDCard.value==""){
	        alert("信息输入不完整");
	        return false;
	      }
	      if(IDCard.value.length!=18){
	        alert("证件格式错误");
	        return false;
	      }
	    }
	  }
	   function check(form1){
	    with(form1){
	      if(newpassword.value==""||password1.value==""||password.value==""){
	        alert("信息输入不完整");
	        return false;
	      }
	      if(newpassword.value!=password1.value){
	        alert("两次输入密码不一致，请重新输入");
	        return false;
	      }
	      }
	    }
	</script>
    <script src="bean/jquery-3.2.0.min.js" type="text/javascript"></script>
    <script>
	  $(function(){
    		$(".act1").click(function(e){
    			var $form1=$(this).next();
    			if($form1.is(":visible")){
    				$form1.hide();
					e.stopPropagation();
    			}else{
    				$form1.show();
					e.stopPropagation();
    			}
    			
    		})
    	})
    </script>
	<link rel="stylesheet" type="text/css" href="style.css">
  </head>
  
  <body>
    <div class="top">
     <div class="tlp">
       <image src="/MySystem/picture/npu.jpg" height="70px" width="70px">
     </div>
     <div class="linka">
       <a href="http://localhost:8080/MySystem/index.jsp">首页</a>
     </div>
     <div class="linka">
       <a href="ArticleListServlet">汽修资料</a>
     </div>
     <div class="linka">
       <a href="test/AboutUs.jsp">关于企业</a>
     </div>
     <div class="linka">
       <a href="test/AboutUs.jsp">联系我们</a>
    </div>
      <div class="in2">
        <%=name %>您好，欢迎回来
        <a href="http://localhost:8080/MySystem/index.jsp">退出</a>
      </div>      
   </div>
   <div class="body1">
    <div class="form1">
     <p>修改资料</p>
     <form method="post" action="OperateServlet" name="form" onsubmit="return check(this);">
       <p>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" name="name" value="<%=name%>"></p>
       <p>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：男<input type="radio" checked="checked" name="sex" value="male"> 女<input type="radio" name="sex" value="female"></p>
       <p>手&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;机：<input type="text" name="phone" value="<%=phone%>"></p>
       <input type="hidden" name="IDCard" value="<%=IDCard%>">
       <p>证件号码：<%=IDCard %></p>
<input type="submit" value="确认提交" class="btn1" name="submit">
        </form>
    <p class="act1">修改密码</p> 
      <div class="act2">
        <form method="post" action="Operate2Servlet" name="form1" onsubmit="return check(this)">
          <p>输入旧密码：<input type="password" name="password" value=""></p>
          <p>输入新密码：<input type="password" name="password1" value=""></p>
          <p>确认新密码：<input type="password" name="newpassword" value=""></p>
          <input type="hidden" name="name" value="<%=name%>">
          <p><input type="submit" value="确认修改" class="btn1" name="submit"></p>
        </form>
      </div>
    </div>
    <div class="NUbody1">
      <image src="/MySystem/picture/car6.jpg" height="150px" width="350px"><br><br><br><br>
      <image src="/MySystem/picture/npu2.jpg" height="150px" width="350px">
    </div>
   </div>
   <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
