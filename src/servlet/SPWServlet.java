package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.*;
import bean.User;
import bean.Worker;

public class SPWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SPWServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type=new String(request.getParameter("type").getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(type);
		WorkerDao wd=new WorkerDao();
		String message="员工业务类型检索";
		int page=1;
		List<Worker> list=wd.getWorkerList();
		List<Worker> wcheck=new ArrayList<Worker>();
		for(Worker w:list){
			if(w.getWType().equals(type)){
				wcheck.add(w);
			}
		}
		request.setAttribute("wcheck", wcheck);
		request.setAttribute("ucheck", new ArrayList<User>());
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
		String name=request.getParameter("name");
		System.out.println(name);
		WorkerDao wd=new WorkerDao();
		String message="员工姓名检索";
		int page=1;
		List<Worker> list=wd.getWorkerList();
		List<Worker> wcheck=new ArrayList<Worker>();
		for(Worker w:list){
			if(w.getWName().equals(name)){
				wcheck.add(w);
				System.out.print(w.getWName());
			}
		}
		request.setAttribute("wcheck", wcheck);
		request.setAttribute("ucheck", new ArrayList<User>());
		request.setAttribute("message", message);
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

}
