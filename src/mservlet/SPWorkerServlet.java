package mservlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.WorkerDao;
import bean.Worker;

public class SPWorkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SPWorkerServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String workId=request.getParameter("workId");
		WorkerDao wd=new WorkerDao();
		wd.deleteWorker(workId);
		int page=1;			
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
		Worker w=new Worker();
		WorkerDao wd=new WorkerDao();
		w.setAchieve(request.getParameter("achieve"));
		w.setWClass(request.getParameter("wClass"));
		w.setWLine(Integer.parseInt(request.getParameter("wLine")));
		w.setWName(request.getParameter("wName"));
		w.setWorkId(request.getParameter("workId"));
		w.setWPhone(request.getParameter("wPhone"));
		w.setWSex(request.getParameter("wSex"));
		w.setWType(request.getParameter("wType"));
		wd.AddNewWorker(w);
		int page=1;			
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

}
