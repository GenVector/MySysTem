package mservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.CarDao;

public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public CarServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//修改车辆信息
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String carId=new String(request.getParameter("carId").getBytes("ISO-8859-1"),"UTF-8");
		String carType=new String(request.getParameter("carType").getBytes("ISO-8859-1"),"UTF-8");
		String color=new String(request.getParameter("color").getBytes("ISO-8859-1"),"UTF-8");
		String cMark=new String(request.getParameter("cMark").getBytes("ISO-8859-1"),"UTF-8");
		String IDCard=request.getParameter("IDCard");
		String date=request.getParameter("date");
		CarDao cd=new CarDao();
		int i=cd.updateCar(carId, carType, color, cMark,date,IDCard);
		String message="这里是修改车辆信息";
		if(i!=0){
			message="修改成功";
		}
		else{
			message="修改失败";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("test/MResult.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
