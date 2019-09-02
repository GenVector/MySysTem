package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.Article;

public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = -5847110076795478101L;

	public SelectServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Article t=new Article();
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		StringBuffer s=new StringBuffer(t.getArticle("D:\\Java\\WorkSpace\\MySystem\\file\\"+name+".txt"));
		request.setAttribute("name", name);
		request.setAttribute("str", s);
		request.getRequestDispatcher("test/article.jsp").forward(request, response);		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String key=request.getParameter("key");
		Article a=new Article();
		List<String> list=a.getList(key);
		request.setAttribute("list", list);
		request.getRequestDispatcher("test/artList.jsp").forward(request, response);
		
	}

}
