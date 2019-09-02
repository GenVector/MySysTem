package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import bean.Worker;
import method.*;

public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public ManageServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String error="";
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String name1="";
		if(request.getSession().getAttribute("name")!=null){
			name1=request.getSession().getAttribute("name").toString();
		}
		if(name.equals(name1)){
			int page=1;	
			List<User> list=new ArrayList<User>();
			request.setAttribute("ucheck", list);
			request.setAttribute("uPage",page);
			request.setAttribute("pPage",page);
			request.setAttribute("cPage",page);
			request.setAttribute("wPage",page);
			String message="亲爱的管理员，欢迎您";
			request.setAttribute("message", message);
			request.getRequestDispatcher("Main2Servlet").forward(request, response);
		}
		else{
			error="身份信息过期，请重新登录验证";
			request.setAttribute("result", error);
			request.getRequestDispatcher("test/manage.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String error="";
		ManagerDao md=new ManagerDao();
		String result=md.checkManager(request.getParameter("name"), request.getParameter("password"));
		if(!result.equals("error")){
			int page=1;	
			List<User> list=new ArrayList<User>();
			List<Worker> wlist=new ArrayList<Worker>();
			request.setAttribute("wcheck",wlist );
			request.setAttribute("ucheck", list);
			request.setAttribute("uPage",page);
			request.setAttribute("pPage",page);
			request.setAttribute("cPage",page);
			request.setAttribute("wPage",page);
			String message="亲爱的管理员，欢迎您";
			HttpSession session=request.getSession();
			session.setAttribute("name", result);
			session.setAttribute("password", request.getParameter("password"));
			request.setAttribute("message", message);
			request.getRequestDispatcher("Main2Servlet").forward(request, response);
		}
		else{
			error="登录失败，请检查用户名和密码";
			request.setAttribute("result", error);
			request.getRequestDispatcher("test/manage.jsp").forward(request, response);
		}
	}
		
	}


