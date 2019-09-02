package mservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.*;
import method.*;

public class MOrder2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public MOrder2Servlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������ʼ���У���״̬����Ϊ������
		//���߽������ж�����Ϊ�����
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String oId=request.getParameter("oId");
		OrderDao od=new OrderDao();
		Orders o=od.getOrder(oId);
		String message="";
		if(o.getIfOk().equals("����ʼ")){
		  o.setIfOk("������");
		  message="�����ѿ�ʼִ��";
		  od.deleteOrder(oId);
		  od.AddNewOrder(o);
		}
		else if(o.getIfOk().equals("������")){
			o.setIfOk("�����");
			CarPartsDao cpd=new CarPartsDao();
			HistoryDao hd=new HistoryDao();
			WorkerDao wd=new WorkerDao();
			Worker w=wd.findWorker(o.getWorkId());
			w.setWLine(w.getWLine()-1);
			w.NewAch();
			wd.deleteWorker(w.getWorkId());
			wd.AddNewWorker(w);
			hd.AddHistory(o);
			od.deleteOrder(oId);
			cpd.deleteCarParts(o.getCarId());
			message="���������";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("test/MResult.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
