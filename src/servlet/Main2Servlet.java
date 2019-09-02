package servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.*;
import bean.*;

public class Main2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public Main2Servlet() {
		super();
	}

	
	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int uPage=Integer.parseInt(request.getAttribute("uPage").toString());
		int cPage=Integer.parseInt(request.getAttribute("cPage").toString());
		int wPage=Integer.parseInt(request.getAttribute("wPage").toString());
		int pPage=Integer.parseInt(request.getAttribute("pPage").toString());
		String message="亲爱的管理员，欢迎您";
		if(request.getAttribute("message")!=null){
			message=request.getAttribute("message").toString();
		}
		UserAction ua=new UserAction();
		CarDao cd=new CarDao();
		WorkerDao wd=new WorkerDao();
		PartsDao pd=new PartsDao();
		OrderDao od=new OrderDao();
		HistoryDao hd=new HistoryDao();
		List<Orders> oList=od.findOrderList();
		List<Worker> wList=wd.getWorkerList();
		List<User> uList=ua.getUserList();
		List<Car> cList=cd.getCarList();
		List<Parts> pList=pd.getPartList();
		List<Orders> his=hd.findHistoryList();
		List<Orders> ol1=new ArrayList<Orders>();
		List<Orders> ol2=new ArrayList<Orders>();
		List<Orders> ol3=new ArrayList<Orders>();
		List<User> ucheck=(List<User>)request.getAttribute("ucheck");
		if(ucheck==null||ucheck.size()==0){
			ucheck=new ArrayList<User>();
		}
		List<Worker> wcheck=(List<Worker>)request.getAttribute("wcheck");
		if(wcheck==null||wcheck.size()==0){
		  wcheck=new ArrayList<Worker>();
		}
		for(Orders o:oList){
			if(o.getIfOk().equals("已提交")){
				ol1.add(o);
			}
			else if(o.getIfOk().equals("进行中")){
				ol2.add(o);
			}
			else if(o.getIfOk().equals("待开始")){
				ol3.add(o);
			}
		}
		Article a=new Article();
		List<String> aList=a.getArtList();
		SuperDao sd=new SuperDao();
		StringBuffer uBar=sd.getUBar(uPage,uList.size());
		StringBuffer cBar=sd.getCBar(cPage,cList.size());
		StringBuffer wBar=sd.getWBar(wPage,wList.size());
		StringBuffer pBar=sd.getPBar(pPage,pList.size());
		NoticeDao nd=new NoticeDao();
		Notice n=nd.getNotic("西安");
		request.setAttribute("ucheck", ucheck);
		request.setAttribute("wcheck", wcheck);
		request.setAttribute("message", message);
		request.setAttribute("cBar", cBar);
		request.setAttribute("wBar", wBar);
		request.setAttribute("uBar", uBar);
		request.setAttribute("pBar", pBar);
		request.setAttribute("his", his);
		request.setAttribute("aList", aList);
		request.setAttribute("uList", uList);
		request.setAttribute("pList", pList);
		request.setAttribute("wList", wList);
		request.setAttribute("cList", cList);
		request.setAttribute("ol1", ol1);
		request.setAttribute("ol2", ol2);
		request.setAttribute("ol3", ol3);
		request.setAttribute("notice", n);
		request.getRequestDispatcher("test/SuPow.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int uPage=Integer.parseInt(request.getAttribute("uPage").toString());
		int cPage=Integer.parseInt(request.getAttribute("cPage").toString());
		int wPage=Integer.parseInt(request.getAttribute("wPage").toString());
		int pPage=Integer.parseInt(request.getAttribute("pPage").toString());
		String message="亲爱的管理员，欢迎您";
		if(request.getAttribute("message")!=null){
			message=request.getAttribute("message").toString();
		}
		UserAction ua=new UserAction();
		CarDao cd=new CarDao();
		WorkerDao wd=new WorkerDao();
		PartsDao pd=new PartsDao();
		OrderDao od=new OrderDao();
		HistoryDao hd=new HistoryDao();
		List<Orders> oList=od.findOrderList();
		List<Worker> wList=wd.getWorkerList();
		List<User> uList=ua.getUserList();
		List<Car> cList=cd.getCarList();
		List<Parts> pList=pd.getPartList();
		List<Orders> his=hd.findHistoryList();
		List<Orders> ol1=new ArrayList<Orders>();
		List<Orders> ol2=new ArrayList<Orders>();
		List<Orders> ol3=new ArrayList<Orders>();
		List<User> ucheck=(List<User>)request.getAttribute("ucheck");
		if(ucheck==null||ucheck.size()==0){
			ucheck=new ArrayList<User>();
		}
		List<Worker> wcheck=(List<Worker>)request.getAttribute("wcheck");
		if(wcheck==null||wcheck.size()==0){
		  wcheck=new ArrayList<Worker>();
		}
		for(Orders o:oList){
			if(o.getIfOk().equals("已提交")){
				ol1.add(o);
			}
			else if(o.getIfOk().equals("进行中")){
				ol2.add(o);
			}
			else if(o.getIfOk().equals("待开始")){
				ol3.add(o);
			}
		}
		Article a=new Article();
		List<String> aList=a.getArtList();
		SuperDao sd=new SuperDao();
		StringBuffer uBar=sd.getUBar(uPage,uList.size());
		StringBuffer cBar=sd.getCBar(cPage,cList.size());
		StringBuffer wBar=sd.getWBar(wPage,wList.size());
		StringBuffer pBar=sd.getPBar(pPage,pList.size());
		NoticeDao nd=new NoticeDao();
		Notice n=nd.getNotic("西安");
		request.setAttribute("ucheck", ucheck);
		request.setAttribute("wcheck", wcheck);
		request.setAttribute("message", message);
		request.setAttribute("cBar", cBar);
		request.setAttribute("wBar", wBar);
		request.setAttribute("uBar", uBar);
		request.setAttribute("pBar", pBar);
		request.setAttribute("his", his);
		request.setAttribute("aList", aList);
		request.setAttribute("uList", uList);
		request.setAttribute("pList", pList);
		request.setAttribute("wList", wList);
		request.setAttribute("cList", cList);
		request.setAttribute("ol1", ol1);
		request.setAttribute("ol2", ol2);
		request.setAttribute("ol3", ol3);
		request.setAttribute("notice", n);
		request.getRequestDispatcher("test/SuPow.jsp").forward(request, response);
	}

}
