package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.CarPartsDao;
import method.OrderDao;
import bean.Orders;

public class OServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public OServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		request.setAttribute("message", message);
		request.getRequestDispatcher("test/MResult.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
	}

}
