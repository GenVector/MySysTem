package mservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Worker;
import method.WorkerDao;

public class WorkerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public WorkerServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�޸�Ա����Ϣ�����ݴ���ҳ��
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String workId=request.getParameter("workId");
		WorkerDao wd=new WorkerDao();
		Worker w=wd.findWorker(workId);
		request.setAttribute("worker", w);
		request.getRequestDispatcher("test/UpdateWorker.jsp").forward(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�޸�Ա����Ϣ�����ݴ���ҳ��
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String workId=request.getParameter("workId");
		String wName=request.getParameter("wName");
		String wSex=request.getParameter("wSex");
		String wPhone=request.getParameter("wPhone");
		String wType=request.getParameter("wType");
		int wLine=Integer.parseInt(request.getParameter("wLine"));
		String achieve=request.getParameter("ahieve");
		String wClass=request.getParameter("wClass");
		WorkerDao wd=new WorkerDao();
		Worker w=wd.findWorker(workId);
		wd.deleteWorker(workId);
		w.setAchieve(achieve);
		w.setWClass(wClass);
		w.setWLine(wLine);
		w.setWName(wName);
		w.setWType(wType);
		w.setWSex(wSex);
		w.setWPhone(wPhone);
		int i=wd.AddNewWorker(w);
		String message="�������޸ĳ�����Ϣ";
		if(i!=0){
			message="�޸ĳɹ�";
		}
		else{
			message="�޸�ʧ��";
		}
		request.setAttribute("message", message);
		request.getRequestDispatcher("test/MResult.jsp").forward(request, response);
	}

}
