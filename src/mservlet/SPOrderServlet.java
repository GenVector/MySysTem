package mservlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.*;
import bean.*;
public class SPOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SPOrderServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//删除订单
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String oId=request.getParameter("oId");
		OrderDao od=new OrderDao();
		Orders o=od.getOrder(oId);
		CarPartsDao cpd=new CarPartsDao();
		int row=od.deleteOrder(oId);
		String message="这里是订单删除页面";
		cpd.deleteCarParts(o.getCarId());
		if(row==0){
			message="订单删除失败";
		}
		else{
			message="订单删除成功";
		}
		int page=1;
		request.setAttribute("message", message);
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//管理员手动添加订单
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		OrderDao od=new OrderDao();
		PartsDao pd=new PartsDao();
		CarPartsDao cpd=new CarPartsDao();
		
		int num=Integer.parseInt(request.getParameter("num"));
		String carId=request.getParameter("carId");
		String name=request.getParameter("name");
		String oType=request.getParameter("oType");
		String workId=request.getParameter("workId");
		String oMark=request.getParameter("oMark");
		String ifOk="待开始";
		String oId=od.newOId();
		double sum=0;
		Date time=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd");
		String oDate=df.format(time);
		List<Orders> list=od.findOrderList();
		String res="true";
		int row=0;
		for(Orders o:list){
			if(o.getCarId().equals(carId)){
				res="false";
			}
		}
		if(res.equals("true")){
		  for(int i=1;i<=num;i++){
			  String partId=request.getParameter("parts"+i);
			  String n=request.getParameter("number"+i);
			  if(!partId.equals("")&&!n.equals("")){
			    int number=Integer.parseInt(n);
			    Parts p=pd.getParts(partId);
			    int pn=p.getPNum()-number;
			    pd.updatePart(partId, pn);			    
			    CarParts cp=new CarParts();
			    cp.setCarId(carId);
			    cp.setNumber(number);
			    cp.setPartId(partId);
			    cp.setPName(p.getPName());
			    cp.setPrice(p.getPrice());
			    double lineSum=number*p.getPrice();
			    cp.setLineSum(lineSum);
			    cpd.AddCarParts(cp);
			    sum+=lineSum;
			  }
		  }
		  Orders o=new Orders();
		  o.setCarId(carId);
		  o.setIfOk(ifOk);
		  o.setName(name);
		  o.setODate(oDate);
		  o.setOId(oId);
		  o.setOMark(oMark);
		  o.setOType(oType);
		  o.setSum(sum+50);
		  o.setWorkId(workId);
		  row=od.AddNewOrder(o);
		}
		String message="这里是订单添加";
		if(row==0){
			message="添加订单失败";
		}
		else{
			message="订单添加成功";
		}
		int page=1;
		request.setAttribute("message", message);
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

}
