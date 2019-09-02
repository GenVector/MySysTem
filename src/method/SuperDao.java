package method;


import bean.*;

public class SuperDao {
	public StringBuffer getCBar(int cPage,int count){
		int pages;
		StringBuffer sb=new StringBuffer();
		if(count%Car.PAGE_SIZE==0)
			pages=count/Car.PAGE_SIZE;
		else 
			pages=count/Car.PAGE_SIZE+1;
		for(int i=1;i<=pages;i++){
			if(i==cPage)
				sb.append("["+i+"]");
			else
				sb.append("<a href='Main2Servlet?cPage="+i+"'>"+i+"</a>");
			sb.append(" ");
		}
		return sb;
		
	}
	public StringBuffer getWBar(int wPage,int count){
		int pages;
		StringBuffer sb=new StringBuffer();
		if(count%Worker.PAGE_SIZE==0)
			pages=count/Worker.PAGE_SIZE;
		else 
			pages=count/Worker.PAGE_SIZE+1;
		for(int i=1;i<=pages;i++){
			if(i==wPage)
				sb.append("["+i+"]");
			else
				sb.append("<a href='Main2Servlet?wPage="+i+"'>"+i+"</a>");
			sb.append(" ");
		}
		return sb;
		
	}
	public StringBuffer getPBar(int pPage,int count){
		int pages;
		StringBuffer sb=new StringBuffer();
		if(count%Parts.PAGE_SIZE==0)
			pages=count/Parts.PAGE_SIZE;
		else 
			pages=count/Parts.PAGE_SIZE+1;
		for(int i=1;i<=pages;i++){
			if(i==pPage)
				sb.append("["+i+"]");
			else
				sb.append("<a href='Main2Servlet?pPage="+i+"'>"+i+"</a>");
			sb.append(" ");
		}
		return sb;
		
	}
	public StringBuffer getUBar(int uPage,int count){
		int pages;
		StringBuffer sb=new StringBuffer();
		if(count%User.PAGE_SIZE==0)
			pages=count/User.PAGE_SIZE;
		else 
			pages=count/User.PAGE_SIZE+1;
		for(int i=1;i<=pages;i++){
			if(i==uPage)
				sb.append("["+i+"]");
			else
				sb.append("<a href='Main2Servlet?page="+i+"'>"+i+"</a>");
			sb.append(" ");
		}
		return sb;
		
	}

}
