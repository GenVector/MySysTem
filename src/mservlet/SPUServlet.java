package mservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import bean.Worker;
import method.UserAction;

public class SPUServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SPUServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String sex=new String(request.getParameter("sex").getBytes("ISO-8859-1"),"UTF-8");
		UserAction ua=new UserAction();
		String message="用户性别检索";
		int page=1;
		List<User> list=ua.getUserList();
		List<User> ucheck=new ArrayList<User>();
		for(User u:list){
			if(u.getSex().equals(sex)){
				ucheck.add(u);
				
			}
		}
		request.setAttribute("ucheck", ucheck);
		request.setAttribute("wcheck", new ArrayList<Worker>());
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
		UserAction ua=new UserAction();
		String message="用户姓名检索";
		int page=1;
		List<User> list=ua.getUserList();
		List<User> ucheck=new ArrayList<User>();
		for(User u:list){
			if(u.getName().equals(name)){
				ucheck.add(u);				
			}
		}
		request.setAttribute("ucheck", ucheck);
		request.setAttribute("wcheck", new ArrayList<Worker>());
		request.setAttribute("message", message);
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

}
