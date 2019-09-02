package servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import method.*;

import java.text.SimpleDateFormat;

public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = -5847110076795478101L;
	public OrderServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建新订单时发送页面
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		WorkerDao wd=new WorkerDao();
		List<Worker> list=wd.returnWList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("test/NewOrder.jsp").forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//创建新订单页面
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String carId=request.getParameter("carId");
		String oType=request.getParameter("oType");
		String oMark=request.getParameter("oMark");
		String workId=request.getParameter("workId");
		System.out.println(name+carId+oType+oMark+workId);
		if(workId.equals("")||workId==null){
			WorkerDao wd=new WorkerDao();
			List<Worker> list=wd.returnWList();
			int min=list.get(0).getWLine();
			workId=list.get(0).getWorkId();
			for(int i=1;i<list.size();i++){
				if(min>list.get(i).getWLine()){
					min=list.get(i).getWLine();
					workId=list.get(i).getWorkId();
				}
			}			
		}
		OrderDao od=new OrderDao();
		String ifOk="已提交";
		Date time=new Date();
		SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd");
		String oDate=df.format(time);
		double sum=0;
		String oId=od.newOId();
		Orders o=new Orders(oId,carId,name,oType,workId,oDate,ifOk,oMark,sum);
		od.AddNewOrder(o);
		request.setAttribute("order", o);
		request.getRequestDispatcher("test/NewOrderResult.jsp").forward(request, response);
	}

}
