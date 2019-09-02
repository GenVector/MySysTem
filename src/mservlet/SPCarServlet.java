package mservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.CarDao;
import method.CarPartsDao;
import method.OrderDao;
import bean.*;

public class SPCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SPCarServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String carId=new String(request.getParameter("carId").getBytes("ISO-8859-1"),"UTF-8");
		CarDao cd=new CarDao();
		OrderDao od=new OrderDao();
		CarPartsDao cpd=new CarPartsDao();
		Orders o=od.findOrder(carId);
		cd.deleteCar(carId);
		od.deleteOrder(o.getName(),carId);
		cpd.deleteCarParts(carId);
		int page=1;
		String message="车辆删除成功";
		request.setAttribute("message", message);
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String carId=new String(request.getParameter("carId"));
		String IDCard=new String(request.getParameter("IDCard"));
		String cMark=new String(request.getParameter("cMark"));
		String Date=new String(request.getParameter("Date"));
		String carType=new String(request.getParameter("carType"));
		String color=new String(request.getParameter("color"));
		Car c=new Car(carId,carType,color,IDCard,Date,cMark);
		CarDao cd=new CarDao();
		int i=cd.AddNewCar(c);
		int page=1;	
		String message="这里是添加车辆";
		if(i!=0){
			message="车辆添加成功";
		}
		request.setAttribute("message", message);
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

}
