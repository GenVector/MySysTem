package servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.*;

public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NoticeServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		NoticeDao nd=new NoticeDao();
		String weather=request.getParameter("weather");
		String road=request.getParameter("road");
		String oil90=request.getParameter("oil90");
		String oil93=request.getParameter("oil93");
		String oil97=request.getParameter("oil97");
		String benefit=request.getParameter("benefit");
		nd.updateNotice(weather, road, oil90, oil93, oil97,benefit,"Î÷°²");
		int page=1;
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

}
