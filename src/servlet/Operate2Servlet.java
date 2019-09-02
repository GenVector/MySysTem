package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import method.*;

public class Operate2Servlet extends HttpServlet {
	private static final long serialVersionUID = -5847110076795478101L;
	public Operate2Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//查看订单详情
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String carId=new String(request.getParameter("carId").getBytes("ISO-8859-1"),"UTF-8");
		CarDao cd=new CarDao();
		OrderDao od=new OrderDao();
		WorkerDao wd=new WorkerDao();
		CarPartsDao cpd=new CarPartsDao();
		Car c=cd.findCar(carId);
		Orders o=od.findOrder(carId);
		Worker w=wd.findWorker(o.getWorkId());
		List<CarParts> cpl=cpd.getPartList(carId);
		request.setAttribute("car", c);
		request.setAttribute("order", o);
		request.setAttribute("worker", w);
		request.setAttribute("cpl", cpl);
		request.getRequestDispatcher("test/OrderDetail.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//修改用户资料
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String password=request.getParameter("password");
		String newpassword=request.getParameter("newpassword");
		String name=request.getParameter("name");
		UserAction ua=new UserAction();
		User u=ua.checkUser(name, password);
		String result;	
		if(u!=null){
		  ua.updatePasswords(name, newpassword);
		  result="修改成功";
	   }
		else{
		  result="修改失败，检查输入";
		  }
		  request.setAttribute("result", result);
		  request.getRequestDispatcher("test/result.jsp").forward(request, response);
	}
}
