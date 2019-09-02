package servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.Article;

public class ArticleListServlet extends HttpServlet {
	private static final long serialVersionUID = -5847110076795478101L;
	public ArticleListServlet() {
		super();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Article a=new Article();
		List<String> list=a.getArtList();
		request.setAttribute("list", list);
		request.getRequestDispatcher("test/artList.jsp").forward(request, response);
		
	}

}
