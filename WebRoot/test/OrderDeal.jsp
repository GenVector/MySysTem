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
  List<Parts> pList=(List<Parts>)request.getAttribute("list");
  List<CarParts> list=(List<CarParts>)request.getAttribute("cpl");
%> 
<script src="bean/jquery-3.2.0.min.js" type="text/javascript"></script>  
<script>
  $(function(){
    		$(".act1").click(function(e){
    			var $form2=$(".box8");
    			if($form2.is(":visible")){
    				$form2.hide();
					e.stopPropagation();
    			}else{
    				$form2.show();
					e.stopPropagation();
    			}
    			
    		})
    	})
</script>
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
	                      "<td><select name=\"parts"+j+"\" class=\"input\">"+
                          "<option value=\"\">-----------</option>"+
                          "<%for(Parts p:pList) { %><option value=\"<%=p.getPartId()%>\"><%=p.getPName() %>" +
                          "</option><%} %></select></td>"+
						  "<td class=\"tr1\">数量:</td>"+
						  "<td><input class=\"input\" type=\"text\" name=\"number"+j+
						  "\" value=\"\"></td>"+
						  "<td><button onclick=\"add(event)\" type=\"button\">添加</button></td>";
	  newrow.innerHTML=innerHTMLString;
	  orderaddtable.insertBefore(newrow,trnn);
	  console.log(j);
}
function check(form){
		    with(form){
		      if(oMark.value=="")
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
	<link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  
  <body>
   <div class="box7">
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
             <td>出厂日期</td>
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
             int i=0;
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
             i+=1;
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
             <td><%=i %></td>
             <td><%=rsum %></td>
             <td><%=sum %></td>
           </tr>
           <tr>
             <td></td>
             <%if(o.getIfOk().equals("已提交")){ %>
             <td><a class="act1">处理订单</a></td>
             <%} %>
             <%if(o.getIfOk().equals("待开始")){ %>
             <td><a href="MOrder2Servlet?oId=<%=o.getOId()%>" onclick="return confirm('开始执行订单?')">强制开始</a></td>
             <%} %>
             <%if(o.getIfOk().equals("进行中")){ %>
             <td><a href="MOrder2Servlet?oId=<%=o.getOId()%>" onclick="return confirm('订单已完成?')">订单完成</a></td>
             <%} %>
           </tr>
        </table>
      </div>
      <br>
      <div class="box8">
        <form action="MOrderServlet" method="post" onsubmit="return check(this);" name="form">
        <table align="center">
        <tbody class="tbn">
          <tr>
            <td>情况说明:<input type="hidden" value="<%=o.getOId()%>" name="oId">
              <input type="hidden" value="<%=o.getCarId()%>" name="carId">
            </td>
            <td colspan="4"><input type="text" class="input2" name="oMark" value=""></td>
          </tr>
          <tr>
               <td>服务项目:</td>
               <td>
                 <select name="parts1" class="input">
                   <option value="">-----------</option>
                   <%for(Parts p:pList) { %>
                   <option value="<%=p.getPartId()%>"><%=p.getPName() %></option>
                   <%} %>
                 </select>
               </td>
               <td>数量:</td>
               <td><input type="text" class="input" name="number1" value=""></td>
               <td><button type="button" onclick="add(event)">添加</button></td>
             </tr>
             <tr id="trnn">
              <td colspan="5" align="center">
                <input type="submit" name="submit" class="input" onclick="return confirm('确认提交?')" value="确认订单">
              </td>
             </tr>
        </tbody>
        </table>
        </form>
      </div>
  </body>
</html>
