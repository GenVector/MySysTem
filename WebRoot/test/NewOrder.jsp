<%@ page language="java" import="java.util.*" import="bean.*;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>创建新订单</title>
<%
  List<Worker> list=(List<Worker>)request.getAttribute("list");
 %> 
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
 <script type="text/javascript">
   function check(form){
	    with(form){
	      if(name.value==""||carId.value==""||oType.value==""){
	        alert("信息输入不完整");
	        return false;
	      }
	    }
	  }
 </script>
	<link rel="stylesheet" type="text/css" href="style.css">

  </head>
  
  <body>
   <p align="center">创建新订单</p>
   <div class="newbody">
    <div class="neworder1">
     <form method="post" action="OrderServlet" name="form" onsubmit="return check(this);">
       <p>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input type="text" style="width:150px;font-size:18px;height:25px;" name="name" value=""></p>
       <p>车&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;号：<input type="text" style="width:150px;font-size:18px;height:25px;" name="carId" value=""></p>
       <p>业务类型：<select name="oType" style="width:150px;font-size:18px;height:25px;">
           <option value="">-----------</option>
           <option value="清洗">清洗</option>
           <option value="美容">美容</option>
           <option value="维修">维修</option>
           <option value="保养">保养</option>
         </select></p>
       <p>选择技师：<select name="workId" style="width:150px;font-size:18px;height:25px;">
           <option value="">-----------</option>
           <%for(Worker w:list){ 
           %>
           <option value="<%=w.getWorkId()%>"><%=w.getWName()%></option>
           <%} %>
         </select><a>可以为空</a></p>
       <p>备注信息：<input type="text" style="width:150px;font-size:18px;height:25px;" name="oMark" value=""></p>
       <input type="submit" value="确认提交" class="btn1" name="submit">
     </form>
   </div>
   </div>
   <p align="center" class="act1">点击查看技师列表</p>
   <div class="neworder" >
     <table>
       <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td>工号</td>
             <td>技师姓名</td>
             <td>性别</td>
             <td>业务类型</td>
             <td>联系电话</td>
             <td>技能等级</td>
             <td>等待人数</td>
        </tr>
       <% 
       for(Worker w:list){
       %>
         <tr align="center">
           <td>
             <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
           </td>
           <td><%=w.getWorkId() %></td>
           <td><%=w.getWName() %></td>
           <td><%=w.getWSex() %></td>
           <td><%=w.getWType() %></td>
           <td><%=w.getWPhone() %></td>
           <td><%=w.getWClass() %></td>
           <td><%=w.getWLine() %></td>
         </tr>
         <%} %>
     </table>
    </div>
  </body>
</html>
