package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.*;
import bean.*;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		User u=(User) request.getAttribute("user");
		OrderDao od=new OrderDao();
		List<Orders> olist=od.findOrders(u.getName());
		HistoryDao hd=new HistoryDao();
		List<Orders> his=hd.findHistoryList(u.getName());
		CarDao cd=new CarDao();
		NoticeDao nd=new NoticeDao();
		Notice n=nd.getNotic("西安");
		List<Car> carlist=cd.findCars(u.getIDCard());
		request.setAttribute("his", his);
		request.setAttribute("olist", olist);
		request.setAttribute("notice", n);
		request.setAttribute("carlist", carlist);
		request.setAttribute("user", u);
		request.setAttribute("name", u.getName());
		request.getRequestDispatcher("test/person.jsp").forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		User u=(User) request.getAttribute("user");
		OrderDao od=new OrderDao();
		List<Orders> olist=od.findOrders(u.getName());
		HistoryDao hd=new HistoryDao();
		List<Orders> his=hd.findHistoryList(u.getName());
		CarDao cd=new CarDao();
		NoticeDao nd=new NoticeDao();
		Notice n=nd.getNotic("西安");
		List<Car> carlist=cd.findCars(u.getIDCard());
		request.setAttribute("his", his);
		request.setAttribute("olist", olist);
		request.setAttribute("notice", n);
		request.setAttribute("carlist", carlist);
		request.setAttribute("user", u);
		request.setAttribute("name", u.getName());
		request.getRequestDispatcher("test/person.jsp").forward(request, response);
	}
	

}
