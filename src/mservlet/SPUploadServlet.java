package mservlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import method.Article;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class SPUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SPUploadServlet() {
		super();
	}


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		name= new String(name.getBytes("iso8859-1"),"UTF-8");
		Article a=new Article();
		int i=a.deleteArticle(name);
		String message="ɾ��ʧ�ܣ�";
		if(i!=0){
			message="ɾ���ɹ���";
		}
		 int page=1;
         request.setAttribute("message",message);
         request.setAttribute("uPage",page);
  		 request.setAttribute("pPage",page);
  		 request.setAttribute("cPage",page);
  		 request.setAttribute("wPage",page);
  		request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		  String savePath ="D:\\Java\\WorkSpace\\MySystem\\file";
		                  File file = new File(savePath);
		                  if (!file.exists() && !file.isDirectory()) {
		                      System.out.println(savePath+"Ŀ¼�����ڣ���Ҫ����");
		                      file.mkdir();
		                  }
		                  String message = "";
		                  try{
		                     //1������һ��DiskFileItemFactory����
		                      DiskFileItemFactory factory = new DiskFileItemFactory();
		                      //2������һ���ļ��ϴ�������
		                      ServletFileUpload upload = new ServletFileUpload(factory);
		                       //����ϴ��ļ�������������
		                      upload.setHeaderEncoding("UTF-8"); 
		                     //3���ж��ύ�����������Ƿ����ϴ���������
		                      if(!ServletFileUpload.isMultipartContent(request)){
		                         return;
		                     }
		                      //4��ʹ��ServletFileUpload�����������ϴ����ݣ�����������ص���һ��List<FileItem>���ϣ�ÿһ��FileItem��Ӧһ��Form����������
		                     List<FileItem> list = upload.parseRequest(request);
		                      for(FileItem item : list){
		                              String filename = item.getName();
		                              System.out.println(filename);
		                              if(filename==null || filename.trim().equals("")){
		                                  continue;
		                             }
		                              filename = filename.substring(filename.lastIndexOf("\\")+1);
		                              //��ȡitem�е��ϴ��ļ���������
		                             InputStream in = item.getInputStream();
		                              //����һ���ļ������
		                              FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
		                              //����һ��������
		                              byte buffer[] = new byte[1024];
		                              //�ж��������е������Ƿ��Ѿ�����ı�ʶ
		                              int len = 0;
		                              //ѭ�������������뵽���������У�(len=in.read(buffer))>0�ͱ�ʾin���滹������
		                              while((len=in.read(buffer))>0){
		                                  out.write(buffer, 0, len);
		                              }
		                              in.close();
		                              out.close();
		                              item.delete();
		                              message = "�ļ��ϴ��ɹ���";
		                              Article a=new Article();
		                              int i=filename.lastIndexOf(".");
		                              filename=filename.substring(0,i);
		                              a.addArticle(filename);
		                              
		                                               }
		                  }catch (Exception e) {
		                      message= "�ļ��ϴ�ʧ�ܣ�����·�����ļ�";
		                      e.printStackTrace();
		                      
		                 }
		                  int page=1;
		                 request.setAttribute("message",message);
		                 request.setAttribute("uPage",page);
		          		 request.setAttribute("pPage",page);
		          		 request.setAttribute("cPage",page);
		          		 request.setAttribute("wPage",page);
		                 request.getRequestDispatcher("Main2Servlet").forward(request, response);
	}

}
