<%@ page language="java" import="java.util.*" import="bean.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人主页</title>
    
	<link rel="stylesheet" type="text/css" href="styles.css">
	<%
	  String name;
	  if(request.getAttribute("name")!="null"&&request.getAttribute("name")!=null)
	    name=(String)request.getAttribute("name");
	  else name="<a href=>未登录</a>";
	  User u=(User)request.getAttribute("user");
	  List<Car> carlist=(List<Car>)request.getAttribute("carlist");
	  Notice n=(Notice)request.getAttribute("notice");
	  List<Orders> olist=(List<Orders>)request.getAttribute("olist");
	  List<Orders> his=(List<Orders>)request.getAttribute("his");
	  
	 %>
	<script language="javascript">
	  function realSysTime(clock){
	    var now=new Date();
	    var year=now.getFullYear();
	    var month=now.getMonth();
	    var date=now.getDate();
	    var day=now.getDay();
	    var hour=now.getHours();
	    var minu=now.getMinutes();
	    var sec=now.getSeconds();
	    month=month+1;
	    var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
	    var week=arr_week[day];
	    var time=year+"年 "+month+"月 "+date+"日 "+week;
	    if(hour<10){
	       time=time+" 0"+hour;
	    }
	    else{
	       time=time+" "+hour;
	    }
	    if(minu<10){
	      time=time+":0"+minu;
	    }
	    else{
	      time=time+":"+minu;
	    }
	    if(sec<10){
	      time=time+":0"+sec;
	    }
	    else{
	      time=time+":"+sec;
	    }
	    
	    clock.innerHTML="当前时间："+time;
	  }
	  window.onload=function(){
	    window.setInterval("realSysTime(clock)", 1000);
	  }
	</script>
	<script language="javascript">
	  function checkcar(form){
	    with(form){
	      if(carId.value==""){
	        alert("请输入车牌号");
	        return false;
	      }
	      if(carType.value==""){
	        alert("请输入车型");
	        return false;
	      }
	      if(color.value==""){
	        alert("请输入颜色");
	        return false;
	      }
	      if(startDate.value==""){
	        alert("请输入出厂日期");
	        return false;
	      }
	      if(cMark.value==""){
	        alert("请输入备注信息");
	        return false;
	      }
	    }
	  }
	</script>
	<script language="javascript">
	   function check(user){
	    with(user){
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
    	$(function(){
    		$(".leftfont").click(function(e){
    			var $form2=$(".act1");
    			if($form2.is(":visible")){
    				$form2.hide();
					e.stopPropagation();
    			}else{
    				$form2.show();
					e.stopPropagation();
    			}
    			
    		})
    	})
       $(function(){
        $(".act4").click(function(e){
         var w=window.open("OrderServlet", "oderOperation", "width=800px,height=600px,top=100px,left=450px");
        })
       })
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
       <a href="ArticleListServlet" target="view_frame">汽修资料</a>
     </div>
     <div class="linka">
       <a href="test/AboutUs.jsp" target="view_frame">关于企业</a>
     </div>
     <div class="linka">
       <a href="test/Phone.jsp" target="view_frame">联系我们</a>
    </div>
      <div class="in2">
        <%=name %>您好，欢迎回来
        <a href="index.jsp">退出</a>
      </div>      
   </div>
   <div class="body1">
     <div class="bodyleft">
       <div class="left">
         <div class="leftpic">
            <image src="/MySystem/picture/pic1.jpg" heigth="90px" width="100px" >
         </div>
         <div class="leftfont">
         <%=name %><br>
                        用户资料
         </div>
         <br>
         <image src="/MySystem/picture/mess1.png" heigth="50px" width="50px" ><br>
         <div class="mess">
                             亲爱的<%=name %><br>
           <div class="mess1">
             <div id="clock"></div>今日天气：<%=n.getWeather() %>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <a href="http://www.weather.com.cn/weather/101110101.shtml">详情</a>
             <br>今日油价：90号汽油：<%=n.getOil90() %><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;93号汽油：<%=n.getOil93() %>
     <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;97号汽油：<%=n.getOil97() %>
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     <a href="http://www.bitauto.com/youjia/xian/?WT.srch=1">详情</a><br>
             交通状况：<%=n.getRoad() %>
             &nbsp;<a href="">详情</a><br>今日优惠：<%=n.getBenefit() %>
           
           </div>
         </div>
      </div>
    </div>
     <div class="bodyright">
       <div class="data">
        <p class="act1">用户资料</p>
        <table style="display:none;width:650px">
          <tr align="center">
           <td>
             <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp&nbsp
           </td>
           <td>联系人</td>
           <td>证件号</td>
           <td>联系方式</td>
           <td>性别</td>
           <td>当前城市</td>
           <td>操作</td>
         </tr>
         <tr align="center">
           <td>
             <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp&nbsp
           </td>
           <td><%=u.getName() %></td>
           <td><%=u.getIDCard() %></td>                             
           <td><%=u.getPhone() %></td>
           <td><%=u.getSex() %></td>              
           <td>西安市</td>
           <td>
             <a href="test/UpdatePerson.jsp?name=<%=name%>&sex=<%=u.getSex()%>&phone=<%=u.getPhone()%>&IDCard=<%=u.getIDCard()%>" target="view_frame">
                                点击修改资料</a></td>
         </tr>
       </table>
       </div>
       <div class="car">
       <p class="act1">车辆</p>
         <table style="display:none;">
          <tr align="center">
           <td>
             <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
           </td>
           <td>车牌号</td>
           <td>车型</td>
           <td>颜色</td>
           <td>上次检修日期</td>
           <td>备注</td>
           <td>操作</td>
          </tr>
           <% 
             for(Car c:carlist){
            %>
         <tr align="center">
           <td>
             <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
           </td>
           <td><%=c.getCarId() %></td>
           <td><%=c.getCarType() %></td>
           <td><%=c.getColor() %></td>
           <td><%=c.getDate() %></td>
           <td><%=c.getCMark() %></td>
           <td><a href="MainPageServlet?carId=<%=c.getCarId() %>"  onclick="return confirm('真的要删除么')">点击删除</a></td>
         </tr> 
         <%} %>
           <form action="OperateServlet" method="get" name="" onsubmit="return checkcar(this)">
             <tr align="center">
               <td>
                 <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
               </td>
               <td><input type="text" name="carId" value=""  style="width:70px;"></td>
               <td><input type="text" name="carType" value=""  style="width:70px;"></td>
               <td><input type="text" name="color" value=""  style="width:70px;"></td>
               <td><input type="text" name="Date" value="" style="width:70px;"></td>
               <td><input type="text" name="cMark" value="" style="width:70px;"></td>
               <input type="hidden" name="IDCard" value="<%=u.getIDCard()%>">
               <td><input type="submit" name="submit" value="添加车辆"></td>
             </tr>
           </form>
         </table>
       </div>
       <div class="order">
         <p class="act1">我的业务</p>
           <table style="display:none;width:900px">
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
             <td>价格</td>
             <td>当前状态</td>
             <td>备注</td>
             <td>操作订单</td>
          </tr>
             <% 
             for(Orders o:olist){
            %>
         <tr align="center">
           <td>
             <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
           </td>             
           <td><%=o.getOId() %></td>
           <td><%=o.getCarId() %></td>
           <td><%=o.getName() %></td>
           <td><%=o.getOType() %></td>
           <td><%=o.getWorkId() %></td>
           <td><%=o.getODate() %></td>
           <td><%=o.getSum() %></td>
           <td><%=o.getIfOk() %></td>
           <td><%=o.getOMark() %></td>
           <td><a href="Operate2Servlet?carId=<%=o.getCarId() %>" target="view_frame">操作</a></td>
           </tr >
           <%} %>
           <tr align="center"><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>
             <td><a class="act4">添加新订单</a></td>
           </tr>
           </table>
       </div>
       <div class="his">
         <p class="act1">历史订单记录</p>
           <table style="display:none;width:900px">
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
             <td>价格</td>
             <td>当前状态</td>
             <td>备注</td>
          </tr>
             <% 
             for(Orders o:his){
            %>
         <tr align="center">
           <td>
             <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
           </td>             
           <td><%=o.getOId() %></td>
           <td><%=o.getCarId() %></td>
           <td><%=o.getName() %></td>
           <td><%=o.getOType() %></td>
           <td><%=o.getWorkId() %></td>
           <td><%=o.getODate() %></td>
           <td><%=o.getSum() %></td>
           <td><%=o.getIfOk() %></td>
           <td><%=o.getOMark() %></td>
           </tr >
           <%} %>
           </table>
       </div>
     </div>
   </div>
   <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
