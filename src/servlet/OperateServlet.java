package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import method.*;
import bean.*;

public class OperateServlet extends HttpServlet {

	private static final long serialVersionUID = -5847110076795478101L;
	public OperateServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String carId=new String(request.getParameter("carId").getBytes("ISO-8859-1"),"UTF-8");
		String IDCard=new String(request.getParameter("IDCard").getBytes("ISO-8859-1"),"UTF-8");
		String cMark=new String(request.getParameter("cMark").getBytes("ISO-8859-1"),"UTF-8");
		String Date=new String(request.getParameter("Date").getBytes("ISO-8859-1"),"UTF-8");
		String carType=new String(request.getParameter("carType").getBytes("ISO-8859-1"),"UTF-8");
		String color=new String(request.getParameter("color").getBytes("ISO-8859-1"),"UTF-8");
		  Car c=new Car(carId,carType,color,IDCard,Date,cMark);
		  CarDao cd=new CarDao();
		  cd.AddNewCar(c);
		  UserAction ua=new UserAction();
		  User u=ua.findUser(IDCard);
		  request.setAttribute("user", u);
		  request.getRequestDispatcher("MainServlet").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String IDCard=new String(request.getParameter("IDCard").getBytes("ISO-8859-1"),"UTF-8");
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String phone=new String(request.getParameter("phone").getBytes("ISO-8859-1"),"UTF-8");
		UserAction ua=new UserAction();
			ua.updateUser(IDCard, name, sex, phone);
			User u=ua.findUser(IDCard);
			request.setAttribute("user", u);
			request.getRequestDispatcher("MainServlet").forward(request, response);						
	}

}
