package mservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Parts;
import method.*;

public class SPPartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SPPartsServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		new PartsDao().deletePart(request.getParameter("partId"));
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
		PartsDao pd=new PartsDao();
		Parts p=new Parts();
		p.setPartId(request.getParameter("partId"));
		p.setPName(request.getParameter("pName"));
		p.setPNum(Integer.parseInt(request.getParameter("pNum")));
		p.setPrice(Double.parseDouble(request.getParameter("price")));
		p.setProvider(request.getParameter("provider"));
		pd.AddNewParts(p);
		int page=1;			
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

}
