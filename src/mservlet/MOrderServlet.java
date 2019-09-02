package mservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.CarDao;
import method.CarPartsDao;
import method.OrderDao;
import method.PartsDao;
import method.WorkerDao;
import bean.Car;
import bean.CarParts;
import bean.Orders;
import bean.Parts;
import bean.Worker;

public class MOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MOrderServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//管理员订单操作页面
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String carId=new String(request.getParameter("carId").getBytes("ISO-8859-1"),"UTF-8");
		PartsDao pd=new PartsDao();
		List<Parts> list=pd.getPartList();
		CarDao cd=new CarDao();
		OrderDao od=new OrderDao();
		WorkerDao wd=new WorkerDao();
		CarPartsDao cpd=new CarPartsDao();
		Car c=cd.findCar(carId);
		Orders o=od.findOrder(carId);
		Worker w=wd.findWorker(o.getWorkId());
		List<CarParts> cpl=cpd.getPartList(carId);
		request.setAttribute("list", list);
		request.setAttribute("car", c);
		request.setAttribute("order", o);
		request.setAttribute("worker", w);
		request.setAttribute("cpl", cpl);
		request.getRequestDispatcher("test/OrderDeal.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理已提交订单页面
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String oMark=request.getParameter("oMark");
		String carId=request.getParameter("carId");
		String oId=request.getParameter("oId");
		String ifOk="待开始";
		int num=Integer.parseInt(request.getParameter("num"));
		double sum=0;
		PartsDao pd=new PartsDao();
		OrderDao od=new OrderDao();
		CarPartsDao cpd=new CarPartsDao();
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
		Orders o=od.getOrder(oId);
		od.deleteOrder(oId);
		o.setIfOk(ifOk);
		o.setSum(sum);
		o.setOMark(oMark);
		od.AddNewOrder(o);
	}

}
