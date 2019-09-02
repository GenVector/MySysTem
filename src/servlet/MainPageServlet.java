package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.*;
import bean.*;

public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainPageServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String error="";
		UserAction ua=new UserAction();
		User u=ua.checkUser(request.getParameter("name"), request.getParameter("password"));
		if(u!=null){
			request.setAttribute("user", u);			
			request.getRequestDispatcher("MainServlet").forward(request, response);
		}
		else{
			error="µÇÂ¼Ê§°Ü£¬Çë¼ì²éÓÃ»§ÃûºÍÃÜÂë";
			request.setAttribute("result", error);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//É¾³ý³µÁ¾
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		CarDao cd=new CarDao();
		String carId=new String(request.getParameter("carId").getBytes("ISO-8859-1"),"UTF-8");
		String IDCard=cd.returnIDCard(carId);
		cd.deleteCar(carId);
		UserAction ua=new UserAction();
		User u=ua.findUser(IDCard);
		request.setAttribute("user", u);			
		request.getRequestDispatcher("MainServlet").forward(request, response);
	}
	

}
