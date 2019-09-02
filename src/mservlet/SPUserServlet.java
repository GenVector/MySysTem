package mservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import method.*;

public class SPUserServlet extends HttpServlet {	
	private static final long serialVersionUID = -6228481595407723580L;

	public SPUserServlet() {
		super();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		User u=new User();
		UserAction ua=new UserAction();
		u.setIDCard(request.getParameter("IDCard"));
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		u.setPhone(request.getParameter("phone"));
		u.setSex(request.getParameter("sex"));
		String message="这里是添加用户，my world";
		int n=ua.AddNewUser(u);
		if(n!=0){
			message="用户添加成功";
		}
		else{
			message="添加失败，请检查输入";
		}
		int page=1;			
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.setAttribute("message", message);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String IDCard=request.getParameter("IDCard");
		UserAction ua=new UserAction();
		User u=ua.findUser(IDCard);
		int i=ua.deleteUser(IDCard);
		CarDao cd=new CarDao();
		List<Car> list=cd.findCars(IDCard);
		cd.delCar(IDCard);
		OrderDao od=new OrderDao();
		CarPartsDao cpd=new CarPartsDao();
		for(Car c:list){
			od.deleteOrder(u.getName(), c.getCarId());
			cpd.deleteCarParts(c.getCarId());
		}
		String message;
		message="这里是删除用户";
		if(i!=0){
			message="用户删除成功";
		}
		else{
			message="删除失败，请检查输入";
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
