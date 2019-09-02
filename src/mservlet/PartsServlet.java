package mservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.PartsDao;

public class PartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PartsServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//添加零件数量
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String partId=request.getParameter("partId");
		int pNum=Integer.parseInt(new String(request.getParameter("pNum").getBytes("ISO-8859-1"),"UTF-8"));
		PartsDao pd=new PartsDao();	
		pNum+=pd.getParts(partId).getPNum();
		int i=pd.updatePart(partId, pNum);
		String message="这里是添加零件信息";
		if(i!=0){
			message="添加成功";
		}
		else{
			message="添加失败";
		}
		int page=1;			
		request.setAttribute("uPage",page);
		request.setAttribute("pPage",page);
		request.setAttribute("cPage",page);
		request.setAttribute("wPage",page);
		request.setAttribute("message", message);
		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

}
