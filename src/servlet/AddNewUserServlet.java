package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.User;
import method.UserAction;

public class AddNewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddNewUserServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		User u=new User();
		UserAction ua=new UserAction();
		u.setIDCard(request.getParameter("IDCard"));
		u.setName(request.getParameter("name"));
		u.setPassword(request.getParameter("password"));
		u.setPhone(request.getParameter("phone"));
		u.setSex(request.getParameter("sex"));
		int row=ua.AddNewUser(u);
		String success="ע��ɹ�����ӭʹ��";
		String error="ע��ʧ�ܣ�֤�����û�����ռ��";
		if(row==0){
			request.setAttribute("result", error);
		}
		else{
			request.setAttribute("result", success);
		}
		request.getRequestDispatcher("test/result.jsp").forward(request, response);
	}

}
