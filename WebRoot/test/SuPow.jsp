<%@ page language="java" import="java.util.*" import="bean.*;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统管理</title>
     <%
	  String name=session.getAttribute("name").toString();
	  int i;
	  String trn;
	  Notice n=(Notice)request.getAttribute("notice");
	  List<User> uList=(List<User>)request.getAttribute("uList");
	  List<Car> cList=(List<Car>)request.getAttribute("cList");
	  List<Worker> wList=(List<Worker>)request.getAttribute("wList");
	  List<Parts> pList=(List<Parts>)request.getAttribute("pList");
	  List<Orders> ol1=(List<Orders>)request.getAttribute("ol1");
	  List<Orders> ol2=(List<Orders>)request.getAttribute("ol2");
	  List<Orders> ol3=(List<Orders>)request.getAttribute("ol3");
	  List<Orders> his=(List<Orders>)request.getAttribute("his");
	  String message=request.getAttribute("message").toString();
	  List<User> ucheck=(List<User>)request.getAttribute("ucheck");
	  List<Car> ccheck=(List<Car>)request.getAttribute("ccheck");
	  List<Worker> wcheck=(List<Worker>)request.getAttribute("wcheck");
	  List<Parts> pcheck=(List<Parts>)request.getAttribute("pcheck");
	  
	  List<String> aList=(List<String>)request.getAttribute("aList");
	 %>
	 <script src="bean/jquery-3.2.0.min.js" type="text/javascript"></script>
	 <script>
	   var j=1;
 function add(event){
	  event.stopPropagation();
	  var target=event.target;
	  var trnn=document.getElementById("trnn");
	  console.log(trnn);
	  var orderaddtable=document.getElementsByClassName("tbn")[0];
	  var newrow=document.createElement("tr");
	  j++;
	  var innerHTMLString="<td class=\"tr1\">服务项目：</td>"+
	                      "<td><select name=\"parts"+j+"\" style=\"width:100px;font-size:18px;height:25px;\">"+
                          "<option value=\"\">-----------</option>"+
                          "<%for(Parts p:pList) { %><option value=\"<%=p.getPartId()%>\"><%=p.getPName() %>" +
                          "</option><%} %></select></td>"+
						  "<td class=\"tr1\">数量:</td>"+
						  "<td><input class=\"input3\" type=\"text\" name=\"number"+j+
						  "\" value=\"\"></td>"+
						  "<td><button class=\"input3\" onclick=\"add(event)\" type=\"button\">添加</button></td>";
	  newrow.innerHTML=innerHTMLString;
	  orderaddtable.insertBefore(newrow,trnn);
	  console.log(j);
}
function check(form){
		    with(form){
		      if(name.value==""||carId.value==""||oType.value==""||workId.value==""||oMark.value=="")
		      {
		        alert("信息输入不完整");
		        return false;
		        }
		      }
		    
		    event.stopPropagation();
	        var target=event.target;
	        var trnn=document.getElementById("trnn");
	        var orderaddtable=document.getElementsByClassName("tbn")[0];
	        var newrow=document.createElement("tr");
	        var innerHTMLString="<td><input type=\"hidden\" value=\""+j+"\" name=\"num\"></td>";
	        newrow.innerHTML=innerHTMLString;
	        orderaddtable.insertBefore(newrow,trnn);
		  }
	 </script>
	<link rel="stylesheet" type="text/css" href="style2.css">
	<script src="style2.js"></script>
  </head>
  
  <body>
    <div class="top">
     <div class="tlp">
       <image src="/MySystem/picture/npu.jpg" height="70px" width="70px">
     </div>
     <div class="linka">
       <a href="ManageServlet?name=<%=name%>">首页</a>
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
        <%=name %>超级管理员，欢迎您
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
         <%=name %><br>管理员
         </div>
         <br>
         <div class="mess" id="clock"></div>
         <div class="mess1">     
           <ul>
             <li class="act1">公告管理</li>
             <li class="style2"><a class="next2">用户管理</a>
               <ul class="l2">
                 <li class="u3">分类检索</li>
                 <li class="u1">用户列表</li>
                 <li class="u2">添加新用户</li>
               </ul>
             </li>
             <li class="style1"><a class="next1">车辆管理</a>
               <ul class="l2">
                 <li class="c3">分类检索</li>
                 <li class="c1">车辆列表</li>
                 <li class="c2">添加新车辆</li>
               </ul>
             </li>
             <li class="style2"><a class="next2">员工管理</a>
               <ul class="l2">
                 <li class="w3">分类检索</li>
                 <li class="w1">员工列表</li>
                 <li class="w2">添加新员工</li>
               </ul>
             </li>
             <li class="style1"><a class="next1">库存管理</a>
               <ul class="l2">
                 <li class="p3">分类检索</li>
                 <li class="p1">库存列表</li>
                 <li class="p2">添加新零件</li>  
               </ul>
             </li>
             <li class="style2"><a class="next2">订单管理</a>
               <ul class="l2">
                 <li class="o1">添加新订单</li>
                 <li class="o2">未处理订单</li>
                 <li class="o5">待开始订单</li>
                 <li class="o3">进行中订单</li>
                 <li class="o4">订单历史记录</li>
               </ul>
             </li>
             <li class="style1"><a class="next1">文献管理</a>
               <ul class="l2">
                 <li class="a1">上传新文档</li>
                 <li class="a2">文档列表</li>
               </ul>
             </li>
           </ul>
         </div>
       </div>
       </div>
     <div class="bodyright">
       <div class="not">
         <image src="/MySystem/picture/mess1.png" heigth="50px" width="50px" >message<br>
         <div class="mes"><%=name%>:<%=message %></div>
       </div>
       <div class="result">
         <%if(ucheck.size()!=0&&ucheck!=null){ %>
         <p>检索结果</p><p class="p">点击关闭</p><br>
         <table class="tb" style="width:750px;">
          <tr class="tr1">
            <td>序号</td>
            <td>姓名</td>
            <td>证件号</td>
            <td>联系方式</td>
            <td>性别</td>
            <td>密码</td>
            <td>当前城市</td>
            <td>操作</td>
            <td>删除</td>
         </tr>
          <% i=0;
           for(User u:ucheck) {
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
          %>
         <tr class="<%=trn%>" align="center">
           <td>0<%=i %></td>
           <td><%=u.getName() %></td>
           <td><%=u.getIDCard() %></td>                             
           <td><%=u.getPhone() %></td>
           <td><%=u.getSex() %></td>
           <td><%=u.getPassword() %></td>       
           <td>西安市</td>
           <td>
             <a href="test/UpdatePerson.jsp?name=<%=u.getName()%>&sex=<%=u.getSex()%>&phone=<%=u.getPhone()%>&IDCard=<%=u.getIDCard()%>" target="view_frame">
                                操作</a></td>
           <td><a href="SPUserServlet?IDCard=<%=u.getIDCard()%>" onclick="return confirm('真的要删除么')">删除</a></td>
         </tr>
          <%} %>
           <tr class="tr3">
             <td align="center" colspan="9">
              --<%=request.getAttribute("uBar") %>--
           </td>
           </tr>
         </table>
         <%} %>
         <%if(wcheck!=null&&wcheck.size()!=0){ %>
         <p>检索结果</p><p class="p">点击关闭</p><br>
         <table class="tb">
         <tr class="tr1">
           <td>序号</td>
           <td>姓名</td>
           <td>工号</td>
           <td>联系电话</td>
           <td>性别</td>
           <td>业务类型</td>
           <td>业务等级</td>
           <td>当月绩效</td>
           <td>排队人数</td>
           <td>操作</td>
           <td>删除</td>
         </tr>
         <%i=0;
           for(Worker w:wcheck) {
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
           
           %>
         <tr class="<%=trn %>" align="center">
           <td>0<%=i %></td>
           <td><%=w.getWName() %></td>
           <td><%=w.getWorkId() %></td>
           <td><%=w.getWPhone() %></td>
           <td><%=w.getWSex() %></td>
           <td><%=w.getWType() %></td>
           <td><%=w.getWClass() %></td>
           <td><%=w.getAchieve() %></td>
           <td><%=w.getWLine() %></td>
           <td><a href="WorkerServlet?workId=<%=w.getWorkId()%>" target="view_frame">操作</a></td>
           <td><a href="SPWorkerServlet?workId=<%=w.getWorkId()%>">删除</a></td>
         </tr>
         <%} %>
         <tr class="tr3">
             <td align="center" colspan="11">
              --<%=request.getAttribute("uBar") %>--
           </td>
           </tr>
       </table>
       <%} %>
       </div>
       <div class="notice">      
         <p>公告板管理</p><p class="p">点击关闭</p><br>
         <form name="notice" action="NoticeServlet" method="post">
           <input type="hidden" name="name" value="<%=name%>">
           <table class="tb">
             <tr>
               <td class="tr1">今日天气：</td>
               <td><input class="input" type="text" name="weather" value="<%=n.getWeather()%>"></td>
             </tr>
             <tr>
              <td class="tr1">今日油价：</td>
             </tr>
             <tr>
               <td class="tr1">90号汽油：</td>
               <td><input class="input" type="text" name="oil90" value="<%=n.getOil90()%>"></td>
             </tr>
             <tr>
               <td class="tr1">93号汽油：</td>
               <td><input class="input" type="text" name="oil93" value="<%=n.getOil93()%>"></td>
             </tr>
             <tr>
               <td class="tr1">97号汽油：</td>
               <td><input class="input2" type="text" name="oil97" value="<%=n.getOil97()%>"></td>
             </tr>
             <tr>
               <td class="tr1">交通状况：</td>
               <td><input class="input" type="text" name="road" value="<%=n.getRoad()%>"></td>
             </tr>
             <tr>
               <td class="tr1">今日优惠：</td>
               <td><input class="input" type="text" name="benefit" value="<%=n.getBenefit()%>"></td>
             </tr>
             <tr align="center">            
               <td colspan="2"><input type="submit" class="input1" name="submit" value="确定修改"></td>
             </tr>
           </table>
         </form>
       </div>
       <div class="user3">
         <p>分类检索</p><p class="p">点击关闭</p><br>
         <form class="tb1" name="" method="post" action="SPUServlet" style="display:inline-block;">
         <table>
           <tr>
             <td>
               <input type="text" value="" style="width:75px;height:25px;" name="name">
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="姓名检索" name="submit">
             </td>
           </tr>
         </table>
         </form>
         <form method="get" action="SPUServlet" style="display:inline-block;">
         <table class="tb1">
           <tr>
             <td>
               <select name="sex" style="width:60px;font-size:18px;height:25px;">
                 <option value="">---</option>
                 <option value="male">男</option>
                 <option value="female">女</option>
               </select>
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="性别检索" name="submit">
             </td>
           </tr>
         </table>
         </form>
         <table class="tb1">
           <tr>
             <td>
               <input type="text" value="" style="width:70px;height:25px;" name="name">
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="当前城市" name="submit">
             </td>
           </tr>
         </table>
         <table class="tb">
           <tr class="tr1">
             <td>序号</td>
             <td style="width:80px;">姓名</td>
             <td style="width:210px;">证件号</td>
             <td style="width:130px;">联系方式</td>
             <td style="width:50px;">性别</td>
             <td style="width:70px;">密码</td>
             <td style="width:80px;">当前城市</td>
             <td>操作</td>
            <td>删除</td>
           </tr>
           
        </table>
       </div>
       <div class="user1">
         <p>用户管理</p><p class="p">点击关闭</p><br>
         <table class="tb" style="width:750px;">
          <tr class="tr1">
            <td>序号</td>
            <td>姓名</td>
            <td>证件号</td>
            <td>联系方式</td>
            <td>性别</td>
            <td>密码</td>
            <td>当前城市</td>
            <td>操作</td>
            <td>删除</td>
         </tr>
          <% i=0;
           for(User u:uList) {
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
          %>
         <tr class="<%=trn%>" align="center">
           <td>0<%=i %></td>
           <td><%=u.getName() %></td>
           <td><%=u.getIDCard() %></td>                             
           <td><%=u.getPhone() %></td>
           <td><%=u.getSex() %></td>
           <td><%=u.getPassword() %></td>       
           <td>西安市</td>
           <td>
             <a href="test/UpdatePerson.jsp?name=<%=u.getName()%>&sex=<%=u.getSex()%>&phone=<%=u.getPhone()%>&IDCard=<%=u.getIDCard()%>" target="view_frame">
                                操作</a></td>
           <td><a href="SPUserServlet?IDCard=<%=u.getIDCard()%>" onclick="return confirm('真的要删除么')">删除</a></td>
         </tr>
          <%} %>
           <tr class="tr3">
             <td align="center" colspan="9">
              --<%=request.getAttribute("uBar") %>--
           </td>
           </tr>
         </table>
       </div>
       <div class="user2">
         <p>添加新用户</p><p class="p">点击关闭</p>
         <form action="SPUserServlet" method="post">
         <table class="tb">
           <tr class="tr1">
             <td>添加</td>
             <td>姓名</td>
             <td>证件号</td>
             <td>联系方式</td>
             <td>性别</td>
             <td>密码</td>
             <td>当前城市</td>
             <td>添加用户</td>
           </tr>
           <tr align="center">
           <td>---</td>
           <td><input type="text" name="name" value="" style="width:80px;height:25px;"></td>
           <td><input type="text" name="IDCard" value="" style="width:210px;height:25px;"></td>
           <td><input type="text" name="phone" value="" style="width:130px;height:25px;"></td>
           <td><input type="text" name="sex" value="" style="width:50px;height:25px;"></td>
           <td><input type="password" name="password" value="" style="width:70px;height:25px;"></td>
           <td><input type="text" name="address" value="" style="width:80px;height:25px;"></td>
           <td colspan="2"><input type="submit" name="submit" style="font-size:18px;" value="添加用户"></td>
         </tr>
        </table>
        </form>
       </div>
       <div class="car3">
         <p>分类检索车辆</p><p class="p">点击关闭</p>
         <table class="tb1">
           <tr>
             <td>
               <input type="text" value="" style="width:80px;height:25px;" name="">
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="车牌检索" name="submit">
             </td>
           </tr>
         </table>
         <table class="tb1">
           <tr>
             <td>
               <input type="text" value="" style="width:200px;height:25px;" name="IDCard">
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="证件号检索" name="submit">
             </td>
           </tr>
         </table>
         <table>
           <tr class="tr1">
             <td>序号</td>
             <td style="width:85px;">车牌号</td>
             <td style="width:80px;">车型</td>
             <td style="width:45px;">颜色</td>
             <td style="width:190px;">身份证号码</td>
             <td style="width:110px;">上次检修日期</td>
             <td style="width:80px;">备注信息</td>
             <td>操作</td>
             <td>删除</td>
           </tr>
         </table>
       </div>
       <div class="car1">
         <p>车辆管理</p><p class="p">点击关闭</p><br>
         <table class="tb">
         <tr class="tr1">
           <td>序号</td>
           <td>车牌号</td>
           <td>车型</td>
           <td style="width:45px;">颜色</td>
           <td>身份证号码</td>
           <td style="width:110px;">上次检修日期</td>
           <td>备注信息</td>
           <td>操作</td>
           <td>删除</td>
         </tr>
         <%i=0;
           for(Car c:cList) {
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
           %>
         <tr class="<%=trn%>" align="center">
         <td>0<%=i %></td>
           <td><%=c.getCarId() %></td>
           <td><%=c.getCarType() %></td>                             
           <td><%=c.getColor() %></td>
           <td><%=c.getIDCard() %></td>
           <td><%=c.getDate() %></td>       
           <td><%=c.getCMark() %></td>
           <td>
             <a href="test/UpdateCar.jsp?carId=<%=c.getCarId()%>&carType=<%=c.getCarType()%>&color=<%=c.getColor()%>&IDCard=<%=c.getIDCard()%>&date=<%=c.getDate()%>&cMark=<%=c.getCMark()%>" target="view_frame">修改</a></td>
           <td><a href="SPCarServlet?carId=<%=c.getCarId()%>" onclick="return confirm('真的要删除么')">删除</a></td>
         </tr>
         <%} %>
         <tr class="tr3">
           <td align="center" colspan="9">
              <%=request.getAttribute("cBar") %>
           </td>
         </tr>
         </table>
       </div>
       <div class="car2">
         <p>添加车辆</p><p class="p">点击关闭</p><br>
         <form method="post" action="SPCarServlet">
         <table>
           <tr class="tr1">
             <td>序号</td>
             <td>车牌号</td>
             <td>车型</td>
             <td>颜色</td>
             <td>身份证号码</td>
             <td>上次检修日期</td>
             <td>备注信息</td>
             <td>点击添加</td>
           </tr>
           <tr align="center">
             <td>---</td>
             <td><input type="text" name="carId" value="" style="height:25px;width:100px"></td>
             <td><input type="text" name="carType" value="" style="height:25px;width:80px"></td>
             <td><input type="text" name="color" value="" style="height:25px;width:50px"></td>
             <td><input type="text" name="IDCard" value="" style="height:25px;width:210px"></td>
             <td><input type="text" name="Date" value="" style="height:25px;width:105px"></td>
             <td><input type="text" name="cMark" value="" style="height:25px;width:80px"></td>
             <td colspan="2"><input type="submit" name="submit" style="font-size:18px;" value="添加车辆"></td>        
           </tr>
         </table>
         </form>
       </div>
       <div class="worker3">
         <p>检索员工</p><p class="p">点击关闭</p><br>
         <form action="SPWServlet" method="post" style="display:inline-block;">
         <table class="tb1">
           <tr>
             <td>
               <input type="text" value="" style="width:80px;height:25px;" name="name">
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="姓名检索" name="submit">
             </td>
           </tr>
         </table>
         </form>
         <form action="SPWServlet" method="get" style="display:inline-block;">
         <table class="tb1">
           <tr>
             <td>
               <select name="type" style="width:70px;font-size:18px;height:25px;">
                   <option value="">-----------</option>
                   <option value="清洗">清洗</option>
                   <option value="美容">美容</option>
                   <option value="修理">修理</option>
                   <option value="保养">保养</option>
                 </select>
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="业务类型检索" name="submit">
             </td>
           </tr>
         </table>
         </form>
         <table class="tb1">
           <tr>
             <td>
               <select name="sex" style="width:60px;font-size:18px;height:25px;">
                 <option value="">---</option>
                 <option value="male">男</option>
                 <option value="female">女</option>
               </select>
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="性别检索" name="submit">
             </td>
           </tr>
         </table>
         <table class="tb">
           <tr class="tr1">
             <td>序号</td>
             <td  style="width:60px;">姓名</td>
             <td style="width:50px;">工号</td>
             <td style="width:130px;">联系电话</td>
             <td style="width:50px;">性别</td>
             <td style="width:80px;">业务类型</td>
             <td style="width:80px;">业务等级</td>
             <td style="width:80px;">当月绩效</td>
             <td style="width:80px;">排队人数</td>
             <td>操作</td>
             <td>删除</td>
           </tr>
         </table>
       </div>
       <div class="worker">
         <p>员工信息管理</p><p class="p">点击关闭</p><br>
         <table class="tb">
         <tr class="tr1">
           <td>序号</td>
           <td>姓名</td>
           <td>工号</td>
           <td>联系电话</td>
           <td>性别</td>
           <td>业务类型</td>
           <td>业务等级</td>
           <td>当月绩效</td>
           <td>排队人数</td>
           <td>操作</td>
           <td>删除</td>
         </tr>
         <%i=0;
           for(Worker w:wList) {
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
           
           %>
         <tr class="<%=trn %>" align="center">
           <td>0<%=i %></td>
           <td><%=w.getWName() %></td>
           <td><%=w.getWorkId() %></td>
           <td><%=w.getWPhone() %></td>
           <td><%=w.getWSex() %></td>
           <td><%=w.getWType() %></td>
           <td><%=w.getWClass() %></td>
           <td><%=w.getAchieve() %></td>
           <td><%=w.getWLine() %></td>
           <td><a href="WorkerServlet?workId=<%=w.getWorkId()%>" target="view_frame">操作</a></td>
           <td><a href="SPWorkerServlet?workId=<%=w.getWorkId()%>">删除</a></td>
         </tr>
         <%} %>
       </table>
       </div>
       <div class="worker2">
         <p>添加新员工</p><p class="p">点击关闭</p><br>
         <form action="SPWorkerServlet" method="post">
         <table class="tb">
           <tr class="tr1">
             <td>序号</td>
             <td>姓名</td>
             <td>工号</td>
             <td>联系电话</td>
             <td>性别</td>
             <td>业务类型</td>
             <td>业务等级</td>
             <td>当月绩效</td>
             <td>排队人数</td>
             <td>点击添加</td>
           </tr>
           <tr align="center">
             <td>---</td>
             <td><input type="text" name="wName" value="" style="width:60px;height:25px;"></td>
             <td><input type="text" name="workId" value="" style="width:50px;height:25px;"></td>
             <td><input type="text" name="wPhone" value="" style="width:125px;height:25px;"></td>
             <td><input type="text" name="wSex" value="" style="width:50px;height:25px;"></td>
             <td><input type="text" name="wType" value="" style="width:80px;height:25px;"></td>
             <td><input type="text" name="wClass" value="" style="width:80px;height:25px;"></td>
             <td><input type="text" name="achieve" value="" style="width:80px;height:25px;"></td>
             <td><input type="text" name="wLine" value="" style="width:80px;height:25px;"></td>
             <td colspan="2"><input type="submit" name="submit" style="font-size:18px;" value="添加用户"></td>
           </tr>
         </table>
         </form>
       </div>
       <div class="parts3">
         <p>检索零件</p><p class="p">点击关闭</p><br>
         <table class="tb1">
           <tr>
             <td>
               <input type="text" value="" style="width:90px;height:25px;" name="name">
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="编号检索" name="submit">
             </td>
           </tr>
         </table>
         <table class="tb1">
           <tr>
             <td>
               <input type="text" value="" style="width:150px;height:25px;" name="name">
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="名称检索" name="submit">
             </td>
           </tr>
         </table>
         <table class="tb1">
           <tr>
             <td>
               <input type="text" value="" style="width:150px;height:25px;" name="name">
             </td>
             <td>
               <input type="submit" style="font-size:18px;" value="厂商检索" name="submit">
             </td>
           </tr>
         </table>
         <table class="tb">
           <tr class="tr1">
             <td>序号</td>
             <td style="width:90px;">零件编号</td>
             <td style="width:90px;">名称</td>
             <td style="width:80px;">单价</td>
             <td style="width:110px;">提供商</td>
             <td style="width:60px;">数量</td>
             <td colspan="2" style="width:130px;">零件入库</td>
             <td>删除</td>
           </tr>
         </table>
       </div>
       <div class="parts">
         <p>库存管理</p><p class="p">点击关闭</p><br>
         <table class="tb">
           <tr class="tr1">
             <td>序号</td>
             <td style="width:90px;">零件编号</td>
             <td style="width:90px;">名称</td>
             <td style="width:80px;">单价</td>
             <td style="width:110px;">提供商</td>
             <td style="width:60px;">数量</td>
             <td colspan="2" style="width:110px;">零件入库</td>
             <td>删除</td>
           </tr>
         <%i=0;
           for(Parts p:pList) {
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
           if(p.getPNum()<100){
             trn="tr4";
           }
         %>
           <form action="PartsServlet" method="post">
           <tr class="<%=trn%>" align="center">
             <td>0<%=i %></td>
             <td><%=p.getPartId() %></td>
             <td><%=p.getPName() %></td>
             <td><%=p.getPrice() %></td>
             <td><%=p.getProvider() %></td>
             <td><%=p.getPNum() %></td>
             <td><input type="text" name="pNum" value="" style="height:25px;width:60px;">
                 <input type="hidden" name="partId" value="<%=p.getPartId()%>">
             </td>
             <td><input type="submit" name="submit" value="添加" style="width:50px;font-size:18px;"></td>
             <td><a href="SPPartsServlet?partId=<%=p.getPartId() %>">删除</a></td>
           </tr>
           </form>
         <%} %>
           <tr>
             <td align="center" colspan="9" class="tr3">
              <%=request.getAttribute("cBar") %>
             </td>
           </tr>
         </table>
       </div>
      
       <div class="parts2">
         <p>添加新零件</p><p class="p">点击关闭</p>
         <form action="SPPartsServlet" method="post">
         <table class="tb">
           <tr class="tr1">
             <td>序号</td>
             <td style="width:90px;">零件编号</td>
             <td style="width:90px;">名称</td>
             <td style="width:80px;">单价</td>
             <td style="width:110px;">提供商</td>
             <td style="width:60px;">数量</td>
             <td style="width:100px;">点击添加</td>
           </tr>
           <tr align="center">
             <td>---</td>
             <td><input type="text" name="partId" value="" style="width:90px;height:25px;"></td>
             <td><input type="text" name="pName" value="" style="width:90px;height:25px;"></td>
             <td><input type="text" name="price" value="" style="width:80px;height:25px;"></td>
             <td><input type="text" name="provider" value="" style="width:110px;height:25px;"></td>
             <td><input type="text" name="pNum" value="" style="width:60px;height:25px;"></td>
             <td><input type="submit" name="submit" style="width:100px;font-size:18px;" value="添加零件"></td>
           </tr>
         </table>
         </form>
       </div>
       <div class="order1">
         <p>添加新订单</p><p class="p">点击关闭</p><br>
         <form name="form" action="SPOrderServlet" onsubmit="return check(this);" method="post">
           <table>
             <tbody class="tbn">
             <tr>
               <td class="tr1">车牌号码：</td>
               <td colspan="4"><input class="input" type="text" name="carId" value=""></td>
             </tr>
             <tr>
              <td class="tr1">用户名：</td>
              <td colspan="4"><input class="input" type="text" name="name" value=""></td>
             </tr>
             <tr>
               <td class="tr1">业务类型：</td>
               <td><select name="oType" style="width:100px;font-size:18px;height:25px;">
                   <option value="">-----------</option>
                   <option value="清洗">清洗</option>
                   <option value="美容">美容</option>
                   <option value="修理">修理</option>
                   <option value="保养">保养</option>
                 </select>
               </td>
               <td class="tr1">技师编号：</td>
               <td colspan="2">
                 <input class="input5" type="text" name="workId" value="">
               </td>
             </tr>
             <tr>
               <td class="tr1">服务项目：</td>
               <td>
                 <select name="parts1" style="width:100px;font-size:18px;height:25px;">
                   <option value="">-----------</option>
                   <%for(Parts p:pList) { %>
                   <option value="<%=p.getPartId()%>"><%=p.getPName() %></option>
                   <%} %>
                 </select>
               </td>
               <td class="tr1">数量:</td>
               <td><input class="input3" type="text" name="number1" value=""></td>
               <td><button class="input3" type="button" onclick="add(event)">添加</button></td>
             </tr>
             <tr id="trnn">
               <td class="tr1">情况备注：</td>
               <td colspan="4"><input class="input" type="text" name="oMark" value=""></td>
             </tr>
             <tr align="center">            
               <td colspan="5"><input type="submit" class="input1" onclick="return confirm('确认添加?')" name="sub1" value="确定提交"></td>
             </tr>
             </tbody>
           </table>
         </form>
       </div>
       <div class="order2">
         <p>未处理订单信息</p><p class="p">点击关闭</p><br>
         <table class="tb">
         <tr class="tr1">
           <td>序号</td>
           <td>订单编号</td>
           <td>车牌号</td>
           <td>用户名</td>
           <td>业务类型</td>
           <td>技师编号</td>
           <td>提交日期</td>
           <td>总价</td>
           <td>情况备注</td>
           <td>状态</td>
           <td>操作</td>
           <td>删除</td>
         </tr>
         <%i=0;
           for(Orders o:ol1) {
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
           
           %>
         <tr class="<%=trn %>" align="center">
           <td>0<%=i %></td>
           <td><%=o.getOId() %></td>
           <td><%=o.getCarId() %></td>
           <td><%=o.getName() %></td>
           <td><%=o.getOType() %></td>
           <td><%=o.getWorkId() %></td>
           <td><%=o.getODate() %></td>
           <td><%=o.getSum() %></td>
           <td><%=o.getOMark() %></td>
           <td><%=o.getIfOk() %></td>
           <td><a href="MOrderServlet?carId=<%=o.getCarId() %>" target="view_frame">操作</a></td>
           <td><a href="SPOrderServlet?oId=<%=o.getOId()%>" onclick="return confirm('真的要删除么')">删除</a></td>
         </tr>
         <%} %>
       </table>
       </div>
       <div class="order3">
        <p>进行中订单信息</p><p class="p">点击关闭</p><br>
         <table class="tb">
         <tr class="tr1">
           <td>序号</td>
           <td>订单编号</td>
           <td>车牌号</td>
           <td>用户名</td>
           <td>业务类型</td>
           <td>技师编号</td>
           <td>提交日期</td>
           <td>总价</td>
           <td>情况备注</td>
           <td>状态</td>
           <td>操作</td>
           <td>删除</td>
         </tr>
         <%i=0;
           for(Orders o:ol2) {
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
           
           %>
         <tr class="<%=trn %>" align="center">
           <td>0<%=i %></td>
           <td><%=o.getOId() %></td>
           <td><%=o.getCarId() %></td>
           <td><%=o.getName() %></td>
           <td><%=o.getOType() %></td>
           <td><%=o.getWorkId() %></td>
           <td><%=o.getODate() %></td>
           <td><%=o.getSum() %></td>
           <td><%=o.getOMark() %></td>
           <td><%=o.getIfOk() %></td>
           <td><a href="MOrderServlet?carId=<%=o.getCarId() %>" target="view_frame">操作</a></td>
           <td><a href="SPOrderServlet?oId=<%=o.getOId()%>" onclick="return confirm('真的要删除么')">删除</a></td>
         </tr>
         <%} %>
       </table>
        
       </div>
       <div class="order5">
         <p>待开始订单</p><p class="p">点击关闭</p><br>
         <table class="tb">
         <tr class="tr1">
           <td>序号</td>
           <td>订单编号</td>
           <td>车牌号</td>
           <td>用户名</td>
           <td>业务类型</td>
           <td>技师编号</td>
           <td>提交日期</td>
           <td>总价</td>
           <td>情况备注</td>
           <td>状态</td>
           <td>操作</td>
           <td>删除</td>
         </tr>
         <%i=0;
           for(int j=0;j<ol3.size();j++) {
           Orders o=ol3.get(j);
           j++;
           if(i%2==0)trn="tr2";
           else trn="";
           
           %>
         <tr class="<%=trn %>" align="center">
           <td>0<%=j %></td>
           <td><%=o.getOId() %></td>
           <td><%=o.getCarId() %></td>
           <td><%=o.getName() %></td>
           <td><%=o.getOType() %></td>
           <td><%=o.getWorkId() %></td>
           <td><%=o.getODate() %></td>
           <td><%=o.getSum() %></td>
           <td><%=o.getOMark() %></td>
           <td><%=o.getIfOk() %></td>
           <td><a href="MOrderServlet?carId=<%=o.getCarId() %>" target="view_frame">操作</a></td>
           <td><a href="SPOrderServlet?oId=<%=o.getOId()%>" onclick="return confirm('真的要删除么')">删除</a></td>
         </tr>
         <%} %>
       </table>
       </div>
       <div class="order4">
         <p>已完成订单记录</p><p class="p">点击关闭</p><br>
         <table class="tb">
         <tr class="tr1">
           <td>序号</td>
           <td>订单编号</td>
           <td>车牌号</td>
           <td>用户名</td>
           <td>业务类型</td>
           <td>技师编号</td>
           <td>提交日期</td>
           <td>总价</td>
           <td>情况备注</td>
           <td>状态</td>
           <td>操作</td>
         </tr>
         <%i=0;
           for(Orders o:his) {
           
           i++;
           if(i%2==0)trn="tr2";
           else trn="";
           
           %>
         <tr class="<%=trn %>" align="center">
           <td>0<%=i %></td>
           <td><%=o.getOId() %></td>
           <td><%=o.getCarId() %></td>
           <td><%=o.getName() %></td>
           <td><%=o.getOType() %></td>
           <td><%=o.getWorkId() %></td>
           <td><%=o.getODate() %></td>
           <td><%=o.getSum() %></td>
           <td><%=o.getOMark() %></td>
           <td><%=o.getIfOk() %></td>
           <td><a href="MOrderServlet?carId=<%=o.getCarId() %>" target="view_frame">操作</a></td>
           
         </tr>
         <%} %>
       </table>
       </div>
       <div class="article1">
         <p>上传文档</p><p class="p">点击关闭</p><br>
         <form action="SPUploadServlet" enctype="multipart/form-data" method="post">
           <table>
             <tbody class="tbn">
             <tr>
               <td class="tr1">选择文档：</td>
               <td ><input type="file" name="file1" style="width:200px;font-size:18px;"></td>
              <td><input type="submit" name="submit" style="width:100px;font-size:18px;" value="上传"></td>
             </tr>
           </tbody>
           </table>
         </form>
       </div>
       <div class="article2">
         <p style="text-align:center;">文献列表</p><p class="p">点击关闭</p><br>
         <table class="tb1">
           <%i=0;
         for(String s:aList){ 
           i++;
       %>
         <tr>
           <td>
             <a href="SelectServlet?name=<%=s%>" style="color:#000000;"><%=i+"、"+s %></a>
           </td>
           <td>
             <a href="SPUploadServlet?name=<%=s%>">删除</a>
           </td>
         </tr>
       <%} %>
         </table>
         </div>
     </div>
    </div>
    <div class="bottom">NWPU MIS | Copyright © 2017 </div>
  </body>
</html>
