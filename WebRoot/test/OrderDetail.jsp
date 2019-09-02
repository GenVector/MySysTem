<%@ page language="java" import="java.util.*" import="bean.*;" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查看订单详情</title>
<%
  Car c=(Car)request.getAttribute("car");
  Orders o=(Orders)request.getAttribute("order");
  Worker w=(Worker)request.getAttribute("worker");
  List<CarParts> list=(List<CarParts>)request.getAttribute("cpl");
%>   
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>
   <div class="box6">
    <p>订单详情</p>
      <table style="width:800px" align="center">
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
           </tr>
       </table>
       <p>车辆详情</p>
      <table style="width:400px" align="center">
             <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td>车牌号码</td>
             <td>车型</td>
             <td>颜色</td>
             <td>上次检修日期</td>
             <td>备注</td>
          </tr>
          <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td><%=c.getCarId() %></td>
             <td><%=c.getCarType() %></td>
             <td><%=c.getColor() %></td>
             <td><%=c.getDate() %></td>
             <td><%=c.getCMark() %></td>
           </tr>
       </table>
       <p>技师资料</p>
      <table style="width:500px" align="center">
             <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td>技师姓名</td>
             <td>工号</td>
             <td>性别</td>
             <td>联系电话</td>
             <td>业务类型</td>
             <td>技能等级</td>
          </tr>
          <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td><%=w.getWName() %></td>
             <td><%=w.getWorkId() %></td>
             <td><%=w.getWSex() %></td>
             <td><%=w.getWPhone() %></td>
             <td><%=w.getWType() %></td>
             <td><%=w.getWClass() %></td>
           </tr>
       </table>
       <p>消费明细</p>
        <table style="width:400px" align="center">
           <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td>编号</td>
             <td>消费项目</td>
             <td>数量</td>
             <td>单价</td>
             <td>共计</td>
           </tr>
           <%double sum=0;
             double rsum=0;
             for(CarParts cp:list){ %>        
           <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td><%=cp.getPartId() %></td>
             <td><%=cp.getPName() %></td>
             <td><%=cp.getNumber() %></td>
             <td><%=cp.getPrice() %></td>
             <td><%=cp.getLineSum() %></td>
           </tr>
           <%sum+=cp.getLineSum();
             rsum+=cp.getPrice();
             } 
             sum+=50;
             rsum+=50;
             %>
           <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td>0000</td>
             <td>服务费用</td>
             <td>1</td>
             <td>50.00</td>
             <td>50.00</td>
           </tr>
           <tr align="center">
             <td>
               <image src="/MySystem/picture/data1.png" width="50px" height="40px">&nbsp;&nbsp;
             </td>
             <td>----</td>
             <td>共计</td>
             <td>5</td>
             <td><%=rsum %></td>
             <td><%=sum %></td>
           </tr>
           <tr>
             <td></td>
             <td></td>
             <td></td>
             <td></td>
             <td><a href="OServlet?oId=<%=o.getOId()%>" style="color:#0000dd;font-size:20px;" onclick="return confirm('真的要中止么')">中止订单</a></td>
             <%if(o.getIfOk().equals("待开始")){ %>
             <td><a href="MOrder2Servlet?oId=<%=o.getOId()%>"style="color:#0000dd;font-size:20px;" onclick="return confirm('确认订单开始?')">确认订单</a></td>
             <%} %>
           </tr>
        </table>
      </div>
  </body>
</html>
