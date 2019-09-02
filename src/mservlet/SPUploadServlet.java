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
		String message="删除失败！";
		if(i!=0){
			message="删除成功！";
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
		                      System.out.println(savePath+"目录不存在，需要创建");
		                      file.mkdir();
		                  }
		                  String message = "";
		                  try{
		                     //1、创建一个DiskFileItemFactory工厂
		                      DiskFileItemFactory factory = new DiskFileItemFactory();
		                      //2、创建一个文件上传解析器
		                      ServletFileUpload upload = new ServletFileUpload(factory);
		                       //解决上传文件名的中文乱码
		                      upload.setHeaderEncoding("UTF-8"); 
		                     //3、判断提交上来的数据是否是上传表单的数据
		                      if(!ServletFileUpload.isMultipartContent(request)){
		                         return;
		                     }
		                      //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
		                     List<FileItem> list = upload.parseRequest(request);
		                      for(FileItem item : list){
		                              String filename = item.getName();
		                              System.out.println(filename);
		                              if(filename==null || filename.trim().equals("")){
		                                  continue;
		                             }
		                              filename = filename.substring(filename.lastIndexOf("\\")+1);
		                              //获取item中的上传文件的输入流
		                             InputStream in = item.getInputStream();
		                              //创建一个文件输出流
		                              FileOutputStream out = new FileOutputStream(savePath + "\\" + filename);
		                              //创建一个缓冲区
		                              byte buffer[] = new byte[1024];
		                              //判断输入流中的数据是否已经读完的标识
		                              int len = 0;
		                              //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
		                              while((len=in.read(buffer))>0){
		                                  out.write(buffer, 0, len);
		                              }
		                              in.close();
		                              out.close();
		                              item.delete();
		                              message = "文件上传成功！";
		                              Article a=new Article();
		                              int i=filename.lastIndexOf(".");
		                              filename=filename.substring(0,i);
		                              a.addArticle(filename);
		                              
		                                               }
		                  }catch (Exception e) {
		                      message= "文件上传失败！请检查路径和文件";
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
